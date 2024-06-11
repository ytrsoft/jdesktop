package com.ytrsoft.components.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDTrayMenu extends MenuBar implements ActionListener {

    private final PopupMenu menu;
    private BarMenuListener listener;
    private Image icon;
    private String title;

    public JDTrayMenu(String cmd) {
        menu = new PopupMenu(cmd);
        add(menu);
    }

    public void setup() {
        TrayIcon trayIcon = new TrayIcon(icon, title, menu);
        trayIcon.setImageAutoSize(true);
        try {
            SystemTray tray = SystemTray.getSystemTray();
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void add(String cmd) {
        MenuItem item = new MenuItem(cmd);
        item.setActionCommand(cmd);
        item.addActionListener(this);
        menu.add(item);
    }

    public void from(String[] commands) {
        for (String cmd: commands) {
            add(cmd);
        }
    }

    public void setOnBarMenuListener(BarMenuListener listener) {
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.listener != null) {
            String cmd = e.getActionCommand();
            this.listener.selectPerformed(cmd);
        }
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PopupMenu getMenu() {
        return menu;
    }

}
