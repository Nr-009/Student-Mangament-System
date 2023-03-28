/* This class represents a table for setting the grades and absences of a student in a given Class. It has columns of:
Id of the student, name of the student, grade of the students, and  #Number of absences.

 */

package ui.tables;

import model.Student;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableOfStudentsInAClass extends AbstractTableModel {

    private List<Student> allStudents;
    private String nameOfClass;

    public TableOfStudentsInAClass(List<Student> allStudents, String idOfClass) {
        this.allStudents = allStudents;
        this.nameOfClass = idOfClass;

    }

    //Modifies: This
    //Effects: Sets the number of rows to be the same as the number of students
    @Override
    public int getRowCount() {
        return allStudents.size();
    }

    //Modifies: This
    //Effects: Sets the number of columns to be 4
    @Override
    public int getColumnCount() {
        return 4;
    }

    //Modifies: This
    //Effects: Sets the value for each row and collumn based on the current student
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student currentStudent = allStudents.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return currentStudent.getID();
            case 1:
                return currentStudent.getFn() + " " + currentStudent.getLn();
            case 2:
                return currentStudent.gradeInClass(nameOfClass);
            case 3:
                return currentStudent.checkAbsence(nameOfClass);
        }
        return null;
    }

    //Modifies: This
    //Effects: Sets the name for all columns
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Name";
            case 2:
                return "Grade";
            case 3:
                return "#Abscences";
        }
        ;
        return "";
    }

    //Modifies: This
    //Effects: Modifies the table so that the user can change the number of absences and grades
    @Override
    public void setValueAt(Object input, int rowIndex, int columnIndex) {
        Student currentStudent = allStudents.get(rowIndex);
        try {
            int value = Integer.parseInt((String) input);
            switch (columnIndex) {
                case 2:
                    currentStudent.setGradeForClass(nameOfClass, value);
                    fireTableCellUpdated(rowIndex, columnIndex);
                    break;
                case 3:
                    currentStudent.setAbscenceForAClass(value, nameOfClass);
                    fireTableCellUpdated(rowIndex, columnIndex);
                    break;
            }
        } catch (Exception e2) {
            int x = 0;
        }
    }

    //Modifies: This
    //Effects: Makes the column for the absences and grades to be editable
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 2 | columnIndex == 3) {
            return true;
        } else {
            return false;
        }
    }
}
