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
    private Teacher nicolas;
    private AcademyClass MATH100;
    private AcademyClass COMP110;
    private AcademyClass COMP121;
    private AcademyClass COMP210;

    @BeforeEach
    public void setUp() {
        eulogio = new Teacher("Eulogio", "Garcia", 809, "fisica11");
        mickelsen = new Teacher("mickelsen", "Macias", 90, "geometria8");
        orjuela = new Teacher("Edgar", "Orjuela", 800, "Matematicas");

        COMP110 = new AcademyClass("COMP110", mickelsen, "2021W");
        COMP121 = new AcademyClass("COMP121", mickelsen, "2021W");


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
        //Testing for when somebody wants to create a user with an id alreayd created
        nicolas = new Teacher("Nicolas", "Rubiano", 800, "anime");
        assertNotEquals("Nicolas", nicolas.getFn());
        assertNotEquals("Rubiano", nicolas.getLn());
    }

    @Test
    public void testForSetPassword() {
        Teacher angela = new Teacher("Angela", "Sarmiento", 9092, "CAA");
        Teacher tolosa = new Teacher("Fisica", "Tolosa", 7817, "fisica");
        //puts the incorrect last password
        assertFalse(angela.setPassword("mol", "fisica12"));
        //puts the empty string as the password
        assertFalse(angela.setPassword("CAA", ""));
        //correctly changes the password
        assertTrue(angela.setPassword("CAA", "fisica12"));
        assertTrue(tolosa.setPassword("fisica", "geometria9"));
        assertTrue(Teacher.checkLogin(9092, "fisica12"));
        assertTrue(Teacher.checkLogin(7817, "geometria9"));
    }

    @Test
    public void checkLogin() {
        setUp();
        assertFalse(Teacher.checkLogin(9090, "nicolas"));
        assertFalse(Teacher.checkLogin(809, "fisica"));
        assertTrue(Teacher.checkLogin(809, "fisica11"));

    }

    @Test
    public void testContainsTeacher() {
        setUp();
        //searches for teachers that do exists
        assertTrue(Teacher.containsTeacher(809));
        assertTrue(Teacher.containsTeacher(90));
        assertTrue(Teacher.containsTeacher(800));
        //searches for teachers that do not exist
        assertFalse(Teacher.containsTeacher(01));
        assertFalse(Teacher.containsTeacher(1701));
    }

    @Test
    public void testReturnTeacher() {
        //Getting teachers based on valid ids
        Teacher Euologio2;
        Euologio2 = Teacher.returnsTeacher(809);
        assertEquals(eulogio, Euologio2);
        Teacher Mickelsen2;
        Mickelsen2 = Teacher.returnsTeacher(90);
        assertEquals(mickelsen, Mickelsen2);
        assertNotEquals(orjuela, Mickelsen2);
        //Getting null based on and not existing id
        Teacher Nicolas;
        Nicolas = Teacher.returnsTeacher(110);
        assertEquals(null, Nicolas);
    }

    @Test
    public void testTeacherIsTeachingAndAddClass() {
        Teacher gyunay = new Teacher("Gyunay", "Kadirov", 1902829, "chess");
        AcademyClass DSCI200 = new AcademyClass("DSCI200", null, "2022S");
        AcademyClass DSCI203 = new AcademyClass("DSCI203", null, "2022S");
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
        AcademyClass web101 = new AcademyClass("web101",null, "2022S");
        AcademyClass web102 = new AcademyClass("web102", null, "2022S");
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
        MATH100 = new AcademyClass("Math100", null, "2020W");
        COMP210 = new AcademyClass("COMP210", null, "2021W");
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

    @Test
    public void testRemoveTeachers() {
        //fails to delete a teacher in a small list
        assertFalse(Teacher.removeTeacher(190190));
        //safely deletes from the front of the list
        Teacher prof1 = new Teacher("Jadwiga", "R", 190190, "COMP132");
        AcademyClass math126 = new AcademyClass("MATH126", prof1, "2020W");
        math126.setTeacher(prof1);
        assertTrue(Teacher.containsTeacher(prof1.getId()));
        assertTrue(Teacher.removeTeacher(prof1.getId()));
        assertFalse(Teacher.containsTeacher(190190));
        //check the classes assign to the teacher are not null
        assertNull(math126.getTeacher());
        //safely deletes from the back of the list
        Teacher dan = new Teacher("Dan", "Bergrud", 1901902, "MATH220");
        Teacher mao = new Teacher("Mao", "Rubiano",91981, "Publicidad");
        Teacher jiraiya = new Teacher("Joraiya", "N", 9090001, "Elelegido");
        AcademyClass japn101 = new AcademyClass("JAPN101", jiraiya, "2022S");
        AcademyClass wrds150 = new AcademyClass("WRDS150", jiraiya, "2022W");
        AcademyClass engl161 = new AcademyClass("ENGL161", jiraiya, "2023W");
        assertTrue(Teacher.containsTeacher(jiraiya.getId()));
        assertTrue(Teacher.removeTeacher(jiraiya.getId()));
        assertFalse(Teacher.containsTeacher(9090001));
        //check the classes asign to the teacher are not null
        assertNull(japn101.getTeacher());
        assertNull(wrds150.getTeacher());
        assertNull(engl161.getTeacher());
        //fails to delete from a big list
        assertFalse(Teacher.containsTeacher(190191092));
        assertFalse(Teacher.removeTeacher(190191092));
    }


}