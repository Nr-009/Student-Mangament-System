package ui.gui;

import model.DataSystem;
import model.FileReader;
import model.FileWriter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


    public static void main(String[] args) {
        StartFrame myframe = new StartFrame();
        myframe.setVisible(true);

    }

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

    public JLabel setUpVersion() {
        JLabel temp = new JLabel("Version");
        temp.setForeground(new Color(0, 0, 128));
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 29));
        temp.setBounds(90, 10, 155, 86);
        return temp;

    }

    public JRadioButton setUpLastBotton() {
        JRadioButton temp = new JRadioButton("Last");
        temp.setBackground(new Color(255, 255, 255));
        temp.setForeground(new Color(0, 0, 128));
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        temp.setBounds(90, 141, 103, 21);
        return temp;
    }

    public JRadioButton setUpOriginalButtom() {
        JRadioButton temp = new JRadioButton("Original");
        temp.setForeground(new Color(0, 0, 128));
        temp.setBackground(new Color(255, 255, 255));
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        temp.setBounds(90, 102, 103, 21);
        return temp;
    }

    public JButton setUpSubmitButtom() {
        JButton temp = new JButton("Submit");
        temp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        temp.setForeground(SystemColor.window);
        temp.setBackground(new Color(0, 0, 128));
        temp.setBounds(95, 187, 85, 21);
        return temp;
    }


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

    public void continueToLogin() {
        this.setVisible(false);
        Login currentlogin = new Login();
        currentlogin.setVisible(true);
    }



}
