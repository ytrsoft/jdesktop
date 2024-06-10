package com.ytrsoft.components.button;

import com.ytrsoft.base.UIColor;
import com.ytrsoft.components.border.JDButtonBorder;
import com.ytrsoft.event.MouseState;
import com.ytrsoft.base.UseColor;
import org.jdesktop.swingx.JXButton;

import java.awt.*;
import java.util.List;

public class JDButton extends JXButton implements MouseState.Event {

    private final UIColor uiColor;
    private final MouseState mouseState;
    private final JDButtonBorder border;

    private boolean isLoading;
    private boolean isDisabled;

    public JDButton(String name) {
        super(name);
        mouseState = new MouseState();
        addMouseListener(mouseState);
        mouseState.setOnEvent(this);
        border = new JDButtonBorder();
        uiColor = new UIColor();
        setBorder(border);
        applyStyle();
    }

    public void setBorderColor(Color color) {
        border.setBorderColor(color);
    }

    private void applyStyle() {
        List<Color> colors = uiColor.createColors();
        setForeground(colors.get(0));
        setBackground(colors.get(1));
        setBorderColor(colors.get(2));
        applyDisabledStyle();
    }

    private void applyDisabledStyle() {
        if (isDisabled) {
            setEnabled(false);
            setBorderColor(UseColor.DISABLED_TEXT);
        } else {
            setEnabled(true);
        }
    }

    private void applySelectedStyle() {
        List<Color> colors = uiColor.createColors();
        setForeground(colors.get(0));
        setBackground(colors.get(3));
        setBorderColor(colors.get(2));
        fixedDefault();
    }

    private void fixedDefault() {
        if (getType() == UseColor.Type.DEFAULT) {
            setForeground(UseColor.PRIMARY);
            if (isPlain()) {
                setBorderColor(UseColor.PRIMARY);
            } else {
                setBorderColor(UseColor.PRIMARY_PLAIN_BORDER);
            }
        } else {
            setForeground(UseColor.WHITE);
            setBorderColor(getBackground());
        }
    }

    @Override
    public void onEvent(MouseState.MouseEventType eventType) {
        if (isDisabled) {
            return;
        }
        switch (eventType) {
            case HOVER:
            case ACTIVE:
                applySelectedStyle();
                break;
            case NORMAL:
                applyStyle();
                break;
        }
    }

    public boolean isPlain() {
        return uiColor.isPlain();
    }

    public void setPlain(boolean plain) {
        uiColor.setPlain(plain);
        applyStyle();
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
        applyDisabledStyle();
    }

    public void setType(UseColor.Type type) {
        uiColor.setType(type);
        applyStyle();
    }

    public UseColor.Type getType() {
        return uiColor.getType();
    }

    public MouseState getMouseState() {
        return mouseState;
    }

}
