package net.wallop.betterprogression.entity.client.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.client.animation.BindAnimations;
import net.wallop.betterprogression.entity.client.animation.BronzeAnimations;
import net.wallop.betterprogression.entity.custom.BindEntity;

public class BindModel<T extends BindEntity> extends SinglePartEntityModel<T> {
    public static final EntityModelLayer BIND = new EntityModelLayer(Identifier.of(BetterProgression.MOD_ID, "bind"), "main");

    private final ModelPart bind;
    private final ModelPart pair1;
    private final ModelPart pair2;
    public BindModel(ModelPart root) {
        this.bind = root.getChild("bind");
        this.pair1 = this.bind.getChild("pair1");
        this.pair2 = this.bind.getChild("pair2");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData bind = modelPartData.addChild("bind", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData pair1 = bind.addChild("pair1", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData spear1 = pair1.addChild("spear1", ModelPartBuilder.create().uv(0, 2).cuboid(-0.5F, 5.0F, -0.5F, 1.0F, 29.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, 0.0F, -7.0F, -0.4363F, -0.7854F, 0.0F));

        ModelPartData cube_r1 = spear1.addChild("cube_r1", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r2 = spear1.addChild("cube_r2", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));

        ModelPartData spear2 = pair1.addChild("spear2", ModelPartBuilder.create().uv(0, 2).cuboid(-0.5F, 5.0F, -0.5F, 1.0F, 29.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, 0.0F, 7.0F, 0.4363F, -0.7854F, 0.0F));

        ModelPartData cube_r3 = spear2.addChild("cube_r3", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r4 = spear2.addChild("cube_r4", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));

        ModelPartData pair2 = bind.addChild("pair2", ModelPartBuilder.create(), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

        ModelPartData spear3 = pair2.addChild("spear3", ModelPartBuilder.create().uv(0, 2).cuboid(-0.5F, 5.0F, -0.5F, 1.0F, 29.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-7.0F, 0.0F, 7.0F, 0.4363F, -0.7854F, 0.0F));

        ModelPartData cube_r5 = spear3.addChild("cube_r5", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r6 = spear3.addChild("cube_r6", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));

        ModelPartData spear4 = pair2.addChild("spear4", ModelPartBuilder.create().uv(0, 2).cuboid(-0.5F, 5.0F, -0.5F, 1.0F, 29.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(7.0F, 0.0F, -7.0F, -0.4363F, -0.7854F, 0.0F));

        ModelPartData cube_r7 = spear4.addChild("cube_r7", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

        ModelPartData cube_r8 = spear4.addChild("cube_r8", ModelPartBuilder.create().uv(4, 0).cuboid(-2.5F, -5.0F, 0.0F, 5.0F, 7.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, -3.1416F, 0.7854F, 3.1416F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(BindEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);

        this.updateAnimation(entity.bindAnimationState, BindAnimations.BIND, ageInTicks, 1f);

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        pair2.render(matrices, vertexConsumer, light, overlay, color);
        pair1.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return bind;
    }
}
