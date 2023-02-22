/*
This class represents the student in the Academy, they have a first name, last name, a password and id to login.
They also have a list of classes, a list of grades and absences, which all teh things they should keep track of.
Apart from that the class in general has three static list which represents the ids, password and all the references
for the students

 */

package model;

import java.util.ArrayList;
import java.util.List;

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
    //adds the student into the list of all students, adds the password into the stack of the password
    //and adds the id to the stack of id.If the id is on the system it does the defaults values with id of 626.
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

    //Effects: returns the id of the student
    public int getID() {
        return this.id;
    }

    //Modifies: This
    //Effects: changes the address of the given student
    public void setAddress(String s) {
        this.adress = s;
    }

    //Effects: returns the address of the given student
    public String getAddress() {
        return this.adress;
    }

    //Modifies: This
    //Effects: changes the given last name
    public void setLn(String ln) {
        this.ln = ln;
    }

    //Effects: returns the last name of the current Student
    public String getLn() {
        return this.ln;

    }


    //Modifies: This
    //Effects: changes the first name of the student
    public void setFn(String fn) {
        this.fn = fn;
    }

    //Effects: returns the first name of the current student
    public String getFn() {
        return this.fn;

    }


    //Modifies:This
    //Effects:If provided the correct lasPassword, it changes it to a new one, otherwise
    //it produces false
    public boolean changePassword(String currentPassword, String newPassword) {
        if (currentPassword.equals(this.password) && newPassword != "") {
            int index = listOfPassword.indexOf(currentPassword);
            this.password = newPassword;
            listOfPassword.set(index, newPassword);
            return true;
        }
        return false;
    }


    //Modifies:This
    //Effects: If the class is not null and the student does not have the class
    // it adds the clas to the given list of classes for the student. It puts a zero as initial grade and 0 as initial
    //absence
    public boolean addClass(AcademyClass s) {
        if (s != null && !hasClass(s.getName())) {
            listOfClasses.add(s);
            listOfGrades.add(0);
            listOfAbscences.add(0);
            numOfClasses++;
            return true;
        }
        return false;

    }




    //Effects: produces true if the student has the given class
    public boolean hasClass(String s) {
        for (AcademyClass c : listOfClasses) {
            if (c.getName().equals(s)) {
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

    //Requires: The list of id and list of password to have the same order
    //Effects: produces true if the id and password are the correct ones for the given student
    public static boolean checkLogin(int id, String password) {
        if (hasId(id)) {
            int index = listOfId.indexOf(id);
            if (password.equals(listOfPassword.get(index))) {
                return true;
            }
        }
        return false;
    }

    //Requires: the list of absences, and classes to be in the same order for the given student
    //Effects: increments the absences of the student in the given class, if the student
    //is not registered in the class then the number of absences does not change
    public boolean incrementAbsences(String s) {
        if (hasClass(s)) {
            int index = getIndexOfClass(s);
            int absences = listOfAbscences.get(index);
            listOfAbscences.set(index, absences + 1);
            return true;
        }
        return false;

    }

    //Requires: The list of absences and classes to be of the same size
    //Effects: Produces the number of absences a given student has in a class
    //if the student is not registered in the class then it produces -1
    public int checkAbsence(String s) {
        if (hasClass(s)) {
            int index = getIndexOfClass(s);
            return listOfAbscences.get(index);
        }
        return -1;
    }

    //Requires: The list of classes, absences, and grades to be in the same order and same size
    //Modifies:This
    //Effects: If the student is register for the class produces true and eliminates the class, otherwise produces
    //false.
    public boolean removeClass(String s) {
        if (hasClass(s)) {
            int index = getIndexOfClass(s);
            listOfAbscences.remove(index);
            listOfClasses.remove(index);
            listOfGrades.remove(index);
            numOfClasses--;
            return true;

        }
        return false;

    }

    //Effects: returns the number of classes of the given student
    public int getNumOfClasses() {
        return numOfClasses;
    }

    //Effects: if id is found produces true otherwise false
    public static boolean hasId(int id) {
        return listOfId.contains(id);
    }

    //Effects: Produces the index of  a given class in the list of classes, otherwise produces -1
    public int getIndexOfClass(String s) {
        for (AcademyClass c : listOfClasses) {
            if (c.getName().equals(s)) {
                int index = listOfClasses.indexOf(c);
                return index;
            }
        }
        return -1;

    }

    //Effects: Produces the array with all the classes, grades and absences for a given student.
    // If the student does not have any od those produces an empty array
    public Object[][] arrayGrades() {
        Object[][] arrayOfGrades = new  Object[numOfClasses + 1][3];
        arrayOfGrades[0][0] = "Class";
        arrayOfGrades[0][1] = "Grade";
        arrayOfGrades[0][2] = "Absences";
        int row = 1;
        for (AcademyClass a : listOfClasses) {
            arrayOfGrades[row][0] = a.getName();
            row = row + 1;
        }
        row = 1;
        for (double a :listOfGrades) {
            arrayOfGrades[row][1] = a;
            row = row + 1;

        }
        row = 1;
        for (int b: listOfAbscences) {
            arrayOfGrades[row][2] = b;
            row = row + 1;
        }


        return arrayOfGrades;
    }

    //Effects: produces the array with all the students
    public static Object[][] arrayAllStudents() {
        Object[][] resultArray = new Object[allStudents.size() + 1][4];
        resultArray[0][0] = "Id";
        resultArray[0][1] = "First Name";
        resultArray[0][2] = "Last Name";
        resultArray[0][3] = "Number Of Classes";
        int row = 1;
        for (Student s: allStudents) {
            resultArray[row][0] = s.getID();
            resultArray[row][1] = s.getFn();
            resultArray[row][2] = s.getLn();
            resultArray[row][3] = s.getNumOfClasses();
            row++;
        }
        return  resultArray;
    }




}
