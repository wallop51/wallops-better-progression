package net.wallop.betterprogression.block;

import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.wallop.betterprogression.BetterProgression;

public class ModBlocks {

    public static final Block FORGE = registerBlock("forge", new ForgeBlock(
            AbstractBlock.Settings.copy(Blocks.BLAST_FURNACE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BetterProgression.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(BetterProgression.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BetterProgression.LOGGER.info("Registering Mod Blocks for " + BetterProgression.MOD_ID);
    }
}
