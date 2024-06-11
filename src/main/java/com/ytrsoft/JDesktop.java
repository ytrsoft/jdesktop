package com.ytrsoft;

import com.ytrsoft.base.Application;
import com.ytrsoft.components.tabs.JDTabs;
import com.ytrsoft.components.view.JDView;
import com.ytrsoft.demo.ButtonDemo;
import com.ytrsoft.demo.IconDemo;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class JDesktop extends Application {

    private Map<String, Component> tabs() {
        Map<String, Component> maps = new HashMap<>();
        IconDemo iconDemo = new IconDemo();
        ButtonDemo buttonDemo = new ButtonDemo();
        maps.put("图标", iconDemo);
        maps.put("按钮", buttonDemo);
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
