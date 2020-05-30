package ui.search;

import javax.swing.*;
import java.awt.*;

public class SearchMainPanel extends JPanel {

    private JTextField searchTextField;
    private JButton searchButton;

    public SearchMainPanel() {
        config();
        initializeComponents();
    }

    private void config() {
        setLayout(new FlowLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension = new Dimension(screenSize.width / 2, 100);
        setMaximumSize(dimension);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void initializeComponents() {
        searchTextField = new JTextField();
        searchButton = new JButton("Search");

        Dimension dimension = new Dimension(140, 40);
        searchTextField.setPreferredSize(dimension);
        searchButton.setPreferredSize(dimension);

        add(searchTextField);
        add(searchButton);
    }
}
