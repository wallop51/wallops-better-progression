package net.wallop.betterprogression.block;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.item.ModItems;

public class ModBlocks {

    public static final Block FORGE = registerBlock("forge", new ForgeBlock(
            AbstractBlock.Settings.copy(Blocks.BLAST_FURNACE)));

    public static final Block BRONZE_BLOCK = registerBlock("bronze_block", new Block(
            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));

    public static final Block CRUDE_IRON_BLOCK = registerBlock("crude_iron_block", new Block(
            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));

    public static final Block CUT_BRONZE = registerBlock("cut_bronze", new Block(
            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block CUT_BRONZE_SLAB = registerBlock("cut_bronze_slab", new SlabBlock(
            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block CUT_BRONZE_STAIRS = registerBlock("cut_bronze_stairs", new StairsBlock(
            ModBlocks.CUT_BRONZE.getDefaultState(),AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));
    public static final Block CHISELED_BRONZE = registerBlock("chiseled_bronze", new Block(
            AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)));

    public static final Block BRONZE_BARS = registerBlock("bronze_bars", new PaneBlock(
            AbstractBlock.Settings.copy(Blocks.IRON_BARS)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BetterProgression.MOD_ID, name), block);
    }

    private static void addItemsToBuildingBlocksTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(ModBlocks.CRUDE_IRON_BLOCK);
        entries.add(ModBlocks.BRONZE_BLOCK);
        entries.add(ModBlocks.CUT_BRONZE);
        entries.add(ModBlocks.CUT_BRONZE_SLAB);
        entries.add(ModBlocks.CUT_BRONZE_STAIRS);
        entries.add(ModBlocks.CHISELED_BRONZE);
        entries.add(ModBlocks.BRONZE_BARS);
    }

    private static void addItemsToFunctionalBlocksTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(FORGE);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(BetterProgression.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BetterProgression.LOGGER.info("Registering Mod Blocks for " + BetterProgression.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModBlocks::addItemsToBuildingBlocksTabItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addItemsToFunctionalBlocksTabItemGroup);
    }
}
