package com.github.chromaticforge.countdown;

import cc.polyfrost.oneconfig.events.EventManager;
import cc.polyfrost.oneconfig.events.event.WorldLoadEvent;
import cc.polyfrost.oneconfig.libs.eventbus.Subscribe;
import com.github.chromaticforge.countdown.config.TNTCountdownConfig;
import com.github.chromaticforge.countdown.utils.ConfigUtils;
import com.github.chromaticforge.countdown.utils.ServerFuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = TNTCountdown.ID, name = TNTCountdown.NAME, version = TNTCountdown.VERSION)
public class TNTCountdown {
    public static final String ID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        new TNTCountdownConfig();
        EventManager.INSTANCE.register(this);
    }

    @Subscribe
    public void onWorldChange(WorldLoadEvent event) {
        ConfigUtils.ADJUSTMENT = ServerFuses.getAdjustment();
        ConfigUtils.MAX_FUSE = 80 + ConfigUtils.ADJUSTMENT;
    }
}