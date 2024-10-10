package net.epiccool.moistyourself.mixin;

import net.epiccool.moistyourself.effect.ModEffects;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public abstract class EntityMixin extends LivingEntity {
    protected EntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isTouchingWaterOrRain() {
        return super.isTouchingWaterOrRain() || this.hasStatusEffect(ModEffects.MOIST);
    }
}
