package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider{
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        tag(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .add(
                        Blocks.IRON_BLOCK,
                        Blocks.RAW_IRON_BLOCK,
                        Blocks.IRON_ORE,
                        Blocks.DEEPSLATE_IRON_ORE,
                        Blocks.LAPIS_BLOCK,
                        Blocks.LAPIS_ORE,
                        Blocks.DEEPSLATE_LAPIS_ORE,
                        ModBlocks.FORGE);

        tag(ModTags.Blocks.NEEDS_BRONZE_TOOL)
                .add(Blocks.BEDROCK);

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.FORGE);

        tag(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .forceAddTag(BlockTags.NEEDS_IRON_TOOL)
                .forceAddTag(ModTags.Blocks.NEEDS_BRONZE_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .forceAddTag(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .forceAddTag(ModTags.Blocks.NEEDS_BRONZE_TOOL)
                .forceAddTag(BlockTags.NEEDS_DIAMOND_TOOL)
                .forceAddTag(BlockTags.NEEDS_IRON_TOOL);

    }
}
