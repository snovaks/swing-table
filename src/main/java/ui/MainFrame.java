package ui;

import ui.main.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        config();
    }

    private void config() {
        Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenDimension.width / 2, screenDimension.height / 2);
        setLocation(screenDimension.width / 4, screenDimension.height / 4);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setContentPane(new MainPanel());
        setVisible(true);
    }

}
