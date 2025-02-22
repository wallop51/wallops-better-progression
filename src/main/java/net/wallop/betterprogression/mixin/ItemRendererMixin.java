package net.wallop.betterprogression.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.client.render.item.ItemModels;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.wallop.betterprogression.BetterProgression;
import net.wallop.betterprogression.component.ModDataComponentTypes;
import net.wallop.betterprogression.item.ModItems;
import net.wallop.betterprogression.item.custom.BronzeSpearItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.logging.Logger;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    private final ModelIdentifier BRONZE_SPEAR_IN_HAND = ModelIdentifier.ofInventoryVariant(Identifier.of(BetterProgression.MOD_ID, "bronze_spear_in_hand"));
    private final ModelIdentifier BRONZE_SPEAR_THROWING = ModelIdentifier.ofInventoryVariant(Identifier.of(BetterProgression.MOD_ID,"bronze_spear_throwing"));

    @Shadow
    @Final
    private ItemModels models;

    @Shadow
    public abstract ItemModels getModels();

    @ModifyVariable(
            method = "renderItem(Lnet/minecraft/item/ItemStack;Lnet/minecraft/client/render/model/json/ModelTransformationMode;ZLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IILnet/minecraft/client/render/model/BakedModel;)V",
            at = @At(value = "HEAD"),
            argsOnly = true
    )
    public BakedModel renderItem(BakedModel bakedModel, @Local(argsOnly = true) ItemStack stack, @Local(argsOnly = true) ModelTransformationMode renderMode) {
        if (stack.getItem() == ModItems.BRONZE_SPEAR && (renderMode == ModelTransformationMode.GUI || renderMode == ModelTransformationMode.GROUND || renderMode == ModelTransformationMode.FIXED)) {
            return getModels().getModelManager().getModel(ModelIdentifier.ofInventoryVariant(Identifier.of(BetterProgression.MOD_ID, "bronze_spear")));
        }

        return bakedModel;
    }

    @ModifyVariable(
            method = "getModel",
            at = @At(value = "STORE"),
            ordinal = 1
    )
    public BakedModel getHeldItemModelMixin(BakedModel bakedModel, @Local(argsOnly = true) ItemStack stack) {
        if (stack.isOf(ModItems.BRONZE_SPEAR)) {
            bakedModel = this.models.getModelManager().getModel(BRONZE_SPEAR_IN_HAND);
        } else return bakedModel;

        if (stack.get(ModDataComponentTypes.THROWING) != null) {
            if (Boolean.TRUE.equals(stack.get(ModDataComponentTypes.THROWING))) {
                bakedModel = this.models.getModelManager().getModel(BRONZE_SPEAR_THROWING);
            } else return bakedModel;
        }
        return bakedModel;
    }
}
