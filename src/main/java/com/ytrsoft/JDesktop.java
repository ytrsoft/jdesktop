package com.ytrsoft;

import com.ytrsoft.base.Application;
import com.ytrsoft.components.button.JDButton;

import java.awt.*;

public class JDesktop extends Application {

    @Override
    public void start() {
        setLayout(new FlowLayout());
        JDButton button = new JDButton("JDesktop");
        button.setPreferredSize(new Dimension(120, 48));
        add(button);
    }

    public static void main(String[] args) {
        launch(JDesktop.class);
    }

}