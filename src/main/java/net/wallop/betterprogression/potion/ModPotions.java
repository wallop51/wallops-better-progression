package net.wallop.betterprogression.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> BIND_RESISTANCE_POTION = registerPotion("bind_resistance_potion",
            new Potion(new StatusEffectInstance(ModEffects.BIND_RESISTANCE, 3600, 0)));

    public static final RegistryEntry<Potion> LONG_BIND_RESISTANCE_POTION = registerPotion("long_bind_resistance_potion",
            new Potion(new StatusEffectInstance(ModEffects.BIND_RESISTANCE, 9600, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(BetterProgression.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        BetterProgression.LOGGER.info("Registering Mod Potions for {}", BetterProgression.MOD_ID);
    }
}
