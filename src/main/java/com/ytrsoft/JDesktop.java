package com.ytrsoft;

import com.ytrsoft.base.Application;
import org.jdesktop.swingx.JXButton;

import java.awt.*;

public class JDesktop extends Application {

    @Override
    public void start() {
        setLayout(new FlowLayout());
        JXButton button = new JXButton("JDesktop");
        button.setPreferredSize(new Dimension(120, 48));
        add(button);
    }

    public static void main(String[] args) {
        launch(JDesktop.class);
    }

}