/* This table represents the frame where a teacher can add a student to the system
 */

package ui.gui;


import ui.tables.TableForAddingStudents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddingAStudent extends BasicFrameForTeacherSide {

    private JLabel currentStudents;
    private JLabel firstNameLabel;
    private JTextField firstName;
    private JLabel lastNameLabel;
    private JTextField lastName;
    private JPasswordField passworldField;
    private JLabel passworldLabel;
    private JButton submitButton;
    private TableForAddingStudents table = new TableForAddingStudents(new ArrayList<>());
    private JButton backButton;
    private JLabel createStudentLabel;
    private JPanel panelOfTable;

    public AddingAStudent(int id) {
        super(id);
        myData = sendData();
        currentStudents = setCurrentStudents();
        super.contentPane.add(currentStudents);
        createStudentLabel = setCreateStudentLabel();
        super.contentPane.add(createStudentLabel);
        firstNameLabel = setFirstName();
        super.contentPane.add(firstNameLabel);
        firstName = firstName();
        super.contentPane.add(firstName);
        lastNameLabel = setLastNameLabel();
        super.contentPane.add(lastNameLabel);
        constructor2(id);

    }

    //Modifies: This
    //Effects: Continues constructing the frame  by adding missing text-fields and labels
    public void constructor2(int id) {
        lastName = setTextFieldLastName();
        super.contentPane.add(lastName);
        passworldField = setLastNameText();
        super.add(passworldField);
        passworldLabel = setPassworldLabel();
        super.add(passworldLabel);
        submitButton = setSubmitButton();
        super.add(submitButton);
        backButton = backButton(id);
        super.contentPane.add(backButton);
        panelOfTable = setPanelOfTable();
        super.add(panelOfTable);
    }

    public static void main(String[] args) {
        AddingAStudent myMain = new AddingAStudent(0);
        myMain.setVisible(true);
    }

    //Modifies: This
    //Effects: Sets the button of adding Student to not change frame but rather show a message
    @Override
    public JButton setUpCreateStudent(int id) {
        JButton createStudent = new JButton("Create Student");
        createStudent.setForeground(new Color(12, 35, 68));
        createStudent.setBackground(SystemColor.controlHighlight);
        createStudent.setBounds(0, 0, 121, 34);
        createStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AddingAStudent.this,"You are already here");

            }
        });
        return createStudent;
    }

    //Effects: Creates the label of the "current Student" with the correct color, font and position
    public JLabel setCurrentStudents() {
        JLabel currentStudents = new JLabel("Current Students");
        currentStudents.setFont(new Font("Arial", Font.PLAIN, 30));
        currentStudents.setBounds(124, 232, 282, 45);
        return currentStudents;

    }


    //Effects: Creates the label of the "Create Student" with the correct color, font and position
    public JLabel setCreateStudentLabel() {
        JLabel createStudentLabel = new JLabel("Create Student:");
        createStudentLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        createStudentLabel.setBounds(626, 259, 277, 47);
        return createStudentLabel;
    }

    //Effects: Creates the label of the "First Name" with the correct color, font and position
    public JLabel setFirstName() {
        JLabel firstName =  new JLabel("First Name");
        firstName.setFont(new Font("Arial", Font.PLAIN, 24));
        firstName.setBounds(554, 316, 116, 47);
        return firstName;
    }

    //Effects: Creates the Text Field of the "First Name" with the correct color, font and position
    public JTextField firstName() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setBounds(733, 322, 157, 34);
        return textField;

    }

    //Effects: Creates the Label of the "Last Name" with the correct color, font and position
    public JLabel setLastNameLabel() {
        JLabel label = new JLabel("Last Name");
        label.setFont(new Font("Arial", Font.PLAIN, 24));
        label.setBounds(551, 386, 146, 47);
        return label;
    }

    //Effects: Creates the Text field of the "Last Name" with the correct color, font and position
    public JTextField setTextFieldLastName() {
        JTextField thisText =  new JTextField();
        thisText.setColumns(10);
        thisText.setFont(new Font("Arial", Font.PLAIN, 15));
        thisText.setBounds(733, 397, 157, 34);
        return thisText;
    }

    //Effects: Creates the PasswordField with the correct color, font and position
    public JPasswordField setLastNameText() {
        JPasswordField thisfield = new JPasswordField();
        thisfield.setFont(new Font("Arial", Font.PLAIN, 15));
        thisfield.setColumns(10);
        thisfield.setBounds(733, 473, 157, 34);
        return thisfield;
    }

    //Effects: Creates the Label of the "Password" with the correct color, font and position
    public JLabel setPassworldLabel() {
        JLabel thisLabel = new JLabel("Password");
        thisLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        thisLabel.setBounds(554, 462, 135, 47);
        return thisLabel;
    }

    //Modifies: This
    //Effects: Creates teh submit button with the correct color and font. Adds the behaviour
    //of adding a student in case of putting valid information
    public JButton setSubmitButton() {
        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBackground(new Color(12, 35, 68));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(757, 538, 116, 34);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fn = firstName.getText();
                String ln = lastName.getText();
                String passworld = String.copyValueOf(passworldField.getPassword());
                if (fn.isEmpty() | ln.isEmpty() | passworld.isEmpty()) {
                    JOptionPane.showMessageDialog(AddingAStudent.this,
                            "One of the fields is/are empty");
                } else {
                    int idOfStudent = myData.addStudent(fn,ln,passworld);
                    JOptionPane.showMessageDialog(AddingAStudent.this,
                            "Student created with id of " + idOfStudent);
                    saveData(myData);
                    table.fireTableDataChanged();


                }

            }
        });
        return  btnNewButton;
    }

    //Modifies: Creates the table with teh list of all students
    //Effects: Sets the JPanel in the correct position and adds the table to it
    public JPanel setPanelOfTable() {
        table = new TableForAddingStudents(myData.getListOfStudents());
        JTable table2 = new JTable(table);
        JPanel myPanel = new JPanel();
        myPanel.setBounds(19,287,467,335);
        myPanel.add(new JScrollPane(table2));
        myPanel.setBackground(new Color(240, 240, 240));
        return myPanel;
    }





}