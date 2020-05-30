package ui.add;

import lombok.Setter;
import model.Person;

import javax.swing.*;
import java.awt.*;

public class AddButtonPanel extends JPanel {

    @Setter
    private AddPersonListener addPersonListener;

    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField sportTextField;
    private JTextField yearsTextField;
    private JCheckBox vegetarianCheckBox;
    private JButton addButton;

    public AddButtonPanel() {
        config();
        initializeComponents();
        addListeners();
    }

    private void config() {
        setLayout(new FlowLayout());
    }

    private void initializeComponents() {
        firstNameTextField = new JTextField();
        lastNameTextField = new JTextField();
        sportTextField = new JTextField();
        yearsTextField = new JTextField();
        vegetarianCheckBox = new JCheckBox();
        addButton = new JButton("Add");

        Dimension dimension = new Dimension(140, 40);
        firstNameTextField.setPreferredSize(dimension);
        lastNameTextField.setPreferredSize(dimension);
        sportTextField.setPreferredSize(dimension);
        yearsTextField.setPreferredSize(dimension);
        vegetarianCheckBox.setPreferredSize(dimension);
        addButton.setPreferredSize(dimension);

        vegetarianCheckBox.setHorizontalAlignment(SwingConstants.CENTER);

        add(firstNameTextField);
        add(lastNameTextField);
        add(sportTextField);
        add(yearsTextField);
        add(vegetarianCheckBox);
        add(addButton);
    }

    private void addListeners() {
        addButton.addActionListener(l -> {
            String firstNameText = firstNameTextField.getText();
            String lastNameText = lastNameTextField.getText();
            String sportText = sportTextField.getText();
            int years = Integer.parseInt(yearsTextField.getText());
            boolean isVegetarian = vegetarianCheckBox.isSelected();
            Person person = new Person();
            person.setFirstName(firstNameText);
            person.setLastName(lastNameText);
            person.setSport(sportText);
            person.setNumberOfYears(years);
            person.setVegetarian(isVegetarian);
            addPersonListener.add(person);
        });
    }

}
