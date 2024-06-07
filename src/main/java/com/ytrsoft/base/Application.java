package com.ytrsoft.base;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.ytrsoft.util.Tools;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;

public abstract class Application extends JFrame {

    public Application() {
        setTitle("App");
        setSize(getDefaultSize());
        setIconImage(Tools.getLogo());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public Dimension getDefaultSize() {
        double scale = 0.5;
        Dimension size = Tools.getScreenSize();
        int w = (int)(size.width * scale);
        int h = (int)(size.height * scale);
        return new Dimension(w, h);
    }

    protected static void launch(Class<? extends Application> clazz) {
        SwingUtilities.invokeLater(() -> {
            try {
                FlatDarculaLaf.setup();
                Application app = clazz.getDeclaredConstructor().newInstance();
                app.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
