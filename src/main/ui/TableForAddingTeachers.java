package ui;

import model.Student;
import model.Teacher;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableForAddingTeachers extends AbstractTableModel {
    private List<Teacher> allTeachers;

    public TableForAddingTeachers(List<Teacher> allTeachers) {
        this.allTeachers = allTeachers;
    }

    @Override
    public int getRowCount() {
        return allTeachers.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
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
        }
        ;
        return "";
    }


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
