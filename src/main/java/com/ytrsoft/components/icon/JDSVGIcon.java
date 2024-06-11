package com.ytrsoft.components.icon;

import com.ytrsoft.util.SVGIconLoader;

import javax.swing.*;

public class JDSVGIcon extends JLabel {

    public void setIcon(String name, int width, int height) {
        super.setIcon(SVGIconLoader.get(name, width, height));
    }

}
