package com.entropy.tacz_turrets;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = TACZTurrets.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TACZTurretsConfig {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue CONSUME_AMMO = BUILDER
            .comment("Whether turrets need ammo")
            .define("consumeAmmo", true);

    private static final ForgeConfigSpec.IntValue TURRET_RANGE = BUILDER
            .comment("Turret detection and engagement range in blocks")
            .defineInRange("turretRange", 64, 8, 128);

    private static final ForgeConfigSpec.IntValue TURRET_HEALTH = BUILDER
            .comment("Initial health for new turrets. Will not affect existing turrets")
            .defineInRange("turretHealth", 200, 10, 1000);

    private static final ForgeConfigSpec.BooleanValue TARGET_ALL_MOBS = BUILDER
            .comment(
                    "If true, turrets target all living entities (except players, turrets, and the owner). If false, turrets only target vanilla monsters and entities in the tacz_turrets:turret_targets entity type tag.")
            .define("targetAllMobs", false);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean consumeAmmo = CONSUME_AMMO.getDefault();
    public static int turretRange = TURRET_RANGE.getDefault();
    public static int turretHealth = TURRET_HEALTH.getDefault();
    public static boolean targetAllMobs = TARGET_ALL_MOBS.getDefault();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        consumeAmmo = CONSUME_AMMO.get();
        turretRange = TURRET_RANGE.get();
        turretHealth = TURRET_HEALTH.get();
        targetAllMobs = TARGET_ALL_MOBS.get();
    }
}
