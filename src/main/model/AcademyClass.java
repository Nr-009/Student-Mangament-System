package model;

import java.util.ArrayList;
import java.util.List;

public class AcademyClass {
    private String name;
    private int id;//TODO
    private static int counter = 0; //TODO
    public static List<AcademyClass> allclasses = new ArrayList<>(); //TODO
    public static List<Integer> allIds = new ArrayList<>();
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private String sesion;
    private int numOfStudents;

    //Constructs a class with a given name teacher and sesion.
    // It initializes the list of Students as empty
    public AcademyClass(String name, Teacher t, String sesion) {
        this.name = name;
        this.teacher = t;
        this.id = counter;
        this.sesion = sesion;
        counter++;
        allclasses.add(this);
        allIds.add(this.id);
    }


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
        return total / numOfStudents;
    }
    //Efects: returns the current id

    public int getId() {
        return this.id;
    }


    //Modifies: This
    //Effects: If teacher is not null changes the teacher, also adds the reference to the teacher class
    public boolean setTeacher(Teacher t) {
        if (t != null) {
            this.teacher = t;
            teacher.addClass(this);
            return true;
        } else {
            return false;
        }

    }

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
        for (Student s : students) {
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

    public Object[][] gradesforClass() {
        Object[][] myArray = new Object[numOfStudents + 1][2];
        myArray[0][0] = "Students";
        myArray[0][1] = "Grade";
        int row = 1;
        for (Student s: students) {
            myArray[row][0] = s.getID();
            row = row + 1;
        }
        row = 1;
        for (Student s: students) {
            myArray[row][1] = s.gradeInClass(this.name);
            row = row + 1;
        }

        return myArray;
    }


    //Effects: Gives an array for all the classes with the number of students, teacher name, and average grade
    public static  Object[][] informationDisplay() {
        Object[][] arrayResult = new Object[counter + 1][5];
        arrayResult[0][0] = "Class";
        arrayResult[0][1] = "Teacher";
        arrayResult[0][2] = "Average Grade";
        arrayResult[0][3] = "NumberOfStudents";
        arrayResult[0][4] = "Id of the Class";
        int row = 1;
        for (AcademyClass s : allclasses) {
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

    //Effects: Produces the class if found otherwise null;
    public static AcademyClass findClass(int id) {
        if (id >= counter || id < 0) {
            return null;
        } else {
            return allclasses.get(id);
        }
    }

    public static boolean doesThisClassExist(int id) {
        return allIds.contains(id);
    }





}
