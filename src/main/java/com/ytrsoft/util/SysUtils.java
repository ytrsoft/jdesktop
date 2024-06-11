package com.ytrsoft.util;

public final class SysUtils {

    private SysUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isWin() {
        String osName = System.getProperty("os.name").toLowerCase();
        return !osName.contains("mac");
    }

}
