package ui.add;

import javax.swing.*;
import java.awt.*;

public class AddMainPanel extends JPanel {

    private AddPersonListener addPersonListener;

    private LabelPanel labelPanel;
    private AddButtonPanel addButtonPanel;

    public AddMainPanel() {
        config();
        initializeComponents();
    }

    private void config() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dimension = new Dimension(screenSize.width / 2, 100);
        setMaximumSize(dimension);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void initializeComponents() {
        labelPanel = new LabelPanel();
        addButtonPanel = new AddButtonPanel();
        add(labelPanel);
        add(addButtonPanel);
    }

    /**
     * Obiekty, które są jako pierwsze zainicjalizowane w 100% znajdują się na końcu wywołań
     * Zostaną w pełni utworzone w kolejności:
     * 1. AddButtonPanel
     * 2. AddMainPanel
     * 3. MainPanel
     *
     * 1.   Tworzony jest MainPanel
     * 2.   Tworzony jest AddMainPanel
     * 2.1. AddMainPanel tworzy AddButtonPanel, ale nie może ustawić mu listenera
     *      ponieważ jego własny listener nie jest jeszcze ustawiony,
     *      gdyby to zrobił to listener miałby warotść null
     * 2.2  Po utworzeniu wszysktich obiektów, zaczyna się procedura przypisywania listenerów
     * 3.   MainPanel wywołuje metodę setListeners
     * 3.1  metoda ta ustawia listenera w obiekcie AddMainPanel
     * 3.2  Dopiero w tym momencie można ustawić listenera w AddButtonPanel
     * @param addPersonListener
     */
    public void setAddPersonListener(AddPersonListener addPersonListener) {
        this.addPersonListener = addPersonListener;
        addButtonPanel.setAddPersonListener(this.addPersonListener);
    }

}
