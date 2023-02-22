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
    private static List<Teacher> allTeachers = new ArrayList<>();
    private static List<Integer> allId = new ArrayList<>();
    private static List<String> allPassworld = new ArrayList<>();
    private List<AcademyClass> allClasses = new ArrayList<>();
    private int numClasses;

    //Effects:If the id is not present,
    //Creates a teacher with a given fn, ln, id, and password, otherwise produces a teacher with
    //null values, and id of 626.
    public Teacher(String fn, String ln, int id, String password) {
        if (!allId.contains(id)) {
            this.fn = fn;
            this.ln = ln;
            this.id = id;
            this.password = password;
            allTeachers.add(this);
            allId.add(this.id);
            allPassworld.add(this.password);
            numClasses = 0;
        } else {
            this.id = 626;
        }
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
    //Modifies:This
    //Effects: Produces true and modifies the password of the teacher if
    // his or her last password is correct and the new password is not empty
    // , otherwise produces false and does not change the password

    public boolean setPassword(String lastP, String newP) {
        if (password.equals(lastP) && newP != "") {
            this.password = newP;
            int index = allPassworld.indexOf(lastP);
            allPassworld.set(index, newP);
            return true;
        } else {
            return false;
        }
    }

    //Effects: Produces true if the given id matches the correct password, otherwise false
    public static boolean checkLogin(int id, String password) {
        if (allId.contains(id)) {
            int index = allId.indexOf(id);
            return allPassworld.get(index).equals(password);
        } else {
            return false;
        }

    }

    //Effects:Produces true if the id of teacher is on the system, otherwise false
    public static boolean containsTeacher(int id) {
        return allId.contains(id);

    }

    //Effects: Produces the reference to the teacher given the id if the id does not exit
    //produces null
    public static Teacher returnsTeacher(int id) {
        if (allId.contains(id)) {
            int index = allId.indexOf(id);
            Teacher newTeacher = allTeachers.get(index);
            return newTeacher;
        } else {
            return null;
        }


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

    //Modifies: This
    //Effects: if the id is valid it deletes the teacher and all the classes he was teaching set the teacher field to
    //null
    public static boolean  removeTeacher(int id) {
        if (!Teacher.containsTeacher(id)) {
            return false;
        }
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        List<AcademyClass> currentClasses = currentTeacher.allClasses;
        if (!currentClasses.isEmpty()) {
            for (AcademyClass s : currentClasses) {
                s.setTeacher(null);
            }
        }
        int indexOfTeacher = allId.indexOf(id);
        allId.remove(indexOfTeacher);
        allPassworld.remove(indexOfTeacher);
        allTeachers.remove(indexOfTeacher);
        return true;
    }

    public static Object[][] displayAllTeachers() {
        int size = allTeachers.size() + 1;
        Object[][] resultArray = new Object[size][4];
        resultArray[0][0] = "First Name";
        resultArray[0][1] = "Last Name";
        resultArray[0][2] = "Id";
        resultArray[0][3] = "NumberOfClasses";
        int row = 1;
        for (Teacher t :allTeachers) {
            resultArray[row][0] = t.getFn();
            resultArray[row][1] = t.getLn();
            resultArray[row][2] = t.getId();
            resultArray[row][3] = t.allClasses.size();
            row++;
        }

        return resultArray;
    }

    //Todo: debug the shit out of the new options










}
