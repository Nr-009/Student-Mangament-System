package ui.tables;

import model.Student;

import java.util.List;

public class TableOfStudentInAClassWithoutEditable extends TableOfStudentsInAClass {

    public TableOfStudentInAClassWithoutEditable(List<Student> allstudents, String name) {
        super(allstudents, name);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
