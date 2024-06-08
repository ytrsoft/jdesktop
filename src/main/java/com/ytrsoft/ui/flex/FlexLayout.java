package com.ytrsoft.ui.flex;

import java.awt.*;

public class FlexLayout extends FlexAdapter {

    @Override
    protected Dimension calculateLayoutSize(Container view) {
        return new Dimension(0, 0);
    }

    @Override
    public void layoutContainer(Container parent) {
        System.out.println(parent);
    }
}
