package com.ytrsoft.base;

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
                Constructor<? extends Application> constructor = clazz.getDeclaredConstructor();
                Application app = constructor.newInstance();
                app.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
