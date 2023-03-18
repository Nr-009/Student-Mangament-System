package ui;

import model.Student;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TestingHowTableLooks extends JFrame {

    public static void main(String[] args) {
        List<Student> myStudents = new ArrayList<>();
        myStudents.add(new Student(0, "Nicolas","Rubiano", "lol"));
        TableForAddingStudents currentTable = new TableForAddingStudents(myStudents);
        JTable myTable = new JTable(currentTable);
        JPanel myPanel = new JPanel();
        myPanel.add(new JScrollPane(myTable));
        TestingHowTableLooks thisTable = new TestingHowTableLooks();
        thisTable.add(myPanel);
        thisTable.setSize(200, 200);
        thisTable.setVisible(true);


    }
}
