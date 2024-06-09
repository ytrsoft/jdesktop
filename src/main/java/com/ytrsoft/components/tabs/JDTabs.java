package com.ytrsoft.components.tabs;

import com.ytrsoft.components.view.JDView;

import javax.swing.*;
import java.util.Map;

public class JDTabs extends JTabbedPane {

    public void from(Map<String, JDView> source) {
        removeAll();
        for (Map.Entry<String, JDView> entry : source.entrySet()) {
            String title = entry.getKey();
            JDView view = entry.getValue();
            addTab(title, view);
        }
    }

}
