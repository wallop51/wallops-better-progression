package net.wallop.betterprogression.recipe;

import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.wallop.betterprogression.BetterProgression;

import java.util.Map;

public class RecipeDebugger {

    public static void logCustomRecipes() {
        // Access the RecipeManager from the world
        if (Minecraft.getInstance().level != null) {
            // Get the RecipeManager
            RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

            // Iterate through all recipes in the manager
            for (RecipeHolder<?> recipeEntry : recipeManager.getRecipes()) {
                Recipe<?> recipe = recipeEntry.value(); // Get the recipe from the entry

                // Check if the recipe type matches the custom ForgeRecipe type
                if (recipe.getType() == ForgeRecipe.ForgeRecipeType.INSTANCE) {
                    // Log the recipe ID if it's a custom ForgeRecipe
                    ResourceLocation recipeId = recipeEntry.id();// Get the recipe ID from the entry
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
