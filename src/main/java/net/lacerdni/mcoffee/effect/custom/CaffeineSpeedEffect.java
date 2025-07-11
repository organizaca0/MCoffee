package net.lacerdni.mcoffee.effect.custom;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class CaffeineSpeedEffect extends MobEffect {
    public CaffeineSpeedEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x7E5109);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        entity.setDeltaMovement(entity.getDeltaMovement().multiply(1.1 + (amplifier * 0.1), 1, 1.1 + (amplifier * 0.1)));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        return true;
    }
}
