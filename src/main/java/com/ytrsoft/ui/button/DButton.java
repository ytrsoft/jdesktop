package com.ytrsoft.ui.button;

import com.ytrsoft.theme.Theme;
import com.ytrsoft.theme.ThemeChanger;
import com.ytrsoft.theme.ThemeType;
import org.jdesktop.swingx.JXButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DButton extends JXButton implements MouseListener {

    private final ThemeChanger changer;

    public DButton(String text) {
        super(text);
        setFocusable(false);
        setRolloverEnabled(false);
        setRequestFocusEnabled(false);
        addMouseListener(this);
        changer = new ThemeChanger();
        changer.setComponent(this);
    }

    private void updateTheme() {
        setForeground(Theme.getForeground(changer));
        setBackground(Theme.getBackground(changer));
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        SwingUtilities.invokeLater(this::updateTheme);
    }

    public void setPlan(boolean value) {
        changer.setPlan(value);
        updateTheme();
    }

    public void setType(ThemeType value) {
        changer.setType(value);
        updateTheme();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        changer.setActive(true);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        changer.setActive(false);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        changer.setHover(true);
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        changer.setHover(false);
        repaint();
    }
}
