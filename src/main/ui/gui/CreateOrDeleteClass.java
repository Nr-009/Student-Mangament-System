/* This class represent the adding or deleting a class frame
 */


package ui.gui;

import model.*;
import ui.tables.TableForAddingAClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateOrDeleteClass extends BasicFrameForTeacherSide {

    private JLabel currentTeachers;
    private TableForAddingAClass table = new TableForAddingAClass(new ArrayList<>());
    private JPanel panelOfTable;
    private JLabel createTeacherLabel;
    private JLabel nameLabel;
    private JLabel lastNameLabel;
    private JLabel sessionLabel;
    private JTextField nameTextField;
    private JTextField idOfTeacher;
    private JTextField sesion;
    private JButton submitButton;
    private JLabel labelofDeleteClass;
    private JTextField texFieldOfId;
    private JLabel labelOfId;
    private JButton deleteButton;
    private JButton backButton;


    public CreateOrDeleteClass(int id) {
        super(id);
        currentTeachers = setCurrentStudents();
        super.contentPane.add(currentTeachers);
        panelOfTable = setPanelOfTable();
        super.contentPane.add(panelOfTable);
        createTeacherLabel = setCreateStudentLabel();
        super.contentPane.add(createTeacherLabel);
        nameLabel = setFirstName();
        super.contentPane.add(nameLabel);
        lastNameLabel = setLastNameLabel();
        super.contentPane.add(lastNameLabel);
        sessionLabel = setSessionLabel();
        super.contentPane.add(sessionLabel);
        nameTextField = firstName();
        super.contentPane.add(nameTextField);
        idOfTeacher = setTextFieldLastName();
        super.contentPane.add(idOfTeacher);
        sesion = setSessionText();
        super.contentPane.add(sesion);
        submitButton = setSubmitButton();
        super.contentPane.add(submitButton);
        constructorPart2(id);

    }

    //Modifies: This
    //Effects: Continues creating the Frame with the missing labels, text-fields and buttons.
    public void constructorPart2(int id) {
        labelofDeleteClass = setLabelofDeleteClass();
        super.contentPane.add(labelofDeleteClass);
        texFieldOfId = setTextFieldOfId();
        super.contentPane.add(texFieldOfId);
        labelOfId = setLabelId();
        super.contentPane.add(labelOfId);
        deleteButton = setDeleteButton(id);
        super.contentPane.add(deleteButton);
        backButton = backButton(id);
        super.contentPane.add(backButton);
    }

    public static void main(String[] args) {
        CreateOrDeleteClass creating = new CreateOrDeleteClass(0);
        creating.setVisible(true);
    }

    //Modifies: This
    //Effects: Creates the JLabel of "Session" with the correct faint, color and positions
    public JLabel setSessionLabel() {
        JLabel thisLabel = new JLabel("Sesion");
        thisLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        thisLabel.setBounds(510, 473, 135, 47);
        return thisLabel;
    }

    //Modifies: This
    //Effects: Creates the JLabel of "Current Classes" with the correct faint, color and positions
    public JLabel setCurrentStudents() {
        JLabel currentClasses = new JLabel("Current Classes");
        currentClasses.setFont(new Font("Arial", Font.PLAIN, 30));
        currentClasses.setBounds(124, 250, 282, 45);
        return currentClasses;
    }

    //Modifies: This
    //Effects: Create JPanel and put the correct table
    public JPanel setPanelOfTable() {
        table = new TableForAddingAClass(myData.getListOfClasses());
        JTable table2 = new JTable(table);
        JPanel myPanel = new JPanel();
        myPanel.setBounds(19, 305, 462, 323);
        myPanel.add(new JScrollPane(table2));
        myPanel.setBackground(new Color(240, 240, 240));
        return myPanel;
    }

    //Modifies: This
    //Effects: Creates the JLabel of "Create Class" with the correct faint, color and positions
    public JLabel setCreateStudentLabel() {
        JLabel createStudentLabel = new JLabel("Create Class");
        createStudentLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        createStudentLabel.setBounds(585, 305, 199, 47);
        return createStudentLabel;
    }

    //Modifies: This
    //Effects: Creates the JLabel of "Name" with the correct faint, color and positions
    public JLabel setFirstName() {
        JLabel firstName = new JLabel("Name");
        firstName.setFont(new Font("Arial", Font.PLAIN, 21));
        firstName.setBounds(510, 353, 116, 47);
        return firstName;
    }

    //Modifies: This
    //Effects: Creates the JLabel of "Id of Teacher" with the correct faint, color and positions
    public JLabel setLastNameLabel() {
        JLabel lblIdOfTeacher = new JLabel("Id of Teacher");
        lblIdOfTeacher.setFont(new Font("Arial", Font.PLAIN, 21));
        lblIdOfTeacher.setBounds(510, 416, 146, 47);
        return lblIdOfTeacher;
    }

    //Effects: Creates Text Field with the First Name with the correct position and font
    public JTextField firstName() {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 15));
        textField.setBounds(651, 362, 146, 29);
        return textField;
    }

    //Effects: Creates Text Field with the Last Name with the correct position and font
    public JTextField setTextFieldLastName() {
        JTextField thisText = new JTextField();
        thisText.setColumns(10);
        thisText.setFont(new Font("Arial", Font.PLAIN, 15));
        thisText.setBounds(651, 427, 146, 29);
        return thisText;
    }

    //Effects: Creates Text Field with the Session with the correct position and font
    public JTextField setSessionText() {
        JTextField thisfield = new JTextField();
        thisfield.setFont(new Font("Arial", Font.PLAIN, 15));
        thisfield.setColumns(10);
        thisfield.setBounds(651, 484, 146, 29);
        return thisfield;
    }

    //Modifies: This
    //Effects: Sets the submit button  and adds the correct behaviour for creating a class and adding to the system.
    @SuppressWarnings("methodlength")
    public JButton setSubmitButton() {
        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setBackground(new Color(12, 35, 68));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBounds(606, 530, 116, 34);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameTextField.getText();
                int id = -120;
                String id2 = "";
                try {
                    id2 = idOfTeacher.getText();
                    id = Integer.parseInt(idOfTeacher.getText());
                } catch (Exception e2) {
                    if (!id2.isEmpty()) {
                        JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                                "You try to insert something that is not a number");
                    } else {
                        JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                                "The id field is empty");
                    }
                }
                String sesionText = sesion.getText();
                if (name.isEmpty() | sesionText.isEmpty()) {
                    JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                            "One of the fields is/are empty");
                } else if ((id < 0) && (id != -120)) {
                    JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                            "You enter an invalid id");

                } else if (!myData.hasIDTeacher(id) && (id != -120)) {
                    JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                            "This id does not exit in the system");
                } else if (id != -120) {
                    Teacher currentTeacher = myData.getTeacher(id);
                    int idOfClassCreated = myData.addAcademyClass(name, currentTeacher, sesionText);
                    JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                            "Class with id " + idOfClassCreated + "  created");
                    saveData(myData);
                    table.fireTableDataChanged();
                }
            }

        });
        return btnNewButton;
    }

    //Modifies: This
    //Effects: Creates the JLabel of "Delete Teacher" with the correct faint, color and positions
    public JLabel setLabelofDeleteClass() {
        JLabel deleteTeacherLabel = new JLabel("Delete Class");
        deleteTeacherLabel.setFont(new Font("Arial", Font.PLAIN, 26));
        deleteTeacherLabel.setBounds(856, 305, 153, 47);
        return deleteTeacherLabel;
    }

    //Effects: Creates Text Field with the Id with the correct position and font
    public JTextField setTextFieldOfId() {
        JTextField texFieldOfId = new JTextField();
        texFieldOfId.setFont(new Font("Arial", Font.PLAIN, 15));
        texFieldOfId.setBounds(866, 360, 146, 32);
        contentPane.add(texFieldOfId);
        return texFieldOfId;
    }

    //Modifies: This
    //Effects: Creates the JLabel of "Id" with the correct faint, color and positions
    public JLabel setLabelId() {
        JLabel idLabel = new JLabel("Id");
        idLabel.setFont(new Font("Arial", Font.PLAIN, 21));
        idLabel.setBounds(831, 353, 41, 47);
        return idLabel;
    }

    //Modifies: This
    //Effects: Creates the delete button and sets the behavior for deleting A class
    public JButton setDeleteButton(int idRecieved) {
        JButton btndeleteTeacherButton = new JButton("Delete");
        btndeleteTeacherButton.setForeground(Color.WHITE);
        btndeleteTeacherButton.setBackground(new Color(12, 35, 68));
        btndeleteTeacherButton.setBounds(890, 416, 100, 34);
        setButtonOfDeletePart2(btndeleteTeacherButton, idRecieved);
        return btndeleteTeacherButton;
    }

    //Modifies: This
    //Effects: Creates the delete button and sets the behavior for deleting A class
    @SuppressWarnings("methodlength")
    public void setButtonOfDeletePart2(JButton button, int idTeacher) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = -11;
                String myString = " ";
                boolean idIsGood = true;
                try {
                    myString = texFieldOfId.getText();
                    id = Integer.parseInt(texFieldOfId.getText());
                } catch (Exception e2) {
                    idIsGood = false;
                    if (myString.isEmpty()) {
                        JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                                "You need to put an id");
                    } else {
                        JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                                "You put something \n that is not a number");
                    }
                }
                if (!myData.hasIdOfAcademyClass(id) && id != -11) {
                    JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                            "This class does not exist");
                } else {
                    if (id != -11 && idIsGood && id >= 0) {
                        AcademyClass currentClass = myData.getAcademyClass(id);
                        Teacher currentTeacher = myData.getTeacher(idTeacher);
                        if (currentClass.getTeacher().getId() != idTeacher) {
                            JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                                    "You can not delete other teacher classes");
                        } else {
                            myData.removeAcademyClass(id);
                            JOptionPane.showMessageDialog(CreateOrDeleteClass.this,
                                    "Class with id " + id + " deleted");
                            saveData(myData);
                            table.fireTableDataChanged();

                        }
                    }

                }
            }
        });
    }



}