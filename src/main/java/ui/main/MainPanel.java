package ui.main;

import model.Person;
import ui.add.AddMainPanel;
import ui.delete.DeleteMainPanel;
import ui.filter.FilterMainPanel;
import ui.search.SearchMainPanel;
import ui.table.PersonTablePanel;

import javax.swing.*;
import java.util.regex.PatternSyntaxException;

public class MainPanel extends JPanel {

    private AddMainPanel addMainPanel;
    private SearchMainPanel searchMainPanel;
    private PersonTablePanel personTablePanel;
    private FilterMainPanel filterMainPanel;
    private DeleteMainPanel deleteMainPanel;

    public MainPanel() {
        config();
        initializeComponents();
        setListeners();
    }

    private void config() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    private void initializeComponents() {
        addMainPanel = new AddMainPanel();
        searchMainPanel = new SearchMainPanel();
        personTablePanel = new PersonTablePanel();
        filterMainPanel = new FilterMainPanel();
        deleteMainPanel = new DeleteMainPanel();
        add(addMainPanel);
        add(Box.createVerticalStrut(5));
        add(searchMainPanel);
        add(Box.createVerticalStrut(5));
        add(personTablePanel);
        add(Box.createVerticalStrut(5));
        add(filterMainPanel);
        add(deleteMainPanel);
    }

    private void setListeners() {
        addMainPanel.setAddPersonListener(this::addNewPersonToTable);
        deleteMainPanel.setDeletePersonListener(this::deletePerson);
        filterMainPanel.setFilterListener(this::filter);
    }

    private void addNewPersonToTable(Person person) {
        PersonTablePanel.PersonTableModel model =
                (PersonTablePanel.PersonTableModel) personTablePanel.getPersonTable().getModel();
        model.addPerson(person);
    }

    private void deletePerson() {
        int selectedRow = personTablePanel.getPersonTable().getSelectedRow();
        if (selectedRow != -1) {
            PersonTablePanel.PersonTableModel model =
                    (PersonTablePanel.PersonTableModel) personTablePanel.getPersonTable().getModel();
            model.deletePerson(selectedRow);
        }
    }

    private void filter(String text) {
        RowFilter<PersonTablePanel.PersonTableModel, Object> rowFilter = null;

        /**
         * Ciąg znaków na podstawie których utworzone jest wyrażenie regularne
         * i kolumny na których ma być zastosowane filtrowanie
         */
        try {
            rowFilter = RowFilter.regexFilter(text,0, 1, 2);
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
            return;
        }

        personTablePanel.getRowSorter().setRowFilter(rowFilter);
    }

}
