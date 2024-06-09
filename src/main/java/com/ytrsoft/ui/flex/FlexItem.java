package com.ytrsoft.ui.flex;


public class FlexItem {

    private int order = 0;
    private int shrink = 1;
    private int grow = 1;
    private int alignSelf = FlexAdapter.STRETCH;
    private int basis = -1;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getShrink() {
        return shrink;
    }

    public void setShrink(int shrink) {
        this.shrink = shrink;
    }

    public int getGrow() {
        return grow;
    }

    public void setGrow(int grow) {
        this.grow = grow;
    }

    public int getAlignSelf() {
        return alignSelf;
    }

    public void setAlignSelf(int alignSelf) {
        this.alignSelf = alignSelf;
    }

    public int getBasis() {
        return basis;
    }

    public void setBasis(int basis) {
        this.basis = basis;
    }

}
