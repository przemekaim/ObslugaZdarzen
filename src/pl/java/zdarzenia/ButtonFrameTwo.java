package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;

public class ButtonFrameTwo extends JFrame {
    private final JPanel buttonPanel;
    private final static int DEFAULT_WIDTH = 600;
    private final static int DEFAULT_HEIGHT = 400;

    public ButtonFrameTwo() throws HeadlessException {
        pack();
        buttonPanel = new JPanel();

        add(buttonPanel);

        makeButton("Yellow", Color.YELLOW);
        makeButton("Blue", Color.BLUE);
        makeButton("Red", Color.RED);

        JButton exitButton = new JButton("Exit");
        buttonPanel.add(exitButton);
        exitButton.addActionListener(event -> System.exit(0));
    }

    private void makeButton(String name, Color backgroundColor) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event -> buttonPanel.setBackground(backgroundColor));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}