package net.wallop.betterprogression.entity.client;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.custom.BronzeEntity;

public class BronzeRenderer extends MobEntityRenderer<BronzeEntity, BronzeModel<BronzeEntity>> {


    public BronzeRenderer(EntityRendererFactory.Context context) {
        super(context, new BronzeModel<>(context.getPart(BronzeModel.BRONZE)), 0.4f);
        this.addFeature(new BronzeGlowFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(BronzeEntity entity) {
        return Identifier.of(BetterProgression.MOD_ID, "textures/entity/bronze/bronze.png");
    }

}
