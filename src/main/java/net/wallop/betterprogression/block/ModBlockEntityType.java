package net.wallop.betterprogression.block;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.block.entity.ForgeBlockEntity;

public class ModBlockEntityType {
    public static final BlockEntityType<ForgeBlockEntity> FORGE_BLOCK_ENTITY = register("forge_block_entity",
            BlockEntityType.Builder.create(ForgeBlockEntity::new, ModBlocks.FORGE).build());

    public static <T extends BlockEntity> BlockEntityType<T> register (String name, BlockEntityType<T> type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(BetterProgression.MOD_ID, name), type);
    }

    public static void registerBlockEntityTypes() {
        BetterProgression.LOGGER.info("Registering Block Entity Types for " + BetterProgression.MOD_ID);

    }
}
