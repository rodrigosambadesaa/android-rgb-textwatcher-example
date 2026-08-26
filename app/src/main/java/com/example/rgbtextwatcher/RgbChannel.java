package com.example.rgbtextwatcher;

public final class RgbChannel {
    public static final int MIN = 0;
    public static final int MAX = 255;

    private RgbChannel() {}

    public static int parseClamped(String value) {
        if (value == null || value.trim().isEmpty()) {
            return MIN;
        }
        try {
            return clamp(Integer.parseInt(value));
        } catch (NumberFormatException exception) {
            return MIN;
        }
    }

    public static int clamp(int value) {
        return Math.max(MIN, Math.min(MAX, value));
    }
}
