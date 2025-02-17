package net.wallop.betterprogression.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.custom.BronzeSpearEntity;

public class BronzeSpearModel<T extends BronzeSpearEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer BRONZE_SPEAR = new EntityModelLayer(Identifier.of(BetterProgression.MOD_ID, "bronze_spear"),"main");

    private final ModelPart bronze_spear;

    public BronzeSpearModel(ModelPart root) {
        this.bronze_spear = root.getChild("bronze_spear");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bone = modelPartData.addChild("bronze_spear", ModelPartBuilder.create().uv(0, 6).cuboid(-0.5F, -25.0F, -0.5F, 1.0F, 25.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r1 = bone.addChild("cube_r1", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -25.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r2 = bone.addChild("cube_r2", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -25.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        bronze_spear.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return bronze_spear;
    }

    @Override
    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }
}
