package com.github.chromaticforge.countdown.utils;

import cc.polyfrost.oneconfig.utils.hypixel.HypixelUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;

public class ServerUtils {
    public static boolean isHypixel() {
        return HypixelUtils.INSTANCE.isHypixel() && scoreboardTitleContains("BED WARS");
    }

    public static boolean isMinemen() {
        return serverIPContains("minemen") || scoreboardContains("minemen");
    }

    public static boolean isVoxyl() {
        return serverIPContains("bedwarspractice") || scoreboardContains("bedwarspractice")
                || serverIPContains("voxyl") || scoreboardContains("voxyl");
    }

    private static boolean serverIPContains(String text) {
        ServerData data = Minecraft.getMinecraft().getCurrentServerData();
        if (data == null) return false;

        return data.serverIP.contains(text);
    }

    private static boolean scoreboardTitleContains(String text) {
        return scoreboardContainsInSlot(text, 1);
    }

    private static boolean scoreboardContains(String text) {
        WorldClient world = Minecraft.getMinecraft().theWorld;
        if (world == null || world.getScoreboard() == null) return false;

        Scoreboard scoreboard = world.getScoreboard();
        int objectives = scoreboard.getScoreObjectives().size();

        for (int i = 1; i <= objectives; i++) {
            if (scoreboardContainsInSlot(text, i)) {
                return true;
            }
        }

        return false;
    }

    private static boolean scoreboardContainsInSlot(String text, int slot) {
        WorldClient world = Minecraft.getMinecraft().theWorld;
        if (world == null || world.getScoreboard() == null) return false;

        Scoreboard scoreboard = world.getScoreboard();
        ScoreObjective objective = scoreboard.getObjectiveInDisplaySlot(slot);
        String display = EnumChatFormatting.getTextWithoutFormattingCodes(objective.getDisplayName());
        return display.contains(text);
    }
}
