package com.ytrsoft.base;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public final class Tools {

    private Tools() {
        throw new UnsupportedOperationException();
    }

    public static Dimension getScreenSize() {
        return  Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static Image getLogo() {
        URL url = Resources.get("/logo.png");
        return Toolkit.getDefaultToolkit().getImage(url);
    }

}
