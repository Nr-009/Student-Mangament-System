package model;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataSystem {
    private List<Student> listOfStudents;
    private List<Integer> listOfIdStudents;
    private List<String> listOfPasswordStudents;
    private int counterStudents = 0;
    private List<AcademyClass> listOfAllClasses;
    private List<Integer> listOfAllIdClasses;
    private int counterAcademyClasses = 0;
    private List<Teacher> listOfAllTeachers;
    private List<Integer> listOfAllIdTeacher;
    private List<String> listOfAllPasswordTeachers;
    private int counterTeacher = 0;


    //Effects: Creates a new DataSystem with empty list of Students, list of students id and empty list of passworld
    // of students
    public DataSystem() {
        listOfStudents = new ArrayList<>();
        listOfIdStudents = new ArrayList<>();
        listOfPasswordStudents = new ArrayList<>();
        listOfAllClasses = new ArrayList<>();
        listOfAllIdClasses = new ArrayList<>();
        listOfAllTeachers = new ArrayList<>();
        listOfAllIdTeacher = new ArrayList<>();
        listOfAllPasswordTeachers = new ArrayList<>();

    }

    //Section: Student Methods

    //Modifies: This
    //Effects: Creates a student and adds it to the Data system
    public int addStudent(String fn, String ln, String password) {
        Student currentStudent = new Student(counterStudents, fn, ln, password);
        this.listOfStudents.add(currentStudent);
        this.listOfIdStudents.add(counterStudents);
        this.listOfPasswordStudents.add(password);
        this.counterStudents++;
        return counterStudents - 1;

    }

    //Effects:If a valid id is provided produces the given student, null otherwise
    public Student getStudent(int id) {
        for (Student s : listOfStudents) {
            if (s.getID() == id) {
                return s;
            }
        }
        return null;
    }

    //Effects: if id is found produces true otherwise false
    public boolean hasIdStudent(int id) {
        return listOfIdStudents.contains(id);
    }

    //Requires: The list of idStudents and list of passwordStudents to have the same order
    public boolean checkLoginStudent(int id, String password) {
        if (hasIdStudent(id)) {
            int index = listOfIdStudents.indexOf(id);
            if (password.equals(listOfPasswordStudents.get(index))) {
                return true;
            }
        }
        return false;
    }

    //Effects: produces the array with all the students
    public Object[][] arrayAllStudents() {
        Object[][] resultArray = new Object[listOfStudents.size() + 1][4];
        resultArray[0][0] = "Id";
        resultArray[0][1] = "First Name";
        resultArray[0][2] = "Last Name";
        resultArray[0][3] = "Number Of Classes";
        int row = 1;
        for (Student s : listOfStudents) {
            resultArray[row][0] = s.getID();
            resultArray[row][1] = s.getFn();
            resultArray[row][2] = s.getLn();
            resultArray[row][3] = s.getNumOfClasses();
            row++;
        }
        return resultArray;
    }

    //Modifies:This
    //Effects:If provided the correct lasPassword, it changes it to a new one, otherwise
    //it produces false
    public boolean changePasswordStudent(int id, String currentPassword, String newPassword) {
        Student currentStudent = getStudent(id);
        if (currentPassword.equals(currentStudent.getPassword()) && newPassword != "") {
            int index = listOfIdStudents.indexOf(currentStudent.getID());
            listOfPasswordStudents.set(index, newPassword);
            currentStudent.setPassword(newPassword);
            return true;
        }
        return false;
    }

    //Section: AcademyClassMethods

    //Modifies: This
    //Effects: Creates a new AcademyClass and add it to the system
    public int addAcademyClass(String name, Teacher t, String session) {
        AcademyClass thisAcademyClass = new AcademyClass(counterAcademyClasses, name, t, session);
        listOfAllClasses.add(thisAcademyClass);
        listOfAllIdClasses.add(counterAcademyClasses);
        counterAcademyClasses++;
        return counterAcademyClasses - 1;
    }

    //Effects: returns the reference to teh academy class if the given id exits
    public AcademyClass getAcademyClass(int id) {
        for (AcademyClass a : listOfAllClasses) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    //Effects: returns true if the class with the given id exist
    public boolean hasIdOfAcademyClass(int id) {
        return listOfAllIdClasses.contains(id);
    }


    //Effects: if the class with the given id exist then it deletes it from the database,
    //otherwise returns false
    public boolean removeAcademyClass(int id) {
        if (!hasIdOfAcademyClass(id)) {
            return false;
        }
        AcademyClass currentClass = getAcademyClass(id);
        Teacher currentTeacher = currentClass.getTeacher();
        if (currentTeacher != null) {
            currentTeacher.removeClass(currentClass.getName());
        }

        for (Student s: currentClass.getStudents()) {
            s.removeClass(currentClass.getName());
        }
        int index = listOfAllIdClasses.indexOf(currentClass.getId());
        listOfAllIdClasses.remove(index);
        listOfAllClasses.remove(index);
        return true;


    }

    //Effects: Gives an array for all the classes with the number of students, teacher name, and average grade
    public Object[][] arrayAllClasses() {
        Object[][] arrayResult = new Object[listOfAllClasses.size() + 1][5];
        arrayResult[0][0] = "Class";
        arrayResult[0][1] = "Teacher";
        arrayResult[0][2] = "Average Grade";
        arrayResult[0][3] = "NumberOfStudents";
        arrayResult[0][4] = "Id of the Class";
        int row = 1;
        for (AcademyClass s : listOfAllClasses) {
            arrayResult[row][0] = s.getName();
            if (s.getTeacher() == null) {
                arrayResult[row][1] = "No teacher at the moment";
            } else {
                arrayResult[row][1] = s.getTeacher().getFn();
            }

            arrayResult[row][2] = s.getAverageGrade();
            arrayResult[row][3] = s.getNumOfStudents();
            arrayResult[row][4] = s.getId();
            row++;
        }
        return arrayResult;
    }


    //Section: Teachers Methods
    //Modifies: This
    //Effects: Creates a Teacher and adds it to the Data system
    public int addTeacher(String fn, String ln, String password) {
        Teacher newTeacher = new Teacher(fn, ln, counterTeacher, password);
        this.listOfAllTeachers.add(newTeacher);
        this.listOfAllIdTeacher.add(counterTeacher);
        this.listOfAllPasswordTeachers.add(password);
        this.counterTeacher++;
        return counterTeacher - 1;

    }

    //Effects: Produces the reference to the teacher given the id if the id does not exit
    //produces null
    public Teacher getTeacher(int id) {
        for (Teacher t: listOfAllTeachers) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    //Effects:Produces true if the id of teacher is on the system, otherwise false
    public boolean hasIDTeacher(int id) {
        return listOfAllIdTeacher.contains(id);
    }

    //Requires: The list of idStudents and list of passwordStudents to have the same order
    public boolean checkLoginTeacher(int id, String password) {
        if (hasIDTeacher(id)) {
            int index = listOfAllIdTeacher.indexOf(id);
            if (password.equals(listOfAllPasswordTeachers.get(index))) {
                return true;
            }
        }
        return false;
    }

    //Modifies:This
    //Effects: Produces true and modifies the password of the teacher if
    // his or her last password is correct and the new password is not empty
    // , otherwise produces false and does not change the password
    public boolean changePasswordTeacher(int id, String currentPassword, String newPassword) {
        Teacher currentTeacher = getTeacher(id);
        if (currentPassword.equals(currentTeacher.getPassword()) && newPassword != "") {
            int index = listOfAllIdTeacher.indexOf(currentTeacher.getId());
            listOfAllPasswordTeachers.set(index, newPassword);
            currentTeacher.setPassword(newPassword);
            return true;
        }
        return false;
    }

    //Modifies: This
    //Effects: if the id is valid it deletes the teacher and all the classes he was teaching set the teacher field to
    //null
    public boolean removeTeacher(int id) {
        if (!hasIDTeacher(id)) {
            return false;
        }
        Teacher currentTeacher = getTeacher(id);
        List<AcademyClass> currentClasses = currentTeacher.getAllClasses();
        if (!currentClasses.isEmpty()) {
            for (AcademyClass s : currentClasses) {
                s.setTeacher(null);
            }
        }
        int index = listOfAllIdTeacher.indexOf(id);
        listOfAllIdTeacher.remove(index);
        listOfAllTeachers.remove(index);
        listOfAllPasswordTeachers.remove(index);
        return true;
    }

    //Effects: produces the array of all the teachers currently in the system
    public Object[][] arrayAllTeachers() {
        Object[][] resultArray = new Object[listOfAllTeachers.size() + 1][4];
        resultArray[0][0] = "First Name";
        resultArray[0][1] = "Last Name";
        resultArray[0][2] = "Id";
        resultArray[0][3] = "NumberOfClasses";
        int row = 1;
        for (Teacher t :listOfAllTeachers) {
            resultArray[row][0] = t.getFn();
            resultArray[row][1] = t.getLn();
            resultArray[row][2] = t.getId();
            resultArray[row][3] = t.getAllClasses().size();
            row++;
        }
        return resultArray;
    }

    //Effects: Produces the correct jason object based on the current DataSystem
    public JSONObject toJson() {
        JSONObject currentDataSystem = new JSONObject();
        //students
        currentDataSystem.put("ListOfAllStudents",studentsToJson());

        JSONArray listOfIDStudents2 = new JSONArray(listOfIdStudents);
        currentDataSystem.put("ListOfIDStudents",listOfIDStudents2);

        JSONArray listOfPasswordStudents2 = new JSONArray(listOfPasswordStudents);
        currentDataSystem.put("listOfPasswordStudents",listOfPasswordStudents2);

        currentDataSystem.put("counterStudents",counterStudents);

        //Classes
        currentDataSystem.put("listOfAllClasses",classesToJson());

        JSONArray listOfAllIdClasses2 = new JSONArray(listOfAllIdClasses);
        currentDataSystem.put("listOfAllIdClasses",listOfAllIdClasses2);

        currentDataSystem.put("counterAcademyClasses",counterAcademyClasses);

        //Teachers
        currentDataSystem.put("listOfAllTeachers",teacherToJson());

        JSONArray listOfAllIdTeacher2 = new JSONArray(listOfAllIdTeacher);
        currentDataSystem.put("listOfAllIdTeacher",listOfAllIdTeacher2);

        JSONArray listOfAllPasswordTeachers2 = new JSONArray(listOfAllPasswordTeachers);
        currentDataSystem.put("listOfAllPasswordTeachers",listOfAllPasswordTeachers2);

        currentDataSystem.put("counterTeacher",counterTeacher);

        //return statements
        return currentDataSystem;
    }

    //Effects: Produce teh JSONArray of all the students in the system
    public JSONArray studentsToJson() {
        JSONArray resultArray = new JSONArray();
        for (Student s: listOfStudents) {
            resultArray.put(s.toJson());
        }
        return resultArray;
    }

    //Effects: Produces the JSONArray of all teachers in the system
    public JSONArray teacherToJson() {
        JSONArray resultArray = new JSONArray();
        for (Teacher t: listOfAllTeachers) {
            resultArray.put(t.toJson());
        }
        return resultArray;
    }

    //Effects: produces the JSONArray of all the currentClasses in the system
    public JSONArray classesToJson() {
        JSONArray resultArray = new JSONArray();
        for (AcademyClass a: listOfAllClasses) {
            resultArray.put(a.toJson());
        }
        return resultArray;
    }

    //Modifies: This
    //Effects: Creates a new DataSystem for when reading and writing JSONObject
    public DataSystem(List<Student> listOfStudents,
                      List<Integer> listOfIdStudents,
                      List<String> listOfPasswordStudents,
                      int counterStudents,
                      List<AcademyClass> listOfAllClasses,
                      List<Integer> listOfAllIdClasses,
                      int counterAcademyClasses,
                      List<Teacher> listOfAllTeachers,
                      List<Integer> listOfAllIdTeacher,
                      List<String> listOfAllPasswordTeachers,
                      int counterTeacher
                      ) {
        this.listOfStudents = listOfStudents;
        this.listOfIdStudents = listOfIdStudents;
        this.listOfPasswordStudents = listOfPasswordStudents;
        this.counterStudents = counterStudents;
        this.listOfAllClasses = listOfAllClasses;
        this.listOfAllIdClasses = listOfAllIdClasses;
        this.counterAcademyClasses = counterAcademyClasses;
        this.listOfAllTeachers = listOfAllTeachers;
        this.listOfAllIdTeacher = listOfAllIdTeacher;
        this.listOfAllPasswordTeachers = listOfAllPasswordTeachers;
        this.counterTeacher = counterTeacher;
    }





}
