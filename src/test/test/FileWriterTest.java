package test;

import model.AcademyClass;
import model.Student;
import model.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistance.FileReader;
import persistance.FileWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileWriterTest {
    private Student nicolas;
    private Student gyunay;
    private AcademyClass CPSC110;
    private AcademyClass CPSC210;
    private AcademyClass CPSC221;
    private Teacher steven;



    @BeforeEach
    public void setUp(){
        List<Integer> listOfGrades = new ArrayList<>();
        listOfGrades.add(90);
        listOfGrades.add(25);
        List<Integer> listOfAbsences = new ArrayList<>();
        listOfAbsences.add(1);
        listOfAbsences.add(0);
        nicolas = new Student(9,"Nicolas","Rubiano","anime",listOfGrades,listOfAbsences);
        gyunay = new Student(20,"Gyunay","Kadirov","athena");
        CPSC110 = new AcademyClass(190,"CPSC110",null,"2022S");
        CPSC210 = new AcademyClass(109,"CPSC210",null,"2022S");
        CPSC221 = new AcademyClass(100,"CPSC221",null,"2022S");
        steven = new Teacher("Steven","Wolfram",101,"abstraction");
        nicolas.addClass(CPSC110);
        CPSC110.addStudent(nicolas);
        gyunay.addClass(CPSC110);
        CPSC110.addStudent(gyunay);
        nicolas.addClass(CPSC210);
        CPSC210.addStudent(nicolas);
        gyunay.addClass(CPSC210);
        CPSC210.addStudent(gyunay);

        CPSC210.setTeacher(steven);
        steven.addClass(CPSC210);
        CPSC221.setTeacher(steven);
        steven.addClass(CPSC221);

    }

    @Test
    public void testNoValidFileName() {
        FileReader myReader = new FileReader("data/noSuchAfile.json");
        try{
            Student currentStudent =  myReader.readStudent();
            fail();
        } catch (IOException e){
            //method working correctly
        }

        try{
            Teacher currentStudent =  myReader.readTeacher();
            fail();
        } catch (IOException e){
            //method working correctly
        }

        try{
            AcademyClass currentStudent =  myReader.readAcademyClass();
            fail();
        } catch (IOException e){
            //method working correctly
        }

    }

    @Test
    public void testingStudentMethods()  {
        try {
            FileWriter myWritter = new FileWriter();
            myWritter.setFileDestination("data/oneStudent.json");
            myWritter.open();
            myWritter.write(nicolas);
            myWritter.close();

            FileReader myReader = new FileReader("data/oneStudent.json");
            Student resultStudent = myReader.readStudent();
            assertEquals("anime", resultStudent.getPassword());
            assertEquals("Nicolas", resultStudent.getFn());
            assertEquals("Rubiano", resultStudent.getLn());
            assertEquals(90, resultStudent.getListOfGrades().get(0));
            assertEquals(25, resultStudent.getListOfGrades().get(1));
            assertEquals(1, resultStudent.getListOfAbscences().get(0));
            assertEquals(0, resultStudent.getListOfAbscences().get(1));
            assertEquals(190, resultStudent.getAllIDOfClasses().get(0));
            assertEquals(109, resultStudent.getAllIDOfClasses().get(1));
        } catch(IOException e) {
            fail("IOException not expected here");
        }
    }

    @Test
    public void testOneAcademyClas() {
        try {
            FileWriter myWriter = new FileWriter();
            myWriter.setFileDestination("data/oneClass.json");
            myWriter.open();
            myWriter.write(CPSC110);
            myWriter.close();

            FileReader myReader = new FileReader("data/oneClass.json");
            AcademyClass currentClass = myReader.readAcademyClass();
            assertEquals("CPSC110", currentClass.getName());
            assertEquals(190, currentClass.getId());
            assertEquals(-1, currentClass.getIdOfTeacher());
            assertEquals("2022S", currentClass.getSession());
            assertEquals(9, currentClass.getAllIdStudent().get(0));
            assertEquals(20, currentClass.getAllIdStudent().get(1));
        } catch(IOException e) {
            fail("IOException not expected here");
        }
    }

    @Test
    public void testOneTeacher()  {
        try {
            FileWriter myWriter = new FileWriter();
            myWriter.setFileDestination("data/oneTeacher.json");
            myWriter.open();
            myWriter.write(steven);
            myWriter.close();
            FileReader myReader = new FileReader("data/oneTeacher.json");
            Teacher currentTeacher = myReader.readTeacher();
            assertEquals("Steven", currentTeacher.getFn());
            assertEquals("Wolfram", currentTeacher.getLn());
            assertEquals(101, currentTeacher.getId());
            assertEquals("abstraction", currentTeacher.getPassword());
            assertEquals(109, currentTeacher.getAllClassesIds().get(0));
            assertEquals(100, currentTeacher.getAllClassesIds().get(1));
        } catch (IOException e) {
            fail("IOException not expected here");
        }

    }




}
