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

    private static final ForgeConfigSpec.BooleanValue TARGET_ALL_MOBS = BUILDER
            .comment(
                    "If true, turrets target all living entities (except players, turrets, and the owner). If false, turrets only target vanilla monsters and entities in the tacz_turrets:turret_targets entity type tag.")
            .define("targetAllMobs", false);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean consumeAmmo;
    public static int turretRange;
    public static boolean targetAllMobs;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        consumeAmmo = CONSUME_AMMO.get();
        turretRange = TURRET_RANGE.get();
        targetAllMobs = TARGET_ALL_MOBS.get();
    }
}
