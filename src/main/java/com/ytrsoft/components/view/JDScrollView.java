package com.ytrsoft.components.view;

import javax.swing.*;

public class JDScrollView extends JScrollPane {
    public JDScrollView(JDView root) {
        super(root);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
}
