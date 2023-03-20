package ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.DataSystem;
import model.FileReader;
import model.FileWriter;
import model.Teacher;
import ui.tables.TableForAddingTeachers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class AddingDeletingATeacher  extends JFrame {

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
    private TableForAddingTeachers table = new TableForAddingTeachers(new ArrayList<>());
    private JLabel currentTeachers;
    private JLabel createTeacherLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JTextField firstName;
    private JTextField lastName;
    private JLabel passworldLabel;
    private JPasswordField passworldField;
    private JButton submitButton;
    private JButton backButton;
    private JPanel panelOfTable;
    private JTextField texFieldOfId;
    private JLabel labelofDeleteTeacher;
    private JLabel labelOfId;
    private JButton deleteButton;

    public static void main(String[] args) {
        AddingDeletingATeacher myStudent = new AddingDeletingATeacher(0);
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


    public AddingDeletingATeacher(int id) {
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
        firstName = firstName();
        contentPane.add(firstName);
        constructorpart2(id);
        constructor3();
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

        setGradeOrArbscence = getSetGradeOrArbscence(id);
        greyUpperPannel.add(setGradeOrArbscence);

        addOrDropStudents = getAddOrDropStudents(id);
        greyUpperPannel.add(addOrDropStudents);


        personalInfo = setPersonalInfo();
        greyUpperPannel.add(personalInfo);
        passworldLabel = setPassworldLabel();
        contentPane.add(passworldLabel);
        passworldField = setLastNameText();
        contentPane.add(passworldField);




    }

    public void constructor3() {
        lowerBluePanel = getLowerBluePanel();
        contentPane.add(lowerBluePanel);
        lowerTitle = setLowerTitle();
        lowerBluePanel.add(lowerTitle);
        imageOfUBC2 = setUpImageOfUbc2();
        lowerBluePanel.add(imageOfUBC2);
        panelOfTable = setPanelOfTable();
        contentPane.add(panelOfTable);
        currentTeachers = setCurrentStudents();
        contentPane.add(currentTeachers);
        createTeacherLabel = setCreateStudentLabel();
        contentPane.add(createTeacherLabel);
        firstNameLabel = setFirstName();
        contentPane.add(firstNameLabel);
        lastNameLabel = setLastNameLabel();
        contentPane.add(lastNameLabel);
        lastName = setTextFieldLastName();
        contentPane.add(lastName);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLogout();
    }

    public void constructor4(int id) {
        imageOfUbc = getImageOfUbc();
        upperPanel.add(imageOfUbc);
        submitButton = setSubmitButton();
        contentPane.add(submitButton);
        backButton = backButton(id);
        contentPane.add(backButton);
        labelofDeleteTeacher = setLabelofDeleteTeacher();
        contentPane.add(labelofDeleteTeacher);
        labelOfId = setLabelId();
        contentPane.add(labelOfId);
        texFieldOfId = setTextFieldOfId();
        contentPane.add(texFieldOfId);
        deleteButton = setDeleteButton(id);
        contentPane.add(deleteButton);
    }

    public JPanel setPanelOfTable() {
        table = new TableForAddingTeachers(myData.getListOfTeacher());
        JTable table2 = new JTable(table);
        JPanel myPanel = new JPanel();
        myPanel.setBounds(19,305,462,323);
        myPanel.add(new JScrollPane(table2));
        myPanel.setBackground(new Color(240, 240, 240));
        return myPanel;
    }

    public JTextField firstName() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setBounds(636, 362, 146, 29);
        return textField;

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

    public JButton setSubmitButton() {
        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBackground(new Color(12, 35, 68));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(606, 530, 116, 34);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fn = firstName.getText();
                String ln = lastName.getText();
                String passworld = String.copyValueOf(passworldField.getPassword());
                if (fn.isEmpty() | ln.isEmpty() | passworld.isEmpty()) {
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "One of the fields is/are empty");
                } else {
                    int idOfTeacher = myData.addTeacher(fn,ln,passworld);
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "Teacher created with id of " + idOfTeacher);
                    saveData(myData);
                    table.fireTableDataChanged();


                }

            }
        });
        return  btnNewButton;
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

    public JPasswordField setLastNameText() {
        JPasswordField thisfield = new JPasswordField();
        thisfield.setFont(new Font("Arial", Font.PLAIN, 15));
        thisfield.setColumns(10);
        thisfield.setBounds(636, 484, 146, 29);
        return thisfield;
    }

    public JLabel setPassworldLabel() {
        JLabel thisLabel = new JLabel("Password");
        thisLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        thisLabel.setBounds(510, 473, 135, 47);
        return thisLabel;
    }


    public JTextField setTextFieldLastName() {
        JTextField thisText =  new JTextField();
        thisText.setColumns(10);
        thisText.setFont(new Font("Arial", Font.PLAIN, 15));
        thisText.setBounds(636, 427, 146, 29);
        return thisText;
    }

    public JLabel setLastNameLabel() {
        JLabel label = new JLabel("Last Name");
        label.setFont(new Font("Arial", Font.PLAIN, 21));
        label.setBounds(510, 416, 146, 47);
        return label;
    }

    public JLabel setFirstName() {
        JLabel firstName =  new JLabel("First Name");
        firstName.setFont(new Font("Arial", Font.PLAIN, 21));
        firstName.setBounds(510, 353, 116, 47);
        return firstName;
    }

    public JLabel setCreateStudentLabel() {
        JLabel createStudentLabel = new JLabel("Create Teacher");
        createStudentLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        createStudentLabel.setBounds(552, 305, 277, 47);
        return createStudentLabel;
    }

    public JLabel setCurrentStudents() {
        JLabel currentStudents = new JLabel("Current Teacher");
        currentStudents.setFont(new Font("Arial", Font.PLAIN, 30));
        currentStudents.setBounds(124, 250, 282, 45);
        return currentStudents;

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
                AddingAStudent newAdding = new AddingAStudent(id);
                setVisible(false);
                newAdding.setVisible(true);
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
                SeetingGrade mygrade = new SeetingGrade(id);
                setVisible(false);
                mygrade.setVisible(true);
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
                SeetingGrade mygrade = new SeetingGrade(id);
                setVisible(false);
                mygrade.setVisible(true);
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

    public JLabel setLabelofDeleteTeacher() {
        JLabel deleteTeacherLabel = new JLabel("Delete Teacher");
        deleteTeacherLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        deleteTeacherLabel.setBounds(856, 305, 175, 47);
        return deleteTeacherLabel;
    }

    public JTextField setTextFieldOfId() {
        JTextField texFieldOfId = new JTextField();
        texFieldOfId.setFont(new Font("Arial", Font.PLAIN, 15));
        texFieldOfId.setBounds(866, 360, 146, 32);
        contentPane.add(texFieldOfId);
        return texFieldOfId;
    }

    public JButton setDeleteButton(int idRecieved) {
        JButton btndeleteTeacherButton = new JButton("Delete");
        btndeleteTeacherButton.setForeground(Color.WHITE);
        btndeleteTeacherButton.setBackground(new Color(12, 35, 68));
        btndeleteTeacherButton.setBounds(890, 416, 100, 34);
        setButtonOfDeletePart2(btndeleteTeacherButton, idRecieved);
        return btndeleteTeacherButton;
    }


    @SuppressWarnings("methodlength")
    public void setButtonOfDeletePart2(JButton button, int idRecieved) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = -11;
                String myString = " ";
                try {
                    myString = texFieldOfId.getText();
                    id = Integer.parseInt(texFieldOfId.getText());
                } catch (Exception e2) {
                    if (myString.isEmpty()) {
                        JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                                "You need to put an id");
                    } else {
                        JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                                "You put something \n that is not a number");
                    }
                }
                if (id == idRecieved) {
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "You can not delete yourself");
                } else if (!myData.hasIDTeacher(id) && id != -11) {
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "This id does not exit in the system");
                } else if (id != -11) {
                    myData.removeTeacher(id);
                    table.fireTableDataChanged();
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "Teacher with id " + id + " deleted");
                }
            }
        });
    }

    public JLabel setLabelId() {
        JLabel idLabel = new JLabel("Id");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        idLabel.setBounds(831, 353, 41, 47);
        return idLabel;
    }

}