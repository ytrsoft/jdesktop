package com.ytrsoft.components.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDBarMenu extends MenuBar implements ActionListener {

    private final Menu menu;
    private BarMenuListener listener;

    public JDBarMenu(String cmd) {
        menu = new Menu(cmd);
        add(menu);
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
}
