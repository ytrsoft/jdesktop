package com.ytrsoft.demo;

import com.ytrsoft.theme.ThemeType;
import com.ytrsoft.ui.button.DButton;
import com.ytrsoft.ui.view.BView;

public class BtnView extends BView {

    public BtnView() {
        setLayout(null);

        DButton success = new DButton("SUCCESS");
        success.setType(ThemeType.SUCCESS);
        success.setBounds(15, 15, 120, 48);
        add(success);

        DButton primary = new DButton("PRIMARY");
        primary.setType(ThemeType.PRIMARY);
        primary.setBounds(15, 78, 120, 48);
        add(primary);

        DButton info = new DButton("INFO");
        info.setType(ThemeType.INFO);
        info.setBounds(15, 141, 120, 48);
        add(info);

        DButton warning = new DButton("WARNING");
        warning.setType(ThemeType.WARNING);
        warning.setBounds(15, 204, 120, 48);
        add(warning);

        DButton danger = new DButton("DANGER");
        danger.setType(ThemeType.DANGER);
        danger.setBounds(15, 267, 120, 48);
        add(danger);

        DButton _default = new DButton("DEFAULT");
        _default.setType(ThemeType.DEFAULT);
        _default.setBounds(15, 331, 120, 48);
        add(_default);
    }


}
