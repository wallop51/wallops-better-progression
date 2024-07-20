package net.wallop.betterprogression;

import net.fabricmc.api.ModInitializer;

import net.wallop.betterprogression.item.ModItemGroups;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.util.ModLootTableModifiers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BetterProgression implements ModInitializer {
	public static final String MOD_ID = "betterprogression";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemsGroups();
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
	}
}