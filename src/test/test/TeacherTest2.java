package test;

import model.AcademyClass;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TeacherTest2 {
    private Teacher eulogio;
    private Teacher mickelsen;
    private Teacher orjuela;
    private Teacher nicolas;



    @Test
    public void testArrayAllTeachers( ){
        Object[][] resultArray = Teacher.displayAllTeachers();
        //Array with no teachers
        assertEquals("First Name", resultArray[0][0]);
        assertEquals("Last Name", resultArray[0][1]);
        assertEquals("Id", resultArray[0][2]);
        assertEquals("NumberOfClasses", resultArray[0][3]);
        //Array with one teacher
        eulogio= new Teacher("Eulogio", "R", 1901901, "fisica12");
        Object[][] resultArray2 = Teacher.displayAllTeachers();
        assertEquals("Eulogio", resultArray2[1][0]);
        assertEquals("R", resultArray2[1][1]);
        assertEquals(1901901, resultArray2[1][2]);
        assertEquals(0, resultArray2[1][3]);
        //Array with more than one teacher
        mickelsen = new Teacher("Mickelsen", "M", 1910920, "geometria9");
        AcademyClass math100 = new AcademyClass("MATH10-", mickelsen, "2021S");
        Object[][] resultArray3 = Teacher.displayAllTeachers();
        assertEquals("Mickelsen", resultArray3[2][0]);
        assertEquals("M", resultArray3[2][1]);
        assertEquals(1910920, resultArray3[2][2]);
        assertEquals(1, resultArray3[2][3]);


    }

}
