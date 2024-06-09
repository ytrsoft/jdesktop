package com.ytrsoft.components.button;

import com.ytrsoft.util.UIColor;

import java.awt.*;

public class JDButtonStyles {

    private final Color foreground;
    private final Color background;
    private final Color border;
    private final Color hover;
    private final Color active;

    public JDButtonStyles(Color foreground, Color background, Color border, Color hover, Color active) {
        this.foreground = foreground;
        this.background = background;
        this.border = border;
        this.hover = hover;
        this.active = active;
    }

    public Color getForeground() {
        return foreground;
    }

    public Color getBackground() {
        return background;
    }

    public Color getBorder() {
        return border;
    }

    public Color getHover() {
        return hover;
    }

    public Color getActive() {
        return active;
    }

    public static JDButtonStyles getStyles(UIColor.Type type, boolean isPlain) {
        switch (type) {
            case PRIMARY:
                return new JDButtonStyles(
                    isPlain ? UIColor.PRIMARY : UIColor.WHITE,
                    isPlain ? UIColor.PRIMARY_PLAIN_BG : UIColor.PRIMARY,
                    isPlain ? UIColor.PRIMARY_PLAIN_BORDER : UIColor.PRIMARY,
                    UIColor.PRIMARY,
                    UIColor.PRIMARY
                );
            case SUCCESS:
                return new JDButtonStyles(
                    isPlain ? UIColor.SUCCESS : UIColor.WHITE,
                    isPlain ? UIColor.SUCCESS_PLAIN_BG : UIColor.SUCCESS,
                    isPlain ? UIColor.SUCCESS_PLAIN_BORDER : UIColor.SUCCESS,
                    UIColor.SUCCESS,
                    UIColor.SUCCESS
                );
            case WARNING:
                return new JDButtonStyles(
                    isPlain ? UIColor.WARNING : UIColor.WHITE,
                    isPlain ? UIColor.WARNING_PLAIN_BG : UIColor.WARNING,
                    isPlain ? UIColor.WARNING_PLAIN_BORDER : UIColor.WARNING,
                    UIColor.WARNING,
                    UIColor.WARNING
                );
            case DANGER:
                return new JDButtonStyles(
                    isPlain ? UIColor.DANGER : UIColor.WHITE,
                    isPlain ? UIColor.DANGER_PLAIN_BG : UIColor.DANGER,
                    isPlain ? UIColor.DANGER_PLAIN_BORDER : UIColor.DANGER,
                    UIColor.DANGER,
                    UIColor.DANGER
                );
            case INFO:
                return new JDButtonStyles(
                    isPlain ? UIColor.INFO : UIColor.WHITE,
                    isPlain ? UIColor.INFO_PLAIN_BG : UIColor.INFO,
                    isPlain ? UIColor.INFO_PLAIN_BORDER : UIColor.INFO,
                    UIColor.INFO,
                    UIColor.INFO
                );
            case DEFAULT:
            default:
                return new JDButtonStyles(
                    UIColor.TEXT_REGULAR,
                    UIColor.WHITE,
                    UIColor.BORDER_COLOR_BASE,
                    isPlain ? UIColor.WHITE : UIColor.PRIMARY_PLAIN_BG,
                    isPlain ? UIColor.WHITE : UIColor.PRIMARY_PLAIN_BG
                );
        }
    }
}
