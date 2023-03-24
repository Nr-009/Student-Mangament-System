package ui.medianamente;

import model.Teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EditInfo extends BasicFrameForTeacherSide {

    private JTextField fnTextField;
    private JTextField lnTextField;
    private JTextField passwordTextField;
    private JTextField newPasswroldTextField;
    private JButton submitButton;
    private JLabel labelOfFirstName;
    private JLabel labelOfLastName;
    private JLabel labelOfPassworld;
    private JLabel labelOfNewPassword;
    private JLabel idLabel;
    private JLabel labelOfNumberOfClasses;
    private JLabel currentStudents;
    private JButton backButton;

    public EditInfo(int id) {
        super(id);
        myData = super.sendData();
        fnTextField = settingfirstName();
        super.contentPane.add(fnTextField);
        lnTextField = settingLastName();
        super.contentPane.add(lnTextField);
        passwordTextField = setPasswordTextField();
        super.contentPane.add(passwordTextField);
        newPasswroldTextField = setNewPasworldTextField();
        super.contentPane.add(newPasswroldTextField);
        submitButton = setSubmitButton(id);
        super.contentPane.add(submitButton);
        labelOfFirstName = firstNameLabel(id);
        super.contentPane.add(labelOfFirstName);
        labelOfLastName = lastNameLabel(id);
        constructorPart2(id);
    }

    public void constructorPart2(int id) {
        super.contentPane.add(labelOfLastName);
        labelOfPassworld = labelOfPassword();
        super.contentPane.add(labelOfPassworld);
        labelOfNewPassword = getLabelOfNewPassword();
        super.contentPane.add(labelOfNewPassword);
        idLabel = labelOfId(id);
        super.contentPane.add(idLabel);
        labelOfNumberOfClasses = numberOfClasses(id);
        super.contentPane.add(labelOfNumberOfClasses);
        currentStudents = setCurrentStudents(id);
        super.contentPane.add(currentStudents);
        backButton = backButton(id);
        super.contentPane.add(backButton);
    }

    public static void main(String[] args) {
        EditInfo myMain = new EditInfo(0);
        myMain.setVisible(true);
    }

    public JTextField settingfirstName() {
        JTextField fnTextField = new JTextField();
        fnTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        fnTextField.setBounds(603, 303, 154, 28);
        fnTextField.setColumns(10);
        return fnTextField;
    }

    public JTextField settingLastName() {
        lnTextField = new JTextField();
        lnTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lnTextField.setColumns(10);
        lnTextField.setBounds(603, 347, 154, 28);
        return lnTextField;
    }

    public JTextField setPasswordTextField() {
        JPasswordField passwordTextField = new JPasswordField();
        passwordTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(603, 391, 154, 28);
        return passwordTextField;
    }

    public JPasswordField setNewPasworldTextField() {
        JPasswordField newPasswroldTextField = new JPasswordField();
        newPasswroldTextField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        newPasswroldTextField.setColumns(10);
        newPasswroldTextField.setBounds(603, 440, 154, 28);
        return newPasswroldTextField;
    }


    public JButton setSubmitButton(int idOfTeacher) {
        JButton btnBack = new JButton("Submit");
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(new Color(12, 35, 68));
        btnBack.setBounds(627, 489, 100, 29);
        setUpSubmitButton(btnBack, idOfTeacher);
        return btnBack;
    }

    @SuppressWarnings("methodlength")
    public void setUpSubmitButton(JButton s, int idOfTeacher) {
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fn = fnTextField.getText();
                String ln = lnTextField.getText();
                String password = passwordTextField.getText();
                String newPassword = newPasswroldTextField.getText();
                Teacher currentTeacher = myData.getTeacher(idOfTeacher);
                if (password.isEmpty() && (fn.isEmpty() | ln.isEmpty() | newPassword.isEmpty())) {
                    JOptionPane.showMessageDialog(EditInfo.this,
                            "You need to put the \npassword to make any changes");
                } else if (!myData.checkLoginTeacher(idOfTeacher, password)) {
                    JOptionPane.showMessageDialog(EditInfo.this,
                            "You put an incorrect password");
                } else {
                    if (!fn.isEmpty() && !fn.equals(currentTeacher.getFn())) {
                        JOptionPane.showMessageDialog(EditInfo.this,
                                "Changing fn for " + fn);
                        currentTeacher.setFn(fn);
                        labelOfFirstName.setText("First Name: " + currentTeacher.getFn());
                        saveData(myData);
                    }
                    if (!ln.isEmpty()  && !ln.equals(currentTeacher.getLn())) {
                        JOptionPane.showMessageDialog(EditInfo.this,
                                "Changing ln for " + ln);
                        currentTeacher.setLn(ln);
                        labelOfLastName.setText("Last Name: " + currentTeacher.getLn());
                        saveData(myData);
                    }
                    if (!newPassword.isEmpty() && !newPassword.equals(currentTeacher.getPassword())) {
                        JOptionPane.showMessageDialog(EditInfo.this,
                                "Changed password");
                        myData.changePasswordTeacher(idOfTeacher, password, newPassword);
                        saveData(myData);
                    }
                    name.setText("Name: " + currentTeacher.getFn()
                            + " " + currentTeacher.getLn());
                }
            }
        });
    }

    public JLabel firstNameLabel(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel firstName = new JLabel("First Name: " + currentTeacher.getFn());
        firstName.setFont(new Font("Arial", Font.PLAIN, 24));
        firstName.setBounds(315, 292, 278, 45);
        return firstName;
    }

    public JLabel lastNameLabel(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel lastName = new JLabel("Last Name: " + currentTeacher.getLn());
        lastName.setFont(new Font("Arial", Font.PLAIN, 24));
        lastName.setBounds(315, 336, 287, 45);
        return lastName;
    }

    public JLabel labelOfPassword() {
        JLabel lblCurrentPassworld = new JLabel("Password:");
        lblCurrentPassworld.setFont(new Font("Arial", Font.PLAIN, 24));
        lblCurrentPassworld.setBounds(315, 385, 278, 45);
        return lblCurrentPassworld;
    }

    public JLabel getLabelOfNewPassword() {
        JLabel lblNewPassword = new JLabel("New Password:");
        lblNewPassword.setFont(new Font("Arial", Font.PLAIN, 24));
        lblNewPassword.setBounds(315, 434, 278, 45);
        return lblNewPassword;
    }

    public JLabel labelOfId(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel idLabel = new JLabel("Id: " + currentTeacher.getId());
        idLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        idLabel.setBounds(315, 489, 120, 45);
        return idLabel;
    }

    public JLabel numberOfClasses(int id) {
        Teacher currentTeacher = myData.getTeacher(id);
        JLabel numberOfClassesLabel = new JLabel("#Classes: " + currentTeacher.getNumClasses());
        numberOfClassesLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        numberOfClassesLabel.setBounds(315, 544, 278, 45);
        return numberOfClassesLabel;
    }

    public JLabel setCurrentStudents(int idOfClass) {
        String name = myData.getAcademyClass(idOfClass).getName();
        JLabel classSelected = new JLabel("Current Information");
        classSelected.setFont(new Font("Arial", Font.PLAIN, 30));
        classSelected.setBounds(408, 237, 278, 45);
        return classSelected;
    }

    @Override
    public JButton setPersonalInfo(int id) {
        JButton personalInfo =  new JButton("Personal Info");
        personalInfo.setForeground(new Color(12, 35, 68));
        personalInfo.setBackground(SystemColor.controlHighlight);
        personalInfo.setBounds(261, 0, 121, 34);
        personalInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(EditInfo.this,
                        "You are already here");
            }
        });
        return personalInfo;
    }
}



