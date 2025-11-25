package club.sk1er.mods.tnttime.utils;

import cc.polyfrost.oneconfig.utils.hypixel.HypixelUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;

public class ServerUtils {
    public static boolean isHypixelBedwars() {
        return HypixelUtils.INSTANCE.isHypixel() && scoreboardContains("BED WARS");
    }

    public static boolean isMinemen() {
        return Minecraft.getMinecraft().getCurrentServerData().serverIP.contains("minemen") || scoreboardContains("minemen");
    }

    private static boolean scoreboardContains(String text) {
        WorldClient world = Minecraft.getMinecraft().theWorld;
        if (world == null || world.getScoreboard() == null) return false;

        Scoreboard scoreboard = world.getScoreboard();
        for (ScoreObjective objective : scoreboard.getScoreObjectives()) {
            String name = EnumChatFormatting.getTextWithoutFormattingCodes(objective.getDisplayName());
            if (name != null && name.contains(text)) {
                return true;
            }
        }
        return false;
    }
}
