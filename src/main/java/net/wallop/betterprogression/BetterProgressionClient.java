package net.wallop.betterprogression;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screens.MenuScreens;
import net.wallop.betterprogression.inventory.ForgeScreen;

@Environment(EnvType.CLIENT)
public class BetterProgressionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(BetterProgression.FORGE_SCREEN_HANDLER, ForgeScreen::new);
    }
}
