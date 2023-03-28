/* This class represents teh frame for adding or deleting a teacher.
 */

package ui.medianamente;

import ui.tables.TableForAddingTeachers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddingDeletingATeacher  extends BasicFrameForTeacherSide {
    private JLabel currentTeachers;
    private JLabel createTeacherLabel;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JTextField firstName;
    private JTextField lastName;
    private JPasswordField passworldField;
    private JLabel passwordLabel;
    private JButton submitButton;
    private JLabel labelofDeleteTeacher;
    private JTextField texFieldOfId2;
    private JLabel labelOfId;
    private JButton deleteButton;
    private TableForAddingTeachers table = new TableForAddingTeachers(new ArrayList<>());
    private JPanel panelOfTable;
    private JButton backButton;

    public AddingDeletingATeacher(int id) {
        super(id);
        myData = sendData();
        passwordLabel = setPassworldLabel();
        super.contentPane.add(passwordLabel);
        currentTeachers = setCurrentTeachers();
        super.contentPane.add(currentTeachers);
        createTeacherLabel = setCreateTeacherLabel();
        super.contentPane.add(createTeacherLabel);
        firstNameLabel = setFirstName();
        super.contentPane.add(firstNameLabel);
        lastNameLabel = setLastNameLabel();
        super.contentPane.add(lastNameLabel);
        firstName = firstName();
        super.contentPane.add(firstName);
        lastName = setTextFieldLastName();
        super.contentPane.add(lastName);
        passworldField = setPaasswordTextField();
        super.contentPane.add(passworldField);
        constructorPart2(id);
    }


    //Modifies: This
    //Effects: Sets the frame with all the missing buttons, frames, and labels
    public void constructorPart2(int id) {
        submitButton = setSubmitButton();
        super.contentPane.add(submitButton);
        labelofDeleteTeacher = setLabelofDeleteTeacher();
        super.contentPane.add(labelofDeleteTeacher);
        texFieldOfId2 = setTextFieldOfId();
        super.contentPane.add(texFieldOfId2);
        labelOfId = setLabelId();
        super.contentPane.add(labelOfId);
        deleteButton = setDeleteButton(id);
        super.contentPane.add(deleteButton);
        panelOfTable = setPanelOfTable();
        super.contentPane.add(panelOfTable);
        backButton = backButton(id);
        super.contentPane.add(backButton);
    }

    public static void main(String[] args) {
        AddingDeletingATeacher myMain = new AddingDeletingATeacher(0);
        myMain.setVisible(true);
    }

    //Effects: Creates a label of "Current Teacher" with the correct color, position and font
    public JLabel setCurrentTeachers() {
        JLabel currentStudents = new JLabel("Current Teacher");
        currentStudents.setFont(new Font("Arial", Font.PLAIN, 30));
        currentStudents.setBounds(124, 250, 282, 45);
        return currentStudents;
    }

    //Effects: Creates a label of "Create Teacher" with the correct color, position and font
    public JLabel setCreateTeacherLabel() {
        JLabel createStudentLabel = new JLabel("Create Teacher");
        createStudentLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        createStudentLabel.setBounds(552, 305, 277, 47);
        return createStudentLabel;
    }

    //Effects: Creates a label of "First Name" with the correct color, position and font
    public JLabel setFirstName() {
        JLabel firstName =  new JLabel("First Name");
        firstName.setFont(new Font("Arial", Font.PLAIN, 21));
        firstName.setBounds(510, 353, 116, 47);
        return firstName;
    }

    //Effects: Creates a label of "Last Name" with the correct color, position and font
    public JLabel setLastNameLabel() {
        JLabel label = new JLabel("Last Name");
        label.setFont(new Font("Arial", Font.PLAIN, 21));
        label.setBounds(510, 416, 146, 47);
        return label;
    }

    //Effects: Creates a label of "Password" with the correct color, position and font
    public JLabel setPassworldLabel() {
        JLabel thisLabel = new JLabel("Password");
        thisLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        thisLabel.setBounds(510, 473, 135, 47);
        return thisLabel;
    }

    //Effects: Creates a Textfield of first name with the correct color, position and font
    public JTextField firstName() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setBounds(636, 362, 146, 29);
        return textField;
    }

    //Effects: Creates a Textfield of last name with the correct color, position and font
    public JTextField setTextFieldLastName() {
        JTextField thisText =  new JTextField();
        thisText.setColumns(10);
        thisText.setFont(new Font("Arial", Font.PLAIN, 15));
        thisText.setBounds(636, 427, 146, 29);
        return thisText;
    }

    //Effects: Creates a Password field with the correct color, position and font
    public JPasswordField setPaasswordTextField() {
        JPasswordField thisfield = new JPasswordField();
        thisfield.setFont(new Font("Arial", Font.PLAIN, 15));
        thisfield.setColumns(10);
        thisfield.setBounds(636, 484, 146, 29);
        return thisfield;
    }

    //Modifies: This
    //Effects: Creates the submit button and sets the behaviour to in case
    // of putting the valid fields creating a teacher
    public JButton setSubmitButton() {
        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBackground(new Color(12, 35, 68));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(606, 530, 116, 34);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fn = firstName.getText();
                String ln = lastName.getText();
                String passworld = String.copyValueOf(passworldField.getPassword());
                if (fn.isEmpty() | ln.isEmpty() | passworld.isEmpty()) {
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "One of the fields is/are empty");
                } else {
                    int idOfTeacher = myData.addTeacher(fn,ln,passworld);
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "Teacher created with id of " + idOfTeacher);
                    saveData(myData);
                    table.fireTableDataChanged();
                }

            }
        });
        return  btnNewButton;
    }

    //Effects: Creates a id Text field with the correct color, position and font
    public JTextField setTextFieldOfId() {
        JTextField texFieldOfId = new JTextField();
        texFieldOfId.setFont(new Font("Arial", Font.PLAIN, 15));
        texFieldOfId.setBounds(866, 360, 146, 32);
        contentPane.add(texFieldOfId);
        return texFieldOfId;
    }

    //Effects: Creates a JLabel  of "Delete a teacher" with the correct color, position and font
    public JLabel setLabelofDeleteTeacher() {
        JLabel deleteTeacherLabel = new JLabel("Delete Teacher");
        deleteTeacherLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        deleteTeacherLabel.setBounds(856, 305, 175, 47);
        return deleteTeacherLabel;
    }

    //Effects: Creates a JLabel  of "Id" with the correct color, position and font
    public JLabel setLabelId() {
        JLabel idLabel = new JLabel("Id");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        idLabel.setBounds(831, 353, 41, 47);
        return idLabel;
    }

    //Modifies: This
    //Effects: Creates a JButton for deleting a teacher and adds the respective behaviour so that if the valid is
    // inserted the teacher is deleted of the database
    public JButton setDeleteButton(int idRecieved) {
        JButton btndeleteTeacherButton = new JButton("Delete");
        btndeleteTeacherButton.setForeground(Color.WHITE);
        btndeleteTeacherButton.setBackground(new Color(12, 35, 68));
        btndeleteTeacherButton.setBounds(890, 416, 100, 34);
        setButtonOfDeletePart2(btndeleteTeacherButton, idRecieved);
        return btndeleteTeacherButton;
    }

    //Modifies: This
    //Effects: Creates the table for seeing all the teachers currently in the system
    public JPanel setPanelOfTable() {
        table = new TableForAddingTeachers(myData.getListOfTeacher());
        JTable table2 = new JTable(table);
        JPanel myPanel = new JPanel();
        myPanel.setBounds(19,305,462,323);
        myPanel.add(new JScrollPane(table2));
        myPanel.setBackground(new Color(240, 240, 240));
        return myPanel;
    }

    //Modifies: This
    //Effects: Sets the behaviour for the delete button so that if the correct id is inserted the teacher is deleted
    //from the database
    @SuppressWarnings("methodlength")
    public void setButtonOfDeletePart2(JButton button, int idRecieved) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = -11;
                String myString = " ";
                try {
                    myString = texFieldOfId2.getText();
                    id = Integer.parseInt(texFieldOfId2.getText());
                } catch (Exception e2) {
                    if (myString.isEmpty()) {
                        JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                                "You need to put an id");
                    } else {
                        JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                                "You put something \n that is not a number");
                    }
                }
                if (id == idRecieved) {
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "You can not delete yourself");
                } else if (!myData.hasIDTeacher(id) && id != -11) {
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "This id does not exit in the system");
                } else if (id != -11) {
                    myData.removeTeacher(id);
                    saveData(myData);
                    table.fireTableDataChanged();
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "Teacher with id " + id + " deleted");
                }
            }
        });
    }


}