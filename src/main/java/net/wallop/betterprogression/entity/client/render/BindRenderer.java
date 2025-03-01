package net.wallop.betterprogression.entity.client.render;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.client.model.BindModel;
import net.wallop.betterprogression.entity.custom.BindEntity;

public class BindRenderer extends EntityRenderer<BindEntity> {
    public static final Identifier TEXTURE = Identifier.of(BetterProgression.MOD_ID, "textures/entity/bronze_spear/bronze_spear.png");
    private final BindModel<BindEntity> model;

    public BindRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.model = new BindModel<>(context.getPart(BindModel.BIND));
        // , new BindModel<>(context.getPart(BindModel.BIND)), 0
    }

    @Override
    public void render(BindEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(this.model.getLayer(TEXTURE));
        this.model.setAngles(entity, 0, 0, entity.age + tickDelta, entity.getYaw(), entity.getPitch());
        this.model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }


    @Override
    public Identifier getTexture(BindEntity entity) {
        return TEXTURE;
    }
}
