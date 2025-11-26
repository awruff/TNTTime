package com.github.chromaticforge.countdown.utils;

import cc.polyfrost.oneconfig.config.core.OneColor;
import com.github.chromaticforge.countdown.config.TNTCountdownConfig;

import java.awt.*;
import java.text.DecimalFormat;

public class ConfigUtils {
    public static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("0.00");

    public static int ADJUSTMENT = 0;
    public static int MAX_FUSE = 80;

    public static String getTimerText(int ticks) {
        final int fuseTimer = getAdjustedFuse(ticks);

        if (fuseTimer < 1) return null;

        String time = DECIMAL_FORMATTER.format(fuseTimer / 20f);

        return TNTCountdownConfig.timerText.replace("%VALUE%", time);
    }

    public static Color getFuseColor(int ticks) {
        float fuse = getAdjustedFuse(ticks);
        float divisor = MAX_FUSE;
        float progress = Math.min(fuse / divisor, 1f);
        return interpolateColor(progress);
    }

    private static int getAdjustedFuse(int ticks) {
        return ticks + ADJUSTMENT;
    }

    private static Color interpolateColor(float progress) {
        OneColor start = TNTCountdownConfig.startColor;
        OneColor end = TNTCountdownConfig.endColor;

        int r = lerp(start.getRed(), end.getRed(), progress);
        int g = lerp(start.getGreen(), end.getGreen(), progress);
        int b = lerp(start.getBlue(), end.getBlue(), progress);

        return new Color(r, g, b);
    }

    private static int lerp(int start, int end, float progress) {
        return (int) (end + progress * (start - end));
    }
}
