package net.wallop.betterprogression.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.block.ModBlockEntityType;
import net.wallop.betterprogression.inventory.ForgeScreenHandler;
import net.wallop.betterprogression.inventory.ImplementedInventory;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.recipe.ForgeRecipe;
import net.wallop.betterprogression.recipe.ForgeRecipeInput;

import java.util.Optional;

public class ForgeBlockEntity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {
    private static final int INPUT1_SLOT = 0;
    private static final int INPUT2_SLOT = 1;
    private static final int UPGRADE_SLOT = 2;
    private static final int FUEL_SLOT = 3;
    private static final int OUTPUT_SLOT = 4;
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(5, ItemStack.EMPTY);

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 100;
    private int fuelCounter = 0;

    public ForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntityType.FORGE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ForgeBlockEntity.this.progress;
                    case 1 -> ForgeBlockEntity.this.maxProgress;
                    case 2 -> ForgeBlockEntity.this.fuelCounter;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ForgeBlockEntity.this.progress = value;
                    case 1 -> ForgeBlockEntity.this.maxProgress = value;
                    case 2 -> ForgeBlockEntity.this.fuelCounter = value;
                }
            }

            @Override
            public int size() {
                return 3;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new ForgeScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable(getCachedState().getBlock().getTranslationKey());
    }


    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, inventory, registryLookup);
    }


    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient()) {
            return;
        }

        if (isOutputSlotEmptyOrReceivable()) {
            if (this.hasFuel()) {
                if (this.hasRecipe()) {
                    //BetterProgression.LOGGER.info("Recipe matched");
                    this.increaseCraftProgress();
                    markDirty(world, pos, state);

                    if (hasCraftingFinished()) {
                        this.craftItem();
                        this.resetProgress();
                    }
                } else {
                    this.resetProgress();
                    //BetterProgression.LOGGER.info("Recipe not matched");
                }
            } else {
                this.resetProgress();
                markDirty(world, pos, state);
            }
        } else {
            this.resetProgress();
            markDirty(world, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<RecipeEntry<ForgeRecipe>> recipe = getCurrentRecipe();

        fuelCounter++;
        this.removeStack(INPUT1_SLOT, 1);
        this.removeStack(INPUT2_SLOT, 1);
        if (fuelCounter == 8) {
            this.removeStack(FUEL_SLOT, 1);
            fuelCounter = 0;
        }

        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<ForgeRecipe>> recipe = getCurrentRecipe();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(recipe.get().value().getResult(null))
                && canInsertItemIntoOutputSlot(recipe.get().value().getResult(null).getItem());
    }

    private Optional<RecipeEntry<ForgeRecipe>> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            if (this.getStack(i) == ItemStack.EMPTY) {
                inv.setStack(i, ModItems.EMPTY_SLOT.getDefaultStack());
            } else {
                inv.setStack(i, this.getStack(i));
            }
        }
        //BetterProgression.LOGGER.info("Checking current recipe: " + inv);

        return getWorld().getRecipeManager().getFirstMatch(
                ForgeRecipe.ForgeRecipeType.INSTANCE,
                new ForgeRecipeInput(
                        inv.getStack(INPUT1_SLOT),
                        inv.getStack(INPUT2_SLOT),
                        inv.getStack(UPGRADE_SLOT)
        ), getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }

    private boolean hasFuel() {
        return this.getStack(FUEL_SLOT).getItem() == Items.COAL;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();


    }
}