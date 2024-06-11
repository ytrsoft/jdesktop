package com.ytrsoft.base;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.util.SystemInfo;
import com.ytrsoft.components.menu.BarMenuListener;
import com.ytrsoft.components.menu.JDBarMenu;
import com.ytrsoft.components.menu.JDTrayMenu;
import com.ytrsoft.util.ResourceUtils;
import org.apache.commons.lang3.reflect.ConstructorUtils;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Application extends JFrame implements BarMenuListener {

    private static final Toolkit TOOLKIT = Toolkit.getDefaultToolkit();

    public Application() {
        setTitle("JDesktop");
        setIconImage(getLogo());
        setSize(getDefaultSize());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowClosing(this));
        createMenu();
    }

    public void start() {};

    public void stop() {};

    private void createMenu() {
        if (SystemInfo.isWindows) {
            createTrayMenu();
        } else {
            createBarMenu();
        }
    }

    private void createBarMenu() {
        JDBarMenu menu = new JDBarMenu("Theme");
        menu.setOnBarMenuListener(this);
        menu.from(ThemeMode.DARK.keys());
        setMenuBar(menu);
    }

    private void createTrayMenu() {
        JDTrayMenu themeMenu = new JDTrayMenu("Theme");
        themeMenu.setOnBarMenuListener(this);
        themeMenu.from(ThemeMode.DARK.keys());
        themeMenu.setTitle(getTitle());
        themeMenu.setIcon(getLogo());
        themeMenu.setup();
    }

    public Dimension getDefaultSize() {
        Dimension size = TOOLKIT.getScreenSize();
        int w = (int) (size.width * 0.5);
        int h = (int) (size.height * 0.5);
        return new Dimension(w, h);
    }

    public Image getLogo() {
        URL url = ResourceUtils.getResource("/logo.png");
        return TOOLKIT.getImage(url);
    }

    private static void prepareUI() {
        URL url = ResourceUtils.getResource("/themes/");
        FlatLaf.registerCustomDefaultsSource(url);
        FlatDarkLaf.setup();
    }

    private static void createUI(Class<? extends Application> clz) {
        try {
            Application app = ConstructorUtils.invokeConstructor(clz);
            app.setVisible(true);
            app.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void launch(Class<? extends Application> clz) {
        prepareUI();
        SwingUtilities.invokeLater(() -> createUI(clz));
    }

    @Override
    public void selectPerformed(String command) {
        ThemeMode mode = ThemeMode.fromName(command);
        if (mode == ThemeMode.DARK) {
            FlatDarkLaf.setup();
        } else {
            FlatLightLaf.setup();
        }
        SwingUtilities.updateComponentTreeUI(this);
    }

}
