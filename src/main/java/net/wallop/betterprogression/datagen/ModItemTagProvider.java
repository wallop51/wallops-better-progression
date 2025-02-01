package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD);
        tag(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE);
        tag(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL);
        tag(ItemTags.AXES)
                .add(ModItems.COPPER_AXE);
        tag(ItemTags.HOES)
                .add(ModItems.COPPER_HOE);

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.COPPERMAIL_HELMET);
        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.COPPERMAIL_CHESTPLATE);
        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.COPPERMAIL_LEGGINGS);
        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.COPPERMAIL_BOOTS);

        tag(ModTags.Items.TIN_OIL_FOOD_INGREDIENTS)
                .add(Items.APPLE)
                .add(Items.BEETROOT)
                .add(Items.SWEET_BERRIES);

        tag(ModTags.Items.FORGE_SLOT_0_ITEMS)
                .add(Items.RAW_IRON)
                .add(Items.IRON_ORE)
                .add(Items.DEEPSLATE_IRON_ORE)
                .add(Items.COPPER_INGOT)
                .add(ModItems.CRUDE_IRON);

        tag(ModTags.Items.FORGE_SLOT_1_ITEMS)
                .add(ModItems.TIN_DUST);

        tag(ModTags.Items.FORGE_SLOT_2_ITEMS)
                .add(ModItems.TOTEM_OF_FORGING);

    }
}
