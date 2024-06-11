package com.ytrsoft.components.button;

import com.ytrsoft.base.ColorScheme;
import com.ytrsoft.base.ColorType;
import com.ytrsoft.components.border.JDButtonBorder;
import com.ytrsoft.components.icon.JDIcon;
import com.ytrsoft.components.icon.JDIconFont;
import com.ytrsoft.components.icon.LoadingIcon;
import com.ytrsoft.util.SVGIconLoader;

import javax.swing.*;
import java.awt.*;

public class JDButton extends JButton {

    private JDIcon icon;
    private ColorType colorType;
    private boolean isLoading;
    private Icon originalIcon;
    private final LoadingIcon buttonLoading;

    public JDButton(String name) {
        super(name);
        buttonLoading = new LoadingIcon(getFontSize());
    }

    private int getFontSize() {
        return (int) getFont().getSize2D();
    }

    public void setIcon(JDIcon icon) {
        this.icon = icon;
        setIcon(JDIconFont.buildIcon(icon, getFontSize()));
    }

    public void setIcon(JDIcon icon, Color color) {
        setIcon(JDIconFont.buildIcon(icon, getFontSize(), color));
    }

    public void setIcon(String name) {
        setIcon(SVGIconLoader.get(name, getFontSize()));
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        if (!isEnabled()) return;
        isLoading = loading;
        if (isLoading) {
            originalIcon = getIcon();
            setIcon(buttonLoading);
            buttonLoading.start(this);
        } else {
            buttonLoading.stop();
            setIcon(originalIcon);
        }
    }

    public ColorType getColorType() {
        return colorType;
    }

    public void setColorType(ColorType colorType) {
        this.colorType = colorType;
        JDButtonBorder border = new JDButtonBorder();
        Color bg = Color.WHITE;
        Color fg = ColorScheme.PRIMARY_TEXT;
        switch (colorType) {
            case PRIMARY:
                bg = ColorScheme.PRIMARY;
                break;
            case SUCCESS:
                bg = ColorScheme.SUCCESS;
                break;
            case WARNING:
                bg = ColorScheme.WARNING;
                break;
            case DANGER:
                bg = ColorScheme.DANGER;
                break;
            case INFO:
                bg = ColorScheme.INFO;
                break;
        }
        if (ColorType.DEFAULT == colorType) {
            border.setBorderColor(fg);
            setBackground(Color.white);
            setForeground(fg);
            setIcon(icon, fg);
        } else {
            border.setBorderColor(bg);
            setBackground(bg);
            setForeground(Color.white);
            setIcon(icon, Color.white);
        }
        setBorder(border);
    }
}
