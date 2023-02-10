package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {
    private Student nicolas;
    private Student gyunay;
    private Student carlitos;
    private Student cubillos;
    private AcademyClass phil220;
    private AcademyClass dsci100;
    private AcademyClass cpsc210;
    private AcademyClass japn100;
    private Teacher eulogio;
    private Student pizzarro;

    @BeforeEach
    public void setUp(){
        nicolas= new Student(1701, "Nicolas", "Rubiano", "lol");
        gyunay= new Student(2509, "Gyunay", "Kadirov", "turkey");
        carlitos= new Student(2909, "Carlos", "Garcia", "pokemon");
        cubillos= new Student(18918,"Juan Camilo", "Cubillos","energias");
        eulogio= new Teacher("Eulogio", "Garcia", 190, "fisica11");
        phil220= new AcademyClass("PHIL220", eulogio, "2020W");
        dsci100= new AcademyClass("DSCI100", null, "2021W");
        cpsc210= new AcademyClass("CPSC210", null, "2022S");
        japn100= new AcademyClass("JAPN100", null, "2021S");

    }

    @Test
    public void testConstructor() {
        Student angel = new Student(909089, "angel", "Quiroga", "noanime");
        Student gabo = new Student(7854356, "Samuel", "Abuchaive", "babucha");
        //Checking the constructor works
        assertEquals(angel.getID(), 909089);
        assertEquals(angel.getFn(), "angel");
        assertEquals(angel.getLn(), "Quiroga");
        assertEquals(angel.getNumOfClasses(), 0);
        //Checking the basic setters and getters
        gabo.setFn("Jose");
        gabo.setLn("Mendieta");
        assertEquals(gabo.getFn(), "Jose");
        assertEquals(gabo.getLn(), "Mendieta");
        assertEquals(gabo.getID(), 7854356);
        //Deal with duplications
        pizzarro= new Student(909089, "David","Pizzarro", "matemosalmartin");
        assertNotEquals(pizzarro.getID(), 9090);
        assertNotEquals(pizzarro.getFn(), "David");
        assertNotEquals(pizzarro.getLn(), "Pizzarro");
        assertEquals(pizzarro.getID(), 626);
    }

    @Test
    public void testChangePassworld(){
        Student Piedra = new Student(69422, "Santiago", "Piedrahita","cocteles");
        //incorret pastPassworld
        assertFalse(Piedra.changePassword("lolololo", ""));
        //correctpast Passworld but new password is empty
        assertFalse(Piedra.changePassword("cocteles", ""));
        //correct cahnge of passworld
        assertTrue(Piedra.changePassword("cocteles", "anime"));
    }

    @Test
    public void testHasClass(){
        //Tries to add the clas but the class is null
        assertFalse(nicolas.addClass(null));
        assertEquals(nicolas.getNumOfClasses(), 0);
        //does not have classes produces false
        assertFalse(nicolas.hasClass("PHYS107"));
        //has one class but it is not teh correct one
        nicolas.addClass(phil220);
        assertFalse(nicolas.hasClass("MATH220"));
        //has one class but misppeles the name
        assertFalse(nicolas.hasClass("PJIL220"));
        //has the class and is the correct name
        assertTrue(nicolas.hasClass("PHIL220"));
        // has the class but is later on the list
        nicolas.addClass(dsci100);
        nicolas.addClass(cpsc210);
        assertTrue(nicolas.hasClass("CPSC210"));
        //does not have the class and teh list is long
        assertFalse(nicolas.hasClass("ENGL150"));
    }

    @Test
    public void testForSetGrade() {
        //the class does not exist and the grade is less than zero
        assertEquals(nicolas.getNumOfClasses(), 0);
        assertFalse(nicolas.setGradeForClass("MATH100", -11));
        //the class exist but the grade is less than zero
        nicolas.addClass(phil220);
        assertFalse(nicolas.setGradeForClass("PHIL220",-1));
        //the class exit and the grade is zero
        assertTrue(nicolas.setGradeForClass("PHIL220", 0));
        assertEquals(nicolas.gradeInClass("PHIL220"), 0);
        //the class exit and the grade is one
        assertTrue(nicolas.setGradeForClass("PHIL220", 1));
        assertEquals(nicolas.gradeInClass("PHIL220"), 1);
        //the class exit and grade is greater than
        assertTrue(nicolas.setGradeForClass("PHIL220", 12));
        assertEquals(nicolas.gradeInClass("PHIL220"), 12);


    }

    @Test
    public void testForSetGradeUpperBoundary(){
        //the class exists but is at the end of the list
       assertEquals( nicolas.getNumOfClasses(), 0);
       nicolas.addClass(dsci100);
       nicolas.addClass(cpsc210);
        assertTrue(nicolas.setGradeForClass("CPSC210", 11));
        assertEquals(nicolas.gradeInClass("CPSC210"), 11);
        //The class exist and the grade is 99
        assertTrue(nicolas.setGradeForClass("CPSC210", 99));
        assertEquals(nicolas.gradeInClass("CPSC210"), 99);
        //The class exist and the grade is 100
        assertTrue(nicolas.setGradeForClass("CPSC210", 100));
        assertEquals(nicolas.gradeInClass("CPSC210"), 100);
        //The class exits but the grades is greater than 100;
        assertFalse(nicolas.setGradeForClass("CPSC210", 101));
        assertEquals(nicolas.gradeInClass("CPSC210"), 100);
        //The class exist but the garde is far more than 100
        assertFalse(nicolas.setGradeForClass( "CPSC210", 1111));
        assertEquals(nicolas.gradeInClass("CPSC210"), 100);
    }

    @Test
    public void testForGradeInClass(){

        //the student is not register for any class
        assertEquals(nicolas.gradeInClass("CPSC210"), -1);
        //the student is register for one class but is not the one correct
        nicolas.addClass(cpsc210);
        assertEquals(nicolas.gradeInClass("CPSC313"), -1);
        //the student is register for the class and is the correct one
        nicolas.setGradeForClass("CPSC210", 90);
        assertEquals(nicolas.gradeInClass("CPSC210"), 90);
        //The student is register for the class but is not the first class
        nicolas.addClass(dsci100);
        nicolas.setGradeForClass("DSCI100",76);
        assertEquals(nicolas.gradeInClass("DSCI100"), 76);
        //the student is not register for the class and is the las one.
        nicolas.addClass(phil220);
        assertEquals(nicolas.gradeInClass("MATH302"),-1);

    }

    @Test
    public void testGetStudents() {
        Student bonilla = new Student(9090, "Santiago", "Bonilla", "Juliana");
        Student abucha = new Student(78543, "Samuel", "Abuchaive", "babucha");
        //the id is invalid
        assertNull(Student.getStudent(90));
        //the id is valid and is the first one
        pizzarro= Student.getStudent(9090);
        assertEquals(pizzarro, bonilla);
        //the if is valid and is the last one
        pizzarro = Student.getStudent(78543);
        assertEquals(pizzarro, abucha);
    }

    @Test
    public void testCheckLogin(){
        //the id does not exits
        assertFalse(Student.checkLogin(9090,"mom"));
        //the id exits but the password is wrong
        assertFalse(Student.checkLogin(1701, "mom"));
        //the id exits and the password is good but is the first student
        assertTrue(Student.checkLogin(1701,"lol"));
        //the id exists and teh password is good but is not the first student
        assertTrue(Student.checkLogin(18918,"energias"));
        //the id exits is at the end of the list but the password is wrong
        assertFalse(Student.checkLogin(18918, "energias2"));
    }

    @Test
    public void testincrementAbsences(){
        nicolas.addClass(phil220);
        nicolas.addClass(dsci100);
        //the student is not register in the subject
        assertFalse(nicolas.incrementAbsecences("PHIL222"));
        assertEquals(nicolas.checkAbsence("PHIL220"), 0);
        //the student is register on the class
        assertTrue(nicolas.incrementAbsecences("PHIL220"));
        assertEquals(nicolas.checkAbsence("PHIL220"), 1);
        cubillos.addClass(dsci100);
        cubillos.incrementAbsecences("DSCI100");
        cubillos.incrementAbsecences("DSCI100");
        assertEquals(cubillos.checkAbsence("DSCI100"), 2);
    }

    @Test
    public void testNumberOfClasses(){
        assertEquals(nicolas.getNumOfClasses(), 0);
        nicolas.addClass(dsci100);
        assertEquals(nicolas.getNumOfClasses(), 1);
        nicolas.addClass(dsci100);
        assertEquals(nicolas.getNumOfClasses(), 1);
        nicolas.addClass(phil220);
        nicolas.addClass(cpsc210);
        assertEquals(nicolas.getNumOfClasses(), 3);
    }

    public void setUpforRemoveClass(){
        nicolas.addClass(phil220);
        nicolas.setGradeForClass("PHIL220", 90);
        nicolas.incrementAbsecences("PHIL220");
        phil220.addStudent(nicolas);
        nicolas.addClass(dsci100);
        nicolas.setGradeForClass("DSCI100", 45);
        nicolas.incrementAbsecences("DSCI100");
        nicolas.incrementAbsecences("DSCI100");
        dsci100.addStudent(nicolas);
        nicolas.addClass(cpsc210);
        nicolas.setGradeForClass("CPSC210", 87);
        cpsc210.addStudent(nicolas);
    }

    @Test
    public void removeClass(){
        setUpforRemoveClass();
        //tries to remove a class that does not belong to the student
        assertFalse(nicolas.removeClass("JAPN100"));
        //Removes Sucesfully the first Class from the student view
        assertTrue(nicolas.removeClass("PHIL220"));
        assertTrue(phil220.deleteStudent(nicolas.getID()));
        assertFalse(phil220.hasStudent(nicolas.getID()));
        assertEquals(nicolas.getNumOfClasses(), 2);
        assertTrue(nicolas.hasClass("DSCI100"));
        assertEquals(nicolas.gradeInClass("DSCI100"), 45);
        assertEquals(nicolas.checkAbsence("DSCI100"), 2);
        assertTrue(nicolas.hasClass("CPSC210"));
        assertEquals(nicolas.gradeInClass("CPSC210"), 87);
        assertEquals(nicolas.checkAbsence("CPSC210"), 0);
        //Sucessfully removes the second class
        assertTrue(nicolas.removeClass("CPSC210"));
        assertTrue(cpsc210.deleteStudent(nicolas.getID()));
        assertFalse(cpsc210.hasStudent(nicolas.getID()));
        assertEquals(nicolas.getNumOfClasses(), 1);
        assertTrue(nicolas.hasClass("DSCI100"));
        assertEquals(nicolas.gradeInClass("DSCI100"), 45);
        assertEquals(nicolas.checkAbsence("DSCI100"), 2);


    }

    @Test
    public void testForSettingandGettingAdress() {
        nicolas.setAdress("1701 burnaby st");
        assertEquals(nicolas.getAdress(), "1701 burnaby st");
        gyunay.setAdress("cr 57 #119a-60");
        assertEquals(gyunay.getAdress(), "cr 57 #119a-60");
    }

    @Test
    public void testHasId() {
        //tries to find a non existent id
        assertFalse(Student.hasId(190190190));
        //find the id on the first position
        assertTrue(Student.hasId(1701));
        //finds the id on the last part of the list
        assertTrue(Student.hasId(18918));
    }

    @Test
    public void testGetIndexOfClass() {
        //Tries to find in an empty list for a class
        assertEquals(nicolas.getIndexOfClass("PHIL220"), -1);
        //tries to find for the empty string
        assertEquals(nicolas.getIndexOfClass(""), -1);
        //tries to find and finds it on the first index, in a list with size 1
        nicolas.addClass(phil220);
        assertEquals(nicolas.getIndexOfClass("PHIL220"), 0);
        //find the class and is on the end of the list
        nicolas.addClass(dsci100);
        nicolas.addClass(cpsc210);
        nicolas.addClass(japn100);
        assertEquals(nicolas.getIndexOfClass("JAPN100"), 3);
        //does not find it
        assertEquals(nicolas.getIndexOfClass("MATH302"), -1);
    }

    @Test
    public void testArrayForClasses() {
        Student michael= new Student(9082, "Michael", "Jackson", "Beatit");
        //TestForAnEmptyArray
        Object[][] resulArray= michael.arrayGrades();
        assertTrue( resulArray[0][0].equals("Class"));
        assertTrue(resulArray[0][1].equals("Grade"));
        assertTrue(resulArray[0][2].equals("Absences"));
    }

    @Test
    public void testForClassesOtherCases() {
        Student michael= new Student(9083, "Michael", "Jackson", "Beatit");
        michael.addClass(phil220);
        michael.setGradeForClass("PHIL220", 77);
        //testForOneClass:
        Object[][] resultArray= michael.arrayGrades();
        int x = 90;
        assertEquals("PHIL220", resultArray[1][0]);
        assertEquals(77.0, resultArray[1][1]);
        assertEquals(0, resultArray[1][2]);
        assertEquals(resultArray.length, 2);
        //Test for more than one class
        michael.addClass(cpsc210);
        michael.setGradeForClass("CPSC210", 34);
        michael.incrementAbsecences("CPSC210");
        michael.incrementAbsecences("CPSC210");
        michael.incrementAbsecences("CPSC210");
        Object[][] resultArray2= michael.arrayGrades();
        assertEquals(resultArray2[2][0], "CPSC210");
        assertEquals(resultArray2[2][1], 34.0);
        assertEquals(resultArray2[2][2], 3);
        assertEquals(resultArray2.length, 3);


    }
}
