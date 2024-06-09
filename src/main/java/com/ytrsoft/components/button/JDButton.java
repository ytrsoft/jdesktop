package com.ytrsoft.components.button;

import com.ytrsoft.components.border.JDButtonBorder;
import com.ytrsoft.event.MouseState;
import com.ytrsoft.util.UIColor;
import org.jdesktop.swingx.JXButton;

import java.awt.*;

public class JDButton extends JXButton implements MouseState.Event {

    private final MouseState mouseState;
    private final JDButtonBorder border;

    private boolean isPlain;
    private boolean isDisabled;
    private UIColor.Type type = UIColor.Type.DEFAULT;

    public JDButton(String name) {
        super(name);
        mouseState = new MouseState();
        addMouseListener(mouseState);
        mouseState.setOnEvent(this);
        border = new JDButtonBorder();
        setBorder(border);
        setButtonStyle();
    }

    public void setBorderColor(Color color) {
        border.setBorderColor(color);
    }

    private void setButtonStyle() {
        JDButtonStyles styles = JDButtonStyles.getStyles(type, isPlain);
        setForeground(styles.getForeground());
        setBackground(styles.getBackground());
        setBorderColor(styles.getBorder());
        disabledStyle();
    }

    private void disabledStyle() {
        if (isDisabled) {
            setEnabled(false);
            setBorderColor(UIColor.DISABLED_TEXT);
        } else {
            setEnabled(true);
        }
    }

    private void setHoverStyle() {
        JDButtonStyles styles = JDButtonStyles.getStyles(type, isPlain);
        setForeground(styles.getForeground());
        setBackground(styles.getHover());
        setBorderColor(styles.getBorder());
        setDefault();
    }

    private void setActiveStyle() {
        JDButtonStyles styles = JDButtonStyles.getStyles(type, isPlain);
        setForeground(styles.getForeground());
        setBackground(styles.getActive());
        setBorderColor(styles.getBorder());
        setDefault();
    }

    private void setDefault() {
        if (type == UIColor.Type.DEFAULT) {
            setForeground(UIColor.PRIMARY);
            if (isPlain) {
                setBorderColor(UIColor.PRIMARY);
            } else {
                setBorderColor(UIColor.PRIMARY_PLAIN_BORDER);
            }
        } else {
            setForeground(UIColor.WHITE);
            setBorderColor(getBackground());
        }
        disabledStyle();
    }

    @Override
    public void onEvent(MouseState.MouseEventType eventType) {
        if (isDisabled) {
            return;
        }

        switch (eventType) {
            case HOVER:
                setHoverStyle();
                break;
            case ACTIVE:
                setActiveStyle();
                break;
            case NORMAL:
                setButtonStyle();
                break;
        }
    }

    public boolean isPlain() {
        return isPlain;
    }

    public void setPlain(boolean plain) {
        isPlain = plain;
        setButtonStyle();
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        isDisabled = disabled;
        setButtonStyle();
    }

    public UIColor.Type getType() {
        return type;
    }

    public void setType(UIColor.Type type) {
        this.type = type;
        setButtonStyle();
    }

    public MouseState getMouseState() {
        return mouseState;
    }
}
