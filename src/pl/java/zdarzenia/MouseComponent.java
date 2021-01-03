package pl.java.zdarzenia;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class MouseComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    private static final int SIDELENGTH = 10;
    private ArrayList<Rectangle2D> squares;
    private Rectangle2D current; // kwadrat zawierajacy kursor

    public MouseComponent() {
        squares = new ArrayList<>();
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

        //Rysowanie wszystkich kwadratow

        for (Rectangle2D square : squares) {
            g2.draw(square);
        }
    }

    // Znajduje pierwszy kwadrat zawierajacy punkt
    // p - punkt
    // return - pierwszy kwadrat zawierajacy punkt p


    public Rectangle2D find(Point2D p) {
        for (Rectangle2D square : squares) {
            if (square.contains(p))
                return square;
        }
        return null;
    }

    public void add (Point2D p) {
        double x = p.getX();
        double y = p.getY();

        current = new Rectangle2D.Double(x - SIDELENGTH /2, y - SIDELENGTH /2, SIDELENGTH, SIDELENGTH);
        squares.add(current);
        repaint();
    }

    public void remove(Rectangle2D s) {
        if (s == null) return;
        if (s == current) current = null;
        squares.remove(s);
        repaint();
    }

    private class MouseHandler extends MouseAdapter {

        public void mousePressed(MouseEvent event) {
            // Dodanie nowego kwadratu, jesli kursor nie jest wenwatrz innego kwadratu
            current = find(event.getPoint());
            if (current == null) add(event.getPoint());
        }

        public void mouseClicked(MouseEvent event) {
            //Usuniecie kwadratu w wyniku jego dwukrotnego klikniecia
            current = find(event.getPoint());
            if(current != null && event.getClickCount() >= 2) remove(current);
        }
    }

    private class MouseMotionHandler implements MouseMotionListener {

        @Override
        public void mouseMoved(MouseEvent event) {
            // Ustawienie kursora na krzyzyk jesli znaduje sie wewnatrz kwadratu

            if(find(event.getPoint()) == null) setCursor(Cursor.getDefaultCursor());
            else setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        }

        @Override
        public void mouseDragged(MouseEvent event) {
            if (current != null) {
                int x = event.getX();
                int y = event.getY();

                //Przeciagniecie aktualnego kwadreatu w celu wysrodkowania go w punkcie (x, y)
                current.setFrame(x - SIDELENGTH/2 , y-SIDELENGTH /2, SIDELENGTH, SIDELENGTH);
                repaint();
            }
        }
    }
}
