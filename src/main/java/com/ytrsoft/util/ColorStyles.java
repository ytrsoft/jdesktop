package com.ytrsoft.util;

import java.awt.*;

public final class ColorStyles {

    public enum Type {
        DEFAULT,
        PRIMARY,
        SUCCESS,
        INFO,
        WARNING,
        DANGER
    }

    public static final Color WHITE = Color.WHITE;
    public static final Color BLACK = Color.BLACK;

    public static final Color PRIMARY = h("#409EFF");
    public static final Color PRIMARY_LIGHT_1 = h("#53a8ff");
    public static final Color PRIMARY_LIGHT_2 = h("#66b1ff");
    public static final Color PRIMARY_LIGHT_3 = h("#79bbff");
    public static final Color PRIMARY_LIGHT_4 = h("#8cc5ff");
    public static final Color PRIMARY_LIGHT_5 = h("#a0cfff");
    public static final Color PRIMARY_LIGHT_6 = h("#b3d8ff");
    public static final Color PRIMARY_LIGHT_7 = h("#c6e2ff");
    public static final Color PRIMARY_LIGHT_8 = h("#d9ecff");
    public static final Color PRIMARY_LIGHT_9 = h("#ecf5ff");

    public static final Color SUCCESS = h("#67C23A");
    public static final Color SUCCESS_LIGHT = h("#E1F3D8");
    public static final Color SUCCESS_LIGHTER = h("#F0F9EB");

    public static final Color INFO = h("#909399");
    public static final Color INFO_LIGHT = h("#67C23A");
    public static final Color INFO_LIGHTER = h("#67C23A");

    public static final Color WARNING = h("#E6A23C");
    public static final Color WARNING_LIGHT = h("#F2F2F5");
    public static final Color WARNING_LIGHTER = h("#F9F9FB");

    public static final Color DANGER = h("#303133");
    public static final Color DANGER_LIGHT = h("#606266");
    public static final Color DANGER_LIGHTER = h("#909399");

    public static final Color TEXT_PRIMARY = h("#C0C4CC");
    public static final Color TEXT_REGULAR = h("#DCDFE6");
    public static final Color TEXT_SECONDARY = h("#E4E7ED");
    public static final Color TEXT_PLACEHOLDER = h("#EBEEF5");

    public static final Color BORDER_BASE = h("#FDE2E2");
    public static final Color BORDER_LIGHT = h("#FEF0F0");
    public static final Color BORDER_LIGHTER = h("#FDE2E2");
    public static final Color BORDER_EXTRA_LIGHT = h("#FEF0F0");

    public static final Color BG_BASE = h("#F5F7FA");

    private ColorStyles() {
        throw new UnsupportedOperationException();
    }

    private static Color h(String hex) {
        return Color.decode(hex);
    }



}
