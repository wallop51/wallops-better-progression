package net.wallop.betterprogression.command;

import com.mojang.brigadier.Command;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.commands.Commands;
import net.wallop.betterprogression.recipe.RecipeDebugger;

public class RecipeCommand {

    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, dedicated) -> {
            dispatcher.register(
                    Commands.literal("logRecipes")
                            .executes(context -> {
                                // Call the logCustomRecipes method
                                RecipeDebugger.logCustomRecipes();
                                return Command.SINGLE_SUCCESS;
                            })
            );
        });
    }
}
