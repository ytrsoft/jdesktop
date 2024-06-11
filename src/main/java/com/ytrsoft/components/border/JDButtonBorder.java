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

    private Color getEffectiveBorderColor(Component c) {
        return borderColor != null ? borderColor : super.getOutlineColor(c);
    }

    @Override
    protected Color getOutlineColor(Component c) {
        return getEffectiveBorderColor(c);
    }

    @Override
    protected Color getFocusColor(Component c) {
        return getEffectiveBorderColor(c);
    }

    @Override
    protected Paint getBorderColor(Component c) {
        return getEffectiveBorderColor(c);
    }
}
