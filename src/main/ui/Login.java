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
    private JLabel ubcUpperTitle;
    private JLabel logo;
    private JLabel passwordLabel;
    private JLabel loginNameLabel;
    private JLabel cwlLabel;
    private JLabel loginToContinueLabel;


    public Login() {
        readData();
        setBounds(100, 100, 858, 621);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        ubcUpperTitle = setUbcUpperTitle();
        contentPane.add(ubcUpperTitle);
        logo = setUplogo();
        contentPane.add(logo);
        passwordLabel = setupPasswordLabel();
        contentPane.add(passwordLabel);
        loginNameLabel = setloginNameLabel();
        contentPane.add(loginNameLabel);
        part2OfTheConstructor();

    }

    public void part2OfTheConstructor() {
        username = setUsername();
        contentPane.add(username);
        password = setPassword();
        contentPane.add(password);
        login = setUpLogin();
        setActionLogin();
        contentPane.add(login);
        JPanel panel = new JPanel();
        panel.setBackground(new Color(12, 35, 68));
        panel.setBounds(0, 0, 844, 155);
        contentPane.add(panel);
        panel.setLayout(null);
        cwlLabel = setupcwlLabel();
        contentPane.add(cwlLabel);
        loginToContinueLabel = setLoginToContinueLabel();
        contentPane.add(loginToContinueLabel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void goToTeachersMenu(int id) {
        this.setVisible(false);
        TeacherMenu currentTeacher = new TeacherMenu(id);
        currentTeacher.setVisible(true);
    }

    public void readData() {
        myReader = new FileReader("data/tempDataSystem.json");
        try {
            dataSystem = myReader.readDataSystem();
        } catch (IOException e) {
            System.out.println("Could not read the data");
        }
    }

    public JTextField setUsername() {
        JTextField username = new JTextField();
        username.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        username.setBounds(39, 346, 169, 36);
        username.setColumns(10);
        return username;
    }

    public JPasswordField setPassword() {
        JPasswordField password = new JPasswordField();
        password.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        password.setColumns(10);
        password.setBounds(39, 435, 169, 36);
        return password;
    }

    public JButton setUpLogin() {
        JButton login = new JButton("Login");
        login.setBackground(new Color(0, 0, 128));
        login.setForeground(new Color(255, 255, 255));
        login.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        login.setBounds(39, 481, 85, 21);
        return login;
    }

    public void setActionLogin() {
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
    }

    public JLabel setUbcUpperTitle() {
        JLabel ubcUpperTitle = new JLabel("THE UNIVERSITY OF BRITISH COUMBIA");
        ubcUpperTitle.setBounds(184, 37, 637, 69);
        ubcUpperTitle.setBackground(new Color(0, 0, 128));
        ubcUpperTitle.setForeground(new Color(255, 255, 255));
        ubcUpperTitle.setFont(new Font("Arial", Font.PLAIN, 33));
        return ubcUpperTitle;
    }

    public JLabel setUplogo() {
        JLabel logo = new JLabel("");
        ImageIcon img = new ImageIcon("data/Ubcmodified.png");
        logo.setIcon(img);
        logo.setBounds(24, 10, 126, 124);
        return logo;
    }

    public JLabel setupPasswordLabel() {
        JLabel passworldLabel = new JLabel("Password:");
        passworldLabel.setForeground(new Color(128, 128, 128));
        passworldLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passworldLabel.setBounds(39, 403, 137, 22);
        return passworldLabel;
    }

    public JLabel setloginNameLabel() {
        JLabel loginLabel =  new JLabel("Login Name:");
        loginLabel.setForeground(Color.GRAY);
        loginLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        loginLabel.setBounds(39, 314, 137, 22);
        return loginLabel;
    }

    public JLabel setupcwlLabel() {
        JLabel cwlLabel = new JLabel(" CWL Authentication");
        cwlLabel.setFont(new Font("Times New Roman", Font.PLAIN, 36));
        cwlLabel.setBounds(252, 165, 403, 81);
        return cwlLabel;
    }

    public JLabel setLoginToContinueLabel() {
        JLabel logintoContinue = new JLabel("Login to Continue");
        logintoContinue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        logintoContinue.setBounds(327, 213, 178, 81);
        return logintoContinue;
    }






}
