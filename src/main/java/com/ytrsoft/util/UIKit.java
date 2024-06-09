package com.ytrsoft.util;

import com.ytrsoft.components.view.JDView;

import javax.swing.*;
import javax.swing.border.Border;

public final class UIKit {

    private UIKit() {
        throw new UnsupportedOperationException();
    }

    public static void padding(JDView view, int s) {
        padding(view, s, s, s, s);
    }

    public static void padding(JDView view, int x, int y) {
        padding(view, y, x, y, x);
    }

    public static void padding(JDView view, int top, int left, int bottom, int right) {
        Border border = BorderFactory.createEmptyBorder(top, left, bottom, right);
        view.setBorder(border);
    }

}
