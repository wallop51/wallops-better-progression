package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .add(
                        Blocks.IRON_BLOCK,
                        Blocks.RAW_IRON_BLOCK,
                        Blocks.IRON_ORE,
                        Blocks.DEEPSLATE_IRON_ORE,
                        Blocks.LAPIS_BLOCK,
                        Blocks.LAPIS_ORE,
                        Blocks.DEEPSLATE_LAPIS_ORE,
                        ModBlocks.FORGE);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_BRONZE_TOOL)
                .add(Blocks.BEDROCK);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.FORGE);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .forceAddTag(BlockTags.NEEDS_IRON_TOOL)
                .forceAddTag(ModTags.Blocks.NEEDS_BRONZE_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .forceAddTag(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .forceAddTag(ModTags.Blocks.NEEDS_BRONZE_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .forceAddTag(BlockTags.NEEDS_IRON_TOOL);

    }
}
