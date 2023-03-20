package ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EditInfo extends JFrame {

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
    private JLabel currentStudents;
    private JButton backButton;
    private JLabel labelOfFirstName;
    private JLabel labelOfSession;
    private JTextField fnTextField;
    private JTextField lnTextField;
    private JTextField passwordTextField;
    private JTextField newPasswroldTextField;
    private JLabel idLabel;
    private JLabel labelOfNumberOfClasses;
    private JLabel labelOfPassworld;
    private JLabel labelOfNewPassword;
    private JButton submitButton;

    public static void main(String[] args) {
        EditInfo myStudent = new EditInfo(0);
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


    public EditInfo(int idOfTeacher) {
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
        constructor3(idOfTeacher);
        constructor4(idOfTeacher);




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

    public void constructor3(int id) {
        lowerBluePanel = getLowerBluePanel();
        contentPane.add(lowerBluePanel);
        lowerTitle = setLowerTitle();
        lowerBluePanel.add(lowerTitle);
        imageOfUBC2 = setUpImageOfUbc2();
        lowerBluePanel.add(imageOfUBC2);
        currentStudents = setCurrentStudents(id);
        contentPane.add(currentStudents);
        passwordTextField = setPasswordTextField();
        contentPane.add(passwordTextField);
        newPasswroldTextField = setNewPasworldTextField();
        contentPane.add(newPasswroldTextField);
        submitButton = setSubmitButton();
        contentPane.add(submitButton);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLogout();
    }

    public void constructor4(int id) {
        imageOfUbc = getImageOfUbc();
        upperPanel.add(imageOfUbc);
        backButton = backButton(id);
        contentPane.add(backButton);
        labelOfFirstName = firstNameLabel(id);
        contentPane.add(labelOfFirstName);
        labelOfSession = lastNameLabel(id);
        contentPane.add(labelOfSession);
        idLabel = labelOfId(id);
        contentPane.add(idLabel);
        labelOfNumberOfClasses = numberOfClasses(id);
        contentPane.add(labelOfNumberOfClasses);
        labelOfPassworld = labelOfPassword();
        contentPane.add(labelOfPassworld);
        labelOfNewPassword = getLabelOfNewPassword();
        contentPane.add(labelOfNewPassword);
        fnTextField = settingfirstName();
        contentPane.add(fnTextField);
        lnTextField = settingLastName();
        contentPane.add(lnTextField);

    }

    public JButton setSubmitButton() {
        JButton btnBack = new JButton("Submit");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(new Color(12, 35, 68));
        btnBack.setBounds(627, 489, 100, 29);
        return btnBack;
    }

    public JPasswordField setNewPasworldTextField() {
        JPasswordField newPasswroldTextField = new JPasswordField();
        newPasswroldTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        newPasswroldTextField.setColumns(10);
        newPasswroldTextField.setBounds(603, 440, 154, 28);
        return newPasswroldTextField;
    }

    public JTextField setPasswordTextField() {
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(603, 391, 154, 28);
        return passwordTextField;
    }


    public JTextField settingLastName() {
        lnTextField = new JTextField();
        lnTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lnTextField.setColumns(10);
        lnTextField.setBounds(603, 347, 154, 28);
        return lnTextField;
    }

    public JTextField settingfirstName() {
        JTextField fnTextField = new JTextField();
        fnTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fnTextField.setBounds(603, 303, 154, 28);
        fnTextField.setColumns(10);
        return fnTextField;
    }

    public JLabel getLabelOfNewPassword() {
        JLabel lblNewPassword = new JLabel("New Password:");
        lblNewPassword.setFont(new Font("Arial", Font.PLAIN, 24));
        lblNewPassword.setBounds(315, 434, 278, 45);
        return lblNewPassword;
    }

    public JLabel labelOfPassword() {
        JLabel lblCurrentPassworld = new JLabel("Password:");
        lblCurrentPassworld.setFont(new Font("Arial", Font.PLAIN, 24));
        lblCurrentPassworld.setBounds(315, 385, 278, 45);
        return lblCurrentPassworld;
    }



    public JLabel numberOfClasses(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel numberOfClassesLabel = new JLabel("#Classes: " + currentTeacher.getNumClasses());
        numberOfClassesLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        numberOfClassesLabel.setBounds(315, 544, 278, 45);
        return numberOfClassesLabel;

    }

    public JLabel labelOfId(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel idLabel = new JLabel("Id: " + currentTeacher.getId());
        idLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        idLabel.setBounds(315, 489, 120, 45);
        return idLabel;
    }




    public JLabel lastNameLabel(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel lastName = new JLabel("Last Name: " + currentTeacher.getLn());
        lastName.setFont(new Font("Arial", Font.PLAIN, 24));
        lastName.setBounds(315, 336, 287, 45);
        return lastName;
    }

    public JLabel firstNameLabel(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel firstName = new JLabel("First Name: " + currentTeacher.getFn());
        firstName.setFont(new Font("Arial", Font.PLAIN, 24));
        firstName.setBounds(315, 292, 278, 45);
        return firstName;
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



    public JLabel setCurrentStudents(int idOfClass) {
        String name = myData.getAcademyClass(idOfClass).getName();
        JLabel classSelected = new JLabel("Current Information");
        classSelected.setFont(new Font("Arial", Font.PLAIN, 30));
        classSelected.setBounds(408, 237, 278, 45);
        return classSelected;

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



