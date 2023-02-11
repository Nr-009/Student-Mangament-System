package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AcademyClassTest {

    private AcademyClass math100;
    private AcademyClass cpsc110;
    private AcademyClass cpsc210;
    private AcademyClass cpsc121;
    private Student nicolas;
    private Student gyunay;
    private Student carlitos;
    private Teacher eulogio;
    private Teacher mickelsen;

    @BeforeEach
    public void setUp() {
        eulogio = new Teacher("Eulogio", "Garcia", 90, "fisica11");
        mickelsen = new Teacher("Mickelsen", "Ramirez", 100, "geometria8");
        math100 = new AcademyClass("MATH100", null, "2020W");
        cpsc110 = new AcademyClass("CPSC110", mickelsen, "2021W");
        cpsc210 = new AcademyClass("CPSC210", eulogio, "2022W");
        cpsc121 = new AcademyClass("CPSC121", null, "2021S");
        nicolas = new Student(20, "Nicolas", "Rubiano", "conoseeuir");
        gyunay = new Student(22, "Gynay", "kadirov", "Athena");
        carlitos = new Student(23, "Carlos", "Garcia", "Pokemon");

    }

    @Test
    public void testConstructor() {
        assertEquals(math100.getName(), "MATH100");
        assertEquals(cpsc110.getName(), "CPSC110");
        assertNull(math100.getTeacher());
        assertEquals(cpsc110.getTeacher(), mickelsen);
        assertEquals(cpsc110.getSession(), "2021W");
        assertEquals(math100.getSession(), "2020W");

    }

    @Test
    public void testGetAverageGrade() {
        Student murcia = new Student(978782, "Sebastian", "Murica", "drugs");
        Student garcia = new Student(27628, "Juan", "Garcia", "Futbol");
        Student gabo2 = new Student(178178, "Gabriel", "Granados", "Millos");
        //Zero students so the average grade should be zero
        assertEquals(math100.getAverageGrade(), 0);
        //One student so the average grade should be just his grade
        gabo2.addClass(math100);
        math100.addStudent(gabo2);
        gabo2.setGradeForClass("MATH100", 89);
        assertEquals(math100.getAverageGrade(), 89);
        //Two or more student so the average grade should now be the average
        garcia.addClass(math100);
        math100.addStudent(garcia);
        garcia.setGradeForClass("MATH100", 46);
        murcia.addClass(math100);
        math100.addStudent(murcia);
        murcia.setGradeForClass("MATH100", 67);
        assertEquals(math100.getAverageGrade(), 67);
    }

    @Test
    public void testSetSession() {
        math100.setSesion("2019W");
        assertEquals(math100.getSession(), "2019W");
        cpsc121.setSesion("2022W");
        assertEquals(cpsc121.getSession(), "2022W");
    }

    @Test
    public void testSetTeacherandGetTeacher() {
        assertTrue(math100.setTeacher(eulogio));
        assertEquals(eulogio, math100.getTeacher());
        assertFalse(math100.setTeacher(null));
        assertEquals(eulogio, math100.getTeacher());
        assertTrue(cpsc121.setTeacher(mickelsen));
        assertEquals(mickelsen, cpsc121.getTeacher());
        assertTrue(math100.setTeacher(mickelsen));
        assertEquals(math100.getTeacher(), mickelsen);
        assertNotEquals(math100.getTeacher(), eulogio);
    }

    @Test
    public void testHasStudent() {
        Student abucha = new Student(90909012, "Santiago", "Abuchaive", "babucha");
        //There is no student
        assertFalse(math100.hasStudent(90));
        //There is one student but not with that id
        math100.addStudent(abucha);
        assertFalse(math100.hasStudent(909090123));
        //There is one student and you find it at first
        assertTrue(math100.hasStudent(90909012));
        //There are more than 1 student but it fails
        Student angel = new Student(190, "Angel", "Garcia", "noanime");
        Student gabo = new Student(1908, "Gabo", "Martinez", "Nose");
        math100.addStudent(angel);
        math100.addStudent(gabo);
        assertFalse(math100.hasStudent(89));
        //There is more than one student but it get it
        assertTrue(math100.hasStudent(1908));
    }

    @Test
    public void addStudent() {
        //null case
        assertFalse(math100.addStudent(null));
        //Add one student
        Student ana = new Student(198250, "Ana", "Flavia", "psycology");
        Student clara = new Student(190190, "Clara", "Flavia", "comunism");
        Student dj = new Student(19080, "D", "j", "Peru");
        assertTrue(math100.addStudent(ana));
        //Tries to add the same student more than once
        assertEquals(math100.getNumOfStudents(), 1);
        assertFalse(math100.addStudent(ana));
        assertEquals(math100.getNumOfStudents(), 1);
        //Adss more than one student succesfully;
        assertTrue(math100.addStudent(clara));
        assertEquals(math100.getNumOfStudents(), 2);
        assertTrue(math100.addStudent(dj));
        assertEquals(math100.getNumOfStudents(), 3);
    }

    @Test
    public void testSetGradeAndGetGrade() {
        math100.addStudent(gyunay);
        gyunay.addClass(math100);
        math100.addStudent(nicolas);
        nicolas.addClass(math100);
        math100.addStudent(carlitos);
        carlitos.addClass(math100);
        //The student does not exist
        assertFalse(math100.setGradeStudent(9909090, 90));
        assertEquals(math100.getGradeStudent(90909090), -1);
        //The student Exists but the grade is less than zero
        assertFalse(math100.setGradeStudent(gyunay.getID(), -1));
        //The student exist and the grade is more equal to zero
        assertTrue(math100.setGradeStudent(gyunay.getID(), 0));
        assertEquals(math100.getGradeStudent(gyunay.getID()), 0);
        //The student exist and teh garde is equal to 1
        assertTrue(math100.setGradeStudent(gyunay.getID(), 1));
        assertEquals(math100.getGradeStudent(gyunay.getID()), 1);
        //The student exist and the grade is more than 1 but the student appears on teh end of the list
        assertTrue(math100.setGradeStudent(nicolas.getID(), 10));
        assertEquals(math100.getGradeStudent(nicolas.getID()), 10);
        //The student exits and the grade is 99
        assertTrue(math100.setGradeStudent(nicolas.getID(), 99));
        assertEquals(math100.getGradeStudent(nicolas.getID()), 99);
        //the student exits and the grade is 100
        assertTrue(math100.setGradeStudent(nicolas.getID(), 100));
        assertEquals(math100.getGradeStudent(nicolas.getID()), 100);
        //the student exist and the grade is 101
        assertFalse(math100.setGradeStudent(nicolas.getID(), 101));
        assertEquals(math100.getGradeStudent(nicolas.getID()), 100);
        //the student exits and teh grade is far more than 101
        assertFalse(math100.setGradeStudent(nicolas.getID(), 1600));
        assertEquals(math100.getGradeStudent(nicolas.getID()), 100);

    }

    @Test
    public void testGetIndexOf() {
        //tries to find a student when  the index does not exist and the database is empty
        assertEquals(math100.getIndexStudent(90), -1);
        //tries to find a student when the index is wrong but the data base is not empty
        math100.addStudent(carlitos);
        assertEquals(math100.getIndexStudent(909090), -1);
        //Find the correct index in the first try
        assertEquals(math100.getIndexStudent(carlitos.getID()), 0);
        //Find students in different indexes
        math100.addStudent(nicolas);
        math100.addStudent(gyunay);
        assertEquals(math100.getIndexStudent(nicolas.getID()), 1);
        assertEquals(math100.getIndexStudent(gyunay.getID()), 2);
        //Fails because index does not exist in a list greater than 2
        assertEquals(math100.getIndexStudent(90909090), -1);

    }

    @Test
    public void testDeleteStudent() {
        Student valentina = new Student(1898, "Valentina", "Ramirez", "kokok");
        Student laura = new Student(192862, "Laura", "liliana", "hola");
        Student giorno = new Student(18178, "Giono", "Giovanna", "deusxmachina");
        //Requires clause
        math100.addStudent(valentina);
        math100.addStudent(laura);
        math100.addStudent(giorno);
        valentina.addClass(math100);
        laura.addClass(math100);
        giorno.addClass(math100);
        //Searches for a non existing id
        assertEquals(math100.getNumOfStudents(), 3);
        assertFalse(math100.deleteStudent(909090));
        //Safely deletes one correct student
        assertTrue(math100.deleteStudent(valentina.getID()));
        valentina.removeClass("MATH100");
        assertEquals(math100.getNumOfStudents(), 2);
        assertFalse(valentina.hasClass("MATH100"));
        //Safely deletes another student
        assertTrue(math100.deleteStudent(giorno.getID()));
        giorno.removeClass("MATH100");
        assertEquals(math100.getNumOfStudents(), 1);
        assertFalse(giorno.hasClass("MATH100"));
    }

    @Test
    public void testArrayOfGradeslastwoCases() {
        Student samir = new Student(28298921, "Samir", "Kush", "kokklao");
        Student survi = new Student(28902836, "Survi", "I", "ksksl");
        Object[][] testArray = new Object[3][3];
        //array with one student
        math100.addStudent(samir);
        samir.addClass(math100);
        samir.setGradeForClass("MATH100", 89);
        testArray[1][0] = samir.getID();
        testArray[1][1] = 89.0;
        Object[][] resultArray2 = math100.gradesforClass();
        assertEquals(testArray[1][0], resultArray2[1][0]);
        assertEquals(2, resultArray2.length);
        assertEquals(testArray[1][1], resultArray2[1][1]);
        //array with more than one student
        math100.addStudent(survi);
        survi.addClass(math100);
        survi.setGradeForClass("MATH100", 76);
        testArray[2][0] = survi.getID();
        testArray[2][1] = 76.0;
        Object[][] resultArray3 = math100.gradesforClass();
        assertEquals(testArray[2][0], resultArray3[2][0]);
        assertEquals(3, resultArray3.length);
        assertEquals(testArray[2][1], resultArray3[2][1]);


    }

    @Test
    public void testforthefirsArrayFirstCase() {
        //array with zero students
        Object[][] testArray = new Object[3][3];
        testArray[0][0] = "Students";
        testArray[0][1] = "Grade";
        Object[][] resultArray = math100.gradesforClass();
        assertEquals(testArray[0][0], resultArray[0][0]);
        assertEquals(testArray[0][1], resultArray[0][1]);
        assertEquals(1, resultArray.length);
    }

    @Test
    public void testIfAClassExist() {
        //Negative id
        assertFalse(AcademyClass.doesThisClassExist(-9));
        //First class created
        assertTrue(AcademyClass.doesThisClassExist(0));
        //Some class later
        assertTrue(AcademyClass.doesThisClassExist(2));
        //Id non existing
        assertFalse(AcademyClass.doesThisClassExist(1000));
    }



}
