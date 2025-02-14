package net.wallop.betterprogression.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.custom.BronzeEntity;

public class ModEntities {
    public static final EntityType<BronzeEntity> BRONZE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BetterProgression.MOD_ID, "bronze"),
            EntityType.Builder.create(BronzeEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.8f,1.8f).build());

    public static void registerModEntities() {
        BetterProgression.LOGGER.info("Registering Mod Entites for " + BetterProgression.MOD_ID);
    }
}
