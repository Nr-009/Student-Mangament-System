package ui;

import model.DataSystem;
import model.FileReader;
import model.Teacher;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
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

    public static void main(String[] args) {
        TeacherMenu myTeacher = new TeacherMenu(0);
        myTeacher.setVisible(true);
    }


    public TeacherMenu(int id) {
        try {
            FileReader myReader = new FileReader("data/tempDataSystem.json");
            myData = myReader.readDataSystem();
        } catch (IOException e3) {
            System.out.println("Could not read the data");
        }
        Teacher currentTeacher = myData.getTeacher(id);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1076, 721);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        JPanel blueBackgorund2 = new JPanel();
        blueBackgorund2.setBackground(new Color(12, 35, 68));
        blueBackgorund2.setBounds(0, 0, 1062, 107);
        contentPane.add(blueBackgorund2);
        blueBackgorund2.setLayout(null);

        JLabel lblNewLabel = new JLabel("The University Of British Columbia");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBackground(Color.WHITE);
        lblNewLabel.setBounds(181, 10, 479, 50);
        blueBackgorund2.add(lblNewLabel);

        imageOfUbc = new JLabel("");
        ImageIcon currentUBClogo = new ImageIcon("data/Ubcmodified.png");
        imageOfUbc.setIcon(currentUBClogo);
        imageOfUbc.setBounds(0, 0, 103, 107);
        blueBackgorund2.add(imageOfUbc);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(51, 102, 153));
        panel2.setBounds(0, 104, 1062, 69);
        contentPane.add(panel2);
        panel2.setLayout(null);

        JLabel lblYeacherServiceCenter = new JLabel("Teacher Service Center");
        lblYeacherServiceCenter.setForeground(Color.WHITE);
        lblYeacherServiceCenter.setFont(new Font("Arial", Font.PLAIN, 27));
        lblYeacherServiceCenter.setBackground(Color.WHITE);
        lblYeacherServiceCenter.setBounds(10, 10, 297, 50);
        panel2.add(lblYeacherServiceCenter);

        name = new JLabel("Name: " + currentTeacher.getFn() + " " + currentTeacher.getLn());
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBackground(Color.WHITE);
        name.setBounds(495, 12, 328, 50);
        panel2.add(name);

        teacherId = new JLabel("Teacher id#: " + currentTeacher.getId());
        teacherId.setForeground(Color.WHITE);
        teacherId.setFont(new Font("Arial", Font.BOLD, 18));
        teacherId.setBackground(Color.WHITE);
        teacherId.setBounds(825, 10, 227, 50);
        panel2.add(teacherId);

        JPanel greBackground = new JPanel();
        greBackground.setBackground(SystemColor.controlHighlight);
        greBackground.setBounds(0, 171, 1062, 69);
        contentPane.add(greBackground);
        greBackground.setLayout(null);

        JButton logout = new JButton("Logout");
        logout.setBackground(Color.RED);
        logout.setForeground(Color.WHITE);
        logout.setBounds(962, 40, 100, 29);
        greBackground.add(logout);

        createStudent = new JButton("Create Student");
        createStudent.setForeground(new Color(12, 35, 68));
        createStudent.setBackground(SystemColor.controlHighlight);
        createStudent.setBounds(0, 0, 121, 34);
        greBackground.add(createStudent);

        setGradeOrArbscence = new JButton("Set grade");
        setGradeOrArbscence.setForeground(new Color(12, 35, 68));
        setGradeOrArbscence.setBackground(SystemColor.controlHighlight);
        setGradeOrArbscence.setBounds(119, 0, 150, 34);
        greBackground.add(setGradeOrArbscence);

        addOrDropStudents = new JButton("Add students");
        addOrDropStudents.setForeground(new Color(12, 35, 68));
        addOrDropStudents.setBackground(SystemColor.controlHighlight);
        addOrDropStudents.setBounds(381, 0, 129, 34);
        greBackground.add(addOrDropStudents);

        seeStats = new JButton("See stats");
        seeStats.setForeground(new Color(12, 35, 68));
        seeStats.setBackground(SystemColor.controlHighlight);
        seeStats.setBounds(506, 0, 129, 34);
        greBackground.add(seeStats);

        personalInfo = new JButton("Personal Info");
        personalInfo.setForeground(new Color(12, 35, 68));
        personalInfo.setBackground(SystemColor.controlHighlight);
        personalInfo.setBounds(261, 0, 121, 34);
        greBackground.add(personalInfo);

        helloMessage = new JLabel("Hi " + currentTeacher.getFn() + " , Welcome to the Teacher Center");
        helloMessage.setForeground(new Color(12, 35, 68));
        helloMessage.setFont(new Font("Arial", Font.PLAIN, 27));
        helloMessage.setBackground(Color.WHITE);
        helloMessage.setBounds(10, 250, 654, 51);
        contentPane.add(helloMessage);

        createOrDeleteTeacher = new JButton("Create or Delete a Teacher");
        createOrDeleteTeacher.setFont(new Font("Arial", Font.PLAIN, 20));
        createOrDeleteTeacher.setForeground(SystemColor.window);
        createOrDeleteTeacher.setBackground(new Color(12, 35, 68));
        createOrDeleteTeacher.setBounds(20, 311, 375, 44);
        contentPane.add(createOrDeleteTeacher);

        createOrDeleteTeacher = new JButton("Create or Delete a Class");
        createOrDeleteTeacher.setForeground(Color.WHITE);
        createOrDeleteTeacher.setFont(new Font("Arial", Font.PLAIN, 20));
        createOrDeleteTeacher.setBackground(new Color(12, 35, 68));
        createOrDeleteTeacher.setBounds(20, 385, 375, 44);
        contentPane.add(createOrDeleteTeacher);

        needHelp = new JLabel("Need Help:");
        //Source:https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
        needHelp.setForeground(new Color(12, 35, 68));
        needHelp.setFont(new Font("Arial", Font.PLAIN, 22));
        needHelp.setBackground(Color.WHITE);
        needHelp.setBounds(10, 439, 654, 51);
        contentPane.add(needHelp);


        videoTutorials = new JLabel("Video Tutorials");
        videoTutorials.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        videoTutorials.addMouseListener(new MouseAdapter() {
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
        videoTutorials.setForeground(new Color(12, 35, 68));
        videoTutorials.setFont(new Font("Arial", Font.PLAIN, 18));
        videoTutorials.setBounds(20, 485, 179, 24);
        contentPane.add(videoTutorials);

        thenicalSupport = new JLabel("Thechnical Support");
        thenicalSupport.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        thenicalSupport.addMouseListener(new MouseAdapter() {
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
        thenicalSupport.setForeground(new Color(12, 35, 68));
        thenicalSupport.setFont(new Font("Arial", Font.PLAIN, 18));
        thenicalSupport.setBounds(20, 519, 179, 24);
        contentPane.add(thenicalSupport);

        askUBC = new JLabel(" Ask Me @ UBC");
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
        askUBC.setBounds(20, 550, 179, 24);
        contentPane.add(askUBC);

        JPanel blueBakground = new JPanel();
        blueBakground.setLayout(null);
        blueBakground.setBackground(new Color(12, 35, 68));
        blueBakground.setBounds(0, 584, 1062, 107);
        contentPane.add(blueBakground);

        JLabel ubcLogo = new JLabel("The University Of British Columbia");
        ubcLogo.setForeground(Color.WHITE);
        ubcLogo.setFont(new Font("Arial", Font.PLAIN, 25));
        ubcLogo.setBackground(Color.WHITE);
        ubcLogo.setBounds(113, 10, 444, 36);
        blueBakground.add(ubcLogo);

        imageOfUBC2 = new JLabel("");
        imageOfUBC2.setIcon(currentUBClogo);
        imageOfUBC2.setBounds(0, 0, 103, 107);
        blueBakground.add(imageOfUBC2);
    }
}
