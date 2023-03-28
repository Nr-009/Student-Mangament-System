package ui.tables;

import model.Student;

import java.util.List;

public class TableOfStudentInAClassWithoutEditable extends TableOfStudentsInAClass {


    public TableOfStudentInAClassWithoutEditable(List<Student> allstudents, String name) {
        super(allstudents, name);
    }

    //Modifies: This
    //Effects: Changes the properties of all cells so that it is not modifiable
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
