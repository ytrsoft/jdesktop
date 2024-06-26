package com.ytrsoft.components.icon;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.ArrayList;

public final class JDIconFont {

    private static final List<IconFont> fonts = new ArrayList<>();

    public static synchronized void register(IconFont iconFont) {
        if (!fonts.contains(iconFont)) {
            fonts.add(iconFont);
        }
    }

    public static synchronized Font buildFont(String fontFamily) {
        try {
            for (IconFont iconFont : JDIconFont.fonts) {
                if (iconFont.getFontFamily().equals(fontFamily)) {
                    return Font.createFont(Font.TRUETYPE_FONT, iconFont.getFontInputStream());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private JDIconFont() {
        throw new UnsupportedOperationException();
    }

    private static Color getForeground() {
        return UIManager.getColor("Component.foreground");
    }

    public static Image buildImage(IconCode iconCode, float size) {
        return buildImage(iconCode, size, getForeground());
    }

    public static Image buildImage(IconCode iconCode, float size, Color color) {
        if (iconCode == null) return null;
        Font font = buildFont(iconCode, size);
        String text = Character.toString(iconCode.getUnicode());
        return buildImage(text, font, color);
    }

    public static Icon buildIcon(IconCode iconCode, float size) {
        return buildIcon(iconCode, size, getForeground());
    }

    public static Icon buildIcon(IconCode iconCode, float size, Color color) {
        if (iconCode == null) return null;
        return new ImageIcon(buildImage(iconCode, size, color));
    }

    private static BufferedImage buildImage(String text, Font font, Color color) {
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(font);
        Dimension dim = label.getPreferredSize();
        int width = dim.width + 1;
        int height = dim.height + 1;
        label.setSize(width, height);
        BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufImage.createGraphics();
        setupGraphics(g2d);
        label.print(g2d);
        g2d.dispose();
        return bufImage;
    }

    private static void setupGraphics(Graphics2D g2d) {
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    }

    private static Font buildFont(IconCode iconCode, float size) {
        if (iconCode == null) return null;
        Font font = JDIconFont.buildFont(iconCode.getFontFamily());
        if (font == null) return null;
        return font.deriveFont(size);
    }

}
