package com.ytrsoft.components.demo;

import com.ytrsoft.components.tabs.JDView;
import com.ytrsoft.util.Settings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo extends JDView implements ActionListener {

    private static final int SIZE = 10;
    private static final int GAP = Settings.SPACE;

    public ButtonDemo() {
        setLayout(new GridLayout(SIZE, SIZE, GAP, GAP));
        for (int i = 1; i <= SIZE * SIZE; i++) {
            JButton button = new JButton("按钮");
            button.setActionCommand(String.valueOf(i));
            button.addActionListener(this);
            add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = e.getActionCommand();
        System.out.println("第" + n + "个按钮被点击");
    }

}
