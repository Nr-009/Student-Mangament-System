/* AcademyClass represent each class offer by the Academy, it has a name, id, a teacher, a list of students,
a number of students and a session where you can register. The class has three static fields, a counter that assigns
the id to avoid repetition, a list of all the classes and a list of all ids
 */


package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class AcademyClass {
    private String name;
    private int id;
    private Teacher teacher;
    private int idOfTeacher;
    private List<Student> students = new ArrayList<>();
    private List<Integer> allIdStudent = new ArrayList<>();
    private String sesion;
    private int numOfStudents;


    //Effects: Constructs a class with a given name teacher and session. It initializes the list of Students as empty
    public AcademyClass(int id,String name, Teacher t, String session) {
        this.id = id;
        this.name = name;
        this.teacher = t;
        this.sesion = session;
    }

    //Effects: returns the current name
    public String getName() {
        return name;
    }


    //Effects: Produces the average grade of a class based on the students present
    public double getAverageGrade() {
        if (numOfStudents == 0) {
            return 0;
        }
        int total = 0;
        for (Student s : students) {
            total = total + (int) s.gradeInClass(this.name);
        }
        return (double)total / (double)numOfStudents;
    }

    //Effects: returns the current id
    public int getId() {
        return this.id;
    }


    //Modifies: This
    //Effects: Sets the teacher for the given class
    public boolean setTeacher(Teacher t) {
        if (t == null) {
            this.teacher = null;
        } else {
            this.teacher = t;
            return true;
        }
        return true;
    }

    //Effects: returns the teacher of teh given class
    public Teacher getTeacher() {
        return teacher;
    }

    //Effects: Produces true if the class has a student with the given id, otherwise false
    public boolean hasStudent(int id) {
        for (Student i : students) {
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

    //Effects:Sets the grade for a given student, if the student is not on the system, or the grade is
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

    //Effects: returns the session of the given class
    public void setSession(String s) {
        this.sesion = s;

    }

    //Effects: returns the given session
    public String getSession() {
        return sesion;
    }


    //Effects:If the student is not null and the id is not inside it adds the given student
    public boolean addStudent(Student s) {
        if (s != null && !hasStudent(s.getID())) {
            students.add(s);
            numOfStudents++;
            return true;
        }
        return false;

    }

    //Effects: returns the given number of students
    public int getNumOfStudents() {
        return numOfStudents;

    }

    //Effects: Gives the index of the student if found on the database otherwise produces -1
    public int getIndexStudent(int id) {
        for (Student s : students) {
            if (s.getID() == id) {
                return students.indexOf(s);
            }
        }
        return -1;
    }

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

    //Effects: Prints the array of all the student with their given first name, last name, id and grade
    public Object[][] gradesForClass() {
        Object[][] myArray = new Object[numOfStudents + 1][3];
        myArray[0][0] = "Id";
        myArray[0][1] = "Name";
        myArray[0][2] = "Grade";
        int row = 1;
        for (Student s: students) {
            myArray[row][0] = s.getID();
            myArray[row][1] = s.getFn() + " " + s.getLn();
            row = row + 1;
        }
        row = 1;
        for (Student s: students) {
            myArray[row][2] = s.gradeInClass(this.name);
            row = row + 1;
        }

        return myArray;
    }


    //Effects: return a list of students with all the Ids of the student used for ToJSON method
    private List<Integer> allStudentsTransformToJson() {
        List<Integer> resultList =  new ArrayList<>();
        for (Student  s: students) {
            resultList.add(s.getID());
        }
        return resultList;
    }

    //Effects: returns the list of all students
    public List<Student> getStudents() {
        return this.students;
    }

    //Effects:Returns the the current Student as a jason Object
    public JSONObject toJson() {
        JSONObject currentAcademyClass = new JSONObject();
        currentAcademyClass.put("name",name);
        currentAcademyClass.put("id",id);
        int idOfTeacher = -2;
        if (teacher != null) {
            idOfTeacher = teacher.getId();
        } else {
            idOfTeacher = -1;
        }
        currentAcademyClass.put("IdTeacher",idOfTeacher);
        JSONArray allStudent =  new JSONArray(allStudentsTransformToJson());
        currentAcademyClass.put("IdsOfAllStudents",allStudent);
        currentAcademyClass.put("session",sesion);
        currentAcademyClass.put("numOfStudents",numOfStudents);
        return currentAcademyClass;

    }

    //Todo: test this method
    //Modifies: This
    //Effects: Sets all the Id Students
    public void setAllIdStudent(List<Integer> s) {
        this.allIdStudent = s;
    }

    //Todo: test this method
    //Effects: returns the list of all the id of students
    public List<Integer> getAllIdStudent() {
        return this.allIdStudent;
    }

    //Modifies: This
    // Effects: sets the id of the teacher
    public void setIdOfTeacher(int idOfTeacher) {
        this.idOfTeacher = idOfTeacher;
    }

    //Effects: sets the id of the teacher
    public int getIdOfTeacher() {
        return idOfTeacher;
    }
}
