package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame {
    private final JPanel buttonPanel;
    private final static int DEFAULT_WIDTH = 600;
    private final static int DEFAULT_HEIGHT = 400;

    public ButtonFrame() throws HeadlessException {
        buttonPanel = new JPanel();
        pack();

        JButton yellowButton = new JButton("Yellow", new ImageIcon("yellow-ball.gif"));
        JButton blueButton = new JButton("Blue", new ImageIcon("blue-ball.gif"));
        JButton redButton = new JButton("Red", new ImageIcon("red-ball.gif"));

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);

        add(buttonPanel);

        ActionColor yellowAction = new ActionColor(Color.YELLOW);
        ActionColor blueAction = new ActionColor(Color.BLUE);
        ActionColor redAction = new ActionColor(Color.RED);

        yellowButton.addActionListener(yellowAction);
        blueButton.addActionListener(blueAction);
        redButton.addActionListener(redAction);

        // LAMBDA
        //yellowButton.addActionListener(event -> buttonPanel.setBackground(Color.YELLOW));
        //blueButton.addActionListener(event -> buttonPanel.setBackground(Color.BLUE));
        //yellowButton.addActionListener(event -> buttonPanel.setBackground(Color.RED));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    private class ActionColor implements ActionListener {
        private final Color backgroundColor;

        public ActionColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}
