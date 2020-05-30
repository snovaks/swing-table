package ui.table;

import lombok.Getter;
import model.Person;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class PersonTablePanel extends JPanel implements TableModelListener {

    private static final int TABLE_ROW_HEIGHT = 40;

    @Getter
    private TableRowSorter<PersonTableModel> rowSorter;

    @Getter
    private JTable personTable;

    public PersonTablePanel() {
        config();
        initializeComponents();
        setTableListener();
    }

    private void config() {
        setLayout(new GridLayout(1, 0));
        setOpaque(true);
    }

    private void initializeComponents() {
        PersonTableModel personTableModel = new PersonTableModel();
        personTable = new JTable(personTableModel);
        personTable.setPreferredScrollableViewportSize(new Dimension(500, 70));
        personTable.setFillsViewportHeight(true);
        personTable.setRowHeight(TABLE_ROW_HEIGHT);
        rowSorter = new TableRowSorter<>(personTableModel);
        personTable.setRowSorter(rowSorter);
        add(new JScrollPane(personTable));
    }

    private void setTableListener() {
        personTable.getModel().addTableModelListener(this);
    }

    @Override
    public void tableChanged(TableModelEvent event) {
        int type = event.getType();
        switch (type) {
            case TableModelEvent.INSERT:
                insertAction(event);
                break;
            case TableModelEvent.UPDATE:
                updateAction(event);
                break;
            case TableModelEvent.DELETE:
                deleteAction(event);
                break;
        }
    }


    private void insertAction(TableModelEvent event) {
        System.out.println("insert action here");
    }

    private void updateAction(TableModelEvent event) {
        int row = event.getFirstRow();
        int column = event.getColumn();

        PersonTableModel personTableModel = (PersonTableModel) event.getSource();
        personTableModel.getColumnName(column);
        Object value = personTableModel.getValueAt(row, column);

        System.out.println(value);

        Class<?> columnClass = personTableModel.getColumnClass(column);

        /**
         * Można w tym miejscu zapisać zmiany do DB
         */
    }

    private void deleteAction(TableModelEvent event) {
        System.out.println("delete action here");
    }

    public class PersonTableModel extends AbstractTableModel {

        private List<Person> data;

        private String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};

        public PersonTableModel() {
            data = new LinkedList<>();
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public Object getValueAt(int row, int col) {
            Person person = data.get(row);

            switch (col) {
                case 0: return person.getFirstName();
                case 1: return person.getLastName();
                case 2: return person.getSport();
                case 3: return person.getNumberOfYears();
                case 4: return person.isVegetarian();
                default: return null;
            }
        }


        /**
         * Trzeba zwrócić uwagę w którym miejscy kodu wywołuje się
         * metodę fireTable...() - od razu po jej wywołaniu zostaje
         * wywołana metoda listenera tableChanged() i może to prowadzić
         * do nieoczekiwanych rezultatów
         * @param aValue
         * @param rowIndex
         * @param columnIndex
         */
        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            Person person = data.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    String firstName = (String) aValue;
                    person.setFirstName(firstName);
                    break;
                case 1:
                    String lastName = (String) aValue;
                    person.setLastName(lastName);
                    break;
                case 2:
                    String sport = (String) aValue;
                    person.setSport(sport);
                    break;
                case 3:
                    int years = (int) aValue;
                    person.setNumberOfYears(years);
                    break;
                case 4:
                    boolean isVegetarian = (boolean) aValue;
                    person.setVegetarian(isVegetarian);
                    break;
            }

            fireTableCellUpdated(rowIndex, columnIndex);
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                case 1:
                case 2:
                    return String.class;
                case 3:
                    return Integer.class;
                case 4:
                    return Boolean.class;
                default:
                    return null;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            if (columnIndex < 2) {
                return false;
            } else {
                return true;
            }
        }
        
        public void addPerson(Person person) {
            data.add(0, person);
            fireTableRowsInserted(0, 0);
        }

        public void deletePerson(int row) {
            data.remove(row);
            fireTableRowsDeleted(row, row);
        }
        
    }

}
