package club.sk1er.mods.tnttime;

import club.sk1er.mods.tnttime.config.TNTTimeConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = TNTTime.ID, name = TNTTime.NAME, version = TNTTime.VERSION)
public class TNTTime {
    public static final String ID = "@MOD_ID@";
    public static final String NAME = "@MOD_NAME@";
    public static final String VERSION = "@MOD_VERSION@";

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        new TNTTimeConfig();
    }
}