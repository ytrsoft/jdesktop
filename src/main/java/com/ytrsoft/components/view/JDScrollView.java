package com.ytrsoft.components.view;

import javax.swing.*;
import java.awt.*;

public class JDScrollView extends JScrollPane {

    private final JDView root;

    public static final int X_AXIS = BoxLayout.X_AXIS;
    public static final int Y_AXIS = BoxLayout.Y_AXIS;

    public JDScrollView() {
        this(Y_AXIS);
    }

    public JDScrollView(int axis) {
        root = new JDView();
        root.setLayout(new BoxLayout(root, axis));
        setViewportView(root);
    }

    @Override
    public Component add(Component comp) {
        return root.add(comp);
    }

    @Override
    public Component add(Component comp, int index) {
        return root.add(comp, index);
    }

    @Override
    public Component add(String name, Component comp) {
        return root.add(name, comp);
    }
}
