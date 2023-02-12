package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AcademyClassTestStatic {

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
        assertEquals(resultArray[0][0], "Class");
        assertEquals(resultArray[0][1], "Teacher");
        assertEquals(resultArray[0][2], "Average Grade");
        assertEquals(resultArray[0][3], "NumberOfStudents");
        assertEquals(resultArray[0][4], "Id of the Class");
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
        assertEquals(cpsc110.getId(), 0);
        assertEquals(phil220.getId(), 3);
        //Finds the class on the first position
        testClass = AcademyClass.findClass(0);
        assertEquals(testClass, cpsc110);
        //Find the class on the latter position
        testClass = AcademyClass.findClass(3);
        assertEquals(testClass, phil220);
        //Does not find the class in a big list
        assertEquals(null, AcademyClass.findClass(4));
        //Testing for an Array with multiple Classes
        resultArray = AcademyClass.informationDisplay();
        assertEquals(resultArray[1][0],"CPSC110");
        assertEquals(resultArray[1][1], "No teacher at the moment");
        assertEquals(resultArray[1][2], 90.0);
        assertEquals(resultArray[1][3], 1);
        assertEquals(resultArray[1][4], 0);
        assertEquals(resultArray[2][0],"MATH100");
        assertEquals(resultArray[2][1], "Eulogio");
        assertEquals(resultArray[2][2], 50.0);
        assertEquals(resultArray[2][3], 2);
        assertEquals(resultArray[2][4], 1);
    }


}
