package model;

import java.util.ArrayList;
import java.util.List;

//A student has an id, a list of classes, a list of grades,list of abescenses a fn, a ln,
//there is a list for all students and


public class Student {

    private int id;
    private List<AcademyClass> listOfClasses = new ArrayList<>(); //classes;
    private String fn;
    private String ln;
    private String password;
    private String adress;
    private static List<Student> allStudents = new ArrayList<>();
    private static List<Integer> listOfId = new ArrayList<>();
    private static List<String> listOfPassword = new ArrayList<>();
    private List<Integer> listOfGrades = new ArrayList<>();
    private List<Integer> listOfAbscences = new ArrayList<>();
    private int numOfClasses = 0;

    //Effects: Creates a student with a given id, first name, last name, and password,
    //adds the student into the stack of all students, adds the password into the stack of the pasword
    //and adds the id to the stack of id, initialize  the list of classes, grades and absecenes as empty.
    //If the id is on the system it does the deafults values; deafult ID
    public Student(int id, String fn, String ln, String password) {
        if (!hasId(id)) {
            this.id = id;
            this.fn = fn;
            this.ln = ln;
            this.password = password;
            allStudents.add(this);
            listOfId.add(this.id);
            listOfPassword.add(this.password);
        } else {
            this.id = 626;
        }
    }


    public int getID() {
        return this.id;
    }


    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getFn() {
        return this.fn;

    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getLn() {
        return this.ln;

    }

    //Modifies:This
    //Effects:If provided the correct lasPassword, it changes it to a new one, otherwise
    //it produces false
    public boolean changePassword(String currentPassword, String newPassword) {
        if (currentPassword == this.password && newPassword != "") {
            int index = listOfPassword.indexOf(currentPassword);
            this.password = newPassword;
            listOfPassword.set(index, newPassword);
            return true;
        }
        return false;
    }


    //Modifies:This
    //Effects: If the class is not null adds the clas to the given list of classes for the student

    public boolean addClass(AcademyClass s) {
        if (s != null && !hasClass(s.getName())) {
            listOfClasses.add(s);
            listOfGrades.add(0);
            listOfAbscences.add(0);
            return true;
        }
        return false;

    }

    public void setAdress(String s) {
        this.adress = s;
    }


    public String getAdress() {
        return this.adress;
    }


    //Effects: produces true if the student has the given class

    public boolean hasClass(String s) {
        for (AcademyClass c : listOfClasses) {
            if (c.getName() == s) {
                return true;
            }
        }
        return false;
    }

    //Modifies: This
    //Effects: sets the grade for the given class. Produces false if the class
    //does not exist in teh student information or if the grade inserted is less than zero or more than 100
    public boolean setGradeForClass(String s, int grade) {
        if (hasClass(s) && grade <= 100 && grade >= 0) {
            int index = getIndexOfClass(s);
            listOfGrades.set(index, grade);
            return true;
        }
        return false;
    }


    //Effects:produces the grade in the given class if the student is register for it, otherwise -1
    public double gradeInClass(String s) {
        if (hasClass(s)) {
            int index = getIndexOfClass(s);
            return listOfGrades.get(index);
        }
        return -1;
    }

    //Effects:If a valid id is provided produces the given student, null otherwise
    public static Student getStudent(int id) {
        for (Student s : allStudents) {
            if (s.getID() == id) {
                return s;
            }
        }
        return null;
    }

    //Requires: The stack of id and stack of password to have the same order
    //Effects: produces true if the id and password are the correct ones for the given student
    public static boolean checkLogin(int id, String password) {
        if (hasId(id)) {
            int index = listOfId.indexOf(id);
            if (password == listOfPassword.get(index)) {
                return true;
            }
        }
        return false;
    }


    //Effects: increments the absences of the student in the given class, if the student
    //is not registered in the class then the number of absences does not change
    public boolean incrementAbsecences(String s) {
        if (hasClass(s)) {
            int index = getIndexOfClass(s);
            int absences = listOfAbscences.get(index);
            listOfAbscences.set(index, absences + 1);
            return true;
        }
        return false;

    }
    //Effects: Produces the number of absences a given student has in a class
    //if the student is not registered in the class then it produces -1

    public int checkAbsence(String s) {
        if (hasClass(s)) {
            int index = getIndexOfClass(s);
            return listOfAbscences.get(index);
        }
        return -1;
    }

    //Modifies:This
    //Effects: If the stduent is register for the class produces true and eliminates the class, otherwise produces
    //false/ Also eliminates the respective grade and abecences
    public boolean removeClass(String s) {
        if (hasClass(s)) {
            int index = getIndexOfClass(s);
            listOfAbscences.remove(index);
            listOfClasses.remove(index);
            listOfGrades.remove(index);
            return true;

        }
        return false;

    }

    public int getNumOfClasses() {
        return listOfClasses.size();
    }

    //Effects: if id is found produces true otherwise false
    public static boolean hasId(int id) {
        return listOfId.contains(id);
    }

    public int getIndexOfClass(String s) {
        for (AcademyClass c : listOfClasses) {
            if (c.getName() == s) {
                int index = listOfClasses.indexOf(c);
                return index;
            }
        }
        return -1;

    }


}
