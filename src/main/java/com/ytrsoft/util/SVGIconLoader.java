package com.ytrsoft.util;

import com.kitfox.svg.SVGDiagram;
import com.kitfox.svg.SVGException;
import com.kitfox.svg.SVGUniverse;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class SVGIconLoader {

    public static Icon get(String name, int size) {
        return get(name, size, size);
    }

    public static Icon get(String name, int width, int height) {
        try {
            URL url = Resource.getResource("/svg/" + name + ".svg");
            SVGUniverse svgUniverse = new SVGUniverse();
            URI uri = svgUniverse.loadSVG(url);
            SVGDiagram diagram = svgUniverse.getDiagram(uri);
            return new SVGIcon(diagram, width, height);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class SVGIcon implements Icon {
        private final SVGDiagram diagram;
        private final int width;
        private final int height;

        public SVGIcon(SVGDiagram diagram, int width, int height) {
            this.diagram = diagram;
            this.width = width;
            this.height = height;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.translate(x, y);
            g2d.scale((double) width / diagram.getWidth(), (double) height / diagram.getHeight());
            try {
                diagram.render(g2d);
            } catch (SVGException e) {
                throw new RuntimeException(e);
            } finally {
                g2d.dispose();
            }
        }

        @Override
        public int getIconWidth() {
            return width;
        }

        @Override
        public int getIconHeight() {
            return height;
        }
    }
}
