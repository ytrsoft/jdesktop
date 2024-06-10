package com.ytrsoft.base;

import java.awt.*;

public final class UseColor {

    public enum Type {
        DEFAULT,
        PRIMARY,
        SUCCESS,
        INFO,
        WARNING,
        DANGER
    }

    public static final Color WHITE = new Color(0xFFFFFF);
    public static final Color BLACK = new Color(0x000000);
    public static final Color TEXT_REGULAR = new Color(0x606266);
    public static final Color BORDER_COLOR_BASE = new Color(0xDCDFE6);

    public static final Color PRIMARY = new Color(0x409EFF);
    public static final Color PRIMARY_LIGHT = new Color(0x66b1ff);
    public static final Color PRIMARY_DARK = new Color(0x3a8ee6);
    public static final Color PRIMARY_PLAIN_BG = new Color(0xecf5ff);
    public static final Color PRIMARY_PLAIN_BORDER = new Color(0xb3d8ff);
    public static final Color PRIMARY_PLAIN_HOVER = new Color(0xd9ecff);

    public static final Color SUCCESS = new Color(0x67C23A);
    public static final Color SUCCESS_LIGHT = new Color(0x85ce61);
    public static final Color SUCCESS_DARK = new Color(0x5daf34);
    public static final Color SUCCESS_PLAIN_BG = new Color(0xf0f9eb);
    public static final Color SUCCESS_PLAIN_BORDER = new Color(0xc2e7b0);
    public static final Color SUCCESS_PLAIN_HOVER = new Color(0xe1f3d8);

    public static final Color WARNING = new Color(0xE6A23C);
    public static final Color WARNING_LIGHT = new Color(0xebb563);
    public static final Color WARNING_DARK = new Color(0xcf9236);
    public static final Color WARNING_PLAIN_BG = new Color(0xfdf6ec);
    public static final Color WARNING_PLAIN_BORDER = new Color(0xf5dab1);
    public static final Color WARNING_PLAIN_HOVER = new Color(0xfaecd8);

    public static final Color DANGER = new Color(0xF56C6C);
    public static final Color DANGER_LIGHT = new Color(0xf78989);
    public static final Color DANGER_DARK = new Color(0xdd6161);
    public static final Color DANGER_PLAIN_BG = new Color(0xfef0f0);
    public static final Color DANGER_PLAIN_BORDER = new Color(0xfbc4c4);
    public static final Color DANGER_PLAIN_HOVER = new Color(0xfde2e2);

    public static final Color INFO = new Color(0x909399);
    public static final Color INFO_LIGHT = new Color(0xa6a9ad);
    public static final Color INFO_DARK = new Color(0x82848a);
    public static final Color INFO_PLAIN_BG = new Color(0xf4f4f5);
    public static final Color INFO_PLAIN_BORDER = new Color(0xd3d4d6);
    public static final Color INFO_PLAIN_HOVER = new Color(0xe9e9eb);

    public static final Color DISABLED_TEXT = new Color(0x909090);

    private UseColor() {
        throw new UnsupportedOperationException();
    }
    
}
