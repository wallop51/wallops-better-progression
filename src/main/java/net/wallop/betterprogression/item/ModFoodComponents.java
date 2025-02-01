package net.wallop.betterprogression.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodComponents {
    public static final FoodProperties TIN_OIL = new FoodProperties.Builder().nutrition(1).saturationModifier(0.25f).usingConvertsTo(Items.BOWL).alwaysEdible().fast()
            .effect(new MobEffectInstance(MobEffects.HEAL, 1,0,false,false), 1f).build();
}
