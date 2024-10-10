package net.epiccool.moistyourself.effect;

import net.epiccool.moistyourself.MoistYourself;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> MOIST = registerStatusEffect("moist",
            new MoistEffect(StatusEffectCategory.NEUTRAL, 0x676ece, ParticleTypes.RAIN));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MoistYourself.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        MoistYourself.LOGGER.info("Registering Mod Effects for " + MoistYourself.MOD_ID);
    }
}
