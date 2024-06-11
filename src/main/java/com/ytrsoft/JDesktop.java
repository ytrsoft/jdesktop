package com.ytrsoft;

import com.ytrsoft.base.Application;
import com.ytrsoft.demo.ButtonDemo;
import com.ytrsoft.components.tabs.JDTabs;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class JDesktop extends Application {

    private Map<String, Component> tabs() {
        Map<String, Component> maps = new HashMap<>();
        maps.put("按钮", new ButtonDemo());
        return maps;
    }

    @Override
    public void start() {
        JDTabs tabs = new JDTabs();
        tabs.from(tabs());
        add(tabs);
    }

    public static void main(String[] args) {
        launch(JDesktop.class);
    }
}
