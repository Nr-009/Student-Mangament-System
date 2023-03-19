package ui.tablesForTheUi;

import model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableForAddingStudents extends AbstractTableModel {
    private List<Student> allStudents;

    public TableForAddingStudents(List<Student> allstudents) {
        this.allStudents = allstudents;
    }

    @Override
    public int getRowCount() {
        return allStudents.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

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
        };
        return "";
    }



}
