package ui.medianamente;

import model.DataSystem;
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
    private DataSystem mydata;
    private JLabel labelOfId;
    private JButton deleteButton;
    private TableForAddingTeachers table = new TableForAddingTeachers(new ArrayList<>());
    private JPanel panelOfTable;

    public AddingDeletingATeacher(int id) {
        super(id);
        mydata = sendData();
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
        passworldField = setLastNameText();
        super.contentPane.add(passworldField);
        constructorPart2(id);
    }


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
    }

    public static void main(String[] args) {
        AddingDeletingATeacher myMain = new AddingDeletingATeacher(0);
        myMain.setVisible(true);
    }


    public JLabel setCurrentTeachers() {
        JLabel currentStudents = new JLabel("Current Teacher");
        currentStudents.setFont(new Font("Arial", Font.PLAIN, 30));
        currentStudents.setBounds(124, 250, 282, 45);
        return currentStudents;
    }

    public JLabel setCreateTeacherLabel() {
        JLabel createStudentLabel = new JLabel("Create Teacher");
        createStudentLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        createStudentLabel.setBounds(552, 305, 277, 47);
        return createStudentLabel;
    }

    public JLabel setFirstName() {
        JLabel firstName =  new JLabel("First Name");
        firstName.setFont(new Font("Arial", Font.PLAIN, 21));
        firstName.setBounds(510, 353, 116, 47);
        return firstName;
    }

    public JLabel setLastNameLabel() {
        JLabel label = new JLabel("Last Name");
        label.setFont(new Font("Arial", Font.PLAIN, 21));
        label.setBounds(510, 416, 146, 47);
        return label;
    }

    public JLabel setPassworldLabel() {
        JLabel thisLabel = new JLabel("Password");
        thisLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        thisLabel.setBounds(510, 473, 135, 47);
        return thisLabel;
    }

    public JTextField firstName() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setBounds(636, 362, 146, 29);
        return textField;
    }

    public JTextField setTextFieldLastName() {
        JTextField thisText =  new JTextField();
        thisText.setColumns(10);
        thisText.setFont(new Font("Arial", Font.PLAIN, 15));
        thisText.setBounds(636, 427, 146, 29);
        return thisText;
    }

    public JPasswordField setLastNameText() {
        JPasswordField thisfield = new JPasswordField();
        thisfield.setFont(new Font("Arial", Font.PLAIN, 15));
        thisfield.setColumns(10);
        thisfield.setBounds(636, 484, 146, 29);
        return thisfield;
    }

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
                    int idOfTeacher = mydata.addTeacher(fn,ln,passworld);
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "Teacher created with id of " + idOfTeacher);
                    saveData(mydata);
                    table.fireTableDataChanged();
                }

            }
        });
        return  btnNewButton;
    }

    public JTextField setTextFieldOfId() {
        JTextField texFieldOfId = new JTextField();
        texFieldOfId.setFont(new Font("Arial", Font.PLAIN, 15));
        texFieldOfId.setBounds(866, 360, 146, 32);
        contentPane.add(texFieldOfId);
        return texFieldOfId;
    }

    public JLabel setLabelofDeleteTeacher() {
        JLabel deleteTeacherLabel = new JLabel("Delete Teacher");
        deleteTeacherLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        deleteTeacherLabel.setBounds(856, 305, 175, 47);
        return deleteTeacherLabel;
    }

    public JLabel setLabelId() {
        JLabel idLabel = new JLabel("Id");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        idLabel.setBounds(831, 353, 41, 47);
        return idLabel;
    }

    public JButton setDeleteButton(int idRecieved) {
        JButton btndeleteTeacherButton = new JButton("Delete");
        btndeleteTeacherButton.setForeground(Color.WHITE);
        btndeleteTeacherButton.setBackground(new Color(12, 35, 68));
        btndeleteTeacherButton.setBounds(890, 416, 100, 34);
        setButtonOfDeletePart2(btndeleteTeacherButton, idRecieved);
        return btndeleteTeacherButton;
    }

    public JPanel setPanelOfTable() {
        table = new TableForAddingTeachers(mydata.getListOfTeacher());
        JTable table2 = new JTable(table);
        JPanel myPanel = new JPanel();
        myPanel.setBounds(19,305,462,323);
        myPanel.add(new JScrollPane(table2));
        myPanel.setBackground(new Color(240, 240, 240));
        return myPanel;
    }

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
                } else if (!mydata.hasIDTeacher(id) && id != -11) {
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "This id does not exit in the system");
                } else if (id != -11) {
                    mydata.removeTeacher(id);
                    saveData(mydata);
                    table.fireTableDataChanged();
                    JOptionPane.showMessageDialog(AddingDeletingATeacher.this,
                            "Teacher with id " + id + " deleted");
                }
            }
        });
    }


}