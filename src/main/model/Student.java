/*
This class represents the student in the Academy, they have a first name, last name, a password and id to login.
They also have a list of classes, a list of grades and absences, which all teh things they should keep track of.
Apart from that the class in general has three static list which represents the ids, password and all the references
for the students */

package model;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student {

    private int id;
    private List<AcademyClass> listOfClasses = new ArrayList<>(); //classes;
    private List<Integer> allIDOfClasses = new ArrayList<>();
    private String fn;
    private String ln;
    private String password;
    private String address;
    private List<Integer> listOfGrades = new ArrayList<>();
    private List<Integer> listOfAbscences = new ArrayList<>();
    private int numOfClasses = 0;

    //Effects: Creates a student with a given id, first name, last name, and password,
    public Student(int id, String fn, String ln, String password) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.password = password;
        Event currentEvent = new Event("Student: " + fn + " " + ln + ",id: " + id + " created");
        EventLog currentLog = EventLog.getInstance();
        currentLog.logEvent(currentEvent);
    }

    //Effects: returns the id of the student
    public int getID() {
        return this.id;
    }

    //Modifies: This
    //Effects: changes the address of the given student
    public void setAddress(String s) {
        this.address = s;
        Event currentEvent = new Event("Student: " + fn + " " + ln + ",id: " + id
                + " set his address to " + s);
        EventLog currentLog = EventLog.getInstance();
        currentLog.logEvent(currentEvent);
    }

    //Effects: returns the address of the given student
    public String getAddress() {
        return this.address;
    }

    //Modifies: This
    //Effects: changes the given last name
    public void setLn(String ln) {
        this.ln = ln;
        Event currentEvent = new Event("Student: " + fn + " " + ln + ",id: " + id
                + " changed his last name");
        EventLog currentLog = EventLog.getInstance();
        currentLog.logEvent(currentEvent);
    }

    //Effects: returns the last name of the current Student
    public String getLn() {
        return this.ln;

    }

    //Modifies: This
    //Effects: changes the first name of the student
    public void setFn(String fn) {
        this.fn = fn;
        Event currentEvent = new Event("Student: " + fn + " " + ln + ",id: " + id
                + " changed his first name");
        EventLog currentLog = EventLog.getInstance();
        currentLog.logEvent(currentEvent);
    }

    //Effects: returns the first name of the current student
    public String getFn() {
        return this.fn;

    }

    //Effects: returns the current Password
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String s) {
        this.password = s;
        Event currentEvent = new Event("Student: " + fn + " " + ln + ",id: " + id + " changed his password");
        EventLog currentLog = EventLog.getInstance();
        currentLog.logEvent(currentEvent);
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
            Event currentEvent = new Event("Student: " + fn + " " + ln + ",id: " + id
                    + " added the class with id of " + s.getId());
            EventLog currentLog = EventLog.getInstance();
            currentLog.logEvent(currentEvent);
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
            AcademyClass currentClass = this.listOfClasses.get(index);
            listOfGrades.set(index, grade);
            Event currentEvent = new Event("Student: " + fn + " " + ln + ",id: " + id
                    + " has now a grade of " + grade + " in AcademyClass: " + currentClass.getName()
                    + ", id:" + currentClass.getId());
            EventLog currentLog = EventLog.getInstance();
            currentLog.logEvent(currentEvent);
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
            int idOfClass = listOfClasses.get(index).getId();
            listOfAbscences.remove(index);
            listOfClasses.remove(index);
            listOfGrades.remove(index);
            Event currentEvent = new Event("Student: " + fn + " " + ln + ",id: " + id
                    + "has dropped out class with id " + idOfClass);
            EventLog currentLog = EventLog.getInstance();
            currentLog.logEvent(currentEvent);
            numOfClasses--;
            return true;

        }
        return false;

    }

    //Effects: returns the number of classes of the given student
    public int getNumOfClasses() {
        return numOfClasses;
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
        Object[][] arrayOfGrades = new Object[numOfClasses + 1][4];
        arrayOfGrades[0][0] = "Class";
        arrayOfGrades[0][1] = "Grade";
        arrayOfGrades[0][2] = "Absences";
        arrayOfGrades[0][3] = "Id";
        int row = 1;
        for (AcademyClass a : listOfClasses) {
            arrayOfGrades[row][0] = a.getName();
            arrayOfGrades[row][3] = a.getId();
            row = row + 1;
        }
        row = 1;
        for (double a : listOfGrades) {
            arrayOfGrades[row][1] = a;
            row = row + 1;

        }
        row = 1;
        for (int b : listOfAbscences) {
            arrayOfGrades[row][2] = b;
            row = row + 1;
        }

        return arrayOfGrades;
    }

    //Effects: Sets the ids of classes
    public void setAllIDOfClasses(List<Integer> s) {
        this.allIDOfClasses = s;
    }

    //Modifies: This
    //Effects: returns the id of all teh classes
    public List<Integer> getAllIDOfClasses() {
        return allIDOfClasses;
    }


    //Effects: returns a List with all the id of the current Classes;
    private List<Integer> allClassesTransformToJason() {
        List<Integer> resultList = new ArrayList<>();
        for (AcademyClass a: listOfClasses) {
            resultList.add(a.getId());
        }
        return resultList;
    }

    //Effects: returns the jason objects based on the currentDataSystem
    public JSONObject toJson() {
        JSONObject currentStudent = new JSONObject();
        currentStudent.put("id",id);
        currentStudent.put("ListOfAllIdOfClasses",allClassesTransformToJason());
        currentStudent.put("fn",fn);
        currentStudent.put("ln",ln);
        currentStudent.put("password",password);
        currentStudent.put("address", address);
        currentStudent.put("listOfGrades",listOfGrades);
        currentStudent.put("listOfAbsences",listOfAbscences);
        currentStudent.put("numberOfClasses",numOfClasses);
        return currentStudent;

    }

    //Requires: Cna not be used to add a student normally apart from reading and writing a jeason file
    //Modifies: This
    //Effects: Creates a new student and adds it to the system
    public Student(int id,String fn,String ln, String password,List<Integer> lg, List<Integer> la) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.password = password;
        this.listOfGrades = lg;
        this.listOfAbscences = la;
    }

    //Effects: returns the list of grades of the current Students
    public List<Integer> getListOfGrades() {
        return Collections.unmodifiableList(listOfGrades);
    }

    //Effects: returns the list of absences
    public List<Integer> getListOfAbscences() {
        return Collections.unmodifiableList(listOfAbscences);
    }

    //Requires it is not the correct way to add a class during the ui, apart from teh jason files
    //Modifies: This
    //Effects: adds a class when reading and writting a jason Class
    public void addClasForReading(AcademyClass s) {
        listOfClasses.add(s);
        numOfClasses++;
    }

    //Effects: set the abscenes of a student for a given clas with the same name
    public void setAbscenceForAClass(int abscence, String name) {
        int index  = getIndexOfClass(name);
        AcademyClass curentClass = listOfClasses.get(index);
        Event currentEvent = new Event("Student: " + fn + " " + ln + ",id: " + id
                + "has now " + abscence + " absences for AcademyClass: " + curentClass.getName() + " ,id: "
                + curentClass.getId());
        EventLog currentLog = EventLog.getInstance();
        currentLog.logEvent(currentEvent);
        listOfAbscences.set(index, abscence);
    }

}
