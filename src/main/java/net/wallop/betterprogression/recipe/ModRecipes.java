package net.wallop.betterprogression.recipe;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.wallop.betterprogression.BetterProgression;

public class ModRecipes {
    public static void registerRecipes() {
        BetterProgression.LOGGER.info("Registering recipes for " + BetterProgression.MOD_ID);

        // Log when recipes are registered
        BetterProgression.LOGGER.info("Registering RecipeType and RecipeSerializer...");


        Registry.register(
                BuiltInRegistries.RECIPE_SERIALIZER,
                ForgeRecipe.ForgeRecipeSerializer.ID,
                ForgeRecipe.ForgeRecipeSerializer.INSTANCE
        );

        Registry.register(
                BuiltInRegistries.RECIPE_TYPE,
                ForgeRecipe.ForgeRecipeType.ID,
                ForgeRecipe.ForgeRecipeType.INSTANCE
        );


        BetterProgression.LOGGER.info("Recipes registered successfully.");
    }
}
