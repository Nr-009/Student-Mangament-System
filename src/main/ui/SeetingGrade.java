package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.*;
import ui.tables.TableOfClasses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SeetingGrade extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    private JLabel imageOfUbc;
    private JLabel name;
    private JLabel teacherId;
    private JButton logout;
    private JButton createStudent;
    private JButton setGradeOrArbscence;
    private JButton addOrDropStudents;
    private JButton personalInfo;
    private JLabel imageOfUBC2;
    private DataSystem myData;
    private JLabel ubcTitle;
    private JLabel labelTeacherCenter;
    private JPanel upperPanel;
    private JPanel secondBlueUpperPanel;
    private JPanel greyUpperPannel;
    private JPanel lowerBluePanel;
    private JLabel lowerTitle;
    private TableOfClasses table;
    private JLabel currentStudents;
    private JLabel createStudentLabel;
    private JLabel firstNameLabel;
    private JTextField id;
    private JButton gradesButton;
    private JButton addButton;
    private JButton backButton;
    private JPanel panelOfTable;

    public static void main(String[] args) {
        SeetingGrade myStudent = new SeetingGrade(0);
        myStudent.setVisible(true);

    }

    public void readData() {
        try {
            FileReader myReader = new FileReader("data/tempDataSystem.json");
            myData = myReader.readDataSystem();
        } catch (IOException e3) {
            System.out.println("Could not read the data");
        }
    }


    public SeetingGrade(int id) {
        readData();
        Teacher currentTeacher = myData.getTeacher(id);
        setBounds(100, 100, 1076, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        upperPanel = setUpperPanel();
        contentPane.add(upperPanel);
        upperPanel.setLayout(null);

        ubcTitle = setUpperTitle();
        upperPanel.add(ubcTitle);

        secondBlueUpperPanel = seconUpperBluePanel();
        contentPane.add(secondBlueUpperPanel);
        secondBlueUpperPanel.setLayout(null);

        labelTeacherCenter = labelTeacherCenter();
        secondBlueUpperPanel.add(labelTeacherCenter);
        this.id = firstName();
        contentPane.add(this.id);
        constructorpart2(id);
        constructor3(id);
        constructor4(id);




    }

    public void constructorpart2(int id) {
        name = setUpName(id);
        secondBlueUpperPanel.add(name);

        teacherId = setUpTeacherId(id);
        secondBlueUpperPanel.add(teacherId);

        greyUpperPannel = setGreyUpperPanel();
        contentPane.add(greyUpperPannel);
        greyUpperPannel.setLayout(null);

        logout = setLougoutButton();
        greyUpperPannel.add(logout);

        createStudent = setUpCreateStudent(id);
        greyUpperPannel.add(createStudent);

        setGradeOrArbscence = getSetGradeOrArbscence();
        greyUpperPannel.add(setGradeOrArbscence);

        addOrDropStudents = getAddOrDropStudents();
        greyUpperPannel.add(addOrDropStudents);

        personalInfo = setPersonalInfo();
        greyUpperPannel.add(personalInfo);


    }

    public void constructor3(int id) {
        lowerBluePanel = getLowerBluePanel();
        contentPane.add(lowerBluePanel);
        lowerTitle = setLowerTitle();
        lowerBluePanel.add(lowerTitle);
        imageOfUBC2 = setUpImageOfUbc2();
        lowerBluePanel.add(imageOfUBC2);
        panelOfTable = setPanelOfTable(id);
        contentPane.add(panelOfTable);
        currentStudents = setCurrentStudents();
        contentPane.add(currentStudents);
        createStudentLabel = setCreateStudentLabel();
        contentPane.add(createStudentLabel);
        firstNameLabel = setFirstName();
        contentPane.add(firstNameLabel);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLogout();
    }

    public void constructor4(int id) {
        imageOfUbc = getImageOfUbc();
        upperPanel.add(imageOfUbc);
        gradesButton = setSubmitButton(id);
        contentPane.add(gradesButton);
        backButton = backButton(id);
        contentPane.add(backButton);
        addButton = setaddButton(id);
        contentPane.add(addButton);
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

    public JTextField firstName() {
        JTextField id = new JTextField();
        id.setFont(new Font("Arial", Font.PLAIN, 15));
        id.setBounds(245, 342, 94, 34);
        return id;

    }

    public JButton backButton(int id) {
        JButton btnBack = new JButton("Back");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.RED);
        btnBack.setBounds(962, 626, 100, 29);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                TeacherMenu currentMenu = new TeacherMenu(id);
                currentMenu.setVisible(true);
            }
        });
        return btnBack;
    }

    public JButton setSubmitButton(int idOfTeacher) {
        JButton btnNewButton = new JButton("Grades");
        btnNewButton.setBackground(new Color(12, 35, 68));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(186, 397, 116, 34);
        setGradeButton2(btnNewButton, idOfTeacher, false);
        return  btnNewButton;
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

    public void saveData(DataSystem data) {
        FileWriter myWriter = new FileWriter();
        myWriter.setFileDestination("data/tempDataSystem.json");
        try {
            myWriter.open();
        } catch (FileNotFoundException e) {
            System.out.println("Could not save");
        }
        myWriter.write(data);
        myWriter.close();


    }



    public JLabel setFirstName() {
        JLabel id =  new JLabel("id");
        id.setFont(new Font("Arial", Font.PLAIN, 24));
        id.setBounds(143, 333, 36, 47);
        return id;
    }

    public JLabel setCreateStudentLabel() {
        JLabel chosenClass = new JLabel("Chosen Class");
        chosenClass.setFont(new Font("Arial", Font.PLAIN, 30));
        chosenClass.setBounds(143, 285, 196, 47);
        return chosenClass;
    }

    public JLabel setCurrentStudents() {
        JLabel currentClasses = new JLabel("Current Classes");
        currentClasses.setFont(new Font("Arial", Font.PLAIN, 30));
        currentClasses.setBounds(701, 237, 282, 45);
        return currentClasses;

    }

    public JLabel getImageOfUbc() {
        JLabel imageOfUBC = new JLabel("");
        ImageIcon currentUBClogo = new ImageIcon("data/Ubcmodified.png");
        imageOfUBC.setIcon(currentUBClogo);
        imageOfUBC.setBounds(0, 0, 103, 107);
        return imageOfUBC;
    }

    public JLabel setUpName(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel name = new JLabel("Name: " + currentTeacher.getFn()
                + " " + currentTeacher.getLn());
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBackground(Color.WHITE);
        name.setBounds(495, 12, 328, 50);
        return name;
    }

    public JLabel setUpTeacherId(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel teacherId = new JLabel("Teacher id#: " + currentTeacher.getId());
        teacherId.setForeground(Color.WHITE);
        teacherId.setFont(new Font("Arial", Font.BOLD, 18));
        teacherId.setBackground(Color.WHITE);
        teacherId.setBounds(825, 10, 227, 50);
        return teacherId;
    }

    public JButton setUpCreateStudent(int id) {
        JButton createStudent = new JButton("Create Student");
        createStudent.setForeground(new Color(12, 35, 68));
        createStudent.setBackground(SystemColor.controlHighlight);
        createStudent.setBounds(0, 0, 121, 34);
        createStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddingAStudent addingAStudent = new AddingAStudent(id);
                setVisible(false);
                addingAStudent.setVisible(true);
            }
        });

        return createStudent;
    }


    public JLabel setUpImageOfUbc2() {
        JLabel imageOfUBC2 = new JLabel("");
        ImageIcon ubc = new ImageIcon("data/Ubcmodified.png");
        imageOfUBC2.setIcon(ubc);
        imageOfUBC2.setBounds(0, 0, 103, 107);
        return imageOfUBC2;
    }

    public JButton getSetGradeOrArbscence() {
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

    public JButton getAddOrDropStudents() {
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


    public JButton setPersonalInfo() {
        JButton personalInfo = new JButton("Personal Info");
        personalInfo.setForeground(new Color(12, 35, 68));
        personalInfo.setBackground(SystemColor.controlHighlight);
        personalInfo.setBounds(261, 0, 121, 34);
        return personalInfo;
    }


    public JPanel setUpperPanel() {
        JPanel upperPanel = new JPanel();
        upperPanel.setBackground(new Color(12, 35, 68));
        upperPanel.setBounds(0, 0, 1062, 107);
        return upperPanel;
    }

    public JLabel setUpperTitle() {
        JLabel myLabel = new JLabel("The University Of British Columbia");
        myLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        myLabel.setForeground(Color.WHITE);
        myLabel.setBackground(Color.WHITE);
        myLabel.setBounds(181, 10, 479, 50);
        return myLabel;
    }

    public JPanel seconUpperBluePanel() {
        JPanel myPannel = new JPanel();
        myPannel.setBackground(new Color(51, 102, 153));
        myPannel.setBounds(0, 104, 1062, 69);
        return myPannel;
    }

    public JLabel labelTeacherCenter() {
        JLabel currentPanel = new JLabel("Teacher Service Center");
        currentPanel.setForeground(Color.WHITE);
        currentPanel.setFont(new Font("Arial", Font.PLAIN, 27));
        currentPanel.setBackground(Color.WHITE);
        currentPanel.setBounds(10, 10, 297, 50);
        return currentPanel;
    }

    public JPanel setGreyUpperPanel() {
        JPanel currentPanel = new JPanel();
        currentPanel.setBackground(SystemColor.controlHighlight);
        currentPanel.setBounds(0, 171, 1062, 56);

        return currentPanel;
    }

    public JButton setLougoutButton() {
        JButton currentBotton = new JButton("Logout");
        currentBotton.setBackground(Color.RED);
        currentBotton.setForeground(Color.WHITE);
        currentBotton.setBounds(962, 27, 100, 29);
        return currentBotton;
    }

    public JPanel getLowerBluePanel() {
        JPanel myPannel = new JPanel();
        myPannel.setLayout(null);
        myPannel.setBackground(new Color(12, 35, 68));
        myPannel.setBounds(0, 656, 1062, 107);
        return myPannel;
    }

    public JLabel setLowerTitle() {
        JLabel currentLabel = new JLabel("The University Of British Columbia");
        currentLabel.setForeground(Color.WHITE);
        currentLabel.setFont(new Font("Arial", Font.PLAIN, 25));
        currentLabel.setBackground(Color.WHITE);
        currentLabel.setBounds(113, 10, 444, 36);
        return currentLabel;
    }

    public void setLogout() {
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Saving newSaving = new Saving();
                setVisible(false);
                newSaving.setVisible(true);
            }
        });
    }
}


