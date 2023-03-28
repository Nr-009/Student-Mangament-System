/* It is a middle frame where you can choose whether to set a grade or add student
*/

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

    //Effects: Creates label id and sets for faint, position and color
    public JLabel setIdLabel() {
        JLabel id =  new JLabel("id");
        id.setFont(new Font("Arial", Font.PLAIN, 24));
        id.setBounds(143, 333, 36, 47);
        return id;
    }

    //Effects: Creates label "Choose a class" and sets for faint, position and color
    public JLabel setChosenClassLabel() {
        JLabel chosenClass = new JLabel("Choose a Class");
        chosenClass.setFont(new Font("Arial", Font.PLAIN, 30));
        chosenClass.setBounds(143, 285, 250, 47);
        return chosenClass;
    }

    //Effects: Creates Text Field "Choose a class" and sets for faint, position and color
    public JTextField idTextField() {
        JTextField id = new JTextField();
        id.setFont(new Font("Arial", Font.PLAIN, 15));
        id.setBounds(245, 342, 94, 34);
        return id;
    }

    //Modifies: This
    //Effects: Creates a JButton to send the to the grades frame
    public JButton setgradesButton(int idOfTeacher) {
        JButton btnNewButton = new JButton("Grades");
        btnNewButton.setBackground(new Color(12, 35, 68));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(186, 397, 116, 34);
        setGradeButton2(btnNewButton, idOfTeacher, false);
        return  btnNewButton;
    }

    //Modifies: This
    //Effects: Creates a JButton to send the to the add or drop student
    public JButton setaddButton(int idOfTeacher) {
        JButton addStudent = new JButton("Add Student");
        addStudent.setForeground(Color.WHITE);
        addStudent.setBackground(new Color(12, 35, 68));
        addStudent.setBounds(186, 441, 116, 34);
        setGradeButton2(addStudent, idOfTeacher, true);
        return addStudent;
    }


    //Modifies: This
    //Effects: Sets the table with the Panel
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

    //Modifies: This
    //Effects: If the input is correct it sends the user to the grades' student frame
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

    //Effects: produces true if the given teacher is teaching that class
    public boolean teacherTeachesThatClass(int idOfTeacher, int idOfClass) {
        Teacher currentTeacher = myData.getTeacher(idOfTeacher);
        for (AcademyClass s: currentTeacher.getAllClasses()) {
            if (s.getId() == idOfClass) {
                return true;
            }
        }
        return false;
    }

    //Modifies: This
    //Effects: Sets the button addGradesOrAbsences so that you can not change frame but rather are shown a message
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

    //Modifies: This
    //Effects: Sets the button getAddOrDropStudents so that you can not change frame but rather are shown a message
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


