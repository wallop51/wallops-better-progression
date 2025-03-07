package net.wallop.betterprogression.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;

public class ModParticles {

    public static final SimpleParticleType BRONZE_SAND_PARTICLE =
            registerParticle("bronze_sand_particle", FabricParticleTypes.simple());

    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(BetterProgression.MOD_ID, name), particleType);
    }

    public static void registerParticles() {
        BetterProgression.LOGGER.info("Registering particles for {}", BetterProgression.MOD_ID);
    }
}
