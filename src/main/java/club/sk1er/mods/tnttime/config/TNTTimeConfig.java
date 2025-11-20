package club.sk1er.mods.tnttime.config;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import club.sk1er.mods.tnttime.TNTTime;

public class TNTTimeConfig extends Config {
    public TNTTimeConfig() {
        super(new Mod(TNTTime.NAME, ModType.HYPIXEL), TNTTime.ID + ".json");
        initialize();
    }
}
