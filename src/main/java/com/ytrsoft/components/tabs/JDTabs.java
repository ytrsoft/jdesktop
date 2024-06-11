package com.ytrsoft.components.tabs;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class JDTabs extends JTabbedPane {

    public void from(Map<String, Component> source) {
        removeAll();
        for (Map.Entry<String, Component> entry : source.entrySet()) {
            String title = entry.getKey();
            Component view = entry.getValue();
            addTab(title, view);
        }
    }

}
