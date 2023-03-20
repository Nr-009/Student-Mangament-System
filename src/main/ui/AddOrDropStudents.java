package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.*;
import ui.tables.TableForAddingAClass;
import ui.tables.TableForAddingStudents;
import ui.tables.TableOfStudentInAClassWithoutEditable;
import ui.tables.TableOfStudentsInAClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddOrDropStudents extends JFrame {

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
    private TableOfStudentsInAClass table;
    private JButton backButton;
    private JPanel panelOfTable;
    private JTextField idTextField;
    private TableForAddingStudents table2;
    private JLabel classStudents;
    private JLabel allStudentsLabel;
    private JLabel addOrdropLabel;
    private JLabel idLabel;
    private JButton dropButton;
    private JButton addButtn;

    public static void main(String[] args) {
        AddOrDropStudents myStudent = new AddOrDropStudents(0, 3);
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


    public AddOrDropStudents(int idOfTeacher, int idOfClass) {
        readData();
        Teacher currentTeacher = myData.getTeacher(idOfTeacher);
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
        constructorpart2(idOfTeacher);
        constructor3(idOfTeacher, idOfClass);
        constructor4(idOfTeacher, idOfClass);




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

        setGradeOrArbscence = getSetGradeOrArbscence(id);
        greyUpperPannel.add(setGradeOrArbscence);

        addOrDropStudents = getAddOrDropStudents(id);
        greyUpperPannel.add(addOrDropStudents);


        personalInfo = setPersonalInfo();
        greyUpperPannel.add(personalInfo);




    }

    public void constructor3(int id, int idOfTheClass) {
        lowerBluePanel = getLowerBluePanel();
        contentPane.add(lowerBluePanel);
        lowerTitle = setLowerTitle();
        lowerBluePanel.add(lowerTitle);
        imageOfUBC2 = setUpImageOfUbc2();
        lowerBluePanel.add(imageOfUBC2);
        panelOfTable = setPanelOfTable(id,idOfTheClass);
        contentPane.add(panelOfTable);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLogout();
    }

    public void constructor4(int id, int idOfClass) {
        imageOfUbc = getImageOfUbc();
        upperPanel.add(imageOfUbc);
        backButton = backButton(id);
        contentPane.add(backButton);

        JPanel allStudnets = setAllStudentTable();
        contentPane.add(allStudnets);

        classStudents = setClassStudents();
        contentPane.add(classStudents);

        allStudentsLabel = setallStudentsLabel();
        contentPane.add(allStudentsLabel);

        addOrdropLabel = addorDropLabel();
        contentPane.add(addOrdropLabel);

        idTextField = new JTextField();
        idTextField.setBounds(894, 384, 88, 29);
        contentPane.add(idTextField);
        idTextField.setColumns(10);

        idLabel = setIdLabel();
        contentPane.add(idLabel);

        dropButton = setDropButton(idOfClass);
        contentPane.add(dropButton);

        JButton addButton = setAddButton(idOfClass);
        contentPane.add(addButton);
    }

    public JButton setAddButton(int idOfClass) {
        JButton addButton = new JButton("Add");
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(new Color(12, 35, 68));
        addButton.setBounds(868, 472, 80, 29);
        setActionAddButton(addButton, idOfClass);
        return addButton;
    }

    public void setActionAddButton(JButton s, int idOfClass) {
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "";
                int intIdOfStudent = 0;
                try {
                    id = idTextField.getText();
                    intIdOfStudent = Integer.parseInt(id);
                    Student currentStudent = myData.getStudent(intIdOfStudent);
                    AcademyClass currentClas = myData.getAcademyClass(idOfClass);
                    if (currentClas.hasStudent(intIdOfStudent)) {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "This student is already register for this class");
                    } else {
                        currentClas.addStudent(currentStudent);
                        currentStudent.addClass(currentClas);
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "Student with id of " + id + " added");
                        saveData(myData);
                        table.fireTableDataChanged();
                        table2.fireTableDataChanged();
                    }
                } catch (Exception e2) {
                    if (id.isEmpty()) {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "You need to put and id");
                    } else {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "You put something that is not a number");
                    }

                }
            }
        });
    }

    public JButton setDropButton(int idOfClass) {
        JButton drop = new JButton("Drop");
        setActionDropStudents(drop, idOfClass);
        drop.setForeground(Color.WHITE);
        drop.setBackground(new Color(12, 35, 68));
        drop.setBounds(868, 433, 80, 29);
        return drop;

    }

    public void setActionDropStudents(JButton s, int idOfClass) {
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "";
                int intIdOfStudent = 0;
                try {
                    id = idTextField.getText();
                    intIdOfStudent = Integer.parseInt(id);
                    Student currentStudent = myData.getStudent(intIdOfStudent);
                    AcademyClass currentClas = myData.getAcademyClass(idOfClass);
                    if (!currentClas.hasStudent(intIdOfStudent)) {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "This student is not register for this class");
                    } else {
                        currentClas.deleteStudent(intIdOfStudent);
                        currentStudent.removeClass(currentClas.getName());
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "Stduent with id of " + id + " dropped");
                        saveData(myData);
                        table.fireTableDataChanged();
                        table2.fireTableDataChanged();
                    }
                } catch (Exception e2) {
                    if (id.isEmpty()) {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "You need to put and id");
                    } else {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "You put something that is not a number");
                    }

                }
            }
        });

    }

    public JLabel setIdLabel() {
        JLabel lblId = new JLabel("Id");
        lblId.setForeground(new Color(12, 35, 68));
        lblId.setFont(new Font("Arial", Font.PLAIN, 24));
        lblId.setBounds(840, 376, 38, 36);
        return lblId;
    }

    public JLabel addorDropLabel() {
        JLabel addOrDrop = new JLabel("Add Or Drop");
        addOrDrop.setForeground(new Color(12, 35, 68));
        addOrDrop.setFont(new Font("Arial", Font.PLAIN, 26));
        addOrDrop.setBounds(840, 329, 151, 45);
        return addOrDrop;
    }

    public JLabel setallStudentsLabel() {
        JLabel lblAllStudents = new JLabel("All Students");
        lblAllStudents.setForeground(new Color(12, 35, 68));
        lblAllStudents.setFont(new Font("Arial", Font.PLAIN, 26));
        lblAllStudents.setBounds(449, 237, 195, 45);
        return lblAllStudents;
    }


    public JLabel setClassStudents() {
        JLabel classStudents = new JLabel("Class Students");
        classStudents.setFont(new Font("Arial", Font.PLAIN, 26));
        classStudents.setForeground(new Color(12, 35, 68));
        classStudents.setBounds(85, 237, 195, 45);
        return classStudents;
    }

    public JPanel setAllStudentTable() {
        table2 = new TableForAddingStudents(myData.getListOfStudents());
        JPanel allStudents = new JPanel();
        allStudents.setBounds(373, 292, 322, 337);
        allStudents.setBackground(new Color(240, 240, 240));
        JTable table3 = new JTable(table2);
        JScrollPane scrollPane = new JScrollPane(table3);
        scrollPane.setPreferredSize(new Dimension(322, 337));
        allStudents.add(scrollPane);
        return allStudents;
    }


    public JPanel setPanelOfTable(int id, int idOfClass) {
        AcademyClass currentClass = myData.getAcademyClass(idOfClass);
        table = new TableOfStudentInAClassWithoutEditable(currentClass.getStudents(), currentClass.getName());
        JPanel classStudents = new JPanel();
        classStudents.setBounds(10,292,336,337);
        classStudents.setBackground(new Color(240, 240, 240));
        JTable table2 = new JTable(table);
        JScrollPane scrollPane = new JScrollPane(table2);
        scrollPane.setPreferredSize(new Dimension(336,337));
        scrollPane.setSize(table2.WIDTH, table2.HEIGHT);
        classStudents.add(scrollPane);
        return classStudents;
    }



    public JButton backButton(int id) {
        JButton btnBack = new JButton("Back");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.RED);
        btnBack.setBounds(962, 626, 100, 29);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(myData);
                setVisible(false);
                TeacherMenu currentMenu = new TeacherMenu(id);
                currentMenu.setVisible(true);
            }
        });
        return btnBack;
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
                saveData(myData);
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

    public JButton getSetGradeOrArbscence(int id) {
        JButton setGrade = new JButton("Set grade");
        setGrade.setForeground(new Color(12, 35, 68));
        setGrade.setBackground(SystemColor.controlHighlight);
        setGrade.setBounds(119, 0, 150, 34);
        setGrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeetingGrade mySetting = new SeetingGrade(id);
                saveData(myData);
                setVisible(false);
                mySetting.setVisible(true);
            }
        });
        return setGrade;
    }

    public JButton getAddOrDropStudents(int id) {
        JButton myButtton = new JButton("Add students");
        myButtton.setForeground(new Color(12, 35, 68));
        myButtton.setBackground(SystemColor.controlHighlight);
        myButtton.setBounds(381, 0, 129, 34);
        myButtton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeetingGrade mySetting = new SeetingGrade(id);
                saveData(myData);
                setVisible(false);
                mySetting.setVisible(true);
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



