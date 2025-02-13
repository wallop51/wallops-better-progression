package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.COPPER_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.COPPER_HOE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.BRONZE_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.BRONZE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.BRONZE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.BRONZE_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.BRONZE_HOE);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.COPPERMAIL_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.COPPERMAIL_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.COPPERMAIL_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.COPPERMAIL_BOOTS);

        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
                .add(ModItems.BRONZE_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
                .add(ModItems.BRONZE_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
                .add(ModItems.BRONZE_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
                .add(ModItems.BRONZE_BOOTS);

        getOrCreateTagBuilder(ModTags.Items.TIN_OIL_FOOD_INGREDIENTS)
                .add(Items.APPLE)
                .add(Items.BEETROOT)
                .add(Items.SWEET_BERRIES);

        getOrCreateTagBuilder(ModTags.Items.FORGE_SLOT_0_ITEMS)
                .add(Items.RAW_IRON)
                .add(Items.IRON_ORE)
                .add(Items.DEEPSLATE_IRON_ORE)
                .add(Items.COPPER_INGOT)
                .add(ModItems.CRUDE_IRON);

        getOrCreateTagBuilder(ModTags.Items.FORGE_SLOT_1_ITEMS)
                .add(ModItems.TIN_DUST);

        getOrCreateTagBuilder(ModTags.Items.FORGE_SLOT_2_ITEMS)
                .add(ModItems.TOTEM_OF_FORGING);

    }
}
