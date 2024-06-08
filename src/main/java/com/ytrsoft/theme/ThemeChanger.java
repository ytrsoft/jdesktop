package com.ytrsoft.theme;

import javax.swing.*;

public class ThemeChanger {

    private JComponent component;
    private boolean isHover = false;
    private boolean isActive = false;
    private boolean isPlan = false;
    private ThemeType type = ThemeType.DEFAULT;

    public ThemeType getType() {
        return type;
    }

    public void setType(ThemeType type) {
        this.type = type;
    }

    public JComponent getComponent() {
        return component;
    }

    public void setComponent(JComponent component) {
        this.component = component;
    }

    public boolean isHover() {
        return isHover;
    }

    public void setHover(boolean hover) {
        isHover = hover;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isPlan() {
        return isPlan;
    }

    public void setPlan(boolean plan) {
        isPlan = plan;
    }
}
