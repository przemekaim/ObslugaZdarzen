package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> EventQueue.invokeLater(() -> {
                JFrame frame = new ButtonFrame();
                frame.setTitle("ButtonFrame");
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            });
            case 2 -> EventQueue.invokeLater(() -> {
                JFrame frame = new ButtonFrameTwo();
                frame.setTitle("ButtonFrameTwo");
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowActivated(WindowEvent e) {
                        System.out.println("Window activated");
                    }

                    @Override
                    public void windowIconified(WindowEvent e) {
                        System.exit(0);
                    }

                });
            });
            case 3 -> EventQueue.invokeLater(() -> {
                JFrame frame = new ButtonFrameStyle();
                frame.setTitle("ButtonFrameStyle");
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            });
            case 4 -> EventQueue.invokeLater(() -> {
                JFrame frame = new ActionFrame();
                frame.setTitle("ActionFrame");
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            });
            case 5 -> EventQueue.invokeLater(() -> {
                JFrame frame = new MouseFrame();
                frame.setTitle("MouseFrame");
                frame.setVisible(true);
                frame.setLocationRelativeTo(null);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            });
        }
    }
}
