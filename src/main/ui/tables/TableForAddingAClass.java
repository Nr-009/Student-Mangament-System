/* This class represent the table used for adding or deleting a class in the teachers' menu with columns:
Name of the class, first name of teh teacher, average grade, number of students, id of the class and id of the teacher
 */

package ui.tables;

import model.AcademyClass;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableForAddingAClass extends AbstractTableModel {

    private List<AcademyClass> allclasses;


    public TableForAddingAClass(List<AcademyClass> allclasses) {
        this.allclasses = allclasses;
    }

    //Modifies: This
    //Effects: sets the table the same size as the classes that the object has
    @Override
    public int getRowCount() {
        return allclasses.size();
    }

    //Modifies: This
    //Effects: set the table with only siz column
    @Override
    public int getColumnCount() {
        return 6;
    }

    @SuppressWarnings("methodlength")
    //Modifies: This
    //Effects: Sets the value for each row and collumn in the class
    public Object getValueAt(int rowIndex, int columnIndex) {
        AcademyClass currentClass = allclasses.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return currentClass.getName();
            case 1:
                if (currentClass.getTeacher() == null) {
                    return "No teacher";
                } else {
                    return currentClass.getTeacher().getFn();
                }

            case 2:
                return currentClass.getAverageGrade();
            case 3:
                return currentClass.getNumOfStudents();
            case 4:
                return currentClass.getId();
            case 5:
                if (currentClass.getTeacher() == null) {
                    return "No id";
                } else {
                    return currentClass.getTeacher().getFn();
                }
        }
        return null;

    }

    //Modifies: This
    //Effects: Sets the name for the columns
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Class";
            case 1:
                return "Teacher";
            case 2:
                return "Average Grade";
            case 3:
                return "#Students";
            case 4:
                return "Id";
            case 5:
                return "Teacher's id";
        };
        return "";
    }
}
