/* The start frame represent the first frame the user sees in the GUI, it first displays the image(visual element)
 and then after clicking the image it prompts the user to choose which saved version do they want use in their program.
*/

package ui.gui;

import model.DataSystem;
import model.FileReader;
import model.FileWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StartFrame extends JFrame {

    private JLabel version;
    private JRadioButton lastButtom;
    private JRadioButton originalButtom;
    private JButton submitButtom;
    private DataSystem myData;
    private static FileReader myReader;
    private static FileWriter myWritter;


    public StartFrame() {
        setTitle("Selecting Version");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 292, 274);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(SystemColor.window);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        version = setUpVersion();
        contentPane.add(version);
        lastButtom = setUpLastBotton();
        contentPane.add(lastButtom);
        originalButtom = setUpOriginalButtom();
        contentPane.add(originalButtom);
        submitButtom = setUpSubmitButtom();
        contentPane.add(submitButtom);
        setSubmitBotton();

    }

    //Effects: Shows and image and the after click runs the start Frame
    public static void main(String[] args) {
        JFrame myInitialFrame = new JFrame();
        JLabel myLabel = new JLabel();
        ImageIcon myImage = new ImageIcon("data/ubcImage.jpg");
        myLabel.setIcon(myImage);
        myInitialFrame.add(myLabel);
        myInitialFrame.setSize(1117, 768);
        myInitialFrame.setVisible(true);
        myInitialFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                myInitialFrame.setVisible(false);
                StartFrame myStart = new StartFrame();
                myStart.setVisible(true);
            }
        });
    }

    //Modifies: This, tempDataSystem.json
    //Effects: Sets the submit button for the frame so that we can know which of the two saved version should we read
    public void setSubmitBotton() {
        submitButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lastButtom.isSelected() && originalButtom.isSelected()) {
                    JOptionPane.showMessageDialog(StartFrame.this,
                                                           "You can not select both options");
                } else if (originalButtom.isSelected()) {
                    JOptionPane.showMessageDialog(StartFrame.this, "Selecting Original Version");
                    settingUpTheData("data/BaseDataSystem.json");
                    continueToLogin();

                } else if (lastButtom.isSelected()) {
                    JOptionPane.showMessageDialog(StartFrame.this, "Selecting Last Version");
                    settingUpTheData("data/SavedChangesDataSystem.json");
                    continueToLogin();
                }
            }
        }
        );
    }

    //Effects: Creates the version label, with the correct color and position
    public JLabel setUpVersion() {
        JLabel temp = new JLabel("Version");
        temp.setForeground(new Color(0, 0, 128));
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 29));
        temp.setBounds(90, 10, 155, 86);
        return temp;

    }

    //Effects: Creates a JRadioButton for last version, with the correct color and position
    public JRadioButton setUpLastBotton() {
        JRadioButton temp = new JRadioButton("Last");
        temp.setBackground(new Color(255, 255, 255));
        temp.setForeground(new Color(0, 0, 128));
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        temp.setBounds(90, 141, 103, 21);
        return temp;
    }

    //Effects: Creates a JRadioButton for the original version, with the correct color and position
    public JRadioButton setUpOriginalButtom() {
        JRadioButton temp = new JRadioButton("Original");
        temp.setForeground(new Color(0, 0, 128));
        temp.setBackground(new Color(255, 255, 255));
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        temp.setBounds(90, 102, 103, 21);
        return temp;
    }

    //Effects: Creates a Jbutton of submit, with the correct color and position
    public JButton setUpSubmitButtom() {
        JButton temp = new JButton("Submit");
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        temp.setForeground(SystemColor.window);
        temp.setBackground(new Color(0, 0, 128));
        temp.setBounds(95, 187, 85, 21);
        return temp;
    }


    //Modifies: This, tempDataSystem.json
    //Effects: Set the myData field with the correct information chosen by rhe user
    public void settingUpTheData(String s) {
        myReader = new FileReader(s);
        try {
            myData = myReader.readDataSystem();

        } catch (IOException e2) {
            System.out.println("An error occur when reading the file");
        }
        myWritter = new FileWriter();
        myWritter.setFileDestination("data/tempDataSystem.json");
        try {
            myWritter.open();
            myWritter.write(myData);
            myWritter.close();
        } catch (FileNotFoundException e3) {
            System.out.println("Write the file");
        }
    }

    //Modifies: This
    //Effects: Send the user To the login frame
    public void continueToLogin() {
        this.setVisible(false);
        Login currentlogin = new Login();
        currentlogin.setVisible(true);
    }



}
