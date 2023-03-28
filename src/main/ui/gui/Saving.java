/*This class represent the Saving frame in which a user may choose to save or not teh work they have done
in the application to be loaded later.
 */


package ui.gui;

import model.DataSystem;
import model.FileReader;
import model.FileWriter;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Saving extends JFrame {

    private JLabel version;
    private JRadioButton yesButton;
    private JRadioButton noButton;
    private JButton submitButtom;

    public Saving() {
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
        yesButton = setUpLastBotton();
        contentPane.add(yesButton);
        noButton = setUpOriginalButtom();
        contentPane.add(noButton);
        submitButtom = setUpSubmitButtom();
        contentPane.add(submitButtom);
        setSubmitBotton();

    }

    //Effects: Runs the saving frame
    public static void main(String[] args) {
        Saving myframe = new Saving();
        myframe.setVisible(true);

    }

    //Modifies: This,
    //Effects: Depending on the user option we may save the data in the json file at data/tempDataSystem.json
    public void setSubmitBotton() {
        submitButtom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (yesButton.isSelected() && noButton.isSelected()) {
                    JOptionPane.showMessageDialog(Saving.this,
                            "You can not select both options");
                } else if (yesButton.isSelected()) {
                    JOptionPane.showMessageDialog(Saving.this, "Saving, \n "
                            + "Thank you for using the application");
                    saveData();
                    System.exit(0);
                } else if (noButton.isSelected()) {
                    JOptionPane.showMessageDialog(Saving.this,
                            "Thank you for using the application");
                    System.exit(0);
                }
            }
        });
    }


    //Effects: Creates the JLabel of "do you want to save" wih the correct color and position
    public JLabel setUpVersion() {
        JLabel temp = new JLabel("Do you want to save?");
        temp.setBounds(46, -3, 245, 86);
        temp.setForeground(new Color(0, 0, 128));
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        return temp;

    }

    //Effects: creates the submit button in the correct color and position
    public JRadioButton setUpLastBotton() {
        JRadioButton temp = new JRadioButton("Yes");
        temp.setBounds(90, 81, 103, 21);
        temp.setBackground(new Color(255, 255, 255));
        temp.setForeground(new Color(0, 0, 128));
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        return temp;
    }

    //Modifies:data/tempDataSystem.json
    //Effects: It saves the myData Object to the destination
    public void saveData() {
        FileReader myReader = new FileReader("data/tempDataSystem.json");
        DataSystem mySystem = null;
        try {
            mySystem = myReader.readDataSystem();
        } catch (IOException e3) {
            System.out.println("Could not save the file");
        }
        FileWriter myWriter = new FileWriter();
        myWriter.setFileDestination("data/SavedChangesDataSystem.json");
        try {
            myWriter.open();
            myWriter.write(mySystem);
            myWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Coudl not find the specific file");
        }
    }

    //Effects: It creates the No JRadioButton, with the correct color and position
    public JRadioButton setUpOriginalButtom() {
        JRadioButton temp = new JRadioButton("No");
        temp.setBounds(88, 116, 103, 21);
        temp.setForeground(new Color(0, 0, 128));
        temp.setBackground(new Color(255, 255, 255));
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        return temp;
    }

    //Modifies: It creates to submit JButton, with the correct color and position
    public JButton setUpSubmitButtom() {
        JButton temp = new JButton("Submit");
        temp.setBounds(91, 165, 85, 21);
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        temp.setForeground(SystemColor.window);
        temp.setBackground(new Color(0, 0, 128));
        return temp;
    }


}

