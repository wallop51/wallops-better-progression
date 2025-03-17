package net.wallop.betterprogression.entity.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.client.animation.ElderGolemAnimations;
import net.wallop.betterprogression.entity.custom.ElderGolemEntity;

public class ElderGolemModel<T extends ElderGolemEntity> extends SinglePartEntityModel<ElderGolemEntity> {
    public static final EntityModelLayer ELDER_GOLEM = new EntityModelLayer(Identifier.of(BetterProgression.MOD_ID, "elder_golem"), "main");
    private final ModelPart root;
    private final ModelPart hip;
    private final ModelPart torso;
    private final ModelPart head;
    public ElderGolemModel(ModelPart root) {
        this.root = root.getChild("root");
        this.hip = this.root.getChild("hip");
        this.torso = this.hip.getChild("torso");
        this.head = this.torso.getChild("head");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData hip = root.addChild("hip", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -24.0F, 6.0F));

        ModelPartData torso = hip.addChild("torso", ModelPartBuilder.create().uv(64, 53).cuboid(-8.0F, 0.0F, -4.0F, 16.0F, 6.0F, 7.0F, new Dilation(0.0F))
                .uv(0, 0).cuboid(-9.0F, -14.0F, -11.0F, 18.0F, 14.0F, 14.0F, new Dilation(0.0F))
                .uv(80, 112).cuboid(-4.0F, -7.0F, -10.0F, 8.0F, 8.0F, 8.0F, new Dilation(0.0F))
                .uv(64, 5).cuboid(-3.0F, -15.0F, -7.0F, 6.0F, 15.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData arms = torso.addChild("arms", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -9.0F, -6.0F));

        ModelPartData right_arm = arms.addChild("right_arm", ModelPartBuilder.create().uv(0, 28).cuboid(-17.0F, -8.0F, -6.0F, 8.0F, 41.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData left_arm = arms.addChild("left_arm", ModelPartBuilder.create().uv(0, 28).mirrored().cuboid(9.0F, -8.0F, -6.0F, 8.0F, 41.0F, 8.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData head = torso.addChild("head", ModelPartBuilder.create().uv(64, 31).cuboid(-5.0F, -12.0F, -10.0F, 10.0F, 12.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, -6.0F, 0.0436F, 0.0F, 0.0F));

        ModelPartData brow = head.addChild("brow", ModelPartBuilder.create().uv(54, 2).cuboid(-5.0F, -10.0F, -11.0F, 10.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData legs = hip.addChild("legs", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

        ModelPartData left_leg = legs.addChild("left_leg", ModelPartBuilder.create().uv(0, 77).mirrored().cuboid(3.0F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData right_leg = legs.addChild("right_leg", ModelPartBuilder.create().uv(64, 66).cuboid(-9.0F, 0.0F, -3.0F, 6.0F, 18.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        return TexturedModelData.of(modelData, 128, 128);
    }
    @Override
    public void setAngles(ElderGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(ElderGolemAnimations.WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30f, 30f);
        headPitch = MathHelper.clamp(headPitch, -25f, 45f);

        this.head.yaw = headYaw * 0.017453292f;
        this.head.pitch = headPitch * 0.017453292f;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }
}