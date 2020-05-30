package ui.add;

import javax.swing.*;
import java.awt.*;

public class LabelPanel extends JPanel {

    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel sportLabel;
    private JLabel yearsLabel;
    private JLabel vegetarianLabel;
    private JLabel emptyLabel;

    public LabelPanel() {
        config();
        initializeComponents();
    }

    private void config() {
        setLayout(new FlowLayout());
    }

    private void initializeComponents() {
        firstNameLabel = new JLabel("First name");
        lastNameLabel = new JLabel("Last name");
        sportLabel = new JLabel("Sport");
        yearsLabel = new JLabel("# of Years");
        vegetarianLabel = new JLabel("Vegetarian");
        emptyLabel = new JLabel("");

        Dimension dimension = new Dimension(140, 20);

        firstNameLabel.setPreferredSize(dimension);
        lastNameLabel.setPreferredSize(dimension);
        sportLabel.setPreferredSize(dimension);
        yearsLabel.setPreferredSize(dimension);
        vegetarianLabel.setPreferredSize(dimension);
        emptyLabel.setPreferredSize(dimension);

        firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lastNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sportLabel.setHorizontalAlignment(SwingConstants.CENTER);
        yearsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        vegetarianLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emptyLabel.setHorizontalAlignment(SwingConstants.CENTER);

        add(firstNameLabel);
        add(lastNameLabel);
        add(sportLabel);
        add(yearsLabel);
        add(vegetarianLabel);
        add(emptyLabel);
    }
}
