package net.wallop.betterprogression.recipe;


import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;


public record ForgeRecipeInput(ItemStack slotA, ItemStack slotB, ItemStack slotC) implements RecipeInput {


    public ForgeRecipeInput(ItemStack slotA, ItemStack slotB, ItemStack slotC) {
        this.slotA = slotA;
        this.slotB = slotB;
        this.slotC = slotC;
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public ItemStack getItem(int slot) {
        ItemStack result;
        switch (slot) {
            case 0:
                result = this.slotA;
                break;
            case 1:
                result = this.slotB;
                break;
            case 2:
                result = this.slotC;
                break;
            default:
                throw new IllegalArgumentException("Recipe does not contain slot " + slot);
        }

        return result;
    }

    public boolean isEmpty() {
        return this.slotA.isEmpty() && this.slotB.isEmpty() && this.slotC.isEmpty();
    }

    public ItemStack slotA() {
        return this.slotA.copy();
    }

    public ItemStack slotB() {
        return this.slotB.copy();
    }

    public ItemStack slotC() {
        return this.slotC.copy();
    }

}
