package net.wallop.betterprogression.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.custom.BindEntity;
import net.wallop.betterprogression.entity.custom.BronzeEntity;
import net.wallop.betterprogression.entity.custom.BronzeSpearEntity;

public class ModEntities {
    public static final EntityType<BronzeEntity> BRONZE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BetterProgression.MOD_ID, "bronze"),
            EntityType.Builder.create(BronzeEntity::new, SpawnGroup.MONSTER)
                    .dimensions(0.8f,1.8f).build());

    public static final EntityType<BronzeSpearEntity> BRONZE_SPEAR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BetterProgression.MOD_ID,"bronze_spear"),
            EntityType.Builder.<BronzeSpearEntity>create(BronzeSpearEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f,0.5f).build());

    public static final EntityType<BindEntity> BIND = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(BetterProgression.MOD_ID, "bind"),
            EntityType.Builder.<BindEntity>create(BindEntity::new, SpawnGroup.MISC)
                    .dimensions(0.9f,1f).build());

    public static void registerModEntities() {
        BetterProgression.LOGGER.info("Registering Mod Entities for " + BetterProgression.MOD_ID);
    }
}
