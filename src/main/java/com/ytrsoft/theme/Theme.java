package com.ytrsoft.theme;

import java.awt.*;

public final class Theme {

    public static final Color WHITE = hex("#ffffff");
    public static final Color DEFAULT = hex("#606266");

    public static final Color PRIMARY = hex("#409eff");
    public static final Color PRIMARY_HOVER = hex("#66b1ff");
    public static final Color PRIMARY_ACTIVE = hex("#3a8ee6");
    public static final Color PRIMARY_PLAN = hex("#a0cfff");

    public static final Color SUCCESS = hex("#67c23a");
    public static final Color SUCCESS_HOVER = hex("#85ce61");
    public static final Color SUCCESS_ACTIVE = hex("#5daf34");
    public static final Color SUCCESS_PLAN = hex("#f0f9eb");

    public static final Color INFO = hex("#909399");
    public static final Color INFO_HOVER = hex("#a6a9ad");
    public static final Color INFO_ACTIVE = hex("#82848a");
    public static final Color INFO_PLAN = hex("#f4f4f5");

    public static final Color WARNING = hex("#e6a23c");
    public static final Color WARNING_HOVER = hex("#ebb563");
    public static final Color WARNING_ACTIVE = hex("#cf9236");
    public static final Color WARNING_PLAN = hex("#fdf6ec");

    public static final Color DANGER = hex("#f56c6c");
    public static final Color DANGER_HOVER = hex("#f78989");
    public static final Color DANGER_ACTIVE = hex("#dd6161");
    public static final Color DANGER_PLAN = hex("#fef0f0");

    private Theme() {
        throw new UnsupportedOperationException();
    }

    public static Color hex(String value) {
        return Color.decode(value);
    }

    public static Color getBackground(ThemeChanger changer) {
        switch (changer.getType()) {
            case PRIMARY:
                if (changer.isActive()) return PRIMARY_ACTIVE;
                if (changer.isHover()) return PRIMARY_HOVER;
                return changer.isPlan() ? PRIMARY_PLAN : PRIMARY;
            case SUCCESS:
                if (changer.isActive()) return SUCCESS_ACTIVE;
                if (changer.isHover()) return SUCCESS_HOVER;
                return changer.isPlan() ? SUCCESS_PLAN : SUCCESS;
            case INFO:
                if (changer.isActive()) return INFO_ACTIVE;
                if (changer.isHover()) return INFO_HOVER;
                return changer.isPlan() ? INFO_PLAN : INFO;
            case WARNING:
                if (changer.isActive()) return WARNING_ACTIVE;
                if (changer.isHover()) return WARNING_HOVER;
                return changer.isPlan() ? WARNING_PLAN : WARNING;
            case DANGER:
                if (changer.isActive()) return DANGER_ACTIVE;
                if (changer.isHover()) return DANGER_HOVER;
                return changer.isPlan() ? DANGER_PLAN : DANGER;
        }
        return WHITE;
    }

    public static Color getForeground(ThemeChanger changer) {
        boolean selected = changer.isHover() || changer.isActive();
        switch (changer.getType()) {
            case PRIMARY:
                if (selected) return WHITE;
                return changer.isPlan() ? PRIMARY : WHITE;
            case SUCCESS:
                if (selected) return WHITE;
                return changer.isPlan() ? SUCCESS : WHITE;
            case INFO:
                if (selected) return WHITE;
                return changer.isPlan() ? INFO : WHITE;
            case WARNING:
                if (selected) return WHITE;
                return changer.isPlan() ? WARNING : WHITE;
            case DANGER:
                if (selected) return WHITE;
                return changer.isPlan() ? DANGER : WHITE;
        }
        if (selected) return PRIMARY;
        return DEFAULT;
    }


}
