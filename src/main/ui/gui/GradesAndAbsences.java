/* Sets the grades and absences frame where the teacher can set the grades and absences for a given */

package ui.gui;

import javax.swing.JPanel;


import model.*;
import ui.tables.TableOfStudentsInAClass;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;

public class GradesAndAbsences extends BasicFrameForTeacherSide {

    private JLabel currentClass;
    private TableOfStudentsInAClass table;
    private JPanel panelOfTable;
    private JLabel labelOfClassName;
    private JLabel labelOfId;
    private JLabel labelOfSession;
    private JLabel labelOfNumberOfStudnets;
    private JLabel labelOfAverageGrade;
    private JTable tablecontainer;
    private TableModelListener myTableListener;
    private JButton backButton;

    public static void main(String[] args) {
        GradesAndAbsences myStudent = new GradesAndAbsences(0, 3);
        myStudent.setVisible(true);

    }

    public GradesAndAbsences(int id, int idOfClass) {
        super(id);
        myData = super.sendData();
        currentClass = setCurrentClass(idOfClass);
        super.contentPane.add(currentClass);
        panelOfTable = setPanelOfTable(id,idOfClass);
        super.contentPane.add(panelOfTable);
        labelOfClassName = classNameLabel(idOfClass);
        super.contentPane.add(labelOfClassName);
        labelOfId = labelOfId(idOfClass);
        super.contentPane.add(labelOfId);
        labelOfSession = classSession(idOfClass);
        super.contentPane.add(labelOfSession);
        labelOfNumberOfStudnets = numberOfStudents(idOfClass);
        super.contentPane.add(labelOfNumberOfStudnets);
        labelOfAverageGrade = labelOfAverageGrade(idOfClass);
        super.contentPane.add(labelOfAverageGrade);
        myTableListener = setupTableModeListener(idOfClass);
        tablecontainer.getModel().addTableModelListener(myTableListener);
        backButton = backButton(id);
        super.contentPane.add(backButton);

    }

    //Modifies: This
    //Modifies: Changes the Average Grade label any time we modify the table
    public TableModelListener setupTableModeListener(int idOfClass) {
        TableModelListener myTableListener = new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                AcademyClass currentClass = myData.getAcademyClass(idOfClass);

                labelOfAverageGrade.setText("Average Grade: " + currentClass.getAverageGrade());
            }
        };
        return myTableListener;
    }

    //Modifies: Creates the Current Class label with the correct color, position and font
    public JLabel setCurrentClass(int idOfClass) {
        String name = myData.getAcademyClass(idOfClass).getName();
        JLabel classSelected = new JLabel(name);
        classSelected.setFont(new Font("Arial", Font.PLAIN, 30));
        classSelected.setBounds(182, 237, 204, 45);
        return classSelected;
    }

    //Modifies: This
    //Effects: Creates the panel with the table with all the students in the class of with the grades and absences
    public JPanel setPanelOfTable(int id, int idOfClass) {
        AcademyClass currentClass = myData.getAcademyClass(idOfClass);
        table = new TableOfStudentsInAClass(currentClass.getStudents(), currentClass.getName());
        JPanel myPanel = new JPanel();
        myPanel.setBounds(57,284,442,331);
        myPanel.setBackground(new Color(240, 240, 240));
        tablecontainer = new JTable(table);
        JScrollPane scrollPane = new JScrollPane(tablecontainer);
        scrollPane.setPreferredSize(new Dimension(442, 331));
        myPanel.add(scrollPane);
        return myPanel;
    }

    //Modifies: Creates the Current class name label with the correct color, position and font
    public JLabel classNameLabel(int idOfClass) {
        AcademyClass currentClass = myData.getAcademyClass(idOfClass);
        JLabel className = new JLabel("Class Name: " + currentClass.getName());
        className.setFont(new Font("Arial", Font.PLAIN, 28));
        className.setBounds(562, 277, 421, 45);
        return className;
    }

    //Modifies: Creates the Current label id with the correct color, position and font
    public JLabel labelOfId(int idOfClas) {
        AcademyClass currentClas = myData.getAcademyClass(idOfClas);
        JLabel classId = new JLabel("Id: " + currentClas.getId());
        classId.setFont(new Font("Arial", Font.PLAIN, 28));
        classId.setBounds(562, 332, 421, 45);
        return classId;
    }

    //Modifies: Creates the Current class session with the correct color, position and font
    public JLabel classSession(int idOfClass) {
        AcademyClass currentClass = myData.getAcademyClass(idOfClass);
        JLabel classSession = new JLabel("Class Session: " + currentClass.getSession());
        classSession.setFont(new Font("Arial", Font.PLAIN, 28));
        classSession.setBounds(562, 387, 421, 45);
        return classSession;
    }

    //Modifies: Creates the Current number of Students with the correct color, position and font
    public JLabel numberOfStudents(int idOfClass) {
        AcademyClass currentClass = myData.getAcademyClass(idOfClass);
        JLabel labelStudents = new JLabel("#Students: " + currentClass.getNumOfStudents());
        labelStudents.setFont(new Font("Arial", Font.PLAIN, 28));
        labelStudents.setBounds(562, 442, 421, 45);
        return labelStudents;
    }

    //Modifies: Creates the Current average Grade with the correct color, position and font
    public JLabel labelOfAverageGrade(int idOfClass) {
        AcademyClass currentClass = myData.getAcademyClass(idOfClass);
        JLabel labelAveraeGrade = new JLabel("Average Grade: " + currentClass.getAverageGrade());
        labelAveraeGrade.setFont(new Font("Arial", Font.PLAIN, 28));
        labelAveraeGrade.setBounds(562, 497, 421, 45);
        return labelAveraeGrade;
    }

}



