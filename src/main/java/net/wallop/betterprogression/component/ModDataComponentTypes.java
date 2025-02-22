package net.wallop.betterprogression.component;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.wallop.betterprogression.BetterProgression;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<Boolean> THROWING = register("throwing", builder -> builder.codec(Codec.BOOL));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(BetterProgression.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        BetterProgression.LOGGER.info("Registering Data Component Types for " + BetterProgression.MOD_ID);
    }
}
