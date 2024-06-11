package com.ytrsoft.demo;

import com.ytrsoft.base.ColorType;
import com.ytrsoft.components.button.JDButton;
import com.ytrsoft.components.icon.JDIcon;
import com.ytrsoft.components.tabs.JDView;
import com.ytrsoft.util.Settings;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ButtonDemo extends JDView implements ActionListener {

    private static final int SIZE = 10;
    private static final int GAP = Settings.SPACE;

    public ButtonDemo() {
        setLayout(new GridLayout(SIZE, SIZE, GAP, GAP));
        for (int i = 1; i <= SIZE * SIZE; i++) {
            JDButton button = new JDButton("咖啡");
            button.setActionCommand(String.valueOf(i));
            button.setIcon(JDIcon.COFFEE);
            button.setColorType(getRandomColorType());
            button.addActionListener(this);
            add(button);
        }
    }

    public static ColorType getRandomColorType() {
        ColorType[] values = ColorType.values();
        int index = new Random().nextInt(values.length);
        return values[index];
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String n = e.getActionCommand();
        System.out.println("第" + n + "个按钮被点击");
    }

}
