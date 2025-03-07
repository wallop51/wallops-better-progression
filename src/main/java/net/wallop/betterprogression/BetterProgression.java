package net.wallop.betterprogression;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.wallop.betterprogression.block.ModBlockEntityType;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.command.RecipeCommand;
import net.wallop.betterprogression.component.ModDataComponentTypes;
import net.wallop.betterprogression.effect.ModEffects;
import net.wallop.betterprogression.entity.ModEntities;
import net.wallop.betterprogression.entity.custom.BronzeEntity;
import net.wallop.betterprogression.inventory.ForgeScreenHandler;
import net.wallop.betterprogression.item.ModItemGroups;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.particle.ModParticles;
import net.wallop.betterprogression.recipe.ModRecipes;
import net.wallop.betterprogression.sound.ModSounds;
import net.wallop.betterprogression.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterProgression implements ModInitializer {
	public static final String MOD_ID = "betterprogression";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ScreenHandlerType<ForgeScreenHandler> FORGE_SCREEN_HANDLER =
			Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MOD_ID,"forge"),
					new ExtendedScreenHandlerType<>(ForgeScreenHandler::new, BlockPos.PACKET_CODEC));

	@Override
	public void onInitialize() {
		LOGGER.info("Loading...");

		ModItemGroups.registerItemsGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModLootTableModifiers.modifyLootTables();
		ModBlockEntityType.registerBlockEntityTypes();
		ModRecipes.registerRecipes();
		ModEntities.registerModEntities();
		RecipeCommand.register();
		ModEffects.registerEffects();
		ModParticles.registerParticles();
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();

		FabricDefaultAttributeRegistry.register(ModEntities.BRONZE, BronzeEntity.createAttributes());

		LOGGER.info("Loaded!");
	}
}