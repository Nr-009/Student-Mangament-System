package model;



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
        assertEquals(ichikawa.getFn(), "Jhonathan");
        assertEquals(ichikawa.getLn(), "Ichikawa");
        assertEquals(anothony.getFn(), "Anthony");
        assertEquals(anothony.getLn(), "Christidis");
        //Testing the setters for fn and ln
        ichikawa.setfn("EuologioElAncestral");
        assertEquals(ichikawa.getFn(), "EuologioElAncestral");
        ichikawa.setLn("BestPhysicsTeacher");
        assertEquals(ichikawa.getLn(), "BestPhysicsTeacher");
        //Testing for when somebody wants to create a user with an id alreayd created
        nicolas = new Teacher("Nicolas", "Rubiano", 800, "anime");
        assertNotEquals(nicolas.getFn(), "Nicolas");
        assertNotEquals(nicolas.getLn(), "Rubiano");
    }

    @Test
    public void testForSetPassworld() {
        Teacher angela = new Teacher("Angela", "Sarmiento", 9092, "CAA");
        Teacher tolosa = new Teacher("Fisica", "Tolosa", 7817, "fisica");
        //puts the incorrect last passworld
        assertFalse(angela.setPassword("mol", "fisica12"));
        //puts the the empty string as the passworld
        assertFalse(angela.setPassword("CAA", ""));
        //correctly changes the passworld
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
        assertEquals(Euologio2, eulogio);
        Teacher Mickelsen2;
        Mickelsen2 = Teacher.returnsTeacher(90);
        assertEquals(Mickelsen2, mickelsen);
        assertNotEquals(Mickelsen2, orjuela);
        //Getting null based on an not existing id
        Teacher Nicolas;
        Nicolas = Teacher.returnsTeacher(110);
        assertEquals(Nicolas, null);
    }

    @Test
    public void testTeacherisTeachingandaddClass() {
        setUp();
        //check for empty string
        assertFalse(eulogio.isTeacherTeaching(""));
        //tries to add null
        eulogio.addClass(null);
        assertEquals(eulogio.getNumClasses(), 0);
        //Adds a class
        assertEquals(mickelsen.getNumClasses(), 0);
        mickelsen.addClass(COMP110);
        assertTrue(mickelsen.isTeacherTeaching("COMP110"));
        assertEquals(mickelsen.getNumClasses(), 1);
        mickelsen.addClass(COMP121);
        assertTrue(mickelsen.isTeacherTeaching("COMP121"));
        assertEquals(mickelsen.getNumClasses(), 2);
        //misppelled the name, produces false
        assertFalse(mickelsen.isTeacherTeaching("COMP111"));
        //Tries to add the teacher but the class has already a teacher
        eulogio.addClass(COMP110);
        assertFalse(eulogio.isTeacherTeaching("COMP110"));
        //avoiding duplicates
        mickelsen.addClass(COMP110);
        assertEquals(mickelsen.getNumClasses(), 2);
        mickelsen.addClass(COMP121);
        assertEquals(mickelsen.getNumClasses(), 2);

    }

    @Test
    public void testRemoveClass() {
        mickelsen.addClass(COMP110);
        mickelsen.addClass(COMP121);
        assertTrue(mickelsen.isTeacherTeaching("COMP110"));
        assertTrue(mickelsen.isTeacherTeaching("COMP121"));
        assertEquals(mickelsen.getNumClasses(), 2);
        //tries to remove a clas that does not exit
        assertFalse(mickelsen.removeClass("PHIL220"));
        //tries to remove empty string
        assertFalse(mickelsen.removeClass(""));
        //sucesfully removes the first class
        assertTrue(mickelsen.removeClass("COMP110"));
        assertEquals(mickelsen.getNumClasses(), 1);
        assertFalse(mickelsen.isTeacherTeaching("COMP110"));
        //sucesfully removes the second class
        assertTrue(mickelsen.removeClass("COMP121"));
        assertEquals(mickelsen.getNumClasses(), 0);
        assertFalse(mickelsen.isTeacherTeaching("COMP121"));
    }

    @Test
    public void testIndexOfClass(){
        setUp();
        mickelsen.addClass(COMP121);
        mickelsen.addClass(COMP110);
        //tries to search for a class that does not appear
        assertEquals(mickelsen.indexOfClass("PHIL220"), -1);
        //tries to serch for a class that does not appear in an teacher without classes
        assertEquals(eulogio.indexOfClass("COMP121"), -1);
        //searches and finds it on the first index
        assertEquals(mickelsen.indexOfClass("COMP121"), 0);
        //searches and finds it in the second index
        assertEquals(mickelsen.indexOfClass("COMP110"), 1);
    }

    @Test
    public void testingforArrayOfIds(){
        MATH100 = new AcademyClass("Math100", null, "2020W");
        COMP210 = new AcademyClass("COMP210", null, "2021W");
        Teacher andres = new Teacher("Andres", "R", 18172, "carros");
        //Test for a teacher with no classes
        Object[][] resultArray = andres.listOfClassesId();
        assertEquals(resultArray[0][0], "Class Name");
        assertEquals(resultArray[0][1], "Class Id");
        assertEquals(resultArray.length, 1);
        //Testing for a teacher with one class
        COMP210.setTeacher(andres);
        Object[][] resultArray2 = andres.listOfClassesId();
        assertEquals(resultArray2[1][0], "COMP210");
        assertEquals(resultArray2[1][1], COMP210.getId());
        assertEquals(resultArray2.length, 2);
        //Testing for a teacher with more than one class
        MATH100.setTeacher(andres);
        Object[][] resultArray3 = andres.listOfClassesId();
        assertEquals(resultArray3[2][0], "Math100");
        assertEquals(resultArray3[2][1], MATH100.getId());
        assertEquals(resultArray3.length, 3);

    }


}