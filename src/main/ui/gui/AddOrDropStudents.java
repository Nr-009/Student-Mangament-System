/* This class represents the frame o adding or dropping a student in teh teachers menu */


package ui.gui;

import model.AcademyClass;
import model.DataSystem;
import model.Student;
import ui.tables.TableForAddingStudents;
import ui.tables.TableOfStudentInAClassWithoutEditable;
import ui.tables.TableOfStudentsInAClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddOrDropStudents extends BasicFrameForTeacherSide {

    private JLabel allStudentsLabel;
    private JLabel classStudents;
    private TableOfStudentsInAClass table;
    private TableForAddingStudents table2;
    private JPanel panelOfTable;
    private JLabel addOrdropLabel;
    private JLabel idLabel;
    private JButton dropButton;
    private JButton addButton;
    private JTextField idTextFields;
    private JPanel allStudnets;
    private JButton backButton;
    private JLabel className;




    public AddOrDropStudents(int id, int idOfClass) {
        super(id);
        allStudnets = setAllStudentTable();
        super.contentPane.add(allStudnets);
        panelOfTable = setPanelOfTable(id,idOfClass);
        super.contentPane.add(panelOfTable);
        classStudents = setClassStudents();
        super.contentPane.add(classStudents);
        allStudentsLabel = setallStudentsLabel();
        super.contentPane.add(allStudentsLabel);
        addOrdropLabel = addorDropLabel();
        super.contentPane.add(addOrdropLabel);
        idLabel = setIdLabel();
        super.contentPane.add(idLabel);
        dropButton = setDropButton(idOfClass);
        super.contentPane.add(dropButton);
        addButton = setAddButton(idOfClass);
        super.contentPane.add(addButton);
        idTextFields = setIdTextField();
        super.contentPane.add(idTextFields);
        backButton = backButton(0);
        super.contentPane.add(backButton);
        className = setClassName(id);
        super.contentPane.add(className);
    }

    public static void main(String[] args) {
        AddOrDropStudents myAddOrDropStudents = new AddOrDropStudents(0, 3);
        myAddOrDropStudents.setVisible(true);
    }

    //Effects: Creates the valid TextField for the Id
    public JTextField setIdTextField() {
        JTextField t = new JTextField();
        t.setBounds(871, 410, 88, 29);
        t.setColumns(10);
        return t;
    }

    //Effects: Creates the valid Label for "All Students" with the correct color, position and font
    public JLabel setallStudentsLabel() {
        JLabel lblAllStudents = new JLabel("All Students");
        lblAllStudents.setForeground(new Color(12, 35, 68));
        lblAllStudents.setFont(new Font("Arial", Font.PLAIN, 26));
        lblAllStudents.setBounds(449, 237, 195, 45);
        return lblAllStudents;
    }

    //Effects: Creates the valid Label for "Class Student" with the correct color, position and font
    public JLabel setClassStudents() {
        JLabel classStudents = new JLabel("Class Students");
        classStudents.setFont(new Font("Arial", Font.PLAIN, 26));
        classStudents.setForeground(new Color(12, 35, 68));
        classStudents.setBounds(85, 237, 195, 45);
        return classStudents;
    }

    //Modifies: This
    //Effects: Creates the valid JPanel for "Class Student" with the correct color, position and font, and adds the
    //table of all the students
    public JPanel setPanelOfTable(int id, int idOfClass) {
        AcademyClass currentClass = myData.getAcademyClass(idOfClass);
        table = new TableOfStudentInAClassWithoutEditable(currentClass.getStudents(), currentClass.getName());
        JPanel classStudents = new JPanel();
        classStudents.setBounds(10,292,336,337);
        classStudents.setBackground(new Color(240, 240, 240));
        JTable table2 = new JTable(table);
        JScrollPane scrollPane = new JScrollPane(table2);
        scrollPane.setPreferredSize(new Dimension(336,337));
        scrollPane.setSize(table2.WIDTH, table2.HEIGHT);
        classStudents.add(scrollPane);
        return classStudents;
    }

    //Modifies: This
    //Effects: Creates the valid JPanel for "Class Student" with the correct color, position and font, and adds the
    //table of all the students
    public JPanel setAllStudentTable() {
        table2 = new TableForAddingStudents(myData.getListOfStudents());
        JPanel allStudents = new JPanel();
        allStudents.setBounds(373, 292, 322, 337);
        allStudents.setBackground(new Color(240, 240, 240));
        JTable table3 = new JTable(table2);
        JScrollPane scrollPane = new JScrollPane(table3);
        scrollPane.setPreferredSize(new Dimension(322, 337));
        allStudents.add(scrollPane);
        return allStudents;
    }

    //Effects: Sets the valid JLabel of "Add or Drop" with the correct font, text and position
    public JLabel addorDropLabel() {
        JLabel addOrDrop = new JLabel("Add Or Drop");
        addOrDrop.setForeground(new Color(12, 35, 68));
        addOrDrop.setFont(new Font("Arial", Font.PLAIN, 26));
        addOrDrop.setBounds(808, 347, 151, 45);
        return addOrDrop;
    }

    //Effects: Sets the valid JLabel of "Id" with the correct font, text and position
    public JLabel setIdLabel() {
        JLabel lblId = new JLabel("Id");
        lblId.setForeground(new Color(12, 35, 68));
        lblId.setFont(new Font("Arial", Font.PLAIN, 24));
        lblId.setBounds(818, 402, 38, 36);
        return lblId;
    }

    //Modifies: This
    //Effects: Sets the for Dropping a class and adds the behavior that if the correct ID is and teh student is drop
    //from the system
    public JButton setDropButton(int idOfClass) {
        JButton drop = new JButton("Drop");
        setActionDropStudents(drop, idOfClass);
        drop.setForeground(Color.WHITE);
        drop.setBackground(new Color(12, 35, 68));
        drop.setBounds(845, 498, 80, 29);
        return drop;

    }

    //Modifies: This
    //Effects: Sets the for Adding a class and adds the behavior that if the correct ID is and the student is added
    //from the system
    @SuppressWarnings("methodlength")
    public void setActionAddButton(JButton s, int idOfClass) {
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "";
                int intIdOfStudent = 0;
                try {
                    id = idTextFields.getText();
                    intIdOfStudent = Integer.parseInt(id);
                    Student currentStudent = myData.getStudent(intIdOfStudent);
                    AcademyClass currentClas = myData.getAcademyClass(idOfClass);
                    if (currentClas.hasStudent(intIdOfStudent)) {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "This student is already register for this class");
                    } else {
                        currentClas.addStudent(currentStudent);
                        currentStudent.addClass(currentClas);
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "Student with id of " + id + " added");
                        saveData(myData);
                        table.fireTableDataChanged();
                        table2.fireTableDataChanged();
                    }
                } catch (Exception e2) {
                    if (id.isEmpty()) {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "You need to put and id");
                    } else {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "You put something that is not a number");
                    }

                }
            }
        });
    }

    //Modifies: This
    //Effects: Sets the for Drop a class and adds the behavior that if the correct ID is and the student is added
    //from the system
    @SuppressWarnings("methodlength")
    public void setActionDropStudents(JButton s, int idOfClass) {
        s.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = "";
                int intIdOfStudent = 0;
                try {
                    id = idTextFields.getText();
                    intIdOfStudent = Integer.parseInt(id);
                    Student currentStudent = myData.getStudent(intIdOfStudent);
                    AcademyClass currentClas = myData.getAcademyClass(idOfClass);
                    if (!currentClas.hasStudent(intIdOfStudent)) {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "This student is not register for this class");
                    } else {
                        currentClas.deleteStudent(intIdOfStudent);
                        currentStudent.removeClass(currentClas.getName());
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "Stduent with id of " + id + " dropped");
                        saveData(myData);
                        table.fireTableDataChanged();
                        table2.fireTableDataChanged();
                    }
                } catch (Exception e2) {
                    if (id.isEmpty()) {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "You need to put and id");
                    } else {
                        JOptionPane.showMessageDialog(AddOrDropStudents.this,
                                "You put something that is not a number");
                    }

                }
            }
        });

    }

    //Modifies: This
    //Effects: Sets the for Drop a class and adds the behavior that if the correct ID is and the student is added
    //from the system
    public JButton setAddButton(int idOfClass) {
        JButton addButton = new JButton("Add");
        addButton.setForeground(Color.WHITE);
        addButton.setBackground(new Color(12, 35, 68));
        addButton.setBounds(845, 459, 80, 29);
        setActionAddButton(addButton, idOfClass);
        return addButton;
    }

    //Effects: returns the correct label for the className
    public JLabel setClassName(int id) {
        AcademyClass myCurrentClass = myData.getAcademyClass(id);
        String name = myCurrentClass.getName();
        JLabel lblClassName = new JLabel(name);
        lblClassName.setHorizontalAlignment(SwingConstants.CENTER);
        lblClassName.setForeground(new Color(12, 35, 68));
        lblClassName.setFont(new Font("Arial", Font.PLAIN, 30));
        lblClassName.setBounds(716, 292, 336, 45);
        return lblClassName;

    }



}



