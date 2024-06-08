package com.ytrsoft.base;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.ytrsoft.util.Tools;
import org.jdesktop.swingx.JXFrame;
import org.jdesktop.swingx.plaf.LoginPaneAddon;
import org.jdesktop.swingx.plaf.LoginPaneUI;

import javax.swing.*;
import java.awt.*;

public abstract class Application extends JXFrame {

    public Application() {
        super("JDesktop", false);
        setSize(getDefaultSize());
        setIconImage(Tools.getLogo());
        setLocationRelativeTo(null);
        initialized();
    }

    protected abstract void initialized();

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
