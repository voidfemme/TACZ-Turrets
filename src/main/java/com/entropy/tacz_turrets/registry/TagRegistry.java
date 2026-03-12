package com.entropy.tacz_turrets.registry;

import com.entropy.tacz_turrets.TACZTurrets;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class TagRegistry {
    public static final TagKey<EntityType<?>> TURRET_TARGETS = TagKey.create(Registries.ENTITY_TYPE, TACZTurrets.id("turret_targets"));

    public static final TagKey<EntityType<?>> TURRET_IGNORED = TagKey.create(Registries.ENTITY_TYPE, TACZTurrets.id("turret_ignored"));
}
