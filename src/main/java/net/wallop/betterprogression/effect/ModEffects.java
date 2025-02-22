package net.wallop.betterprogression.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> SEISMIC = registerStatusEffect(
            "seismic",
            new SeismicEffect(StatusEffectCategory.BENEFICIAL, 0xC2FF32)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE, Identifier.of(BetterProgression.MOD_ID,"seismic"), 6.0,
                            EntityAttributeModifier.Operation.ADD_VALUE));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(BetterProgression.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        BetterProgression.LOGGER.info("Registering Mod Effects for " + BetterProgression.MOD_ID);
    }
}
