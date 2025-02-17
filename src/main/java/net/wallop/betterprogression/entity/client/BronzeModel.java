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

    public BronzeModel(ModelPart root) {
        this.bronze = root.getChild("bronze");
        this.head = this.bronze.getChild("head");
        ModelPart rods = this.bronze.getChild("rods");
        ModelPart bottomrods = rods.getChild("bottomrods");
        ModelPart rod1 = bottomrods.getChild("rod1");
        ModelPart rod2 = bottomrods.getChild("rod2");
        ModelPart rod3 = bottomrods.getChild("rod3");
        ModelPart rod4 = bottomrods.getChild("rod4");
        ModelPart toprods = rods.getChild("toprods");
        ModelPart rod5 = toprods.getChild("rod5");
        ModelPart rod6 = toprods.getChild("rod6");
        ModelPart rod7 = toprods.getChild("rod7");
        ModelPart rod8 = toprods.getChild("rod8");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bronze = modelPartData.addChild("bronze", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        ModelPartData head = bronze.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -19.0F, 0.0F));

        ModelPartData rods = bronze.addChild("rods", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData bottomrods = rods.addChild("bottomrods", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rod1 = bottomrods.addChild("rod1", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -2.0F, 2.0F));

        ModelPartData cube_r1 = rod1.addChild("cube_r1", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1745F, 0.0F, 0.1745F));

        ModelPartData rod2 = bottomrods.addChild("rod2", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -2.0F, -1.0F));

        ModelPartData cube_r2 = rod2.addChild("cube_r2", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.1745F, 0.0F, 0.1745F));

        ModelPartData rod3 = bottomrods.addChild("rod3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r3 = rod3.addChild("cube_r3", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.0F, -2.0F, 0.1745F, 0.0F, -0.1745F));

        ModelPartData rod4 = bottomrods.addChild("rod4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r4 = rod4.addChild("cube_r4", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -2.0F, 2.0F, -0.1745F, 0.0F, -0.1745F));

        ModelPartData toprods = rods.addChild("toprods", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rod5 = toprods.addChild("rod5", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r5 = rod5.addChild("cube_r5", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -12.0F, 6.0F, -0.1745F, 0.0F, 0.1745F));

        ModelPartData rod6 = toprods.addChild("rod6", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r6 = rod6.addChild("cube_r6", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -12.0F, -5.0F, 0.1745F, 0.0F, -0.1745F));

        ModelPartData rod7 = toprods.addChild("rod7", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r7 = rod7.addChild("cube_r7", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, -12.0F, 6.0F, -0.1745F, 0.0F, -0.1745F));

        ModelPartData rod8 = toprods.addChild("rod8", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData cube_r8 = rod8.addChild("cube_r8", ModelPartBuilder.create().uv(0, 16).cuboid(0.0F, -16.0F, -1.0F, 1.0F, 16.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(5.0F, -12.0F, -5.0F, 0.1745F, 0.0F, 0.1745F));
        return TexturedModelData.of(modelData, 32, 33);
    }

    @Override
    public void setAngles(BronzeEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
//        this.setHeadAngles(netHeadYaw, headPitch);

        // animate movement here

        this.updateAnimation(entity.idleAnimationState, BronzeAnimations.IDLE, ageInTicks, 1f);

    }

//    private void setHeadAngles(float headYaw, float headPitch) {
//        headYaw = MathHelper.clamp(headYaw, -30f, 30f);
//        headPitch = MathHelper.clamp(headPitch, -25f, 45f);
//
//        this.head.yaw = headYaw + 0.017453292f;
//        this.head.pitch = headPitch + 0.017453292f;
//        this.head.roll = 0;
//    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        bronze.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return bronze;
    }
}
