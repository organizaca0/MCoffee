package net.lacerdni.mcoffee.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties COFFEE_SEEDS = (new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.1f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F)
            .build()
    );

    public static final FoodProperties TOASTED_COFFEE_BEANS = (new FoodProperties.Builder()
            .nutrition(2)
            .saturationMod(0.1f)
            .fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1.0F)
            .build()
    );
}
