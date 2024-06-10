package com.ytrsoft.base;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UIColor {

    private boolean isPlain;

    private UseColor.Type type = UseColor.Type.DEFAULT;

    private Color m(Color c1, Color c2) {
        return isPlain ? c1 : c2;
    }

    public List<Color> createColors() {
        List<Color> colors = new ArrayList<>();
        switch (type) {
            case PRIMARY:
                colors.add(m(UseColor.PRIMARY, UseColor.WHITE));
                colors.add(m(UseColor.PRIMARY_PLAIN_BG, UseColor.PRIMARY));
                colors.add(m(UseColor.PRIMARY_PLAIN_BORDER, UseColor.PRIMARY));
                colors.add(UseColor.PRIMARY);
                break;
            case SUCCESS:
                colors.add(m(UseColor.SUCCESS, UseColor.WHITE));
                colors.add(m(UseColor.SUCCESS_PLAIN_BG, UseColor.SUCCESS));
                colors.add(m(UseColor.SUCCESS_PLAIN_BORDER, UseColor.SUCCESS));
                colors.add(UseColor.SUCCESS);
                break;
            case WARNING:
                colors.add(m(UseColor.WARNING, UseColor.WHITE));
                colors.add(m(UseColor.WARNING_PLAIN_BG, UseColor.WARNING));
                colors.add(m(UseColor.WARNING_PLAIN_BORDER, UseColor.WARNING));
                colors.add(UseColor.WARNING);
                break;
            case DANGER:
                colors.add(m(UseColor.DANGER, UseColor.WHITE));
                colors.add(m(UseColor.DANGER_PLAIN_BG, UseColor.DANGER));
                colors.add(m(UseColor.DANGER_PLAIN_BORDER, UseColor.DANGER));
                colors.add(UseColor.DANGER);
                break;
            case INFO:
                colors.add(m(UseColor.INFO, UseColor.WHITE));
                colors.add(m(UseColor.INFO_PLAIN_BG, UseColor.INFO));
                colors.add(m(UseColor.INFO_PLAIN_BORDER, UseColor.INFO));
                colors.add(UseColor.INFO);
                break;
            default:
                colors.add(UseColor.TEXT_REGULAR);
                colors.add(UseColor.WHITE);
                colors.add(UseColor.BORDER_COLOR_BASE);
                colors.add(m(UseColor.WHITE, UseColor.PRIMARY_PLAIN_BG));
        }
        return colors;
    }

    public Color getDisabledColor() {
        return UseColor.DISABLED_TEXT;
    }

    public boolean isPlain() {
        return isPlain;
    }

    public void setPlain(boolean plain) {
        isPlain = plain;
    }

    public UseColor.Type getType() {
        return type;
    }

    public void setType(UseColor.Type type) {
        this.type = type;
    }
}
