package net.epiccool.moistyourself.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleEffect;

public class MoistEffect extends StatusEffect {
    public MoistEffect(StatusEffectCategory statusEffectCategory, int i, ParticleEffect particleEffect) {
        super(statusEffectCategory, i, particleEffect);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration == 1;
    }
}