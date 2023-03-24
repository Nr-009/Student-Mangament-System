package ui.medianamente;

import model.DataSystem;
import model.FileReader;
import model.FileWriter;
import model.Teacher;
import ui.gui.Saving;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BasicFrameForTeacherSide extends JFrame {
    protected JPanel contentPane;
    protected JLabel imageOfUbc;
    protected JLabel name;
    protected JLabel teacherId;
    protected JButton logout;
    protected JButton createStudent;
    protected JButton setGradeOrArbscence;
    protected JButton addOrDropStudents;
    protected JButton personalInfo;
    protected JLabel imageOfUBC2;
    protected DataSystem myData;
    protected JLabel ubcTitle;
    protected JLabel labelTeacherCenter;
    protected JPanel upperPanel;
    protected JPanel secondBlueUpperPanel;
    protected JPanel greyUpperPannel;
    protected JPanel lowerBluePanel;
    protected JLabel lowerTitle;

    public static void main(String[] args) {
        BasicFrameForTeacherSide myBasicFrame = new BasicFrameForTeacherSide(0);
        myBasicFrame.setVisible(true);
    }

    public void readData() {
        try {
            FileReader myReader = new FileReader("data/tempDataSystem.json");
            myData = myReader.readDataSystem();
        } catch (IOException e3) {
            System.out.println("Could not read the data");
        }
    }

    public DataSystem sendData() {
        try {
            FileReader myReader = new FileReader("data/tempDataSystem.json");
            return myReader.readDataSystem();
        } catch (IOException e3) {
            System.out.println("Could not read the data");
        }
        return null;
    }




    public BasicFrameForTeacherSide(int id) {
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

        imageOfUbc = getImageOfUbc();
        upperPanel.add(imageOfUbc);

        secondBlueUpperPanel = seconUpperBluePanel();
        contentPane.add(secondBlueUpperPanel);
        secondBlueUpperPanel.setLayout(null);

        labelTeacherCenter = labelTeacherCenter();
        secondBlueUpperPanel.add(labelTeacherCenter);
        constructorpart2(id);
        constructor3(id);

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


        personalInfo = setPersonalInfo(id);
        greyUpperPannel.add(personalInfo);




    }

    public void constructor3(int id) {

        lowerBluePanel = getLowerBluePanel();
        contentPane.add(lowerBluePanel);

        lowerTitle = setLowerTitle();
        lowerBluePanel.add(lowerTitle);

        imageOfUBC2 = setUpImageOfUbc2();
        lowerBluePanel.add(imageOfUBC2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLogout();
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
        JLabel name = new JLabel("Name: " + currentTeacher.getFn() + " " + currentTeacher.getLn());
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBackground(Color.WHITE);
        name.setBounds(495, 12, 328, 50);
        return name;
    }

    public JLabel setUpTeacherId(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel teacherId  = new JLabel("Teacher id#: " + currentTeacher.getId());
        teacherId.setForeground(Color.WHITE);
        teacherId.setFont(new Font("Arial", Font.BOLD, 18));
        teacherId.setBackground(Color.WHITE);
        teacherId.setBounds(825, 10, 227, 50);
        return  teacherId;
    }

    public JButton setUpCreateStudent(int id) {
        JButton createStudent = new JButton("Create Student");
        createStudent.setForeground(new Color(12, 35, 68));
        createStudent.setBackground(SystemColor.controlHighlight);
        createStudent.setBounds(0, 0, 121, 34);
        createStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(myData);
                AddingAStudent thisAdding = new AddingAStudent(id);
                setVisible(false);
                thisAdding.setVisible(true);
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
                saveData(myData);
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
                saveData(myData);
                SeetingGrade mygrade = new SeetingGrade(id);
                setVisible(false);
                mygrade.setVisible(true);
            }
        });
        return myButtton;
    }

    public JButton setPersonalInfo(int id) {
        JButton personalInfo =  new JButton("Personal Info");
        personalInfo.setForeground(new Color(12, 35, 68));
        personalInfo.setBackground(SystemColor.controlHighlight);
        personalInfo.setBounds(261, 0, 121, 34);
        saveData(myData);
        personalInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(myData);
                EditInfo myedit = new EditInfo(id);
                setVisible(false);
                myedit.setVisible(true);

            }
        });
        return  personalInfo;
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
                saveData(myData);
                Saving newSaving = new Saving();
                setVisible(false);
                newSaving.setVisible(true);
            }
        });
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



}



