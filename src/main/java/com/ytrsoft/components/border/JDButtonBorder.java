package com.ytrsoft.components.border;

import com.formdev.flatlaf.ui.FlatButtonBorder;

import java.awt.*;

public class JDButtonBorder extends FlatButtonBorder {

    private Color borderColor;

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    protected Color getOutlineColor(Component c) {
        return borderColor != null ? borderColor : super.getOutlineColor(c);
    }

    @Override
    protected Color getFocusColor(Component c) {
        return borderColor != null ? borderColor : super.getOutlineColor(c);
    }

    @Override
    protected Paint getBorderColor(Component c) {
        return borderColor != null ? borderColor : super.getBorderColor(c);
    }

}
