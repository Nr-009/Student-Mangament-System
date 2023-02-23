package test;

import model.AcademyClass;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student nicolas;
    private Student gyunay;
    private Student carlitos;
    private AcademyClass phil220;
    private AcademyClass dsci100;
    private Teacher eulogio;

    @BeforeEach
    public void setUp(){
        nicolas= new Student(1701, "Nicolas", "Rubiano", "lol");
        gyunay= new Student(2509, "Gyunay", "Kadirov", "turkey");
        carlitos= new Student(2909, "Carlos", "Garcia", "pokemon");
        eulogio= new Teacher("Eulogio", "Garcia", 190, "fisica11");
        phil220= new AcademyClass(0,"PHIL220", eulogio, "2020W");
        dsci100= new AcademyClass(1,"DSCI100", null, "2021W");
    }

    @Test
    public void testConstructor() {
        Student angel = new Student(909089, "angel", "Quiroga", "noanime");
        Student gabo = new Student(7854356, "Samuel", "Abuchaive", "babucha");
        //Checking the constructor works
        assertEquals(909089, angel.getID());
        assertEquals("angel",angel.getFn());
        assertEquals("Quiroga",angel.getLn());
        assertEquals(0, angel.getNumOfClasses());
        //Checking the basic setters and getters
        gabo.setFn("Jose");
       gabo.setLn("Mendieta");
        assertEquals("Jose",gabo.getFn());
        assertEquals("Mendieta",gabo.getLn());
        assertEquals(7854356,gabo.getID());
    }

    @Test
    public void testSetAndGetPassword() {
        assertEquals("lol",nicolas.getPassword());
        nicolas.setPassword("colombia");
        assertEquals("colombia",nicolas.getPassword());
    }



   @Test
    public void testHasClass(){
        //Tries to add the clas but the class is null
        assertFalse(nicolas.addClass(null));
        assertEquals(nicolas.getNumOfClasses(), 0);
        //does not have classes produces false
        assertFalse(nicolas.hasClass("PHYS107"));
        //has one class but it is not teh correct one
        nicolas.addClass(phil220);
        assertFalse(nicolas.hasClass("MATH220"));
        //has one class but misspells the name
        assertFalse(nicolas.hasClass("PJIL220"));
        //has the class and is the correct name
        assertTrue(nicolas.hasClass("PHIL220"));
        // has the class but is later on the list
        nicolas.addClass(dsci100);
        nicolas.addClass(dsci100);
        assertTrue(nicolas.hasClass("DSCI100"));
        //does not have the class and teh list is long
        assertFalse(nicolas.hasClass("ENGL150"));
    }

    @Test
   public void testForSetGrade() {
        //the class does not exist and the grade is less than zero
        assertEquals(0, nicolas.getNumOfClasses());
        assertFalse(nicolas.setGradeForClass("MATH100", -11));
        //the class exist but the grade is less than zero
        nicolas.addClass(phil220);
        assertFalse(nicolas.setGradeForClass("PHIL220",-1));
        //the class exit and the grade is zero
        assertTrue(nicolas.setGradeForClass("PHIL220", 0));
        assertEquals(0, nicolas.gradeInClass("PHIL220"));
        //the class exit and the grade is one
        assertTrue(nicolas.setGradeForClass("PHIL220", 1));
        assertEquals(1,nicolas.gradeInClass("PHIL220"));
        //the class exit and grade is greater than
        assertTrue(nicolas.setGradeForClass("PHIL220", 12));
        assertEquals(12,nicolas.gradeInClass("PHIL220"));
    }

    @Test
    public void testForSetGradeUpperBoundary(){
        //the class exists but is at the end of the list
        assertEquals( 0, nicolas.getNumOfClasses());
        nicolas.addClass(dsci100);
        nicolas.addClass(dsci100);
        assertTrue(nicolas.setGradeForClass("DSCI100", 11));
        assertEquals(11, nicolas.gradeInClass("DSCI100"));
        //The class exist and the grade is 99
        assertTrue(nicolas.setGradeForClass("DSCI100", 99));
        assertEquals(99, nicolas.gradeInClass("DSCI100"));
        //The class exist and the grade is 100
        assertTrue(nicolas.setGradeForClass("DSCI100", 100));
        assertEquals(100, nicolas.gradeInClass("DSCI100"));
        //The class exits but the grades is greater than 100;
        assertFalse(nicolas.setGradeForClass("DSCI100", 101));
        assertEquals(100, nicolas.gradeInClass("DSCI100"));
        //The class exist but the garde is far more than 100
        assertFalse(nicolas.setGradeForClass( "DSCI100", 1111));
        assertEquals(100,nicolas.gradeInClass("DSCI100"));
    }

    @Test
    public void testForGradeInClass(){
        //the student is not register for any class
        assertEquals(-1, nicolas.gradeInClass("CPSC210"));
        //the student is register for one class but is not the one correct
        nicolas.addClass(phil220);
        assertEquals(-1,nicolas.gradeInClass("CPSC313"));
        //the student is register for the class and is the correct one
        nicolas.setGradeForClass("PHIL220", 90);
        assertEquals(90, nicolas.gradeInClass("PHIL220"));
        //The student is register for the class but is not the first class
        nicolas.addClass(dsci100);
        nicolas.setGradeForClass("DSCI100",76);
        assertEquals(76, nicolas.gradeInClass("DSCI100"));
        //the student is not register for the class and is the las one.
       nicolas.addClass(phil220);
        assertEquals(-1,nicolas.gradeInClass("MATH302"));
    }

    @Test
    public void testIncrementAbsences(){
        nicolas.addClass(phil220);
        nicolas.addClass(dsci100);
        //the student is not register in the subject
        assertFalse(nicolas.incrementAbsences("PHIL222"));
        assertEquals(0, nicolas.checkAbsence("PHIL220"));
        //the student is register on the class
        assertTrue(nicolas.incrementAbsences("PHIL220"));
        assertEquals(1, nicolas.checkAbsence("PHIL220"));
        carlitos.addClass(dsci100);
        carlitos.incrementAbsences("DSCI100");
        carlitos.incrementAbsences("DSCI100");
        assertEquals(2, carlitos.checkAbsence("DSCI100"));
    }

    @Test
    public void testNumberOfClasses(){
        assertEquals(0, nicolas.getNumOfClasses());
        nicolas.addClass(dsci100);
        assertEquals(1, nicolas.getNumOfClasses());
        nicolas.addClass(dsci100);
        assertEquals(1, nicolas.getNumOfClasses());
        nicolas.addClass(phil220);
        assertEquals(2, nicolas.getNumOfClasses());
    }

    public void setUpForRemoveClass(){
        nicolas.addClass(phil220);
        nicolas.setGradeForClass("PHIL220", 90);
        nicolas.incrementAbsences("PHIL220");
        phil220.addStudent(nicolas);
        nicolas.addClass(dsci100);
        nicolas.setGradeForClass("DSCI100", 45);
        nicolas.incrementAbsences("DSCI100");
        nicolas.incrementAbsences("DSCI100");
        dsci100.addStudent(nicolas);
    }

    @Test
    public void removeClass(){
        setUpForRemoveClass();
        //tries to remove a class that does not belong to the student
        assertFalse(nicolas.removeClass("JAPN100"));
        //Removes Successfully the first Class from the student view
        assertTrue(nicolas.removeClass("PHIL220"));
        assertTrue(phil220.deleteStudent(nicolas.getID()));
        assertFalse(phil220.hasStudent(nicolas.getID()));
        assertEquals(1, nicolas.getNumOfClasses());
        assertTrue(nicolas.hasClass("DSCI100"));
        assertEquals(45, nicolas.gradeInClass("DSCI100"));
        assertEquals(2, nicolas.checkAbsence("DSCI100"));
        //Successfully removes the second class
        assertTrue(nicolas.removeClass("DSCI100"));
        assertTrue(dsci100.deleteStudent(nicolas.getID()));
        assertFalse(dsci100.hasStudent(nicolas.getID()));
        assertEquals(0, nicolas.getNumOfClasses());
    }

    @Test
    public void testForSettingAndGettingAddress() {
        nicolas.setAddress("1701 burnaby st");
        assertEquals("1701 burnaby st", nicolas.getAddress());
        gyunay.setAddress("cr 57 #119a-60");
        assertEquals("cr 57 #119a-60", gyunay.getAddress());
    }



    @Test
    public void testGetIndexOfClass() {
        //Tries to find in an empty list for a class
        assertEquals(-1,nicolas.getIndexOfClass("PHIL220"));
        //tries to find for the empty string
        assertEquals(-1, nicolas.getIndexOfClass(""));
        //tries to find and finds it on the first index, in a list with size 1
        nicolas.addClass(phil220);
        assertEquals(0, nicolas.getIndexOfClass("PHIL220"));
        //find the class and is on the end of the list
        nicolas.addClass(dsci100);
        assertEquals(1, nicolas.getIndexOfClass("DSCI100"));
        //does not find it
        assertEquals(-1, nicolas.getIndexOfClass("MATH302"));
    }

    @Test
    public void testArrayForClasses() {
        Student michael= new Student(9082, "Michael", "Jackson", "Beatit");
        //TestForAnEmptyArray
        Object[][] resulArray= michael.arrayGrades();
        assertTrue( resulArray[0][0].equals("Class"));
        assertTrue(resulArray[0][1].equals("Grade"));
        assertTrue(resulArray[0][2].equals("Absences"));
    }

    @Test
    public void testForClassesOtherCases() {
        Student michael= new Student(9083, "Michael", "Jackson", "Beatit");
        michael.addClass(phil220);
        michael.setGradeForClass("PHIL220", 77);
        //testForOneClass:
        Object[][] resultArray= michael.arrayGrades();
        int x = 90;
        assertEquals("PHIL220", resultArray[1][0]);
        assertEquals(77.0, resultArray[1][1]);
        assertEquals(0, resultArray[1][2]);
        assertEquals(2, resultArray.length);
        //Test for more than one class
        michael.addClass(dsci100);
        michael.setGradeForClass("DSCI100", 34);
        michael.incrementAbsences("DSCI100");
        michael.incrementAbsences("DSCI100");
        michael.incrementAbsences("DSCI100");
        Object[][] resultArray2= michael.arrayGrades();
        assertEquals("DSCI100", resultArray2[2][0]);
        assertEquals(34.0, resultArray2[2][1]);
        assertEquals(3,resultArray2[2][2]);
        assertEquals(3,resultArray2.length);


    }
}
