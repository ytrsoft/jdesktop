package com.ytrsoft.base;

public enum ThemeMode {

    LIGHT("Light"),
    DARK("Dark");

    public final String name;

    ThemeMode(String name) {
        this.name = name;
    }

    public static ThemeMode fromName(String name) {
        if (name.equals(LIGHT.name)) {
            return ThemeMode.LIGHT;
        }
        return ThemeMode.DARK;
    }

    public static String[] keys() {
        return new String[] { LIGHT.name, DARK.name };
    }

}
