package ui.tablesForTheUi;

import model.AcademyClass;
import model.Student;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableOfClasses extends AbstractTableModel {
    private List<AcademyClass> allclasses;

    public TableOfClasses(List<AcademyClass> allClasses) {
        this.allclasses = allClasses;

    }

    @Override
    public int getRowCount() {
        return allclasses.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

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
