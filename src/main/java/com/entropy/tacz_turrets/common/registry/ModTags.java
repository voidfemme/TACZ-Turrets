package com.entropy.tacz_turrets.common.registry;

import com.entropy.tacz_turrets.TACZTurrets;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class ModTags {
    public static final TagKey<EntityType<?>> TURRET_TARGETS = TagKey.create(
            Registries.ENTITY_TYPE,
            new ResourceLocation(TACZTurrets.MODID, "turret_targets"));

    public static final TagKey<EntityType<?>> TURRET_IGNORED = TagKey.create(
        Registries.ENTITY_TYPE,
        new ResourceLocation(TACZTurrets.MODID, "turret_ignored")
    );
}
