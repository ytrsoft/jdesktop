package com.ytrsoft.components.button;


import com.ytrsoft.components.border.JDButtonBorder;
import com.ytrsoft.event.MouseState;
import com.ytrsoft.util.ColorStyles;
import org.jdesktop.swingx.JXButton;

import java.awt.*;

public class JDButton extends JXButton implements MouseState.Event {

    private final MouseState mouseState;
    private final JDButtonBorder border;

    private boolean isPlan;
    private boolean isDisabled;
    private ColorStyles.Type type;

    public JDButton(String name) {
        super(name);
        mouseState = new MouseState();
        addMouseListener(mouseState);
        mouseState.setOnEvent(this);
        border = new JDButtonBorder();
        setBorder(border);
    }

    public void setBorderColor(Color color) {
        border.setBorderColor(color);
    }

    private void setButtonStyle() {

    }

    @Override
    public void onEvent(MouseState.MouseEventType type) {
        switch (type) {
            case HOVER:
                // 鼠标移入
                break;
            case ACTIVE:
                // 点击
                break;
            case NORMAL:
                // 正常
        }
    }

    public MouseState getMouseState() {
        return mouseState;
    }
}
