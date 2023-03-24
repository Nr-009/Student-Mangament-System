package ui.medianamente;

import javax.swing.JPanel;


import model.*;
import ui.tables.TableOfClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeetingGrade extends BasicFrameForTeacherSide {

    private JLabel chooseAClass;
    private JTextField id;
    private JLabel firstNameLabel;
    private JButton backButton;
    private JButton addButton;
    private JPanel panelOfTable;
    private TableOfClasses table;
    private JLabel idLabel;
    private JButton gradesButton;


    public SeetingGrade(int id) {
        super(id);
        myData = sendData();
        chooseAClass = setChosenClassLabel();
        super.contentPane.add(chooseAClass);
        idLabel = setIdLabel();
        super.contentPane.add(idLabel);
        this.id = idTextField();
        super.contentPane.add(this.id);
        backButton = backButton(id);
        super.contentPane.add(backButton);
        gradesButton = setgradesButton(id);
        super.contentPane.add(gradesButton);
        addButton = setaddButton(id);
        super.contentPane.add(addButton);
        panelOfTable = setPanelOfTable(id);
        super.contentPane.add(panelOfTable);

    }

    public static void main(String[] args) {
        SeetingGrade mygrade = new SeetingGrade(0);
        mygrade.setVisible(true);
    }

    public JLabel setIdLabel() {
        JLabel id =  new JLabel("id");
        id.setFont(new Font("Arial", Font.PLAIN, 24));
        id.setBounds(143, 333, 36, 47);
        return id;
    }

    public JLabel setChosenClassLabel() {
        JLabel chosenClass = new JLabel("Choose a Class");
        chosenClass.setFont(new Font("Arial", Font.PLAIN, 30));
        chosenClass.setBounds(143, 285, 250, 47);
        return chosenClass;
    }

    public JTextField idTextField() {
        JTextField id = new JTextField();
        id.setFont(new Font("Arial", Font.PLAIN, 15));
        id.setBounds(245, 342, 94, 34);
        return id;
    }

    public JButton setgradesButton(int idOfTeacher) {
        JButton btnNewButton = new JButton("Grades");
        btnNewButton.setBackground(new Color(12, 35, 68));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(186, 397, 116, 34);
        setGradeButton2(btnNewButton, idOfTeacher, false);
        return  btnNewButton;
    }


    public JButton setaddButton(int idOfTeacher) {
        JButton addStudent = new JButton("Add Student");
        addStudent.setForeground(Color.WHITE);
        addStudent.setBackground(new Color(12, 35, 68));
        addStudent.setBounds(186, 441, 116, 34);
        setGradeButton2(addStudent, idOfTeacher, true);
        return addStudent;
    }


    public JPanel setPanelOfTable(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        table = new TableOfClasses(currentTeacher.getAllClasses());
        JPanel myPanel = new JPanel();
        myPanel.setBounds(542,285,510,331);
        myPanel.setBackground(new Color(240, 240, 240));
        JTable table2 = new JTable(table);
        JScrollPane scrollPane = new JScrollPane(table2);
        myPanel.add(scrollPane);
        return myPanel;
    }

    @SuppressWarnings("methodlength")
    public void setGradeButton2(JButton l, int idOfTeacher, boolean addStrudent) {
        l.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myString = "";
                try {
                    myString = id.getText();
                    int idOfClass = Integer.parseInt(id.getText());
                    Teacher currentTeacher = myData.getTeacher(idOfTeacher);
                    if (!myData.hasIdOfAcademyClass(idOfClass)) {
                        JOptionPane.showMessageDialog(SeetingGrade.this,
                                "This class does not exist");
                    } else if (!teacherTeachesThatClass(idOfTeacher, idOfClass)) {
                        JOptionPane.showMessageDialog(SeetingGrade.this,
                                "You are not teaching this class");
                    } else {
                        if (addStrudent) {
                            saveData(myData);
                            AddOrDropStudents mydrop = new AddOrDropStudents(idOfTeacher, idOfClass);
                            setVisible(false);
                            mydrop.setVisible(true);
                        } else {
                            saveData(myData);
                            GradesAndAbsences myGrades = new GradesAndAbsences(idOfTeacher, idOfClass);
                            setVisible(false);
                            myGrades.setVisible(true);
                        }
                    }
                } catch (Exception e2) {
                    if (myString.isEmpty()) {
                        JOptionPane.showMessageDialog(SeetingGrade.this,
                                "You need to put an Id");
                    } else {
                        JOptionPane.showMessageDialog(SeetingGrade.this,
                                "The id must be a number");
                    }

                }

            }
        });

    }

    public boolean teacherTeachesThatClass(int idOfTeacher, int idOfClass) {
        Teacher currentTeacher = myData.getTeacher(idOfTeacher);
        for (AcademyClass s: currentTeacher.getAllClasses()) {
            if (s.getId() == idOfClass) {
                return true;
            }
        }
        return false;
    }

    @Override
    public JButton getSetGradeOrArbscence(int id) {
        JButton setGrade = new JButton("Set grade");
        setGrade.setForeground(new Color(12, 35, 68));
        setGrade.setBackground(SystemColor.controlHighlight);
        setGrade.setBounds(119, 0, 150, 34);
        setGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SeetingGrade.this,
                        "You are already here");
            }
        });
        return setGrade;
    }

    @Override
    public JButton getAddOrDropStudents(int id) {
        JButton myButtton = new JButton("Add students");
        myButtton.setForeground(new Color(12, 35, 68));
        myButtton.setBackground(SystemColor.controlHighlight);
        myButtton.setBounds(381, 0, 129, 34);
        myButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(SeetingGrade.this,
                        "You are already here");
            }
        });
        return myButtton;
    }
}


