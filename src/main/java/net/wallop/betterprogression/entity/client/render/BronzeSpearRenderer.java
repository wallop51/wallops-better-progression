package net.wallop.betterprogression.entity.client.render;

import com.google.common.collect.Maps;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.client.model.BronzeSpearModel;
import net.wallop.betterprogression.entity.custom.BronzeSpearEntity;
import net.wallop.betterprogression.entity.custom.BronzeSpearVariant;

import java.util.Map;

public class BronzeSpearRenderer extends EntityRenderer<BronzeSpearEntity> {
    private final BronzeSpearModel model;

    private static final Map<BronzeSpearVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(BronzeSpearVariant.class), map -> {
                map.put(BronzeSpearVariant.DEFAULT,
                        Identifier.of(BetterProgression.MOD_ID, "textures/entity/bronze_spear/bronze_spear.png"));
                map.put(BronzeSpearVariant.CRAFTED,
                        Identifier.of(BetterProgression.MOD_ID, "textures/entity/bronze_spear/bronze_spear_crafted.png"));
            });

    public BronzeSpearRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new BronzeSpearModel<>(ctx.getPart(BronzeSpearModel.BRONZE_SPEAR));
    }

    public void render(BronzeSpearEntity bronzeSpearEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.push();
        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, bronzeSpearEntity.prevYaw, bronzeSpearEntity.getYaw()) - 90.0F));
        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, bronzeSpearEntity.prevPitch, bronzeSpearEntity.getPitch()) + 90.0F));
        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(
                vertexConsumerProvider, this.model.getLayer(this.getTexture(bronzeSpearEntity)), false, bronzeSpearEntity.isEnchanted()
        );
        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV);
        matrixStack.pop();
        super.render(bronzeSpearEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public Identifier getTexture(BronzeSpearEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

}
