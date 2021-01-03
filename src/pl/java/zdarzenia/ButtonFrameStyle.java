package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonFrameStyle extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ButtonFrameStyle() {
        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            System.out.println(info.getName() + " " + info.getClassName());
            makeButton(info.getName(), info.getClassName());
        }

        add(buttonPanel);
        pack();

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(event -> System.exit(0));
        buttonPanel.add(exitButton);


        setLocationByPlatform(true);
    }

    private void makeButton(String name, String classname) {
        JButton button = new JButton(name);
        buttonPanel.add(button);

        // Ustawienie akcji przyciisku
        button.addActionListener(event -> {
            try {
                //buttonPanel.setBackground(Color.BLACK);
                UIManager.setLookAndFeel(classname);
                SwingUtilities.updateComponentTreeUI(this); // buttonPanel
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
