/* A class represent a teacher with given id, first name, last name, and password. The teacher also has a field to
represents all the classes it has. The class three static field where all the id, password and teachers are stored
 */


package model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int id;
    private String fn;
    private String ln;
    private String password;
    private List<AcademyClass> allClasses = new ArrayList<>();
    private int numClasses;

    //Effects:If the id is not present,
    //Creates a teacher with a given fn, ln, id, and password, otherwise produces a teacher with
    //null values, and id of 626.
    public Teacher(String fn, String ln, int id, String password) {
        this.fn = fn;
        this.ln = ln;
        this.id = id;
        this.password = password;
        numClasses = 0;

    }

    //Modifies: This
    //Effects: changes the last name of the current Teacher
    public void setFn(String fn) {
        this.fn = fn;

    }

    //Effects: returns the first name of the given teacher
    public String getFn() {
        return fn;

    }

    //Modifies: This
    //Effects: sets the last name for the given Teacher
    public void setLn(String ln) {
        this.ln = ln;

    }

    //Effects: returns the last name of the current Teacher
    public String getLn() {
        return ln;

    }

    //Effects: returns the given id of the teacher
    public int getId() {
        return id;
    }


    //Effects: returns teh current password
    public String getPassword() {
        return password;
    }


    //Modifies: This
    //Effects: Changes the current Password for the teacher
    public boolean setPassword(String newP) {
        this.password = newP;
        return true;
    }


    //Effects: Produces true if the teacher is teaching the class otherwise false
    public boolean isTeacherTeaching(String s) {
        for (AcademyClass each : allClasses) {
            if (each.getName().equals(s)) {
                return true;
            }
        }
        return false;
    }

    //Effects: if the class is not there and the class
    // adds it to the classes the teacher is teaching
    public void addClass(AcademyClass s) {
        if (!allClasses.contains(s)) {
            if (s != null) {
                allClasses.add(s);
                numClasses++;
            }
        }
    }

    //Effects: returns the number of classes the teacher has
    public int getNumClasses() {
        return numClasses;
    }

    //Effects: if the teacher teaches the class removes it as produces true, otherwise false
    public boolean removeClass(String s) {
        if (isTeacherTeaching(s)) {
            int index = indexOfClass(s);
            allClasses.remove(index);
            numClasses--;
            return true;
        } else {
            return false;
        }
    }

    //Effects: produces the index of the class if found, otherwise -1
    public int indexOfClass(String s) {
        if (isTeacherTeaching(s)) {
            for (AcademyClass c : allClasses) {
                if (c.getName().equals(s)) {
                    return allClasses.indexOf(c);
                }
            }
        } else {
            return -1;
        }
        return -1;
    }

    //Effects: produces the array with all the classes and the id of the class for a given teacher
    public Object[][] listOfClassesId() {
        Object[][] arrayClasses = new Object[numClasses + 1][5];
        arrayClasses[0][0] = "Class Name";
        arrayClasses[0][1] = "Class Id";
        arrayClasses[0][2] = "Number of Students";
        arrayClasses[0][3] = "Average Grade";
        arrayClasses[0][4] = "Session";
        int row = 1;
        for (AcademyClass c : allClasses) {
            arrayClasses[row][0] = c.getName();
            arrayClasses[row][1] = c.getId();
            arrayClasses[row][2] = c.getNumOfStudents();
            arrayClasses[row][3] = c.getAverageGrade();
            arrayClasses[row][4] = c.getSession();
            row = row + 1;
        }
        return arrayClasses;
    }

    public List<AcademyClass> getAllClasses() {
        return allClasses;
    }


    //Todo: Change the whole test suite for the Students
    //Todo: Change the whole test suite for the Teachers
    //Todo: Change teh whole test suite for the AcademyClass
    //Todo: Create a test suite for the Data System
    //Todo: Change the whole Ui



}
