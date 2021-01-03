package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionFrame extends JFrame {
    private JPanel buttonPanel;
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public ActionFrame() {
        buttonPanel = new JPanel();

        //Definicje akcji
        Action yellowAction = new ColorAction("Zolty", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
        Action blueAction = new ColorAction("Niebieski", new ImageIcon("blue-ball.gif"), Color.BLUE);
        Action redAction = new ColorAction("Czerwony", new ImageIcon("red-ball.gif"), Color.RED);

        //Dodanie przyciskow do akcji
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(redAction));

        //Dodanie panelu do ramki
        add(buttonPanel);

        // Powiazanie klawiszy Z, N, C z nazwami
        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(KeyStroke.getKeyStroke("ctrl Z"), "panel.yellow");
        imap.put(KeyStroke.getKeyStroke("ctrl N"), "panel.blue");
        imap.put(KeyStroke.getKeyStroke("ctrl C"), "panel.red");

        // Powiazanie nazw z akcjami
        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.blue", blueAction);
        amap.put("panel.red", redAction);
        pack();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public class ColorAction extends AbstractAction{
        //Tworzy akcje zmiany koloru

        public ColorAction(String name, Icon icon, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue(Action.SHORT_DESCRIPTION, "Ustaw kolor panelu na: " + name.toLowerCase());
            putValue("color", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color color = (Color) getValue("color");
            buttonPanel.setBackground(color);
        }
    }
}
