package ui;

import model.DataSystem;
import model.FileReader;
import model.Teacher;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;

public class TeacherMenu extends JFrame {
    private JPanel contentPane;
    private JLabel imageOfUbc;
    private JLabel name;
    private JLabel teacherId;
    private JButton logout;
    private JButton createStudent;
    private JButton setGradeOrArbscence;
    private JButton addOrDropStudents;
    private JButton seeStats;
    private JButton personalInfo;
    private JLabel helloMessage;
    private JButton createOrDeleteTeacher;
    private JButton createOrDeleteClass;
    private JLabel needHelp;
    private JLabel videoTutorials;
    private JLabel thenicalSupport;
    private JLabel askUBC;
    private JLabel imageOfUBC2;
    private DataSystem myData;
    private JLabel ubcTitle;
    private JLabel labelTeacherCenter;
    private JPanel upperPanel;
    private JPanel secondBlueUpperPanel;
    private JPanel greyUpperPannel;
    private JPanel lowerBluePanel;
    private JLabel lowerTitle;

    public static void main(String[] args) {
        TeacherMenu myTeacher = new TeacherMenu(0);
        myTeacher.setVisible(true);
    }

    public void readData() {
        try {
            FileReader myReader = new FileReader("data/tempDataSystem.json");
            myData = myReader.readDataSystem();
        } catch (IOException e3) {
            System.out.println("Could not read the data");
        }
    }


    public TeacherMenu(int id) {
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
        constructor3();

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

        createStudent = setUpCreateStudent();
        greyUpperPannel.add(createStudent);

        setGradeOrArbscence = getSetGradeOrArbscence();
        greyUpperPannel.add(setGradeOrArbscence);

        addOrDropStudents = getAddOrDropStudents();
        greyUpperPannel.add(addOrDropStudents);

        seeStats = setSeeStats();
        greyUpperPannel.add(seeStats);

        personalInfo = setPersonalInfo();
        greyUpperPannel.add(personalInfo);

        helloMessage = setHelloMessages(id);
        contentPane.add(helloMessage);


    }

    public void constructor3() {
        createOrDeleteTeacher = setCreateOrDeleteTeacher();
        contentPane.add(createOrDeleteTeacher);

        createOrDeleteClass = setCreateOrDeleteClass();
        contentPane.add(createOrDeleteClass);

        needHelp = setNeedHelp();
        contentPane.add(needHelp);

        videoTutorials = setVideoTutorials();
        contentPane.add(videoTutorials);

        thenicalSupport = setThenicalSupport();
        contentPane.add(thenicalSupport);

        askUBC = setUpAskUBC();
        contentPane.add(askUBC);

        lowerBluePanel = getLowerBluePanel();
        contentPane.add(lowerBluePanel);

        lowerTitle = setLowerTitle();
        lowerBluePanel.add(lowerTitle);

        imageOfUBC2 = setUpImageOfUbc2();
        lowerBluePanel.add(imageOfUBC2);
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

    public JButton setUpCreateStudent() {
        JButton createStudent = new JButton("Create Student");
        createStudent.setForeground(new Color(12, 35, 68));
        createStudent.setBackground(SystemColor.controlHighlight);
        createStudent.setBounds(0, 0, 121, 34);
        return createStudent;
    }

    public JLabel setUpAskUBC() {
        JLabel askUBC = new JLabel("Ask Me @ UBC");
        askUBC.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        askUBC.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(
                            new URI("https://students.ubc.ca/about-student-services/enrolment-services-advisors"));
                } catch (Exception e4) {
                    System.out.println("Exception when oppening the link");
                }
            }
        });
        askUBC.setForeground(new Color(12, 35, 68));
        askUBC.setFont(new Font("Arial", Font.PLAIN, 18));
        askUBC.setBounds(20, 610, 179, 24);
        return askUBC;
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
        return setGrade;
    }

    public JButton getAddOrDropStudents() {
        JButton myButtton = new JButton("Add students");
        myButtton.setForeground(new Color(12, 35, 68));
        myButtton.setBackground(SystemColor.controlHighlight);
        myButtton.setBounds(381, 0, 129, 34);
        return myButtton;
    }

    public JButton setSeeStats() {
        JButton seeStats = new JButton("See stats");
        seeStats.setForeground(new Color(12, 35, 68));
        seeStats.setBackground(SystemColor.controlHighlight);
        seeStats.setBounds(506, 0, 129, 34);
        return seeStats;
    }

    public JButton setPersonalInfo() {
        JButton personalInfo =  new JButton("Personal Info");
        personalInfo.setForeground(new Color(12, 35, 68));
        personalInfo.setBackground(SystemColor.controlHighlight);
        personalInfo.setBounds(261, 0, 121, 34);
        return  personalInfo;
    }

    public JLabel setHelloMessages(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel helloMessage = new JLabel("Hi " + currentTeacher.getFn() + " , Welcome to the Teacher Center");
        helloMessage.setForeground(new Color(12, 35, 68));
        helloMessage.setFont(new Font("Arial", Font.PLAIN, 27));
        helloMessage.setBackground(Color.WHITE);
        helloMessage.setBounds(10, 248, 654, 51);
        return helloMessage;
    }

    public JButton setCreateOrDeleteTeacher() {
        JButton createOrDelete = new JButton("Create or Delete a Teacher");
        createOrDelete.setFont(new Font("Arial", Font.PLAIN, 20));
        createOrDelete.setForeground(SystemColor.window);
        createOrDelete.setBackground(new Color(12, 35, 68));
        createOrDelete.setBounds(20, 318, 375, 44);
        return createOrDelete;
    }

    public JButton setCreateOrDeleteClass() {
        JButton setCreateOrDeleteClass =  new JButton("Create or Delete a Class");
        setCreateOrDeleteClass.setForeground(Color.WHITE);
        setCreateOrDeleteClass.setFont(new Font("Arial", Font.PLAIN, 20));
        setCreateOrDeleteClass.setBackground(new Color(12, 35, 68));
        setCreateOrDeleteClass.setBounds(20, 398, 375, 44);
        return setCreateOrDeleteClass;
    }

    public JLabel setNeedHelp() {
        JLabel myLabel = new JLabel("Need Help:");
        //Source:https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
        myLabel.setForeground(new Color(12, 35, 68));
        myLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        myLabel.setBackground(Color.WHITE);
        myLabel.setBounds(10, 481, 654, 51);
        return myLabel;
    }

    public JLabel setVideoTutorials() {
        JLabel videoTutrials = new JLabel("Video Tutorials");
        videoTutrials.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        videoTutrials.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(
                            new URI("https://www.codejava.net/"
                                    + "java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing"));
                } catch (Exception e4) {
                    System.out.println("Exception when oppening the link");
                }
            }
        });
        videoTutrials.setForeground(new Color(12, 35, 68));
        videoTutrials.setFont(new Font("Arial", Font.PLAIN, 18));
        videoTutrials.setBounds(20, 542, 179, 24);
        return videoTutrials;
    }

    public JLabel setThenicalSupport() {
        JLabel mytechnical = new JLabel("Thechnical Support");
        mytechnical.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        mytechnical.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    Desktop.getDesktop().browse(
                            new URI("https://www.youtube.com/watch?v=DJ7ixkO2Gac"));
                } catch (Exception e4) {
                    System.out.println("Exception when oppening the link");
                }
            }
        });
        mytechnical.setForeground(new Color(12, 35, 68));
        mytechnical.setFont(new Font("Arial", Font.PLAIN, 18));
        mytechnical.setBounds(20, 576, 179, 24);
        return mytechnical;

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



}
