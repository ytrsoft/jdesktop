package com.ytrsoft.util;

import java.io.InputStream;
import java.net.URL;

public final class ResourceUtils {

    private ResourceUtils() {
        throw new UnsupportedOperationException();
    }

    public static URL getResource(String resourceName) {
        return ResourceUtils.class.getResource(resourceName);
    }

    public static InputStream getResourceAsStream(String resourceName) {
        return ResourceUtils.class.getResourceAsStream(resourceName);
    }

}
