package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.*;
import ui.gui.Saving;
import ui.medianamente.AddingAStudent;
import ui.medianamente.BasicFrameForTeacherSide;
import ui.medianamente.SeetingGrade;
import ui.medianamente.TeacherMenu;
import ui.tables.TableOfStudentsInAClass;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GradesAndAbsences extends BasicFrameForTeacherSide {

    private JLabel currentClass;
    private TableOfStudentsInAClass table;
    private JPanel panelOfTable;
    private JLabel labelOfClassName;
    private JLabel labelOfId;
    private JLabel labelOfSession;
    private JLabel labelOfNumberOfStudnets;
    private JLabel labelOfAverageGrade;
    private DataSystem mydata;


    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        GradesAndAbsences myStudent = new GradesAndAbsences(0, 3);
        myStudent.setVisible(true);

    }

    public GradesAndAbsences(int id, int idOfClass) {
        super(id);
        mydata = super.sendData();
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
    }

    public JLabel setCurrentClass(int idOfClass) {
        String name = mydata.getAcademyClass(idOfClass).getName();
        JLabel classSelected = new JLabel(name);
        classSelected.setFont(new Font("Arial", Font.PLAIN, 30));
        classSelected.setBounds(182, 237, 204, 45);
        return classSelected;
    }

    public JPanel setPanelOfTable(int id, int idOfClass) {
        AcademyClass currentClass = mydata.getAcademyClass(idOfClass);
        table = new TableOfStudentsInAClass(currentClass.getStudents(), currentClass.getName());
        JPanel myPanel = new JPanel();
        myPanel.setBounds(57,284,442,331);
        myPanel.setBackground(new Color(240, 240, 240));
        JTable table2 = new JTable(table);
        JScrollPane scrollPane = new JScrollPane(table2);
        scrollPane.setPreferredSize(new Dimension(442, 331));
        myPanel.add(scrollPane);
        return myPanel;
    }

    public JLabel classNameLabel(int idOfClass) {
        AcademyClass currentClass = mydata.getAcademyClass(idOfClass);
        JLabel className = new JLabel("Class Name: " + currentClass.getName());
        className.setFont(new Font("Arial", Font.PLAIN, 28));
        className.setBounds(562, 277, 421, 45);
        return className;
    }

    public JLabel labelOfId(int idOfClas) {
        AcademyClass currentClas = mydata.getAcademyClass(idOfClas);
        JLabel classId = new JLabel("Id: " + currentClas.getId());
        classId.setFont(new Font("Arial", Font.PLAIN, 28));
        classId.setBounds(562, 332, 421, 45);
        return classId;
    }

    public JLabel classSession(int idOfClass) {
        AcademyClass currentClass = mydata.getAcademyClass(idOfClass);
        JLabel classSession = new JLabel("Class Session: " + currentClass.getSession());
        classSession.setFont(new Font("Arial", Font.PLAIN, 28));
        classSession.setBounds(562, 387, 421, 45);
        return classSession;
    }

    public JLabel numberOfStudents(int idOfClass) {
        AcademyClass currentClass = mydata.getAcademyClass(idOfClass);
        JLabel labelStudents = new JLabel("#Students: " + currentClass.getNumOfStudents());
        labelStudents.setFont(new Font("Arial", Font.PLAIN, 28));
        labelStudents.setBounds(562, 442, 421, 45);
        return labelStudents;
    }

    public JLabel labelOfAverageGrade(int idOfClass) {
        AcademyClass currentClass = mydata.getAcademyClass(idOfClass);
        JLabel labelAveraeGrade = new JLabel("Average Grade: " + currentClass.getAverageGrade());
        labelAveraeGrade.setFont(new Font("Arial", Font.PLAIN, 28));
        labelAveraeGrade.setBounds(562, 497, 421, 45);
        return labelAveraeGrade;
    }







}



