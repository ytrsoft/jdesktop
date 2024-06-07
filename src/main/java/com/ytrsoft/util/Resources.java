package com.ytrsoft.util;

import java.net.URL;

public final class Resources {

    private Resources() {
        throw new UnsupportedOperationException();
    }

    public static URL get(String path) {
        return Resources.class.getResource(path);
    }

}
