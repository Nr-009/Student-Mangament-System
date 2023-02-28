package ui;

import model.AcademyClass;
import model.DataSystem;
import model.Student;
import model.Teacher;

public class SetUpOfManagementSystem {
    private DataSystem alldata;
    private int nicolasStudentId;
    private int carlitosStudentId;
    private int gyunayStudentId;
    private int yotasStudentId;
    private int eulogioTeacherId;
    private int jhonathanTeacherId;
    private int gregorTeacherId;
    private int stevenTeacherId;
    private int tienTeacherId;
    private int anthonyTeacherId;
    private int cpsc110AcademyClassId;
    private int cpsc121AcademyClassId;
    private int cpsc210AcademyClassId;
    private int math100AcademyClassId;
    private int math101AcademyClassId;
    private int dsci100AcademyClassId;
    private int phil100AcademyClassId;

    public static void main(String[] args) {
        SetUpOfManagementSystem currentSystem = new SetUpOfManagementSystem();
        currentSystem.startSetUp();


    }


    //SECTION: Setting all the basic fields

    public void startSetUp() {
        initialSetup();
        setUpTeachersRelationships1();
        setUpTeachersRelationships2();
        setUpNicolas();
        setupNicolas2();
        setUpGyunay();
        setUpCarlitos();
        setUpYotas();
        setUpYotas2();
    }

    //Modifies: This
    //Effects: Creates all the necessary student, classes and Teachers for the other methods to use
    public void initialSetup() {
        alldata = new DataSystem();
        nicolasStudentId = alldata.addStudent("Nicolas", "Rubiano", "lol");
        carlitosStudentId = alldata.addStudent("Cralos", "Garcia", "Pokemon");
        gyunayStudentId = alldata.addStudent("Gyunay", "Kadirov", "chess");
        yotasStudentId = alldata.addStudent("Rodrigo", "Gonzales", "eliminaMartinez300");

        eulogioTeacherId = alldata.addTeacher("Eulogio", " El Inmortal", "fisica12");
        jhonathanTeacherId = alldata.addTeacher("Jhonathan", "Ichikawa", "logic");
        gregorTeacherId = alldata.addTeacher("Gregor", "Kiczales", "naturalRecursion");
        stevenTeacherId = alldata.addTeacher("Steven", "Wolfram", "abstraction");
        tienTeacherId = alldata.addTeacher("Tien", "Geoffrey", "circuits");
        anthonyTeacherId = alldata.addTeacher("Anthony", "Christidis", "R");

        cpsc110AcademyClassId = alldata.addAcademyClass("CPSC110", null, "2022W");
        cpsc121AcademyClassId = alldata.addAcademyClass("CPSC121", null, "2022W");
        cpsc210AcademyClassId = alldata.addAcademyClass("CPSC210", null, "2022W");
        math100AcademyClassId = alldata.addAcademyClass("MATH100", null, "2022W");
        math101AcademyClassId = alldata.addAcademyClass("MATH101", null, "2022W");
        dsci100AcademyClassId = alldata.addAcademyClass("DSCI100", null, "2022W");
        phil100AcademyClassId = alldata.addAcademyClass("PHIL100", null, "2022W");
    }

    //Modifies: This
    //Effects: Adds the teacher to the class and the class to the teacher
    public void setUpTeachersRelationships1() {
        Teacher gregor = alldata.getTeacher(gregorTeacherId);
        AcademyClass cpsc110 = alldata.getAcademyClass(cpsc110AcademyClassId);
        gregor.addClass(cpsc110);
        cpsc110.setTeacher(gregor);

        Teacher tien = alldata.getTeacher(tienTeacherId);
        AcademyClass cpsc121 = alldata.getAcademyClass(cpsc121AcademyClassId);
        tien.addClass(cpsc121);
        cpsc121.setTeacher(tien);

        Teacher steven = alldata.getTeacher(stevenTeacherId);
        AcademyClass cpsc210 = alldata.getAcademyClass(cpsc210AcademyClassId);
        steven.addClass(cpsc210);
        cpsc210.setTeacher(steven);




    }

    //Modifies: This
    //Effects: Adds the teacher to the class and the class to the teacher
    public void setUpTeachersRelationships2() {
        Teacher eulogio = alldata.getTeacher(eulogioTeacherId);
        AcademyClass math100 = alldata.getAcademyClass(math100AcademyClassId);
        eulogio.addClass(math100);
        math100.setTeacher(eulogio);

        AcademyClass math101 = alldata.getAcademyClass(math101AcademyClassId);
        eulogio.addClass(math101);
        math101.setTeacher(eulogio);

        Teacher anthony = alldata.getTeacher(anthonyTeacherId);
        AcademyClass dsci100 = alldata.getAcademyClass(dsci100AcademyClassId);
        anthony.addClass(dsci100);
        dsci100.setTeacher(anthony);

        Teacher jhonathan = alldata.getTeacher(jhonathanTeacherId);
        AcademyClass phil110 = alldata.getAcademyClass(phil100AcademyClassId);
        jhonathan.addClass(phil110);
        phil110.setTeacher(jhonathan);
    }


    //Modifies: This
    //Effects: Sets the nicolas field with initial grades and absences for the classes of CPSC110, CPSC121,
    // CPSC210, AND DSCI 100. Also adds the addressTo edit your information Press E to the nicolas field
    public void setUpNicolas() {
        Student nicolas = alldata.getStudent(nicolasStudentId);
        AcademyClass cpsc110 = alldata.getAcademyClass(cpsc110AcademyClassId);
        AcademyClass cpsc121 = alldata.getAcademyClass(cpsc121AcademyClassId);


        nicolas.addClass(cpsc110);
        cpsc110.addStudent(nicolas);
        nicolas.setGradeForClass("CPSC110", 74);
        nicolas.incrementAbsences("CPSC110");
        nicolas.incrementAbsences("CPSC110");
        nicolas.incrementAbsences("CPSC110");

        nicolas.addClass(cpsc121);
        cpsc121.addStudent(nicolas);
        nicolas.setGradeForClass("CPSC121", 73);
        nicolas.incrementAbsences("CPSC121");
        nicolas.incrementAbsences("CPSC121");
        nicolas.incrementAbsences("CPSC121");

    }

    //Modifies: This
    //Effects: Sets the nicolas field with initial grades and absences for the classes of CPSC110, CPSC121,
    // CPSC210, AND DSCI 100. Also adds the addressTo edit your information Press E to the nicolas field
    public void setupNicolas2() {
        Student nicolas = alldata.getStudent(nicolasStudentId);
        AcademyClass cpsc210 = alldata.getAcademyClass(cpsc210AcademyClassId);
        AcademyClass dsci100 = alldata.getAcademyClass(dsci100AcademyClassId);
        nicolas.addClass(cpsc210);
        cpsc210.addStudent(nicolas);
        nicolas.setGradeForClass("CPSC210", 65);
        nicolas.incrementAbsences("CPSC210");

        nicolas.addClass(dsci100);
        dsci100.addStudent(nicolas);
        nicolas.setGradeForClass("DSCI100", 80);
        nicolas.setAddress("2114 Burnaby Street");
    }


    //Modifies: This
    //Effects: Sets the Gyunay field with initial grades and absences for the classes of CPSC110, MATH100,
    // and MATH101. Also adds the address to the gyunay field

    public void setUpGyunay() {
        Student gyunay = alldata.getStudent(gyunayStudentId);
        AcademyClass cpsc210 = alldata.getAcademyClass(cpsc210AcademyClassId);
        AcademyClass math100 = alldata.getAcademyClass(math100AcademyClassId);
        AcademyClass math101 = alldata.getAcademyClass(math101AcademyClassId);

        gyunay.addClass(cpsc210);
        cpsc210.addStudent(gyunay);
        gyunay.setGradeForClass("CPSC210", 89);

        gyunay.addClass(math100);
        math100.addStudent(gyunay);
        gyunay.setGradeForClass("MATH100", 100);
        gyunay.incrementAbsences("MATH100");

        gyunay.addClass(math101);
        math101.addStudent(gyunay);
        gyunay.setGradeForClass("MATH101", 20);
        gyunay.incrementAbsences("MATH101");
        gyunay.incrementAbsences("MATH101");
        gyunay.setAddress("2114 Burnaby Street");


    }
    //Modifies: This
    //Effects: Sets the Carlitos field with initial grades and absences for the classes of CPSC110, MATH101,
    // DSCI100, and PHIL100.

    public void setUpCarlitos() {
        Student carlitos = alldata.getStudent(carlitosStudentId);
        AcademyClass cpsc210 = alldata.getAcademyClass(cpsc210AcademyClassId);
        AcademyClass math101 = alldata.getAcademyClass(math101AcademyClassId);
        AcademyClass dsci100 = alldata.getAcademyClass(dsci100AcademyClassId);
        AcademyClass phil100 = alldata.getAcademyClass(phil100AcademyClassId);
        carlitos.addClass(cpsc210);
        cpsc210.addStudent(carlitos);
        carlitos.setGradeForClass("CPSC210", 77);
        carlitos.incrementAbsences("CPSC210");
        carlitos.incrementAbsences("CPSC210");

        carlitos.addClass(math101);
        math101.addStudent(carlitos);
        carlitos.setGradeForClass("MATH101", 90);
        carlitos.incrementAbsences("MATH101");
        carlitos.incrementAbsences("MATH101");

        carlitos.addClass(dsci100);
        dsci100.addStudent(carlitos);
        carlitos.setGradeForClass("DSCI100", 88);
        carlitos.incrementAbsences("DSCI100");

        carlitos.addClass(phil100);
        phil100.addStudent(carlitos);
        carlitos.setGradeForClass("PHIL100", 99);


    }

    //Modifies: This
    //Effects: Sets the Yotas field with initial grades and absences for the classes of CPSC121, CPSC210,
    // MATH101, DSCI100 and PHIL100.

    public void setUpYotas() {
        Student yotas = alldata.getStudent(yotasStudentId);
        AcademyClass cpsc121 = alldata.getAcademyClass(cpsc121AcademyClassId);
        AcademyClass cpsc210 = alldata.getAcademyClass(cpsc210AcademyClassId);
        AcademyClass math101 = alldata.getAcademyClass(math101AcademyClassId);
        AcademyClass dsci100 = alldata.getAcademyClass(dsci100AcademyClassId);
        AcademyClass phil100 = alldata.getAcademyClass(phil100AcademyClassId);

        yotas.addClass(cpsc121);
        cpsc121.addStudent(yotas);
        yotas.setGradeForClass("CPSC121", 18);
        yotas.incrementAbsences("CPSC121");
        yotas.incrementAbsences("CPSC121");
        yotas.incrementAbsences("CPSC121");

        yotas.addClass(cpsc210);
        cpsc210.addStudent(yotas);
        yotas.setGradeForClass("CPSC210", 87);
        yotas.incrementAbsences("CPSC210");

        yotas.addClass(math101);
        math101.addStudent(yotas);
        yotas.setGradeForClass("MATH101", 88);
        yotas.incrementAbsences("MATH101");

    }

    //Modifies: This
    //Effects: Sets the Yotas field with initial grades and absences for the classes of CPSC121, CPSC210,
    // MATH101, DSCI100 and PHIL100.
    public void setUpYotas2() {
        Student yotas = alldata.getStudent(yotasStudentId);
        AcademyClass dsci100 = alldata.getAcademyClass(dsci100AcademyClassId);
        AcademyClass phil100 = alldata.getAcademyClass(phil100AcademyClassId);

        yotas.addClass(dsci100);
        dsci100.addStudent(yotas);
        yotas.setGradeForClass("DSCI100", 90);
        yotas.incrementAbsences("DSCI100");

        yotas.addClass(phil100);
        phil100.addStudent(yotas);
        yotas.setGradeForClass("PHIL100", 78);
        yotas.incrementAbsences("PHIL100");
        yotas.incrementAbsences("PHIL100");
    }
}
