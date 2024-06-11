package com.ytrsoft.util;

import java.io.InputStream;
import java.net.URL;

public final class Resource {

    private Resource() {
        throw new UnsupportedOperationException();
    }

    public static URL getResource(String resourceName) {
        return Resource.class.getResource(resourceName);
    }

    public static InputStream getResourceAsStream(String resourceName) {
        return Resource.class.getResourceAsStream(resourceName);
    }

}
