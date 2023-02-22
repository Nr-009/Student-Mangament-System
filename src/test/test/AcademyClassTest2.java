package test;

import model.AcademyClass;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AcademyClassTest2 {

    private AcademyClass cpsc110;
    private AcademyClass math100;
    private AcademyClass dsci100;
    private AcademyClass phil220;

    public void setup() {
        Student nicolas = new Student(10, "Nicolas", "Rubiano", "anime");
        Student pizzarro = new Student(16, "David", "Pizzarro", "TulitoesGod");
        Student yotas = new Student(20, "Rodrigo", " Gonzales", "AniquilaMatrines3000");
        Teacher eulogio = new Teacher("Eulogio", "G", 1000, "AliaselInmortal");
        cpsc110 = new AcademyClass("CPSC110", null,"Winter2020");
        cpsc110.addStudent(nicolas);
        nicolas.addClass(cpsc110);
        cpsc110.setGradeStudent(nicolas.getID(), 90);

        math100 = new AcademyClass("MATH100", null, "Summer2021");
        math100.addStudent(pizzarro);
        pizzarro.addClass(math100);
        math100.setGradeStudent(pizzarro.getID(), 0);
        math100.addStudent(yotas);
        yotas.addClass(math100);
        yotas.setGradeForClass("MATH100", 100);
        math100.setTeacher(eulogio);

        dsci100 = new AcademyClass("DSCI100", null, "Winter2022");
        phil220 = new AcademyClass("PHIL220", null, "Summer2021");
    }

    @BeforeEach
    public void setup2() {
        int x = 10;
    }

    @Test
    public void testingForTheArrayFirstCase() {
        Object[][] resultArray = AcademyClass.informationDisplay();
        assertEquals("Class", resultArray[0][0]);
        assertEquals("Teacher", resultArray[0][1]);
        assertEquals("Average Grade", resultArray[0][2]);
        assertEquals("NumberOfStudents", resultArray[0][3]);
        assertEquals("Id of the Class",resultArray[0][4]);
    }

    @Test
    public void testFindClass() {
        //Testing for an empty Array
        Object[][] resultArray = AcademyClass.informationDisplay();
        AcademyClass testClass;
        //Tries to find a class where there is no classes
        assertNull(AcademyClass.findClass(290));
        setup();
        //Testing for ids:
        assertEquals(null, AcademyClass.findClass(-9));
        assertEquals(0, cpsc110.getId());
        assertEquals(3, phil220.getId());
        //Finds the class on the first position
        testClass = AcademyClass.findClass(0);
        assertEquals(cpsc110, testClass);
        //Find the class on the latter position
        testClass = AcademyClass.findClass(3);
        assertEquals(phil220, testClass);
        //Does not find the class in a big list
        assertEquals(null, AcademyClass.findClass(4));
        //Testing for an Array with multiple Classes
        resultArray = AcademyClass.informationDisplay();
        assertEquals("CPSC110", resultArray[1][0]);
        assertEquals("No teacher at the moment", resultArray[1][1]);
        assertEquals(90.0, resultArray[1][2]);
        assertEquals(1,resultArray[1][3]);
        assertEquals(0, resultArray[1][4]);
        assertEquals("MATH100",resultArray[2][0]);
        assertEquals("Eulogio",resultArray[2][1]);
        assertEquals(50.0,resultArray[2][2]);
        assertEquals(2,resultArray[2][3]);
        assertEquals(1,resultArray[2][4]);
    }


}
