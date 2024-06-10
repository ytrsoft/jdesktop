package com.ytrsoft.base;

import com.formdev.flatlaf.FlatDarkLaf;
import com.ytrsoft.components.icon.IconFont;
import com.ytrsoft.components.icon.JDIcon;
import com.ytrsoft.components.icon.JDIconFont;
import org.jdesktop.swingx.JXFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

public class Application extends JXFrame {

    private static final double SIZE_SCALE = 0.5;

    static class WindowClosing extends WindowAdapter {

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

    public Application() {
        super("JDesktop", true);
        setSize(getDefaultSize());
        setIconImage(getLogo());
        setLocationRelativeTo(null);
        addWindowListener(new WindowClosing(this));
    }

    public Image getLogo() {
        URL url = getClass().getResource("/logo.png");
        return Toolkit.getDefaultToolkit().getImage(url);
    }

    private static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

    public Dimension getDefaultSize() {
        Dimension size = getScreenSize();
        int w = (int)(size.width * SIZE_SCALE);
        int h = (int)(size.height * SIZE_SCALE);
        return new Dimension(w, h);
    }


    public void init() {};

    public void start() {};

    public void stop() {};

    public static void launch(Class<? extends Application> clz) {
        SwingUtilities.invokeLater(() -> {
            try {
                FlatDarkLaf.setup();
                JDIconFont.register(JDIcon.getIconFont());
                Application app = clz.getDeclaredConstructor().newInstance();
                app.init();
                app.start();
                app.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
