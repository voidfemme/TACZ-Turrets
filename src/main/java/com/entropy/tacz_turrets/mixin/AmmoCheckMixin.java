package com.entropy.tacz_turrets.mixin;

import com.entropy.tacz_turrets.config.TACZTurretsConfig;
import com.entropy.tacz_turrets.entity.TurretEntity;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.tacz.guns.entity.shooter.LivingEntityAmmoCheck;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntityAmmoCheck.class)
public class AmmoCheckMixin {
    @Shadow(remap = false)
    @Final
    private LivingEntity shooter;

    @ModifyReturnValue(method = "needCheckAmmo", at = @At("RETURN"), remap = false)
    private boolean infiniteAmmoForTurrets(boolean original) {
        if (shooter instanceof TurretEntity) {
            return TACZTurretsConfig.consumeAmmo && original;
        }
        return original;
    }

    @ModifyReturnValue(method = "consumesAmmoOrNot", at = @At("RETURN"), remap = false)
    private boolean allowInfinite(boolean original) {
        if (shooter instanceof TurretEntity) {
            return TACZTurretsConfig.consumeAmmo && original;
        }
        return original;
    }
}
