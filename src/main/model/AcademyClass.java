package model;

import java.util.ArrayList;
import java.util.List;

public class AcademyClass {
    private String name;
    private int averageGrade;
    private Teacher  teacher;
    private List<Student> students = new ArrayList<>();
    private String sesion;
    private int numOfStudents;

    //Constructs a class with a given name teacher and sesion.
    // It initializes the list of Students as empty
    public AcademyClass(String name, Teacher t, String sesion) {
        this.name = name;
        this.teacher = t;
        this.sesion = sesion;
    }
    //Modifies: This
    //Effects: changes the average grade to be given one if greater than 0 and less than 100 otherwise does not change

    public void setAverageGrade(int x) {
        if (x >= 0 && x <= 100) {
            this.averageGrade = x;
        }

    }

    public String getName() {
        return name;
    }

    public int getAverageGrade() {
        return averageGrade;

    }


    //Modifies: This
    //Effects: If teacher is not null changes the teacher, also adds the reference to the teacher class
    public boolean setTeacher(Teacher t) {
        if (t != null) {
            this.teacher = t;
            teacher.addClass(this);
            return true;
        }  else {
            return false;
        }

    }

    public Teacher getTeacher() {
        return teacher;
    }

    //Effects: Produces true if the class has a student with the given id, otherwise false
    public boolean hasStudent(int id) {
        for (Student i: students) {
            if (i.getID() == id) {
                return true;
            }
        }
        return false;

    }
    //Effects: Produces the grade of a given student if he is register for the given clas,
    //otherwise produces -1

    public int getGradeStudent(int id) {
        if (hasStudent(id)) {
            int index = getIndexStudent(id);
            Student newStudent = students.get(index);
            return (int) newStudent.gradeInClass(this.name);
        } else {
            return -1;
        }


    }
    //Effects:Sets the grade for a given student, if the student is not on the system, or teh grade is
    // less than 0 or greater than 100 then it produces false

    public boolean setGradeStudent(int id, int grade) {
        if (hasStudent(id) && grade >= 0 && grade <= 100) {
            int index = getIndexStudent(id);
            Student newStudent = students.get(index);
            newStudent.setGradeForClass(this.name, grade);
            return true;
        } else {
            return false;
        }


    }

    public void setSesion(String s) {
        this.sesion = s;

    }

    public String getSession() {
        return sesion;
    }

    //Requires: To work properly the student function for adding must be also used
    //Effects:If the student is not null and the id is not inside it adds the given student

    public boolean addStudent(Student s) {
        if (s != null && !hasStudent(s.getID())) {
            students.add(s);
            numOfStudents++;
            return true;
        }
        return false;

    }

    public int getNumOfStudents() {
        return numOfStudents;

    }

    //Effects: Gives the index of the student if found on the database otherwise produces -1
    public int getIndexStudent(int id) {
        for (Student s: students) {
            if (s.getID() == id) {
                return students.indexOf(s);
            }
        }
        return -1;
    }
    //Requires: Student to have the register the class and the class to not be empty, to be working correctly
    // the stduent function of deleting must also be used.
    //Effects: Deletes the student with the given id if found otherwise produces false
    //also takes the students reference

    public boolean deleteStudent(int id) {
        if (hasStudent(id)) {
            int index = getIndexStudent(id);
            students.remove(index);
            numOfStudents--;
            return true;
        } else {
            return false;
        }

    }

}
