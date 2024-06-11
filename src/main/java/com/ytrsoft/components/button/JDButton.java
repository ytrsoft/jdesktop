package com.ytrsoft.components.button;

import com.ytrsoft.components.icon.JDIcon;
import com.ytrsoft.components.icon.JDIconFont;
import com.ytrsoft.components.icon.LoadingIcon;

import javax.swing.*;

public class JDButton extends JButton {

    private boolean isLoading;
    private Icon originalIcon;
    private final LoadingIcon buttonLoading;

    public JDButton(String name) {
        super(name);
        buttonLoading = new LoadingIcon(getFontSize());
    }

    private int getFontSize() {
        return (int) getFont().getSize2D();
    }

    public void setIcon(JDIcon icon) {
        setIcon(JDIconFont.buildIcon(icon, getFontSize()));
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        if (!isEnabled()) return;
        isLoading = loading;
        if (isLoading) {
            originalIcon = getIcon();
            setIcon(buttonLoading);
            buttonLoading.start(this);
        } else {
            buttonLoading.stop();
            setIcon(originalIcon);
        }
    }
}
