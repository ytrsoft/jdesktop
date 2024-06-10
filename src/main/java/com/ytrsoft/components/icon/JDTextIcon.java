package com.ytrsoft.components.icon;

import com.ytrsoft.base.UseColor;
import com.ytrsoft.components.view.JDText;

import java.awt.*;

public class JDTextIcon extends JDText {

    private JDIcon icon;

    public JDTextIcon(JDIcon icon) {
        super(null);
        this.icon = icon;
        buildIcon(icon, UseColor.WHITE);
    }

    private void buildIcon(JDIcon icon, Color color) {
        float size2D = getFont().getSize2D();
        setIcon(JDIconFont.buildIcon(icon, size2D, color));
    }

    @Override
    public void setForeground(Color fg) {
        super.setForeground(fg);
        buildIcon(icon, fg);
    }
}
