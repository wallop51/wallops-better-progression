package net.wallop.betterprogression.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.wallop.betterprogression.util.ModTags;

public class ModFoodComponents {
    public static final FoodComponent TIN_OIL = new FoodComponent.Builder().nutrition(1).saturationModifier(0.25f).usingConvertsTo(Items.BOWL).alwaysEdible().snack()
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1,1,false,false), 1f).build();
}
