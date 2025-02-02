package net.wallop.betterprogression.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Supplier;

@Mixin(ToolMaterials.class)
public abstract class ModToolMaterialModifiers {

    @WrapOperation(
            method = "<clinit>",
            at = @At(value = "NEW",target = "(Ljava/lang/String;ILnet/minecraft/registry/tag/TagKey;IFFILjava/util/function/Supplier;)Lnet/minecraft/item/ToolMaterials;")
    )
    private static ToolMaterials modifiedToolMaterial(String name, int ordinal, TagKey<Block> inverseTag, int itemDurability, float miningSpeed,
                                              float attackDamage, int enchantablility, Supplier<Ingredient> repairIngredient, Operation<ToolMaterials> original) {
        switch (name) {
            case "STONE":
                miningSpeed = 2.8f;
                break;
            case "IRON":
                itemDurability = 900;
                break;
            default: break;
        }
        return original.call(name, ordinal, inverseTag, itemDurability, miningSpeed, attackDamage, enchantablility, repairIngredient);
    }
}
