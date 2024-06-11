package com.ytrsoft.components.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDTrayMenu extends PopupMenu implements ActionListener {

    private final PopupMenu popupMenu;
    private MenuListener menuListener;
    private Image icon;
    private String title;

    public JDTrayMenu(String name) {
        popupMenu = new PopupMenu(name);
    }

    public void setup() {
        TrayIcon trayIcon = new TrayIcon(getIcon(), getTitle(), popupMenu);
        trayIcon.setImageAutoSize(true);
        try {
            SystemTray tray = SystemTray.getSystemTray();
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
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

    public void add(String name) {
        MenuItem item = new MenuItem(name);
        item.setActionCommand(name);
        item.addActionListener(this);
        popupMenu.add(item);
    }

    public void from(String[] names) {
        for (String name: names) {
            add(name);
        }
    }

    public void addMenuListener(MenuListener menuListener) {
        this.menuListener = menuListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.menuListener != null) {
            this.menuListener.click(e.getActionCommand());
        }
    }
}
