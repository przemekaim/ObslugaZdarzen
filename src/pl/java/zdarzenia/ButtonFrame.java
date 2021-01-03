package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        // Tworzenie przyciskow
        JButton yellowButton = new JButton("Zolty");
        JButton blueButton = new JButton("Niebieski");
        JButton redButton = new JButton("Czerwony");
        JButton exitButton = new JButton("Wyjscie");

        buttonPanel = new JPanel();

        // Dodanie przyciskow do panelu

        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        buttonPanel.add(exitButton);

        // Dodanie panelu do ramki
        add(buttonPanel);

        //Utworzenie akcji przyciskow
        //ColorAction yellowAction = new ColorAction(Color.YELLOW);
        //ColorAction blueAction = new ColorAction(Color.BLUE);
        // ColorAction redAction = new ColorAction(Color.RED);

        //Powiazanie akcji z przyciskami

        //yellowButton.addActionListener(yellowAction);
        //blueButton.addActionListener(blueAction);
        //redButton.addActionListener(redAction);

        // To samo tylko z lambda
        yellowButton.addActionListener(event -> buttonPanel.setBackground(Color.YELLOW));
        blueButton.addActionListener(event -> buttonPanel.setBackground(Color.BLUE));
        redButton.addActionListener(event -> buttonPanel.setBackground(Color.RED));
        exitButton.addActionListener(event -> System.exit(0));
        // W wyniku tego klasa wenwetrzna ColorAction nie jest potrzebna

        setLocationByPlatform(true);

    }

    private class ColorAction implements ActionListener {
        private Color backgroundColor;

        public ColorAction(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }

}
