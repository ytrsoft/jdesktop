package com.ytrsoft.ui.tabs;

import com.ytrsoft.ui.view.BView;

import javax.swing.*;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class BTabs extends JTabbedPane {

    public BTabs() {}

    public void from(Map<String, BView> map) {
        TreeMap<String, BView> sortedMap = new TreeMap<>(Collections.reverseOrder());
        sortedMap.putAll(map);
        for (Map.Entry<String, BView> entry : sortedMap.entrySet()) {
            addTab(entry.getKey(), entry.getValue());
        }
    }

}
