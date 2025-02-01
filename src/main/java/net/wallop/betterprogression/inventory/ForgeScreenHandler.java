package net.wallop.betterprogression.inventory;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.wallop.betterprogression.BetterProgression;

public class ForgeScreenHandler extends AbstractContainerMenu {
    private final Container inventory;

    public ForgeScreenHandler(int syncId, Inventory playerInventory) {
        this(syncId, playerInventory, new SimpleContainer(5));
    }

    public ForgeScreenHandler(int syncId, Inventory playerInventory, Container inventory) {
        super(BetterProgression.FORGE_SCREEN_HANDLER, syncId);
        checkContainerSize(inventory, 5);
        this.inventory = inventory;
        inventory.startOpen(playerInventory.player);

        /*
        int m;
        int l;
        // Our inventory
        int column;
        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 3; ++l) {
                this.addSlot(new Slot(inventory, l + m * 3, 62 + l * 18, 17 + m * 18));
            }
        }
         */

        //Forge Inventory
        this.addSlot(new Slot(inventory, 0,70,23));//Input 1
        this.addSlot(new Slot(inventory, 1,70,48));//Input 2
        this.addSlot(new Slot(inventory, 2,8,62));//Upgrade
        this.addSlot(new Slot(inventory, 3,33,35));//Fuel
        this.addSlot(new Slot(inventory, 4,125,35));//Output

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
    public boolean stillValid(Player player) {
        return this.inventory.stillValid(player);
    }

    // Shift + Player Inv Slot
    @Override
    public ItemStack quickMoveStack(Player player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasItem()) {
            ItemStack originalStack = slot.getItem();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.getContainerSize()) {
                if (!this.moveItemStackTo(originalStack, this.inventory.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(originalStack, 0, this.inventory.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return newStack;
    }
}
