package net.wallop.betterprogression.inventory;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.FurnaceOutputSlot;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.block.entity.ForgeBlockEntity;
import net.wallop.betterprogression.util.ModTags;

public class ForgeScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final ForgeBlockEntity blockEntity;

    public ForgeScreenHandler(int syncId, PlayerInventory playerInventory, BlockPos obj) {
        this(syncId, playerInventory, playerInventory.player.getWorld().getBlockEntity(obj),
                new ArrayPropertyDelegate(4));
    }

    public ForgeScreenHandler(
            int syncId,
            PlayerInventory playerInventory,
            BlockEntity blockEntity,
            PropertyDelegate propertyDelegate
    ) {
        super(BetterProgression.FORGE_SCREEN_HANDLER, syncId);
        checkSize(((Inventory) blockEntity), 5);
        this.inventory = ((Inventory) blockEntity);
        inventory.onOpen(playerInventory.player);
        this.propertyDelegate = propertyDelegate;
        this.blockEntity = ((ForgeBlockEntity) blockEntity);

        addProperties(propertyDelegate);

        //Forge Inventory

        //Input 1
        this.addSlot(new Slot(inventory, 0,70,23) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(ModTags.Items.FORGE_SLOT_0_ITEMS);
            }
        });

        //Input 2
        this.addSlot(new Slot(inventory, 1,70,48) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(ModTags.Items.FORGE_SLOT_1_ITEMS);
            }
        });

        //Upgrade
        this.addSlot(new Slot(inventory, 2,8,62) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(ModTags.Items.FORGE_SLOT_2_ITEMS);
            }
        });

        //Fuel
        this.addSlot(new Slot(inventory, 3,33,35) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return ForgeBlockEntity.canUseAsFuel(stack);
            }
        });

        //Output
        this.addSlot(new ForgeOutputSlot(playerInventory.player, inventory, 4,125,35));

        int m;
        int l;
        // The player inventory
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        // The player Hotbar
        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }

    }



    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot == 4) {
                if (!this.insertItem(originalStack, 5, 41, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickTransfer(originalStack, newStack);
            }

            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    public Identifier getBurnProgressTexture() {
        if (this.inventory.getStack(1).isEmpty()) {
            return Identifier.of(BetterProgression.MOD_ID,"container/forge/burn_progress_1");
        }
        return Identifier.of(BetterProgression.MOD_ID,"container/forge/burn_progress");
    }

    public float getCookProgress() {
        int i = this.propertyDelegate.get(2);
        int j = this.propertyDelegate.get(3);
        return j != 0 && i != 0 ? MathHelper.clamp((float)i / (float)j, 0.0F, 1.0F) : 0.0F;
    }

    public float getFuelProgress() {
        int i = this.propertyDelegate.get(1);
        if (i == 0) {
            i = 200;
        }

        return MathHelper.clamp((float)this.propertyDelegate.get(0) / (float)i, 0.0F, 1.0F);
    }

    public boolean isBurning() {
        return this.propertyDelegate.get(0) > 0;
    }
}
