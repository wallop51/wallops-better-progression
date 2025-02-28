package net.wallop.betterprogression.entity.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.feature.EyesFeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.client.model.BronzeModel;
import net.wallop.betterprogression.entity.custom.BronzeEntity;

@Environment(EnvType.CLIENT)
public class BronzeGlowFeatureRenderer<T extends BronzeEntity, M extends BronzeModel<T>> extends EyesFeatureRenderer<T, M> {
    public static final RenderLayer SKIN = RenderLayer.getEyes(Identifier.of(BetterProgression.MOD_ID, "textures/entity/bronze/bronze_glow.png"));

    public BronzeGlowFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext) {
        super(featureRendererContext);
    }

    @Override
    public RenderLayer getEyesTexture() {
        return SKIN;
    }
}