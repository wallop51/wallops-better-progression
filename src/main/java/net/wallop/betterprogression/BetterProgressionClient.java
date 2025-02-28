package net.wallop.betterprogression;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.wallop.betterprogression.block.ModBlocks;
import net.wallop.betterprogression.entity.ModEntities;
import net.wallop.betterprogression.entity.client.model.BindModel;
import net.wallop.betterprogression.entity.client.model.BronzeModel;
import net.wallop.betterprogression.entity.client.render.BindRenderer;
import net.wallop.betterprogression.entity.client.render.BronzeRenderer;
import net.wallop.betterprogression.entity.client.model.BronzeSpearModel;
import net.wallop.betterprogression.entity.client.render.BronzeSpearRenderer;
import net.wallop.betterprogression.inventory.ForgeScreen;

@Environment(EnvType.CLIENT)
public class BetterProgressionClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(BetterProgression.FORGE_SCREEN_HANDLER, ForgeScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BRONZE_BARS, RenderLayer.getCutout());

        EntityModelLayerRegistry.registerModelLayer(BronzeModel.BRONZE, BronzeModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BRONZE, BronzeRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(BronzeSpearModel.BRONZE_SPEAR, BronzeSpearModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BRONZE_SPEAR, BronzeSpearRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(BindModel.BIND, BindModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.BIND, BindRenderer::new);
    }
}
