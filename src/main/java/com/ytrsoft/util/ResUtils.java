package com.ytrsoft.util;

import java.net.URL;

public final class ResUtils {

    private ResUtils() {
        throw new UnsupportedOperationException();
    }

    public static URL getResource(String name) {
        return ResUtils.class.getResource(name);
    }

}
