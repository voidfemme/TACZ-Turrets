package com.entropy.tacz_turrets.client.model;

import com.entropy.tacz_turrets.TACZTurrets;
import com.entropy.tacz_turrets.entity.TurretEntity;
import com.entropy.tacz_turrets.item.TurretItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TurretItemModel extends GeoModel<TurretItem> {
    @Override
    public ResourceLocation getModelResource(TurretItem turretItem) {
        return TACZTurrets.id("geo/entity/turret.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TurretItem turretItem) {
        return TurretEntity.TurretState.NO_GUN.getPath();
    }

    @Override
    public ResourceLocation getAnimationResource(TurretItem turretItem) {
        return TACZTurrets.id("animations/entity/turret.animation.json");
    }
}
