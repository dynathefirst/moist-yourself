package net.epiccool.moistyourself.mixin;

import net.epiccool.moistyourself.effect.ModEffects;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LeveledCauldronBlock.class)
public class CauldronMixin {
    @Inject(method = "onEntityCollision", at = @At("HEAD"))
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, CallbackInfo ci) {

        if (entity instanceof PlayerEntity player && !world.isClient && !player.hasStatusEffect(ModEffects.MOIST)) {
            if (state.contains(Properties.LEVEL_3)) {
                int waterLevel = state.get(Properties.LEVEL_3);

                if (waterLevel > 1) {
                    state = state.with(Properties.LEVEL_3, waterLevel - 1);
                    world.setBlockState(pos, state);

                    player.addStatusEffect(new StatusEffectInstance(ModEffects.MOIST, 3600, 0));
                } else {
                    world.setBlockState(pos, Blocks.CAULDRON.getDefaultState());
                }
            }
        }
    }
}

