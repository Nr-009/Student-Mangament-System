/* This class represents a table with when adding or deleting Teachers, the columns it has are : Id,
first name, last name, number of classes
 */


package ui.tables;

import model.Teacher;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableForAddingTeachers extends AbstractTableModel {
    private List<Teacher> allTeachers;

    public TableForAddingTeachers(List<Teacher> allTeachers) {
        this.allTeachers = allTeachers;
    }

    //Modifies: This
    //Effects: Sets the number of rows as the same of the teachers
    @Override
    public int getRowCount() {
        return allTeachers.size();
    }

    //Modifies: This
    //Effects: sets the number of columns to be 4
    @Override
    public int getColumnCount() {
        return 4;
    }



    //Modifies: This
    //Effects: Sets the name of the columns for the table
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "First Name";
            case 2:
                return "Last Name";
            case 3:
                return "Number Of Classes";
        }
        ;
        return "";
    }


    //Modifies: This
    //Effects: sets the value for each row based on teh current Teacher
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Teacher teacher = allTeachers.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return teacher.getId();
            case 1:
                return teacher.getFn();
            case 2:
                return teacher.getLn();
            case 3:
                return teacher.getNumClasses();
        }
        return null;

    }
}
