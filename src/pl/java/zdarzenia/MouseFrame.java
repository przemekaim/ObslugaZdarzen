package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;

public class MouseFrame extends JFrame {
    public MouseFrame() {
        add(new MouseComponent());
        pack();
        Image icon = new ImageIcon("red-ball.gif").getImage();
        setIconImage(icon);

    }
}
