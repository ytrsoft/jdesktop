package com.ytrsoft;

import com.ytrsoft.base.Application;
import com.ytrsoft.theme.ThemeType;
import com.ytrsoft.ui.button.DButton;

public class Startup extends Application {

    @Override
    protected void initialized() {

        getContentPane().setLayout(null);

        DButton success = new DButton("SUCCESS");
        success.setType(ThemeType.SUCCESS);
        success.setBounds(15, 15, 120, 48);
        getContentPane().add(success);

        DButton primary = new DButton("PRIMARY");
        primary.setType(ThemeType.PRIMARY);
        primary.setBounds(15, 78, 120, 48);
        getContentPane().add(primary);

        DButton info = new DButton("INFO");
        info.setType(ThemeType.INFO);
        info.setBounds(15, 141, 120, 48);
        getContentPane().add(info);

        DButton warning = new DButton("WARNING");
        warning.setType(ThemeType.WARNING);
        warning.setBounds(15, 204, 120, 48);
        getContentPane().add(warning);

        DButton danger = new DButton("DANGER");
        danger.setType(ThemeType.DANGER);
        danger.setBounds(15, 267, 120, 48);
        getContentPane().add(danger);

        DButton _default = new DButton("DEFAULT");
        _default.setType(ThemeType.DEFAULT);
        _default.setBounds(15, 331, 120, 48);
        getContentPane().add(_default);
    }

    public static void main(String[] args) {
        launch(Startup.class);
    }
}