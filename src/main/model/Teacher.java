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
    //null values
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
        }
    }

    public void setfn(String fn) {
        this.fn = fn;

    }

    public String getFn() {
        return fn;

    }

    public void setLn(String ln) {
        this.ln = ln;

    }

    public String getLn() {
        return ln;

    }
    //Modifies:This
    //Effects: Produces true and modifies the password of the teacher if
    // his or her last password is correct and the new passworld is not empty
    // , otherwise produces false

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

    //Effects: Produces true if the given id matches the correct passworld, otherwise false

    public static boolean checkLogin(int id, String password) {
        if (allId.contains(id)) {
            int index = allId.indexOf(id);
            return allPassworld.get(index) == password;
        } else {
            return false;
        }

    }
    //Effects:Produces true if the id of teacher is on the system, otherwise false

    public static boolean containsTeacher(int id) {
        return allId.contains(id);

    }
    //Requires: Id to be in the system
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
            if (each.getName() == s) {
                return true;
            }
        }
        return false;
    }

    //Effects: if the class is not there and the class has the same teacher
    // adds it to the classes the teacher is teaching
    public void addClass(AcademyClass s) {
        if (!allClasses.contains(s)) {
            if (s != null) {
                if (s.getTeacher() == this) {
                    allClasses.add(s);
                    numClasses++;
                }
            }
        }
    }

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
                if (c.getName() == s) {
                    return allClasses.indexOf(c);
                }
            }
        } else {
            return -1;
        }
        return -1;
    }


}
