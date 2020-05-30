package ui.filter;

import lombok.Setter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class FilterMainPanel extends JPanel {

    @Setter
    private FilterListener filterListener;

    private JLabel filterLabel;
    private JTextField filterTextField;

    public FilterMainPanel() {
        config();
        initializeComponents();
        addListeners();
    }

    private void config() {
        setLayout(new FlowLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension = new Dimension(screenSize.width / 2, 40);
        setMaximumSize(dimension);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void initializeComponents() {
        filterLabel = new JLabel("Filter text: ");
        filterTextField = new JTextField();
        Dimension labelDimension = new Dimension(100, 40);
        Dimension textFieldlDimension = new Dimension(400, 40);
        filterLabel.setPreferredSize(labelDimension);
        filterTextField.setPreferredSize(textFieldlDimension);
        add(filterLabel);
        add(filterTextField);
    }

    private void addListeners() {
        filterTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                filterListener.filter(filterTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                filterListener.filter(filterTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {
                filterListener.filter(filterTextField.getText());
            }
        });
    }
}
