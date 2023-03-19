package ui.tablesForTheUi;

import model.AcademyClass;
import model.Student;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableOfStudentsInAClass extends AbstractTableModel {

    private List<Student> allStudents;
    private String nameOfClass;

    public TableOfStudentsInAClass(List<Student> allStudents, String idOfClass) {
        this.allStudents = allStudents;
        this.nameOfClass = idOfClass;

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
            System.out.println("The user try to input something different than a number");
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 2 | columnIndex == 3) {
            return true;
        } else {
            return false;
        }
    }
}
