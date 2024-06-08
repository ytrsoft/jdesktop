package com.ytrsoft;

import com.ytrsoft.base.Application;
import org.jdesktop.swingx.JXLoginPane;

public class Startup extends Application {

    @Override
    protected void initialized() {
        getContentPane().add(new JXLoginPane());
    }

    public static void main(String[] args) {
        launch(Startup.class);
    }

}
