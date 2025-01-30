package net.wallop.betterprogression.recipe;

import net.minecraft.client.MinecraftClient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;

import java.util.Map;

public class RecipeDebugger {

    public static void logCustomRecipes() {
        // Access the RecipeManager from the world
        if (MinecraftClient.getInstance().world != null) {
            // Get the RecipeManager
            RecipeManager recipeManager = MinecraftClient.getInstance().world.getRecipeManager();

            // Iterate through all recipes in the manager
            for (RecipeEntry<?> recipeEntry : recipeManager.values()) {
                Recipe<?> recipe = recipeEntry.value(); // Get the recipe from the entry

                // Check if the recipe type matches the custom ForgeRecipe type
                if (recipe.getType() == ForgeRecipe.ForgeRecipeType.INSTANCE) {
                    // Log the recipe ID if it's a custom ForgeRecipe
                    Identifier recipeId = recipeEntry.id();// Get the recipe ID from the entry
                    BetterProgression.LOGGER.info("Found custom recipe: " + recipeId);
                    BetterProgression.LOGGER.info("Type: " + recipe.getType());
                    BetterProgression.LOGGER.info("Ingredients: " + recipe.getIngredients());
                }
            }
        } else {
            BetterProgression.LOGGER.error("World is null, cannot access RecipeManager.");
        }
    }
}
