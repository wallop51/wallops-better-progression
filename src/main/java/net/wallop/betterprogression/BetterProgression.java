package net.wallop.betterprogression;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.MenuType;
import net.wallop.betterprogression.block.ModBlockEntityType;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.block.entity.ForgeBlockEntity;
import net.wallop.betterprogression.command.RecipeCommand;
import net.wallop.betterprogression.inventory.ForgeScreenHandler;
import net.wallop.betterprogression.item.ModItemGroups;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.recipe.ModRecipes;
import net.wallop.betterprogression.recipe.RecipeDebugger;
import net.wallop.betterprogression.util.ModLootTableModifiers;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterProgression implements ModInitializer {
	public static final String MOD_ID = "betterprogression";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final MenuType<ForgeScreenHandler> FORGE_SCREEN_HANDLER = Registry.register(BuiltInRegistries.MENU, ResourceLocation.fromNamespaceAndPath(MOD_ID,"forge"), new MenuType<>(ForgeScreenHandler::new, FeatureFlagSet.of()));

	@Override
	public void onInitialize() {
		LOGGER.info("Loading...");

		ModItemGroups.registerItemsGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		ModBlockEntityType.registerBlockEntityTypes();
		ModRecipes.registerRecipes();
		RecipeCommand.register();


		LOGGER.info("Loaded!");
	}
}