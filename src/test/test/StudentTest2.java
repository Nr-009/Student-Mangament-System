package test;

import model.Student;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest2 {
    private Student nicolas;
    private Student gyunay;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void testArrayOfAllStudents( ) {
        //array with no students
        Object [][] resulArray = Student.arrayAllStudents();
        assertEquals("Id", resulArray[0][0]);
        assertEquals("First Name", resulArray[0][1]);
        assertEquals("Last Name", resulArray[0][2]);
        assertEquals("Number Of Classes", resulArray[0][3]);
        //array with one student
        nicolas= new Student(1701, "Nicolas", "Rubiano", "lol");
        Object [][] resulArray2 = Student.arrayAllStudents();
        assertEquals(nicolas.getID(), resulArray2[1][0]);
        assertEquals(nicolas.getFn(), resulArray2[1][1]);
        assertEquals(nicolas.getLn(), resulArray2[1][2]);
        assertEquals(nicolas.getNumOfClasses(), resulArray2[1][3]);
        //array with two students
        gyunay= new Student(2509, "Gyunay", "Kadirov", "turkey");
        Object [][] resulArray3 = Student.arrayAllStudents();
        assertEquals(gyunay.getID(), resulArray3[2][0]);
        assertEquals(gyunay.getFn(), resulArray3[2][1]);
        assertEquals(gyunay.getLn(), resulArray3[2][2]);
        assertEquals(gyunay.getNumOfClasses(), resulArray3[2][3]);
    }
}
