package com.ytrsoft.base;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.ytrsoft.components.icon.JDIcon;
import com.ytrsoft.components.icon.JDIconFont;
import com.ytrsoft.components.menu.JDMenuBar;
import com.ytrsoft.components.menu.JDTrayMenu;
import com.ytrsoft.components.menu.MenuListener;
import com.ytrsoft.util.LangUtils;
import org.jdesktop.swingx.JXFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.Objects;

public class Application extends JXFrame implements MenuListener {

    private static final double SIZE_SCALE = 0.5;
    private static final String[] THEME_MODE = new String[]{"Dark", "Light"};

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
        createTrayOrMenu();
        addWindowListener(new WindowClosing(this));
    }

    @Override
    public void click(String command) {
        try {
            if (Objects.equals(command, "Dark")) {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } else {
                UIManager.setLookAndFeel(new FlatLightLaf());
            }
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void createTrayOrMenu() {
        boolean isWin = LangUtils.isWin();
        if (!isWin) {
            createMacMenu();
        } else {
            createTrayIcon();
        }
    }

    private void createMacMenu() {
        JDMenuBar themeBar = new JDMenuBar("Theme");
        themeBar.addMenuListener(this);
        themeBar.from(THEME_MODE);
        setMenuBar(themeBar);
    }

    private void createTrayIcon() {
        JDTrayMenu themeMenu = new JDTrayMenu("Theme");
        themeMenu.addMenuListener(this);
        themeMenu.from(THEME_MODE);
        themeMenu.setTitle(getTitle());
        themeMenu.setIcon(getLogo());
        themeMenu.setup();
    }

    public Image getLogo() {
        URL url = getClass().getResource("/logo.png");
        return Toolkit.getDefaultToolkit().getImage(url);
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

    private static Dimension getScreenSize() {
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

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
