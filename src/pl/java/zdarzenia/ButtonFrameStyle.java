package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;

public class ButtonFrameStyle extends JFrame {
    private final JPanel buttonPanel;
    private final static int DEFAULT_WIDTH = 600;
    private final static int DEFAULT_HEIGHT = 400;

    public ButtonFrameStyle() {
        pack();
        buttonPanel = new JPanel();

        add(buttonPanel);

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();

        for (UIManager.LookAndFeelInfo info : infos) {
            System.out.println(info.getName() + " " + info.getClassName() + " " + info.getClass());
            makeButton(info.getName(), info.getClassName());
        }
    }

    private void makeButton(String name, String className) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event -> {
            try {
                UIManager.setLookAndFeel(className);
                SwingUtilities.updateComponentTreeUI(this);
                pack();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}