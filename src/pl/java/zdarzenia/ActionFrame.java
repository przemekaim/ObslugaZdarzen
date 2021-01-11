package pl.java.zdarzenia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionFrame extends JFrame {
    private final JPanel buttonPanel;
    private final static int DEFAULT_WIDTH = 600;
    private final static int DEFAULT_HEIGHT = 400;

    public ActionFrame() {
        pack();
        Image icon = new ImageIcon("blue-ball.gif").getImage();
        setIconImage(icon);

        buttonPanel = new JPanel();

        ColorAction blueAction = new ColorAction("Niebieski", new ImageIcon("blue-ball.gif"), Color.BLUE);
        ColorAction yellowAction = new ColorAction("Zolty", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
        ColorAction redAction = new ColorAction("Czerwony", new ImageIcon("red-ball.gif"), Color.RED);

        buttonPanel.add(new JButton(blueAction));
        buttonPanel.add(new JButton(yellowAction));
        buttonPanel.add(new JButton(redAction));

        add(buttonPanel);

        // Input map
        InputMap inputMap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke("ctrl N"), "panel-blue");
        inputMap.put(KeyStroke.getKeyStroke("ctrl Z"), "panel-yellow");
        inputMap.put(KeyStroke.getKeyStroke("ctrl C"), "panel-red");

        // Action map
        ActionMap actionMap = buttonPanel.getActionMap();
        actionMap.put("panel-yellow", yellowAction);
        actionMap.put("panel-blue", blueAction);
        actionMap.put("panel-red", redAction);
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public class ColorAction extends AbstractAction {

        public ColorAction(String name, Icon icon, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, "Zmien kolor na " + name.toLowerCase());
            putValue(Action.SMALL_ICON, icon);
            putValue("color", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color) getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}
