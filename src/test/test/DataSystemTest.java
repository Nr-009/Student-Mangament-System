package test;

import model.AcademyClass;
import model.DataSystem;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataSystemTest {
    private DataSystem main;
    private int nicolasId;
    private int gyunayId;
    private int yotasId;
    private int cpsc110Id;
    private int cpsc121Id;
    private int phil220Id;
    private int jhonathanId;
    private int eulogioId;
    private int mickelsenId;

    @BeforeEach
    public void setUp(){
        main =new DataSystem();
        nicolasId=main.addStudent("Nicolas", "Rubiano", "lol");
        gyunayId=main.addStudent("Gyunay", "Kadirov","chess");
        yotasId=main.addStudent("Rodrigo", "Gonzales", "eliminaMartinez3000");
        cpsc110Id=main.addAcademyClass("CPSC110",null,"2022W");
        cpsc121Id=main.addAcademyClass("CPSC121",null,"2022W");
        phil220Id=main.addAcademyClass("PHIL220",null,"2023W");
        jhonathanId= main.addTeacher("Jhonathan","Ichikawa","logic");
        eulogioId= main.addTeacher("Eulogio","elInmortal","fisica12");
        mickelsenId= main.addTeacher("Mickelsen","R","geometri8");
        Student gyunay = main.getStudent(gyunayId);
        Student yotas = main.getStudent(yotasId);
        AcademyClass cpsc121 = main.getAcademyClass(cpsc121Id);
        AcademyClass phil220 = main.getAcademyClass(phil220Id);
        Teacher jhonathan = main.getTeacher(jhonathanId);
        Teacher eulogio = main.getTeacher(eulogioId);
        //Setting the Students
        gyunay.addClass(cpsc121);
        cpsc121.addStudent(gyunay);
        gyunay.setGradeForClass("CPSC121",90);
        gyunay.incrementAbsences("CPSC121");

        yotas.addClass(cpsc121);
        cpsc121.addStudent(yotas);
        yotas.addClass(phil220);
        phil220.addStudent(yotas);

        yotas.setGradeForClass("PHIL220",20);
        yotas.incrementAbsences("PHIL220");
        yotas.incrementAbsences("PHIL220");
        yotas.setGradeForClass("CPSC121",85);
        jhonathan.addClass(phil220);
        phil220.setTeacher(jhonathan);
        eulogio.addClass(cpsc121);
        cpsc121.setTeacher(eulogio);
    }

    //Section: Student Section
    @Test
    public void testGetStudent(){
        //the id is invalid
        assertNull(main.getStudent(9090));
        //the id is valid and is the first one
        assertEquals("Nicolas",main.getStudent(nicolasId).getFn());
        assertEquals("Rubiano",main.getStudent(nicolasId).getLn());
        assertEquals("lol",main.getStudent(nicolasId).getPassword());
        //The id is valid and is at the end of the list
        assertEquals("Rodrigo",main.getStudent(yotasId).getFn());
        assertEquals("Gonzales",main.getStudent(yotasId).getLn());
        assertEquals("eliminaMartinez3000",main.getStudent(yotasId).getPassword());
    }

    @Test
    public void testHasIdStudent() {
        //tries to find a non-existent id
        assertFalse(main.hasIdStudent(19019));
        //find the id on the first position
        assertTrue(main.hasIdStudent(nicolasId));
        //finds the id on the last part of the list
        assertTrue(main.hasIdStudent(yotasId));
    }

    @Test
    public void checkLoginStudent(){
        //the id does not exist
        assertFalse(main.checkLoginStudent(18109,"lola"));
        //the the id exist but the password is wrong
        assertFalse(main.checkLoginStudent(nicolasId,"lola"));
        //the id exist and the password is good, is the first student
        assertTrue(main.checkLoginStudent(nicolasId,"lol"));
        //the id exist and the password is good but is not the first student
        assertTrue(main.checkLoginStudent(yotasId,"eliminaMartinez3000"));
    }

    @Test
    public void testChangePasswordStudent(){
        //incorrect Password
        assertFalse(main.changePasswordStudent(nicolasId,"lola","cartagena"));
        //correctPassword but new password is empty
        assertFalse(main.changePasswordStudent(nicolasId,"lol",""));
        //correct change of password
        assertTrue(main.changePasswordStudent(nicolasId,"lol","lola"));

    }
    @Test
    public void testArrayAllStudents(){
        Object [][] resulArray = main.arrayAllStudents();
        assertEquals("Id", resulArray[0][0]);
        assertEquals("First Name", resulArray[0][1]);
        assertEquals("Last Name", resulArray[0][2]);
        assertEquals("Number Of Classes", resulArray[0][3]);

        assertEquals(0, resulArray[1][0]);
        assertEquals("Nicolas", resulArray[1][1]);
        assertEquals("Rubiano", resulArray[1][2]);
        assertEquals(0, resulArray[1][3]);

        assertEquals(1, resulArray[2][0]);
        assertEquals("Gyunay", resulArray[2][1]);
        assertEquals("Kadirov", resulArray[2][2]);
        assertEquals(1, resulArray[2][3]);

        assertEquals(2, resulArray[3][0]);
        assertEquals("Rodrigo", resulArray[3][1]);
        assertEquals("Gonzales", resulArray[3][2]);
        assertEquals(2, resulArray[3][3]);

    }

    //Section:The teacher Section
    @Test
    public void hasTeacher(){
        //the id is invalid
        assertNull(main.getStudent(9090));
        //the id is valid and is the first one
        assertEquals("Jhonathan",main.getTeacher(jhonathanId).getFn());
        assertEquals("Ichikawa",main.getTeacher(jhonathanId).getLn());
        assertEquals("logic",main.getTeacher(jhonathanId).getPassword());
        //The id is valid and is at the end of the list
        assertEquals("Mickelsen",main.getTeacher(mickelsenId).getFn());
        assertEquals("R",main.getTeacher(mickelsenId).getLn());
        assertEquals("geometri8",main.getTeacher(mickelsenId).getPassword());
    }

    @Test
    public void testHasIdTeacher() {
        //tries to find a non-existent id
        assertFalse(main.hasIDTeacher(19019));
        //find the id on the first position
        assertTrue(main.hasIDTeacher(jhonathanId));
        //finds the id on the last part of the list
        assertTrue(main.hasIDTeacher(mickelsenId));
    }
    @Test
    public void checkLoginTeacher(){
        //the id does not exist
        assertFalse(main.checkLoginTeacher(18109,"lola"));
        //the the id exist but the password is wrong
        assertFalse(main.checkLoginTeacher(jhonathanId,"lola"));
        //the id exist and the password is good, is the first student
        assertTrue(main.checkLoginTeacher(jhonathanId,"logic"));
        //the id exist and the password is good but is not the first student
        assertTrue(main.checkLoginTeacher(mickelsenId,"geometri8"));
    }

    @Test
    public void testChangePasswordTeacher(){
        //incorrect Password
        assertFalse(main.changePasswordTeacher(jhonathanId,"lola","cartagena"));
        //correctPassword but new password is empty
        assertFalse(main.changePasswordTeacher(jhonathanId,"logic",""));
        //correct change of password
        assertTrue(main.changePasswordTeacher(jhonathanId,"logic","soundness"));
    }

    @Test
    public void testArrayAllTeacher(){
        Object[][] resultArray = main.arrayAllTeachers();
        //First row:
        assertEquals("First Name", resultArray[0][0]);
        assertEquals("Last Name", resultArray[0][1]);
        assertEquals("Id", resultArray[0][2]);
        assertEquals("NumberOfClasses", resultArray[0][3]);
        //Second row:
        assertEquals("Jhonathan", resultArray[1][0]);
        assertEquals("Ichikawa", resultArray[1][1]);
        assertEquals(0, resultArray[1][2]);
        assertEquals(1, resultArray[1][3]);
        //Third row:
        assertEquals("Eulogio", resultArray[2][0]);
        assertEquals("elInmortal", resultArray[2][1]);
        assertEquals(1, resultArray[2][2]);
        assertEquals(1, resultArray[2][3]);
        //Fourth row:
        assertEquals("Mickelsen", resultArray[3][0]);
        assertEquals("R", resultArray[3][1]);
        assertEquals(2, resultArray[3][2]);
        assertEquals(0, resultArray[3][3]);

    }
    @Test
    public void testDeleteTeacher(){
        //tries to delete a teacher that does not exist
        assertFalse(main.removeTeacher(1910));
        //safely Deletes a teacher with a subject
        assertTrue(main.hasIdOfAcademyClass(phil220Id));
        assertTrue(main.getStudent(yotasId).hasClass("PHIL220"));
        assertEquals("Jhonathan",main.getAcademyClass(phil220Id).getTeacher().getFn());
        assertTrue(main.hasIDTeacher(jhonathanId));
        assertTrue(main.removeTeacher(jhonathanId));
        assertTrue(main.hasIdOfAcademyClass(phil220Id));
        assertTrue(main.getStudent(yotasId).hasClass("PHIL220"));
        assertNull(main.getAcademyClass(phil220Id).getTeacher());
        assertFalse(main.hasIDTeacher(jhonathanId));

    }

    //Todo: deleteTeacher Method
    //Section: AcademyClass

    @Test
    public void testIfAClassExist(){
        //negative id
        assertFalse(main.hasIdOfAcademyClass(-1));
        //First class Created
        assertTrue(main.hasIdOfAcademyClass(cpsc110Id));
        //some class later
        assertTrue(main.hasIdOfAcademyClass(phil220Id));
        //Id non existing class
        assertFalse(main.hasIdOfAcademyClass(19019));
    }

    @Test
    public void testDeleteClassExist() {
        //tries to delete a class that does not exist
        assertFalse(main.hasIdOfAcademyClass(190));
        assertFalse(main.removeAcademyClass(190));
        //Deletes a class safely from the start of the list
        assertTrue(main.hasIdOfAcademyClass(cpsc110Id));
        assertTrue(main.removeAcademyClass(cpsc110Id));
        assertFalse(main.hasIdOfAcademyClass(cpsc110Id));
    }

    @Test
    public void deletesClassChecksForStudentGrades(){
        //Deletes a class from the back of the list
        assertTrue(main.hasIdOfAcademyClass(cpsc121Id));
        assertEquals(main.getAcademyClass(cpsc121Id).getTeacher().getId(),eulogioId);
        assertTrue(main.getStudent(yotasId).hasClass("CPSC121"));
        assertTrue(main.getStudent(gyunayId).hasClass("CPSC121"));
        assertTrue(main.removeAcademyClass(cpsc121Id));
        assertFalse(main.hasIdOfAcademyClass(cpsc121Id));
        assertNull(main.getAcademyClass(cpsc121Id));
        assertFalse(main.getStudent(yotasId).hasClass("CPSC121"));
        assertFalse(main.getStudent(gyunayId).hasClass("CPSC121"));

    }

    @Test
    public void testArrayAllTeachers() {
        Object[][] resultArray = main.arrayAllClasses();
        assertEquals("Class", resultArray[0][0]);
        assertEquals("Teacher", resultArray[0][1]);
        assertEquals("Average Grade", resultArray[0][2]);
        assertEquals("NumberOfStudents", resultArray[0][3]);
        assertEquals("Id of the Class",resultArray[0][4]);

        assertEquals("CPSC110", resultArray[1][0]);
        assertEquals("No teacher at the moment", resultArray[1][1]);
        assertEquals(0.0, resultArray[1][2]);
        assertEquals(0,resultArray[1][3]);
        assertEquals(0, resultArray[1][4]);

        assertEquals("CPSC121", resultArray[2][0]);
        assertEquals("Eulogio", resultArray[2][1]);
        assertEquals(87.5, resultArray[2][2]);
        assertEquals(2,resultArray[2][3]);
        assertEquals(1, resultArray[2][4]);

        assertEquals("PHIL220", resultArray[3][0]);
        assertEquals("Jhonathan", resultArray[3][1]);
        assertEquals(20.0, resultArray[3][2]);
        assertEquals(1,resultArray[3][3]);
        assertEquals(2, resultArray[3][4]);

    }


    }


