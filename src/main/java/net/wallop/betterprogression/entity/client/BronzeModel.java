package net.wallop.betterprogression.entity.client;

import com.ibm.icu.text.Normalizer2;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.custom.BronzeEntity;

public class BronzeModel<T extends BronzeEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer BRONZE = new EntityModelLayer(Identifier.of(BetterProgression.MOD_ID, "bronze"), "main");

    private final ModelPart bronze;
    private final ModelPart head;
    private final ModelPart bottomrods;
    private final ModelPart toprods;
    public BronzeModel(ModelPart root) {
        this.bronze = root.getChild("bronze");
        this.head = this.bronze.getChild("head");
        this.bottomrods = this.bronze.getChild("bottomrods");
        this.toprods = this.bronze.getChild("toprods");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bronze = modelPartData.addChild("bronze", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData head = bronze.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -4.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -23.0F, 0.0F));

        ModelPartData bottomrods = bronze.addChild("bottomrods", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r1 = bottomrods.addChild("cube_r1", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.0F, 2.0F, -0.1745F, 0.0F, -0.1745F));

        ModelPartData cube_r2 = bottomrods.addChild("cube_r2", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.0F, -2.0F, 0.1745F, 0.0F, -0.1745F));

        ModelPartData cube_r3 = bottomrods.addChild("cube_r3", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -2.0F, -1.0F, 0.1745F, 0.0F, 0.1745F));

        ModelPartData cube_r4 = bottomrods.addChild("cube_r4", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -2.0F, 2.0F, -0.1745F, 0.0F, 0.1745F));

        ModelPartData toprods = bronze.addChild("toprods", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r5 = toprods.addChild("cube_r5", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -12.0F, -5.0F, 0.1745F, 0.0F, 0.1745F));

        ModelPartData cube_r6 = toprods.addChild("cube_r6", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -12.0F, 6.0F, -0.1745F, 0.0F, -0.1745F));

        ModelPartData cube_r7 = toprods.addChild("cube_r7", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -12.0F, -5.0F, 0.1745F, 0.0F, -0.1745F));

        ModelPartData cube_r8 = toprods.addChild("cube_r8", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -12.0F, 6.0F, -0.1745F, 0.0F, 0.1745F));
        return TexturedModelData.of(modelData, 32, 33);
    }

    @Override
    public void setAngles(BronzeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        // animate movement here

        this.updateAnimation(entity.idleAnimationState, BronzeAnimations.IDLE, ageInTicks, 1f);

    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30f, 30f);
        headPitch = MathHelper.clamp(headPitch, -25f, 45f);

        this.head.yaw = headYaw + 0.017453292f;
        this.head.pitch = headPitch + 0.017453292f;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        bronze.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return bronze;
    }
}
