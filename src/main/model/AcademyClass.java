/* AcademyClass represent each class offer by the Academy, it has a name, id, a teacher, a list of students,
a number of students and a session where you can register. The class has three static fields, a counter that assigns
the id to avoid repetition, a list of all the classes and a list of all ids
 */


package model;

import java.util.ArrayList;
import java.util.List;

public class AcademyClass {
    private String name;
    private int id;
    private static int counter = 0;
    private static List<AcademyClass> allClasses = new ArrayList<>();
    private static List<Integer> allIds = new ArrayList<>();
    private Teacher teacher;
    private List<Student> students = new ArrayList<>();
    private String sesion;
    private int numOfStudents;

    //Effects: Constructs a class with a given name teacher and session. It initializes the list of Students as empty
    public AcademyClass(String name, Teacher t, String session) {
        this.name = name;
        this.teacher = t;
        if (t != null) {
            t.addClass(this);
        }
        this.id = counter;
        this.sesion = session;
        counter++;
        allClasses.add(this);
        allIds.add(this.id);
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
        return total / numOfStudents;
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


    //Effects: Gives an array for all the classes with the number of students, teacher name, and average grade
    public static  Object[][] informationDisplay() {
        Object[][] arrayResult = new Object[allClasses.size() + 1][5];
        arrayResult[0][0] = "Class";
        arrayResult[0][1] = "Teacher";
        arrayResult[0][2] = "Average Grade";
        arrayResult[0][3] = "NumberOfStudents";
        arrayResult[0][4] = "Id of the Class";
        int row = 1;
        for (AcademyClass s : allClasses) {
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
        if (id < counter && id >= 0) {
            for (AcademyClass s : allClasses) {
                if (s.getId() == id) {
                    return s;
                }
            }

        }
        return null;
    }


    //Effects: returns true if the class with the given id exist
    public static boolean doesThisClassExist(int id) {
        return allIds.contains(id);
    }


    //Effects: if the class with the given id exist then it deletes it from the database,
    //otherwise returns false
    public static boolean removeClass(int id) {
        if (!doesThisClassExist(id)) {
            return false;
        }
        AcademyClass currentClass = AcademyClass.findClass(id);
        Teacher currentTeacher = currentClass.getTeacher();
        if (currentTeacher != null) {
            currentTeacher.removeClass(currentClass.getName());
        }
        for (Student s: currentClass.students) {
            s.removeClass(currentClass.getName());
        }
        int index = allClasses.indexOf(currentClass);
        allIds.remove(index);
        allClasses.remove(currentClass);
        return true;

    }




}
