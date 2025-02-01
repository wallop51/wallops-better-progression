package net.wallop.betterprogression.block;

import net.minecraft.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.wallop.betterprogression.BetterProgression;

public class ModBlocks {

    public static final Block FORGE = registerBlock("forge", new ForgeBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.BLAST_FURNACE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(BuiltInRegistries.BLOCK, ResourceLocation.fromNamespaceAndPath(BetterProgression.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BetterProgression.MOD_ID, name),
                new BlockItem(block, new Item.Properties()));
    }

    public static void registerModBlocks() {
        BetterProgression.LOGGER.info("Registering Mod Blocks for " + BetterProgression.MOD_ID);
    }
}
