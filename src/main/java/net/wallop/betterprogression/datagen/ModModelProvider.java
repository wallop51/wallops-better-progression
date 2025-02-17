package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {


        blockStateModelGenerator.registerCooker(ModBlocks.FORGE, TexturedModel.ORIENTABLE_WITH_BOTTOM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRUDE_IRON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BRONZE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_BRONZE);
        BlockStateModelGenerator.BlockTexturePool cut_bronze_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_BRONZE);

        cut_bronze_pool.slab(ModBlocks.CUT_BRONZE_SLAB);
        cut_bronze_pool.stairs(ModBlocks.CUT_BRONZE_STAIRS);

    }
    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PLANT_FIBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOOL_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPERMAIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.CLOTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_DUST, Models.GENERATED);
        itemModelGenerator.register(ModItems.TIN_OIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUDE_IRON, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOTEM_OF_FORGING, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_SPEAR, Models.GENERATED);

        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BRONZE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BRONZE_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.COPPERMAIL_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPERMAIL_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPERMAIL_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPERMAIL_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BRONZE_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BRONZE_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BRONZE_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }



}
