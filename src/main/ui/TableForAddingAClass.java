package ui;

import model.AcademyClass;
import model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableForAddingAClass extends AbstractTableModel {

    private List<AcademyClass> allclasses;

    public TableForAddingAClass(List<AcademyClass> allclasses) {
        this.allclasses = allclasses;
    }

    @Override
    public int getRowCount() {
        return allclasses.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        AcademyClass currentClass = allclasses.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return currentClass.getName();
            case 1:
                return currentClass.getTeacher().getFn();
            case 2:
                return currentClass.getAverageGrade();
            case 3:
                return currentClass.getNumOfStudents();
            case 4:
                return currentClass.getId();
            case 5:
                return currentClass.getTeacher().getId();
        }
        return null;

    }

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
