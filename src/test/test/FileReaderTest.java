package test;

import model.AcademyClass;
import model.DataSystem;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.FileReader;
import model.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {
    private DataSystem main;
    private int studentNicolasId;
    private int studentPizzaroId;
    private int studentPiedraId;
    private int idMATH200;
    private int idMATH220;
    private int idCPSC221;
    private int idTeacherKim;
    private int idTeacherCindy;

    @BeforeEach
    public void SetUp() {
        main= new DataSystem();
        studentNicolasId = main.addStudent("Nicolas","Rubiano","Anime");
        studentPizzaroId = main.addStudent("David","Pizarro","Medicina");
        studentPiedraId = main.addStudent("Santiago","Piedrahita","juliana");
        idMATH200 = main.addAcademyClass("MATH200",null,"2022S");
        idMATH220 = main.addAcademyClass("MATH220",null,"2022S");
        idCPSC221 = main.addAcademyClass("CPSC221",null,"2022S");
        idTeacherKim = main.addTeacher("Kim","Young-Heon","math");
        idTeacherCindy = main.addTeacher("Cindy","Heeran","computer");
        //Setting up the objects
        Student nicolas = main.getStudent(studentNicolasId);
        Student pizza = main.getStudent(studentPizzaroId);
        Student piedra = main.getStudent(studentPiedraId);
        AcademyClass math200 = main.getAcademyClass(idMATH200);
        AcademyClass math220 = main.getAcademyClass(idMATH220);
        AcademyClass cpsc221 = main.getAcademyClass(idCPSC221);
        Teacher kim = main.getTeacher(idTeacherKim);
        Teacher cindy = main.getTeacher(idTeacherCindy);
        //Setting up nicolas
        nicolas.addClass(math200);
        math200.addStudent(nicolas);
        nicolas.setGradeForClass("MATH200",50);
        //Setting up Pizzarro
        pizza.addClass(math200);
        math200.addStudent(pizza);
        pizza.setGradeForClass("MATH200",70);
        pizza.incrementAbsences("MATH200");

        pizza.addClass(math220);
        math220.addStudent(pizza);
        pizza.setGradeForClass("MATH220",90);
        pizza.incrementAbsences("MATH220");

        //Setting up Piedra
        piedra.addClass(math200);
        math200.addStudent(piedra);
        piedra.setGradeForClass("MATH200",80);
        piedra.incrementAbsences("MATH200");
        piedra.incrementAbsences("MATH200");
        piedra.incrementAbsences("MATH200");
        piedra.incrementAbsences("MATH200");

        piedra.addClass(math220);
        math220.addStudent(piedra);
        piedra.setGradeForClass("MATH220",99);

        piedra.addClass(cpsc221);
        cpsc221.addStudent(piedra);
        piedra.setGradeForClass("CPSC221",100);

        //Setting up Teacher and Class relationships
        cindy.addClass(cpsc221);
        cpsc221.setTeacher(cindy);

        kim.addClass(math200);
        math200.setTeacher(kim);

        kim.addClass(math220);
        math220.setTeacher(kim);
    }

    @Test
    public void testWritingAnReadingDataSystem()  {
        try {
            FileWriter myWriter = new FileWriter();
            myWriter.setFileDestination("data/OneDataSystem.json");
            myWriter.open();
            myWriter.write(main);
            myWriter.close();

            FileReader myReader = new FileReader("data/OneDataSystem.json");
            DataSystem result = myReader.readDataSystem();

            //get all the objects
            Student nicolas = result.getStudent(studentNicolasId);
            Student pizza = result.getStudent(studentPizzaroId);
            Student piedra = result.getStudent(studentPiedraId);
            AcademyClass math200 = result.getAcademyClass(idMATH200);
            AcademyClass math220 = result.getAcademyClass(idMATH220);
            AcademyClass cpsc221 = result.getAcademyClass(idCPSC221);
            Teacher kim = result.getTeacher(idTeacherKim);
            Teacher cindy = result.getTeacher(idTeacherCindy);
            //checkNicolas
            assertEquals("Anime", nicolas.getPassword());
            assertEquals("Nicolas", nicolas.getFn());
            assertEquals("Rubiano", nicolas.getLn());
            assertNull(nicolas.getAddress());
            assertTrue(nicolas.hasClass("MATH200"));
            assertEquals(50, nicolas.gradeInClass("MATH200"));
            assertEquals(0, nicolas.checkAbsence("MATH200"));
            assertEquals(1, nicolas.getListOfAbscences().size());
            assertEquals(1, nicolas.getListOfGrades().size());
            assertEquals(0, nicolas.getAllIDOfClasses().size());
            //check Pizzarro
            assertEquals("Medicina", pizza.getPassword());
            assertEquals("David", pizza.getFn());
            assertEquals("Pizarro", pizza.getLn());
            assertNull(pizza.getAddress());
            assertTrue(pizza.hasClass("MATH200"));
            assertEquals(70, pizza.gradeInClass("MATH200"));
            assertEquals(1, pizza.checkAbsence("MATH200"));
            assertTrue(pizza.hasClass("MATH220"));
            assertEquals(90, pizza.gradeInClass("MATH220"));
            assertEquals(1, pizza.checkAbsence("MATH220"));
            assertEquals(2, pizza.getListOfAbscences().size());
            assertEquals(2, pizza.getListOfGrades().size());
            assertEquals(0, pizza.getAllIDOfClasses().size());
            //checkPiedra
            assertEquals("juliana", piedra.getPassword());
            assertEquals("Santiago", piedra.getFn());
            assertEquals("Piedrahita", piedra.getLn());
            assertNull(piedra.getAddress());
            assertTrue(piedra.hasClass("MATH200"));
            assertEquals(80, piedra.gradeInClass("MATH200"));
            assertEquals(4, piedra.checkAbsence("MATH200"));
            assertTrue(piedra.hasClass("MATH220"));
            assertEquals(99, piedra.gradeInClass("MATH220"));
            assertEquals(0, piedra.checkAbsence("MATH220"));
            assertTrue(piedra.hasClass("CPSC221"));
            assertEquals(100, piedra.gradeInClass("CPSC221"));
            assertEquals(0, piedra.checkAbsence("CPSC221"));
            assertEquals(3, piedra.getListOfAbscences().size());
            assertEquals(3, piedra.getListOfGrades().size());
            assertEquals(0, piedra.getAllIDOfClasses().size());
            //checks MATH200
            assertTrue(math200.hasStudent(nicolas.getID()));
            assertTrue(math200.hasStudent(pizza.getID()));
            assertTrue(math200.hasStudent(piedra.getID()));
            assertEquals(0, math200.getTeacher().getId());
            assertEquals(3, math200.getNumOfStudents());
            assertEquals(0, math200.getAllIdStudent().size());
            //checks MATH220
            assertTrue(math220.hasStudent(pizza.getID()));
            assertTrue(math220.hasStudent(piedra.getID()));
            assertEquals(0, math220.getTeacher().getId());
            assertEquals(2, math220.getNumOfStudents());
            assertEquals(0, math220.getAllIdStudent().size());
            //checks CPSC221
            assertTrue(cpsc221.hasStudent(piedra.getID()));
            assertEquals(1, cpsc221.getTeacher().getId());
            assertEquals(1, cpsc221.getNumOfStudents());
            assertEquals(0, cpsc221.getAllIdStudent().size());
            //checks Kim
            assertEquals("math", kim.getPassword());
            assertEquals("Kim", kim.getFn());
            assertEquals("Young-Heon", kim.getLn());
            assertTrue(kim.isTeacherTeaching("MATH220"));
            assertTrue(kim.isTeacherTeaching("MATH200"));
            assertEquals(0, kim.getAllClassesIds().size());
            //checks
            assertEquals("computer", cindy.getPassword());
            assertEquals("Cindy", cindy.getFn());
            assertEquals("Heeran", cindy.getLn());
            assertTrue(cindy.isTeacherTeaching("CPSC221"));
            assertEquals(0, cindy.getAllClassesIds().size());
            //Check for the correct number of students, teachers and classes
            assertEquals(3,main.getListOfStudents().size());
            assertEquals(2,main.getListOfTeacher().size());
            assertEquals(3,main.getListOfClasses().size());
        } catch(IOException e){
            fail("No exception should be thrown");
        }

    }

    @Test
    public void testingForIOException()  {
        try {
            FileWriter myWritter = new FileWriter();
            myWritter.setFileDestination("data/OneDataSystem.json");
            myWritter.open();
            myWritter.write(main);
            myWritter.close();

            try {
                FileReader myReader = new FileReader("data/OneDataSystemo.json");
                DataSystem myData2 = myReader.readDataSystem();
                fail("Expected an exception to occur");
            } catch (IOException e) {
                //good behaviour
            }
        }catch (FileNotFoundException e) {
            fail("This exception should not have been thrown here");
        }
    }

    @Test
    public void testEmptyDataSystem(){
        try {
            DataSystem emptyDataSystem = new DataSystem();
            FileWriter myWriter = new FileWriter();
            myWriter.setFileDestination("data/EmptyDataSystem.json");
            myWriter.open();
            myWriter.write(emptyDataSystem);
            myWriter.close();

            FileReader myReader = new FileReader("data/EmptyDataSystem.json");
            DataSystem resultDataSystem = myReader.readDataSystem();
            assertEquals(0,resultDataSystem.getListOfStudents().size());
            assertEquals(0,resultDataSystem.getListOfClasses().size());
            assertEquals(0,emptyDataSystem.getListOfClasses().size());
        } catch (FileNotFoundException e) {
            fail("Destination exist and exception should not have been thrown");
        } catch(IOException e) {
            fail("Should not have thrown this exception");
        }


    }
}
