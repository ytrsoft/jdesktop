package com.ytrsoft;

import com.ytrsoft.base.Application;
import com.ytrsoft.demo.BtnView;
import com.ytrsoft.demo.FlexView;
import com.ytrsoft.ui.tabs.BTabs;
import com.ytrsoft.ui.view.BView;

import java.util.HashMap;
import java.util.Map;

public class Startup extends Application {

    @Override
    protected void initialized() {
        Map<String, BView> map = new HashMap<>();
        map.put("按钮", new BtnView());
        map.put("弹性布局", new FlexView());
        BTabs tabs = new BTabs();
        tabs.from(map);
        add(tabs);
    }

    public static void main(String[] args) {
        launch(Startup.class);
    }
}