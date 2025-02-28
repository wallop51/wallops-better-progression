package net.wallop.betterprogression.entity.client.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.client.model.BindModel;
import net.wallop.betterprogression.entity.custom.BindEntity;

public class BindRenderer extends LivingEntityRenderer<BindEntity, BindModel<BindEntity>> {
    public static final Identifier TEXTURE = Identifier.of(BetterProgression.MOD_ID, "textures/entity/bronze_spear/bronze_spear.png");

    public BindRenderer(EntityRendererFactory.Context context) {
        super(context, new BindModel<>(context.getPart(BindModel.BIND)), 0);
    }

    @Override
    public Identifier getTexture(BindEntity entity) {
        return TEXTURE;
    }
}
