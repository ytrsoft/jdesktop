package com.ytrsoft.demo;

import com.ytrsoft.components.icon.JDIcon;
import com.ytrsoft.components.icon.JDTextIcon;
import com.ytrsoft.components.view.JDScrollView;
import com.ytrsoft.components.view.JDText;
import com.ytrsoft.components.view.JDView;

import javax.swing.*;
import java.awt.*;

public class IconDemo extends JDView {

    public IconDemo() {
        JDView root = new JDView();
        root.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        int iconCount = JDIcon.values().length;
        for (int i = 0; i < iconCount; i++) {
            JDView iconView = new JDView();
            iconView.setLayout(new FlowLayout());
            JDText text = new JDText(JDIcon.values()[i].name());
            text.setHorizontalAlignment(SwingConstants.CENTER);
            iconView.add(text, BorderLayout.NORTH);
            JDTextIcon icon = new JDTextIcon(JDIcon.values()[i]);
            icon.setHorizontalAlignment(SwingConstants.CENTER);
            iconView.add(icon, BorderLayout.CENTER);
            root.add(iconView);
        }
        JDScrollView scrollView = new JDScrollView(root);
        setLayout(new BorderLayout());
        add(scrollView);
    }
}
