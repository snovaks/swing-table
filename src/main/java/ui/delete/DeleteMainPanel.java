package ui.delete;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class DeleteMainPanel extends JPanel {

    @Setter
    private DeletePersonListener deletePersonListener;

    private JButton deleteButton;

    public DeleteMainPanel() {
        config();
        initializeComponents();
        addListeners();
    }

    private void config() {
        setLayout(new FlowLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension = new Dimension(screenSize.width / 2, 60);
        setMaximumSize(dimension);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void initializeComponents() {
        deleteButton = new JButton("Delete");
        add(deleteButton);
    }

    private void addListeners() {
        deleteButton.addActionListener(l -> {
            deletePersonListener.deletePerson();
        });
    }
}
