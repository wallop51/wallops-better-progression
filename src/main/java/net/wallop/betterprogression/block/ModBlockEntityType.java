package net.wallop.betterprogression.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.block.entity.ForgeBlockEntity;

public class ModBlockEntityType {
    public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = register("forge_block_entity",
            BlockEntityType.Builder.of(ForgeBlockEntity::new, ModBlocks.FORGE).build());

    public static <T extends BlockEntity> BlockEntityType<T> register (String name, BlockEntityType<T> type) {
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(BetterProgression.MOD_ID, name), type);
    }

    public static void registerBlockEntityTypes() {
        BetterProgression.LOGGER.info("Registering Block Entity Types for " + BetterProgression.MOD_ID);

    }
}
