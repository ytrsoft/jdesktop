package com.ytrsoft.demo;

import com.ytrsoft.theme.ThemeType;
import com.ytrsoft.ui.button.DButton;
import com.ytrsoft.ui.view.BView;

import java.awt.*;

public class BtnView extends BView {

    private static final String[] buttonLabels = {
        "SUCCESS",
        "PRIMARY",
        "INFO",
        "WARNING",
        "DANGER",
        "DEFAULT"
    };

    private static final ThemeType[] buttonTypes = {
        ThemeType.SUCCESS,
        ThemeType.PRIMARY,
        ThemeType.INFO,
        ThemeType.WARNING,
        ThemeType.DANGER,
        ThemeType.DEFAULT
    };

    public BtnView() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        BView row1 = new BView();
        row1.setLayout(new FlowLayout());
        for (int i = 0; i < buttonLabels.length; i++) {
            DButton button = new DButton(buttonLabels[i]);
            button.setType(buttonTypes[i]);
            button.setPreferredSize(new Dimension(100, 48));
            row1.add(button);
        }
        BView row2 = new BView();
        row2.setLayout(new FlowLayout());
        for (int i = 0; i < buttonLabels.length; i++) {
            DButton button = new DButton(buttonLabels[i]);
            button.setType(buttonTypes[i]);
            button.setPlan(true);
            button.setPreferredSize(new Dimension(100, 48));
            row2.add(button);
        }
        add(row1);
        add(row2);
    }
}
