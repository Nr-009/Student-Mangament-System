/* This class represent the table in teh frame for adding students and has columns of Student ID, Student fn,
Student ln, number of classes of teh student
 */

package ui.tables;

import model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableForAddingStudents extends AbstractTableModel {
    private List<Student> allStudents;

    public TableForAddingStudents(List<Student> allstudents) {
        this.allStudents = allstudents;
    }

    //Modifies: This
    //Effects: Sets the table to have the same rows as the number of students
    @Override
    public int getRowCount() {
        return allStudents.size();
    }

    //Modifies: This
    //Effects: Sets the columns to be 4
    @Override
    public int getColumnCount() {
        return 4;
    }


    //Modifies: This
    //Effects: Sets the value at each row based on the specific student
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = allStudents.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return student.getID();
            case 1:
                return student.getFn();
            case 2:
                return student.getLn();
            case 3:
                return student.getNumOfClasses();
        }
        return null;

    }

    //Modifies: This
    //Effects: Sets the name of the collumns
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
                return "#Classes";
        };
        return "";
    }



}
