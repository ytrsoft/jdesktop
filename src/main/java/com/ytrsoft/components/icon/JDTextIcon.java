package com.ytrsoft.components.icon;

import javax.swing.*;

public class JDTextIcon extends JLabel {

    private int getFontSize() {
        return (int) getFont().getSize2D();
    }

    public void setIcon(JDIcon icon) {
        super.setIcon(JDIconFont.buildIcon(icon, getFontSize()));
    }

}
