package net.wallop.betterprogression.entity.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.custom.BronzeSpearEntity;

public class BronzeSpearRenderer extends EntityRenderer<BronzeSpearEntity> {
    public static final Identifier TEXTURE = Identifier.of(BetterProgression.MOD_ID,"textures/entity/bronze_spear.png");
    private final BronzeSpearModel model;

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

    public Identifier getTexture(BronzeSpearEntity bronzeSpearEntity) {
        return TEXTURE;
    }

}
