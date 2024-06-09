package com.ytrsoft.demo;

import com.ytrsoft.theme.Theme;
import com.ytrsoft.theme.ThemeType;
import com.ytrsoft.ui.button.DButton;
import com.ytrsoft.ui.flex.FlexLayout;
import com.ytrsoft.ui.view.BView;
import org.jdesktop.swingx.JXButton;

import javax.swing.*;
import java.awt.*;

public class FlexView extends BView {

    public FlexView() {
        FlexLayout flex = new FlexLayout();
        flex.setDirection(FlexLayout.ROW);
        setLayout(flex);
        BView view1 = new BView();
        view1.setBackground(Theme.PRIMARY);
        BView view2 = new BView();
        view1.setBackground(Theme.SUCCESS);
        BView view3 = new BView();
        view1.setBackground(Theme.INFO);
        BView view4 = new BView();
        view1.setBackground(Theme.WARNING);
        BView view5 = new BView();
        view1.setBackground(Theme.DANGER);
        add(view1);
        add(view2);
        add(view3);
        add(view4);
        add(view5);
        flex.setGrow(0, 1);
        flex.setGrow(1, 2);
        flex.setGrow(2, 3);
        flex.setGrow(3, 4);
        flex.setGrow(4, 5);
    }


}
