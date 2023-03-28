/* Teacher main frame when logging in, in which they can choose the button to go to each specific part */

package ui.gui;

import model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;

public class TeacherMenu extends BasicFrameForTeacherSide {

    private JLabel helloMessage;
    private JButton createOrDeleteTeacher;
    private JButton createOrDeleteClass;
    private JLabel needHelp;
    private JLabel videoTutorials;
    private JLabel thenicalSupport;
    private JLabel askUBC;


    public static void main(String[] args) {
        TeacherMenu myTeacher = new TeacherMenu(0);
        myTeacher.setVisible(true);

    }


    public TeacherMenu(int id) {
        super(id);
        myData = super.sendData();
        helloMessage = setHelloMessages(id);
        super.contentPane.add(helloMessage);
        createOrDeleteTeacher = setCreateOrDeleteTeacher(id);
        super.contentPane.add(createOrDeleteTeacher);
        createOrDeleteClass = setCreateOrDeleteClass(id);
        super.contentPane.add(createOrDeleteClass);
        needHelp = setNeedHelp();
        super.contentPane.add(needHelp);
        videoTutorials = setVideoTutorials();
        super.contentPane.add(videoTutorials);
        thenicalSupport = setThenicalSupport();
        super.add(thenicalSupport);
        askUBC = setUpAskUBC();
        super.add(askUBC);
    }

    //Effects: Creates a given the label where we welcome the teacher with the given Id and name
    public JLabel setHelloMessages(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel helloMessage = new JLabel("Hi " + currentTeacher.getFn() + " , Welcome to the Teacher Center");
        helloMessage.setForeground(new Color(12, 35, 68));
        helloMessage.setFont(new Font("Arial", Font.PLAIN, 27));
        helloMessage.setBackground(Color.WHITE);
        helloMessage.setBounds(10, 248, 654, 51);
        return helloMessage;
    }

    //Modifies: This
    //Effects: Sets the button of creating or deleting Teachers, so that if click the teacher is redirected to that
    //specific frame
    public JButton setCreateOrDeleteTeacher(int id) {
        JButton createOrDelete = new JButton("Create or Delete a Teacher");
        createOrDelete.setFont(new Font("Arial", Font.PLAIN, 20));
        createOrDelete.setForeground(SystemColor.window);
        createOrDelete.setBackground(new Color(12, 35, 68));
        createOrDelete.setBounds(20, 318, 375, 44);
        createOrDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(myData);
                AddingDeletingATeacher thisTeacher = new AddingDeletingATeacher(id);
                setVisible(false);
                thisTeacher.setVisible(true);
            }
        });
        return createOrDelete;
    }

    //Modifies: This
    //Effects: Sets the button of Create or deleting a Class, so that if click the teacher is redirected to that
    //specific frame
    public JButton setCreateOrDeleteClass(int id) {
        JButton setCreateOrDeleteClass =  new JButton("Create or Delete a Class");
        setCreateOrDeleteClass.setForeground(Color.WHITE);
        setCreateOrDeleteClass.setFont(new Font("Arial", Font.PLAIN, 20));
        setCreateOrDeleteClass.setBackground(new Color(12, 35, 68));
        setCreateOrDeleteClass.setBounds(20, 398, 375, 44);
        setCreateOrDeleteClass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData(myData);
                CreateOrDeleteClass thisClass = new CreateOrDeleteClass(id);
                setVisible(false);
                thisClass.setVisible(true);
            }
        });
        return setCreateOrDeleteClass;
    }

    //Effects: Creates a given Label with  for "Need Help" with the correct color, shape and position
    public JLabel setNeedHelp() {
        JLabel myLabel = new JLabel("Need Help:");
        //Source:https://www.codejava.net/java-se/swing/how-to-create-hyperlink-with-jlabel-in-java-swing
        myLabel.setForeground(new Color(12, 35, 68));
        myLabel.setFont(new Font("Arial", Font.PLAIN, 22));
        myLabel.setBackground(Color.WHITE);
        myLabel.setBounds(10, 481, 654, 51);
        return myLabel;
    }

    //Effects: Creates a given Label with  for "Video Tutorial" with the correct color, shape and position, and
    //adds a link to it/
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

    //Effects: Creates a given Label with  for "Thenical Support" with the correct color, shape and position, and
    //adds a link to it/
    public JLabel setThenicalSupport() {
        JLabel technical = new JLabel("Technical Support");
        technical.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        technical.addMouseListener(new MouseAdapter() {
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
        technical.setForeground(new Color(12, 35, 68));
        technical.setFont(new Font("Arial", Font.PLAIN, 18));
        technical.setBounds(20, 576, 179, 24);
        return technical;

    }

    //Effects: Creates a given Label with  for "ask UBC" with the correct color, shape and position, and
    //adds a link to it/
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





}
