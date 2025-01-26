package net.wallop.betterprogression;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.block.ModBlockEntityType;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.block.entity.ForgeBlockEntity;
import net.wallop.betterprogression.inventory.ForgeScreenHandler;
import net.wallop.betterprogression.item.ModItemGroups;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.recipe.ModRecipes;
import net.wallop.betterprogression.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterProgression implements ModInitializer {
	public static final String MOD_ID = "betterprogression";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ScreenHandlerType<ForgeScreenHandler> FORGE_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MOD_ID,"forge"), new ScreenHandlerType<>(ForgeScreenHandler::new, FeatureSet.empty()));

	@Override
	public void onInitialize() {
		LOGGER.info("Loading...");

		ModItemGroups.registerItemsGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		ModBlockEntityType.registerBlockEntityTypes();
		ModRecipes.registerRecipes();


		LOGGER.info("Loaded!");
	}
}