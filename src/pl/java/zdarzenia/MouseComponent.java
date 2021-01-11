package pl.java.zdarzenia;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;



public class MouseComponent extends JComponent {
    private final static int DEFAULT_WIDTH = 600;
    private final static int DEFAULT_HEIGHT = 400;

    private final static int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> rect;
    private Rectangle2D current;

    public MouseComponent() {
        rect = new ArrayList<>();
        current = null;

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseMotionHandler());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        for (Rectangle2D rectangle2D : rect) {
            g2.draw(rectangle2D);
        }
    }

    public Rectangle2D find(Point2D p) {
        for (Rectangle2D r : rect) {
            if (r.contains(p))
                return r;
        }
        return null;
    }

    public void add(Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
        rect.add(current);
        repaint();
    }

    public void remove(Rectangle2D r) {
        if (r == null) return;
        if (r == current) current = null;
        rect.remove(r);
        repaint();

        /*
        if (r == current)
            rect.remove(r);
        repaint();
         */
    }

    private class MouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            current = find(e.getPoint());
            if (current != null && e.getClickCount() >= 2)
                remove(current);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            current = find(e.getPoint());
            if (current == null)
                add(e.getPoint());
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
            if (current != null) {
                double x = e.getX();
                double y = e.getY();

                current.setFrame(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }

        // Wlasny kursor
/*
Toolkit kit = Toolkit.get...
Image img = tk.getImage("nazwa");
Cursor name = tk.createCus...(img, new Point(10,10), "sztick");

 */

        @Override
        public void mouseMoved(MouseEvent e) {
            Toolkit kit = Toolkit.getDefaultToolkit();
            Image image = kit.getImage("red-ball.gif");
            Cursor name = kit.createCustomCursor(image, new Point(10,10), "aaa");
            if (find(e.getPoint()) == null)
                setCursor(Cursor.getDefaultCursor());
            else
                setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            //setCursor(name);
        }
    }
}
