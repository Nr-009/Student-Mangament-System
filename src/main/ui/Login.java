package ui;

import com.sun.tools.jconsole.JConsoleContext;
import model.DataSystem;
import model.FileReader;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class Login extends JFrame {
    private JPanel contentPane;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private DataSystem dataSystem;
    private FileReader myReader;


    public Login() {
        myReader = new FileReader("data/tempDataSystem.json");
        try {
            dataSystem = myReader.readDataSystem();
        } catch (IOException e) {
            System.out.println("Could not read the data");
        }
        setBounds(100, 100, 858, 621);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("THE UNIVERSITY OF BRITISH COUMBIA");
        lblNewLabel.setBounds(184, 37, 637, 69);
        lblNewLabel.setBackground(new Color(0, 0, 128));
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 33));
        contentPane.add(lblNewLabel);


        JLabel logo = new JLabel("");
        ImageIcon img = new ImageIcon("data/Ubcmodified.png");
        logo.setIcon(img);
        logo.setBounds(24, 10, 126, 124);
        contentPane.add(logo);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(new Color(128, 128, 128));
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordLabel.setBounds(39, 403, 137, 22);
        contentPane.add(passwordLabel);

        JLabel loginNameField = new JLabel("Login Name:");
        loginNameField.setForeground(Color.GRAY);
        loginNameField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        loginNameField.setBounds(39, 314, 137, 22);
        contentPane.add(loginNameField);

        username = new JTextField();
        username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        username.setBounds(39, 346, 169, 36);
        contentPane.add(username);
        username.setColumns(10);

        password = new JPasswordField();
        password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        password.setColumns(10);
        password.setBounds(39, 435, 169, 36);
        contentPane.add(password);

        login = new JButton("Login");
        login.setBackground(new Color(0, 0, 128));
        login.setForeground(new Color(255, 255, 255));
        login.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        login.setBounds(39, 481, 85, 21);
        contentPane.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int usernameInt = -1;
                try {
                    usernameInt = Integer.parseInt(username.getText());
                } catch (NumberFormatException e2) {
                    JOptionPane.showMessageDialog(
                            Login.this, "You did not put a valid number for the username");
                }
                if (!dataSystem.hasIDTeacher(usernameInt) && !dataSystem.hasIdStudent(usernameInt)) {
                    JOptionPane.showMessageDialog(Login.this, "The id you enter is wrong");
                } else if (dataSystem.checkLoginTeacher(usernameInt, String.copyValueOf(password.getPassword()))) {
                    JOptionPane.showMessageDialog(Login.this, "Login in as a teacher");
                    goToTeachersMenu(usernameInt);
                } else if (dataSystem.checkLoginStudent(usernameInt, String.copyValueOf(password.getPassword()))) {
                    JOptionPane.showMessageDialog(Login.this, "Login in as a Student");
                } else {
                    JOptionPane.showMessageDialog(Login.this, "This is incorrect");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setBackground(new Color(12, 35, 68));
        panel.setBounds(0, 0, 844, 155);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel cwlLabel = new JLabel(" CWL Authentication");
        cwlLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        cwlLabel.setBounds(252, 165, 403, 81);
        contentPane.add(cwlLabel);

        JLabel loginToContinueLabel = new JLabel("Login to Continue");
        loginToContinueLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        loginToContinueLabel.setBounds(327, 213, 178, 81);
        contentPane.add(loginToContinueLabel);
    }


    public void goToTeachersMenu(int id) {
        this.setVisible(false);
        TeacherMenu currentTeacher = new TeacherMenu(id);
        currentTeacher.setVisible(true);
    }


}
