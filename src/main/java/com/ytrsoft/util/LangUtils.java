package com.ytrsoft.util;

public final class LangUtils {

    private LangUtils() {
        throw new UnsupportedOperationException();
    }

    public static boolean isWin() {
        String osName = System.getProperty("os.name").toLowerCase();
        return !osName.contains("mac");
    }

}
