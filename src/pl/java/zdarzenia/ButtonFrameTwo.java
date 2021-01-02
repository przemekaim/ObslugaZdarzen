package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ButtonFrameTwo extends JFrame{
    private JPanel buttonPanel;
    private final static int DEFAULT_WIDTH = 300;
    private final static int DEFAULT_HEIGHT = 200;

    public ButtonFrameTwo() {
        //setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        pack();
        buttonPanel = new JPanel();

        add(buttonPanel);

        makeButton("Zolty", Color.YELLOW);
        makeButton("Niebieski", Color.BLUE);
        makeButton("Czerwony", Color.RED);

        JButton exitButton = new JButton("Wyjscie");
        buttonPanel.add(exitButton);
        exitButton.addActionListener(event -> System.exit(0));
    }

    private void makeButton(String name, Color backgroundColor) {
        JButton button = new JButton(name);
        buttonPanel.add(button);
        button.addActionListener(event -> buttonPanel.setBackground(backgroundColor));
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
