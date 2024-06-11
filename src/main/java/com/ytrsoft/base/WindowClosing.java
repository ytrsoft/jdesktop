package com.ytrsoft.base;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowClosing extends WindowAdapter {

    private final Application app;

    public WindowClosing(Application app) {
        this.app = app;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        app.stop();
        System.exit(0);
    }

}
