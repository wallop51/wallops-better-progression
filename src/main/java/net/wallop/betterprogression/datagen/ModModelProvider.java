package net.wallop.betterprogression.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.wallop.betterprogression.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PLANT_FIBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOOL_HANDLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);
    }
}
