package com.ytrsoft.components.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JDMenuBar extends MenuBar implements ActionListener {

    private final Menu menu;
    private MenuListener menuListener;

    public JDMenuBar(String name) {
        menu = new Menu(name);
        add(menu);
    }

    public void add(String name) {
        MenuItem item = new MenuItem(name);
        item.setActionCommand(name);
        item.addActionListener(this);
        menu.add(item);
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
