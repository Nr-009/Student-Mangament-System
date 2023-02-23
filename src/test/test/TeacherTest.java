package test;



import model.AcademyClass;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    private Teacher eulogio;
    private Teacher mickelsen;
    private Teacher orjuela;
    private AcademyClass COMP110;
    private AcademyClass COMP121;
    private AcademyClass MATH100;
    private AcademyClass COMP210;

    @BeforeEach
    public void setUp() {
        eulogio = new Teacher("Eulogio", "Garcia", 809, "fisica11");
        mickelsen = new Teacher("mickelsen", "Macias", 90, "geometria8");
        orjuela = new Teacher("Edgar", "Orjuela", 800, "Matematicas");
        COMP110 = new AcademyClass(0,"COMP110", mickelsen, "2021W");
        COMP121 = new AcademyClass(1,"COMP121", mickelsen, "2021W");
    }

    @Test
    public void testConstructor() {
        Teacher ichikawa = new Teacher("Jhonathan", "Ichikawa", 90901123, "PHIL220");
        Teacher anothony = new Teacher("Anthony", "Christidis", 28928, "DSCI100");
        assertEquals("Jhonathan", ichikawa.getFn());
        assertEquals("Ichikawa", ichikawa.getLn());
        assertEquals("Anthony", anothony.getFn());
        assertEquals("Christidis", anothony.getLn());
        //Testing the setters for fn and ln
        ichikawa.setFn("EuologioElAncestral");
        assertEquals("EuologioElAncestral", ichikawa.getFn());
        ichikawa.setLn("BestPhysicsTeacher");
        assertEquals("BestPhysicsTeacher",ichikawa.getLn());
        //Testing for the id
        assertEquals(90901123,ichikawa.getId());
        assertEquals(28928,anothony.getId());
    }


    @Test
    public void testTeacherIsTeachingAndAddClass() {
        Teacher gyunay = new Teacher("Gyunay", "Kadirov", 1902829, "chess");
        AcademyClass DSCI200 = new AcademyClass(2,"DSCI200", null, "2022S");
        AcademyClass DSCI203 = new AcademyClass(3,"DSCI203", null, "2022S");
        //check for empty string
        assertFalse(gyunay.isTeacherTeaching(""));
        //tries to add null
        gyunay.addClass(null);
        assertEquals(0, gyunay.getNumClasses());
        //Adds a class
        assertEquals(0, gyunay.getNumClasses());
        gyunay.addClass(DSCI200);
        assertTrue(gyunay.isTeacherTeaching("DSCI200"));
        assertEquals(1, gyunay.getNumClasses());
        gyunay.addClass(DSCI203);
        assertTrue(gyunay.isTeacherTeaching("DSCI203"));
        assertEquals(2, gyunay.getNumClasses());
        //misspelled the name, produces false
        assertFalse(gyunay.isTeacherTeaching("DSCI202"));
        gyunay.addClass(DSCI203);
        assertEquals(2,gyunay.getNumClasses());
        gyunay.addClass(DSCI200);
        assertEquals(2, gyunay.getNumClasses());

    }

    @Test
    public void testRemoveClass() {
        mickelsen.addClass(COMP110);
        mickelsen.addClass(COMP121);
        assertTrue(mickelsen.isTeacherTeaching("COMP110"));
        assertTrue(mickelsen.isTeacherTeaching("COMP121"));
        assertEquals(2, mickelsen.getNumClasses());
        //tries to remove a clas that does not exit
        assertFalse(mickelsen.removeClass("PHIL220"));
        //tries to remove empty string
        assertFalse(mickelsen.removeClass(""));
        //successfully removes the first class
        assertTrue(mickelsen.removeClass("COMP110"));
        assertEquals(1, mickelsen.getNumClasses());
        assertFalse(mickelsen.isTeacherTeaching("COMP110"));
        //successfully removes the second class
        assertTrue(mickelsen.removeClass("COMP121"));
        assertEquals(0, mickelsen.getNumClasses());
        assertFalse(mickelsen.isTeacherTeaching("COMP121"));
    }

    @Test
    public void testIndexOfClass() {
        Teacher athena = new Teacher("Athena", "J", 1019920, "gyunay");
        AcademyClass web101 = new AcademyClass(6,"web101",null, "2022S");
        AcademyClass web102 = new AcademyClass(7,"web102", null, "2022S");
        athena.addClass(web101);
        athena.addClass(web102);
        //tries to search for a class that does not appear
        assertEquals(-1, athena.indexOfClass("PHIL220"));
        //tries to search for a class that does not appear in an teacher without classes
        assertEquals(-1, eulogio.indexOfClass("COMP121"));
        //searches and finds it on the first index
        assertEquals(0, athena.indexOfClass("web101"));
        //searches and finds it in the second index
        assertEquals(1,athena.indexOfClass("web102"));
    }

   @Test
    public void testingForArrayOfIds(){
        MATH100 = new AcademyClass(90,"Math100", null, "2020W");
        COMP210 = new AcademyClass(189,"COMP210", null, "2021W");
        Teacher andres = new Teacher("Andres", "R", 18172, "carros");
        //Test for a teacher with no classes
        Object[][] resultArray = andres.listOfClassesId();
        assertEquals("Class Name", resultArray[0][0]);
        assertEquals("Class Id",resultArray[0][1]);
        assertEquals("Number of Students",resultArray[0][2]);
        assertEquals("Average Grade",resultArray[0][3]);
        assertEquals("Session",resultArray[0][4]);
        assertEquals(1,resultArray.length);

        //Testing for a teacher with one class
        COMP210.setTeacher(andres);
        andres.addClass(COMP210);
        Object[][] resultArray2 = andres.listOfClassesId();
        assertEquals("COMP210",resultArray2[1][0]);
        assertEquals(COMP210.getId(),resultArray2[1][1]);
        assertEquals(COMP210.getNumOfStudents(),resultArray2[1][2]);
        assertEquals(COMP210.getAverageGrade(),resultArray2[1][3]);
        assertEquals(COMP210.getSession(),resultArray2[1][4]);
        assertEquals(2,resultArray2.length);

        //Testing for a teacher with more than one class
        MATH100.setTeacher(andres);
        andres.addClass(MATH100);
        Object[][] resultArray3 = andres.listOfClassesId();
        assertEquals("Math100",resultArray3[2][0]);
        assertEquals(MATH100.getId(),resultArray3[2][1]);
        assertEquals(MATH100.getNumOfStudents(),resultArray3[2][2]);
        assertEquals(MATH100.getAverageGrade(),resultArray3[2][3]);
        assertEquals(MATH100.getSession(),resultArray3[2][4]);
        assertEquals(3,resultArray3.length);

    }




}