package test;

import model.AcademyClass;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

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
        assertEquals( "MATH100", math100.getName());
        assertEquals("CPSC110", cpsc110.getName() );
        assertNull(math100.getTeacher());
        assertEquals( mickelsen, cpsc110.getTeacher());
        assertEquals("2021W", cpsc110.getSession());
        assertEquals("2020W",math100.getSession());

    }

    @Test
    public void testGetAverageGrade() {
        Student murcia = new Student(978782, "Sebastian", "Murica", "drugs");
        Student garcia = new Student(27628, "Juan", "Garcia", "Futbol");
        Student gabo2 = new Student(178178, "Gabriel", "Granados", "Millos");
        //Zero students so the average grade should be zero
        assertEquals(0,math100.getAverageGrade());
        //One student so the average grade should be just his grade
        gabo2.addClass(math100);
        math100.addStudent(gabo2);
        gabo2.setGradeForClass("MATH100", 89);
        assertEquals(89, math100.getAverageGrade());
        //Two or more student so the average grade should now be the average
        garcia.addClass(math100);
        math100.addStudent(garcia);
        garcia.setGradeForClass("MATH100", 46);
        murcia.addClass(math100);
        math100.addStudent(murcia);
        murcia.setGradeForClass("MATH100", 67);
        assertEquals(67, math100.getAverageGrade());
    }

    @Test
    public void testSetSession() {
        math100.setSession("2019W");
        assertEquals("2019W", math100.getSession());
        cpsc121.setSession("2022W");
        assertEquals("2022W", cpsc121.getSession());
    }

    @Test
    public void testSetTeacherAndGetTeacher() {
        assertTrue(math100.setTeacher(eulogio));
        assertEquals(eulogio, math100.getTeacher());
        assertEquals(eulogio, math100.getTeacher());
        assertTrue(cpsc121.setTeacher(mickelsen));
        assertEquals(mickelsen, cpsc121.getTeacher());
        assertTrue(math100.setTeacher(mickelsen));
        assertEquals(mickelsen, math100.getTeacher());
        assertNotEquals(eulogio, math100.getTeacher());
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
        assertEquals(1, math100.getNumOfStudents());
        assertFalse(math100.addStudent(ana));
        assertEquals(1, math100.getNumOfStudents());
        //Adss more than one student succesfully;
        assertTrue(math100.addStudent(clara));
        assertEquals(2,math100.getNumOfStudents());
        assertTrue(math100.addStudent(dj));
        assertEquals(3, math100.getNumOfStudents());
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
        assertEquals(-1, math100.getGradeStudent(90909090));
        //The student Exists but the grade is less than zero
        assertFalse(math100.setGradeStudent(gyunay.getID(), -1));
        //The student exist and the grade is more equal to zero
        assertTrue(math100.setGradeStudent(gyunay.getID(), 0));
        assertEquals(0, math100.getGradeStudent(gyunay.getID()));
        //The student exist and teh garde is equal to 1
        assertTrue(math100.setGradeStudent(gyunay.getID(), 1));
        assertEquals(1, math100.getGradeStudent(gyunay.getID()));
        //The student exist and the grade is more than 1 but the student appears on teh end of the list
        assertTrue(math100.setGradeStudent(nicolas.getID(), 10));
        assertEquals(10, math100.getGradeStudent(nicolas.getID()));
        //The student exits and the grade is 99
        assertTrue(math100.setGradeStudent(nicolas.getID(), 99));
        assertEquals(99,math100.getGradeStudent(nicolas.getID()));
        //the student exits and the grade is 100
        assertTrue(math100.setGradeStudent(nicolas.getID(), 100));
        assertEquals(100, math100.getGradeStudent(nicolas.getID()));
        //the student exist and the grade is 101
        assertFalse(math100.setGradeStudent(nicolas.getID(), 101));
        assertEquals(100, math100.getGradeStudent(nicolas.getID()));
        //the student exits and teh grade is far more than 101
        assertFalse(math100.setGradeStudent(nicolas.getID(), 1600));
        assertEquals(100, math100.getGradeStudent(nicolas.getID()));

    }

    @Test
    public void testGetIndexOf() {
        //tries to find a student when  the index does not exist and the database is empty
        assertEquals(-1, math100.getIndexStudent(90));
        //tries to find a student when the index is wrong but the data base is not empty
        math100.addStudent(carlitos);
        assertEquals(-1, math100.getIndexStudent(909090));
        //Find the correct index in the first try
        assertEquals(0,math100.getIndexStudent(carlitos.getID()));
        //Find students in different indexes
        math100.addStudent(nicolas);
        math100.addStudent(gyunay);
        assertEquals(1, math100.getIndexStudent(nicolas.getID()));
        assertEquals(2, math100.getIndexStudent(gyunay.getID()));
        //Fails because index does not exist in a list greater than 2
        assertEquals(-1, math100.getIndexStudent(90909090));

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
        //Searches for a non-existing id
        assertEquals(3, math100.getNumOfStudents());
        assertFalse(math100.deleteStudent(909090));
        //Safely deletes one correct student
        assertTrue(math100.deleteStudent(valentina.getID()));
        valentina.removeClass("MATH100");
        assertEquals(2, math100.getNumOfStudents());
        assertFalse(valentina.hasClass("MATH100"));
        //Safely deletes another student
        assertTrue(math100.deleteStudent(giorno.getID()));
        giorno.removeClass("MATH100");
        assertEquals(1,math100.getNumOfStudents());
        assertFalse(giorno.hasClass("MATH100"));
    }


    @Test
    public void testArrayOfGradesLasTwoCases() {
        Student samir = new Student(28298921, "Samir", "Kush", "kokklao");
        Student survi = new Student(28902836, "Survi", "I", "ksksl");
        //array with one student
        math100.addStudent(samir);
        samir.addClass(math100);
        samir.setGradeForClass("MATH100", 89);
        Object[][] resultArray2 = math100.gradesForClass();
        assertEquals(samir.getID(), resultArray2[1][0]);
        assertEquals(2, resultArray2.length);
        assertEquals("Samir Kush", resultArray2[1][1]);
        assertEquals(89.0, resultArray2[1][2]);
        //array with more than one student
        math100.addStudent(survi);
        survi.addClass(math100);
        survi.setGradeForClass("MATH100", 76);
        Object[][] resultArray3 = math100.gradesForClass();
        assertEquals(survi.getID(), resultArray3[2][0]);
        assertEquals(3, resultArray3.length);
        assertEquals("Survi I", resultArray3[2][1]);
        assertEquals(76.0, resultArray3[2][2]);

    }

    @Test
    public void testForTheFirstArrayFirstCase() {
        //array with zero student
        Object[][] resultArray = math100.gradesForClass();
        assertEquals("Id", resultArray[0][0]);
        assertEquals("Name", resultArray[0][1]);
        assertEquals("Grade", resultArray[0][2]);
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

    @Test
    public void testDeleteClassExist() {
        AcademyClass newClass = new AcademyClass("CPSC221", null, "2023S");
        //Tries to delete a class that does not exist
        assertFalse(AcademyClass.removeClass(690));
        assertFalse(AcademyClass.doesThisClassExist(690));
        //Deletes a class safely from the start of  the classes
        int idOfNewClass = newClass.getId();
        assertTrue(AcademyClass.doesThisClassExist(newClass.getId()));
        assertTrue(AcademyClass.removeClass(newClass.getId()));
        assertFalse(AcademyClass.doesThisClassExist(idOfNewClass));



    }

    @Test
    public void deleteClassesChecksStudentGrades() {
        //Deletes a class from the back of the list of classes
        Teacher piedra = new Teacher("Piedra", "E",91011111,"lokok");
        AcademyClass cpsc213 = new AcademyClass("CPSC213", null, "2023S");
        cpsc213.setTeacher(piedra);
        piedra.addClass(cpsc213);
        Student nicolas = new Student(190190, "Nicolas", "Rubiano", "anime");
        Student andrea = new Student(10292082, "andrea", "b", "labiblia");
        nicolas.addClass(cpsc213);
        cpsc213.addStudent(nicolas);
        andrea.addClass(cpsc213);
        cpsc213.addStudent(andrea);
        int idOf213 = cpsc213.getId();
        assertTrue(AcademyClass.doesThisClassExist(cpsc213.getId()));
        assertTrue(piedra.isTeacherTeaching("CPSC213"));
        assertTrue(nicolas.hasClass("CPSC213"));
        assertTrue(andrea.hasClass("CPSC213"));
        assertTrue(AcademyClass.removeClass(cpsc213.getId()));
        assertFalse(AcademyClass.doesThisClassExist(idOf213));
        assertFalse(piedra.isTeacherTeaching("CPSC213"));
        assertFalse(nicolas.hasClass("CPSC213"));
        assertFalse(andrea.hasClass("CPSC213"));
        //Fails to delete a class with a list big
        assertFalse(AcademyClass.doesThisClassExist(90290));
        assertFalse(AcademyClass.removeClass(90290));

    }



}
