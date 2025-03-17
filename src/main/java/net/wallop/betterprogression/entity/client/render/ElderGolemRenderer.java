package net.wallop.betterprogression.entity.client.render;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.entity.client.model.ElderGolemModel;
import net.wallop.betterprogression.entity.custom.ElderGolemEntity;

public class ElderGolemRenderer extends MobEntityRenderer<ElderGolemEntity, ElderGolemModel<ElderGolemEntity>> {


    public ElderGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new ElderGolemModel<>(context.getPart(ElderGolemModel.ELDER_GOLEM)), 0.75f);
    }

    @Override
    public Identifier getTexture(ElderGolemEntity entity) {
        return Identifier.of(BetterProgression.MOD_ID, "textures/entity/elder_golem/elder_golem.png");
    }
}
