package net.wallop.betterprogression.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;

public class ModRecipes {
    public static void registerRecipes() {
        BetterProgression.LOGGER.debug("Registering recipes for " + BetterProgression.MOD_ID);

        Registry.register(
                Registries.RECIPE_SERIALIZER,
                Identifier.of(BetterProgression.MOD_ID, ForgeRecipe.ForgeRecipeSerializer.ID),
                ForgeRecipe.ForgeRecipeSerializer.INSTANCE
        );

        Registry.register(
                Registries.RECIPE_TYPE,
                Identifier.of(BetterProgression.MOD_ID, ForgeRecipe.ForgeRecipeType.ID),
                ForgeRecipe.ForgeRecipeType.INSTANCE
        );
    }
}
