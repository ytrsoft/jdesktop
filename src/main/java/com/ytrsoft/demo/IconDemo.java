package com.ytrsoft.demo;

import com.ytrsoft.components.icon.JDIcon;
import com.ytrsoft.components.icon.JDTextIcon;
import com.ytrsoft.components.view.JDScrollView;
import com.ytrsoft.components.view.JDText;
import com.ytrsoft.components.view.JDView;

import javax.swing.*;
import java.awt.*;

public class IconDemo extends JDScrollView {

    public IconDemo() {
        JDIcon[][] jdIcons = chunkJDIcons();
        for (int i = 0; i < jdIcons.length ; i++) {
            JDView jdView = new JDView();
            jdView.setLayout(new FlowLayout());
            for (int j = 0; j < jdIcons[i].length ; j++) {
                JDView iconView = new JDView();
                iconView.setLayout(new FlowLayout());
                JDText text = new JDText(jdIcons[i][j].name());
                iconView.add(text);
                JDTextIcon icon = new JDTextIcon(JDIcon.values()[i]);
                iconView.add(icon);
                jdView.add(iconView);
            }
            add(jdView);
        }
    }

    private JDIcon[][] chunkJDIcons() {
        int size = 4;
        JDIcon[] values = JDIcon.values();
        int totalIcons = values.length;
        int numChunks = (int) Math.ceil((double) totalIcons / size);
        JDIcon[][] chunks = new JDIcon[numChunks][];
        for (int i = 0; i < numChunks; i++) {
            int start = i * size;
            int length = Math.min(size, totalIcons - start);
            JDIcon[] chunk = new JDIcon[length];
            System.arraycopy(values, start, chunk, 0, length);
            chunks[i] = chunk;
        }
        return chunks;
    }
}
