/* This class represents the table of all the classes that the teacher is currently teaching. It has collumns of:
Class name, class id, #Students, Average grade, session
 */


package ui.tables;

import model.AcademyClass;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableOfClasses extends AbstractTableModel {
    private List<AcademyClass> allclasses;

    public TableOfClasses(List<AcademyClass> allClasses) {
        this.allclasses = allClasses;

    }

    //Modifies: This
    //Effects: Sets the number of rows to be the same of the number of classes
    @Override
    public int getRowCount() {
        return allclasses.size();
    }

    //Modifies: This
    //Effects: Sets the number of columns to 5
    @Override
    public int getColumnCount() {
        return 5;
    }

    //Modifies: This
    //Effects: Sets the value for each row based on the current Student
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        AcademyClass currentClass = allclasses.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return currentClass.getName();
            case 1:
                return currentClass.getId();
            case 2:
                return currentClass.getNumOfStudents();
            case 3:
                return currentClass.getAverageGrade();
            case 4:
                return currentClass.getSession();
        }
        return null;
    }

    //Modifies: This
    //Effects: sets the names of all table
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Class Name";
            case 1:
                return "Class id";
            case 2:
                return "#Students";
            case 3:
                return "Average Grade";
            case 4:
                return "Session";
        };
        return "";
    }
}
