package net.wallop.betterprogression;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.inventory.ForgeScreen;

@Environment(EnvType.CLIENT)
public class BetterProgressionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(BetterProgression.FORGE_SCREEN_HANDLER, ForgeScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRONZE_BARS, RenderLayer.getCutout());
    }
}
