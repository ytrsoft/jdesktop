package com.ytrsoft.components.tabs;

import org.apache.commons.collections4.MapUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class JDTabs extends JTabbedPane {

    public void from(Map<String, Component> source) {
        removeAll();
        Map<String, Component> reversedMap = source.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Component>comparingByKey().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        for (Map.Entry<String, Component> entry : reversedMap.entrySet()) {
            String title = entry.getKey();
            Component view = entry.getValue();
            addTab(title, view);
        }
    }
}
