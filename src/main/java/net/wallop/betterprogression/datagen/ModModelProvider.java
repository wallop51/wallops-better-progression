package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        TextureMap FORGE_TEXTURE_MAP = new TextureMap()
                .put(TextureKey.TOP, TextureMap.getSubId(ModBlocks.FORGE, "_top"))
                .put(TextureKey.SIDE, TextureMap.getSubId(ModBlocks.FORGE, "_side"))
                .put(TextureKey.FRONT, TextureMap.getSubId(ModBlocks.FORGE, "_front"))
                .put(TextureKey.BOTTOM, TextureMap.getSubId(ModBlocks.FORGE, "_bottom"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotatable(
                ModBlocks.FORGE,
                FORGE_TEXTURE_MAP
        );

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

        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.COPPERMAIL_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPERMAIL_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPERMAIL_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPERMAIL_BOOTS, Models.GENERATED);
    }
}
