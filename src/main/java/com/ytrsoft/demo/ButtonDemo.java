package com.ytrsoft.demo;

import com.ytrsoft.components.button.JDButton;
import com.ytrsoft.components.icon.JDIcon;
import com.ytrsoft.components.view.JDText;
import com.ytrsoft.components.view.JDView;
import com.ytrsoft.base.UseColor;

import javax.swing.*;
import java.awt.*;

public class ButtonDemo extends JDView {

    public ButtonDemo() {
        int rows = UseColor.Type.values().length;
        JDView mainView = new JDView();
        mainView.setLayout(new BoxLayout(mainView, BoxLayout.Y_AXIS));

        for (int i = 0; i < rows; i++) {
            JDView outerView = new JDView();
            outerView.setLayout(new BoxLayout(outerView, BoxLayout.Y_AXIS));
            JDView textView = new JDView();
            textView.setLayout(new FlowLayout(FlowLayout.LEFT));
            String name = UseColor.Type.values()[i].name();
            JDText label = new JDText(name);
            textView.add(label);
            JDView buttonView = new JDView();
            buttonView.setLayout(new FlowLayout(FlowLayout.LEFT));
            JDButton[] group = new JDButton[3];
            for (int j = 0; j < group.length; j++) {
                UseColor.Type value = UseColor.Type.values()[i];
                group[j] = new JDButton("BUTTON");
                group[j].setPreferredSize(new Dimension(120, 32));
                if (j == 2) {
                    group[j].setDisabled(true);
                } else {
                    if (j == 1) {
                        group[j].setPlain(true);
                    }
                    group[j].setType(value);
                    group[j].setIcon(JDIcon.USER_CIRCLE_O);
                    if (value == UseColor.Type.PRIMARY && j == 0) {
                        group[j].setLoading(true);
                        group[j].setText("LOADING");
                    }
                }
                buttonView.add(group[j]);
            }
            outerView.add(textView);
            outerView.add(buttonView);
            mainView.add(outerView);
        }

        add(mainView, BorderLayout.CENTER);
    }

}
