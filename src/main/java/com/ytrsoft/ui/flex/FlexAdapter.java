package com.ytrsoft.ui.flex;

import java.awt.*;
import java.util.*;

public abstract class FlexAdapter implements LayoutManager2, Flexible {

    public static final int ROW = 0x000001;
    public static final int ROW_REVERSE = 0x000002;
    public static final int COLUMN = 0x000003;
    public static final int COLUMN_REVERSE = 0x000004;

    public static final int NOWRAP = 0x000005;
    public static final int WRAP = 0x000006;
    public static final int WRAP_REVERSE = 0x000007;

    public static final int START = 0x000008;
    public static final int END = 0x000009;
    public static final int CENTER = 0x00000A;
    public static final int BASELINE = 0x00000B;
    public static final int STRETCH = 0x00000C;
    public static final int SPACE_BETWEEN = 0x00000D;
    public static final int SPACE_AROUND = 0x00000E;
    public static final int SPACE_EVENLY = 0x00000F;

    public Map<Component, FlexItem> items = new HashMap<>();
    public Map<String, Component> compMap = new HashMap<>();

    protected int alignContent = START;
    protected int direction = ROW;
    protected int wrap = NOWRAP;
    protected int justifyContent = START;

    private FlexItem getFlexItem(int index) {
        return new ArrayList<>(items.values()).get(index);
    }

    @Override
    public void setAlignContent(int value) {
        this.alignContent = value;
    }

    @Override
    public void setDirection(int value) {
        this.direction = value;
    }

    @Override
    public void setWrap(int value) {
        this.wrap = value;
    }

    @Override
    public void setJustifyContent(int value) {
        this.justifyContent = value;
    }


    @Override
    public void setGap(int index, int value) {
        getFlexItem(index).setGap(value);
    }

    @Override
    public void setBasis(int index, int value) {
        getFlexItem(index).setBasis(value);
    }

    @Override
    public void setAlignSelf(int index, int value) {
        getFlexItem(index).setAlignSelf(value);
    }

    @Override
    public void setOrder(int index, int value) {
        getFlexItem(index).setOrder(value);
    }

    @Override
    public void setShrink(int index, int value) {
        getFlexItem(index).setShrink(value);
    }

    @Override
    public void setGrow(int index, int value) {
        getFlexItem(index).setGrow(value);
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
        FlexItem item = new FlexItem();
        item.setName(name);
        compMap.put(name, comp);
        addLayoutComponent(comp, item);
    }

    @Override
    public void addLayoutComponent(Component comp, Object flexItem) {
        if (flexItem == null) {
            items.put(comp, new FlexItem());
        }
        if (flexItem instanceof FlexItem) {
            items.put(comp, (FlexItem)flexItem);
        }

    }

    @Override
    public void removeLayoutComponent(Component comp) {
        String name = items.get(comp).getName();
        items.remove(comp);
        if (name != null) {
            compMap.remove(name);
        }
    }

    @Override
    public void invalidateLayout(Container target) {}

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return calculateLayoutSize(parent);
    }

    @Override
    public Dimension maximumLayoutSize(Container target) {
        return calculateLayoutSize(target);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return calculateLayoutSize(parent);
    }

    @Override
    public float getLayoutAlignmentX(Container target) {
        return 0;
    }

    @Override
    public float getLayoutAlignmentY(Container target) {
        return 0;
    }

    protected abstract Dimension calculateLayoutSize(Container view);

}
