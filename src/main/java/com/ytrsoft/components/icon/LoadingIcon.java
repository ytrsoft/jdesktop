package com.ytrsoft.components.icon;

import javax.swing.*;
import java.awt.*;

public class LoadingIcon implements Icon {

    private final int size;
    private int angle;
    private Timer timer;
    private Component component;

    public LoadingIcon(int size) {
        this.size = size;
        this.angle = 0;
        createTimer();
    }

    private void createTimer() {
        this.timer = new Timer(100, e -> {
            angle += 30;
            if (angle >= 360) {
                angle = 0;
            }
            if (component != null) {
                component.repaint();
            }
        });
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int points = 12;
        int radius = size / 2;
        int centerX = x + radius;
        int centerY = y + radius;
        g2.rotate(Math.toRadians(angle), centerX, centerY);
        for (int i = 0; i < points; i++) {
            double theta = (2 * Math.PI / points) * i;
            int x1 = (int) (radius * Math.cos(theta)) + centerX;
            int y1 = (int) (radius * Math.sin(theta)) + centerY;
            float alpha = 1.0f - (i / (float) points);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            g2.setColor(new Color(255, 255, 255, (int) (255 * alpha)));
            g2.setStroke(new BasicStroke(2));
            g2.drawLine(centerX, centerY, x1, y1);
        }
        g2.dispose();
    }

    @Override
    public int getIconWidth() {
        return size;
    }

    @Override
    public int getIconHeight() {
        return size;
    }

    public void start(Component component) {
        this.component = component;
        if (!timer.isRunning()) {
            timer.start();
        }
    }

    public void stop() {
        if (timer.isRunning()) {
            timer.stop();
        }
        this.component = null;
    }
}
