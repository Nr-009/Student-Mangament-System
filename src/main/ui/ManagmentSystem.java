package ui;

import model.AcademyClass;
import model.Student;
import model.Teacher;

import java.util.Arrays;
import java.util.Currency;
import java.util.Scanner;

public class ManagmentSystem {
    private Student nicolas = new Student(90, "Nicolas", "Rubiano", "anime");
    private Student carlitos = new Student(190, "Carlos", "Garcia", "pokemon");
    private Student gyunay = new Student(10, "Gyunay", "Kadirov", "chess");
    private Student yotas = new Student(69, "Rodrigo","Gonzales", "aniquilaMartines3000");
    private Teacher eulogio = new Teacher("Eulogio", "El inmortal", 189, "fisica12");
    private Teacher jhonathan = new Teacher("Jhonathan", "Ichikawa", 190, "phil220");
    private Teacher gregor = new Teacher("Gregor","Kiczales", 11, "TrustTheNaturalRecursion");
    private Teacher steven = new Teacher("Steven", "Wolfram", 1, "Abstraction");
    private Teacher tien = new Teacher("Tien", "Geoffrey", 122, "logic");
    private Teacher anthony = new Teacher("Anthony", "Christidis", 1901901,"regression");
    private AcademyClass cpsc110 = new AcademyClass("CPSC110", null, "Winter2-2022");
    private AcademyClass cpsc121 = new AcademyClass("CPSC121", null, "Winter2-2022");
    private AcademyClass cpsc210 = new AcademyClass("CPSC210", null, "Winter2-2022");
    private AcademyClass math100 = new AcademyClass("MATH100", null, "Winter2-2022");
    private AcademyClass math101 = new AcademyClass("MATH101", null, "Winter2-2022");
    private AcademyClass dsci100 = new AcademyClass("DSCI100", null, "Winter2-2022");
    private AcademyClass phil100 = new AcademyClass("PHIL100", null, "Winter2-2022");

    public void setUpNicolas() {
        nicolas.addClass(cpsc110);
        cpsc110.addStudent(nicolas);
        nicolas.setGradeForClass("CPSC110", 74);
        nicolas.incrementAbsecences("CPSC110");
        nicolas.incrementAbsecences("CPSC110");
        nicolas.incrementAbsecences("CPSC110");

        nicolas.addClass(cpsc121);
        cpsc121.addStudent(nicolas);
        nicolas.setGradeForClass("CPSC121", 73);
        nicolas.incrementAbsecences("CPSC121");
        nicolas.incrementAbsecences("CPSC121");
        nicolas.incrementAbsecences("CPSC121");

        nicolas.addClass(cpsc210);
        cpsc210.addStudent(nicolas);
        nicolas.setGradeForClass("CPSC210", 65);
        nicolas.incrementAbsecences("CPSC210");

        nicolas.addClass(dsci100);
        dsci100.addStudent(nicolas);
        nicolas.setGradeForClass("DSCI100", 80);
        nicolas.setAdress("2114 Burnaby Street");
    }

    public void setUpGyuany() {
        gyunay.addClass(cpsc210);
        cpsc210.addStudent(gyunay);
        gyunay.setGradeForClass("CPSC210", 89);

        gyunay.addClass(math100);
        math100.addStudent(gyunay);
        gyunay.setGradeForClass("MATH100", 100);
        gyunay.incrementAbsecences("MATH100");

        gyunay.addClass(math101);
        math101.addStudent(gyunay);
        gyunay.setGradeForClass("MATH101", 20);
        gyunay.incrementAbsecences("MATH101");
        gyunay.incrementAbsecences("MATH101");
        gyunay.setAdress("2114 Burnaby Street");

    }

    public void setUpCarlitos() {
        carlitos.addClass(cpsc210);
        cpsc210.addStudent(carlitos);
        carlitos.setGradeForClass("CPSC210", 77);
        carlitos.incrementAbsecences("CPSC210");
        carlitos.incrementAbsecences("CPSC210");

        carlitos.addClass(math101);
        math101.addStudent(carlitos);
        carlitos.setGradeForClass("MATH101", 90);
        carlitos.incrementAbsecences("MATH101");
        carlitos.incrementAbsecences("MATH101");

        carlitos.addClass(dsci100);
        dsci100.addStudent(carlitos);
        carlitos.setGradeForClass("DSCI100", 88);
        carlitos.incrementAbsecences("DSCI100");

        carlitos.addClass(phil100);
        phil100.addStudent(carlitos);
        carlitos.setGradeForClass("PHIL100", 99);


    }

    public void setUpYotas() {
        yotas.addClass(cpsc121);
        cpsc121.addStudent(yotas);
        yotas.setGradeForClass("CPSC121", 18);
        yotas.incrementAbsecences("CPSC121");
        yotas.incrementAbsecences("CPSC121");
        yotas.incrementAbsecences("CPSC121");

        yotas.addClass(cpsc210);
        cpsc210.addStudent(yotas);
        yotas.setGradeForClass("CPSC210", 87);
        yotas.incrementAbsecences("CPSC210");

        yotas.addClass(math101);
        math101.addStudent(yotas);
        yotas.setGradeForClass("MATH101", 88);
        yotas.incrementAbsecences("MATH101");

        yotas.addClass(dsci100);
        dsci100.addStudent(yotas);
        yotas.setGradeForClass("DSCI100",90);
        yotas.incrementAbsecences("DSCI100");

        yotas.addClass(phil100);
        phil100.addStudent(yotas);
        yotas.setGradeForClass("PHIL100", 78);
        yotas.incrementAbsecences("PHIL100");
        yotas.incrementAbsecences("PHIL100");


    }

    public void setTeachers() {
        cpsc110.setTeacher(gregor);
        cpsc121.setTeacher(tien);
        cpsc210.setTeacher(steven);
        math101.setTeacher(eulogio);
        math100.setTeacher(eulogio);
        dsci100.setTeacher(anthony);
        phil100.setTeacher(jhonathan);
    }


    public ManagmentSystem() {
        setUpNicolas();
        setUpGyuany();
        setUpCarlitos();
        setUpYotas();
        setTeachers();
        runManagementSystem();

    }

    public void runManagementSystem() {
        Scanner myScanner = new Scanner(System.in);
        boolean continuing = true;
        System.out.println("Hello, please insert you id:");
        while (continuing) {
            int id = myScanner.nextInt();
            System.out.println("Please now insert you Password");
            String password = myScanner.next();
            if (Student.checkLogin(id, password)) {
                continuing = false;
                studentMenu(id);
            } else if (Teacher.checkLogin(id, password)) {
                continuing = false;
                teacherMenu(id);
            } else {
                System.out.println("Sorry the information you put again was wrong, please try again");
            }

        }
    }

    public void printingForStudentMenu() {
        System.out.println("What would you like to do");
        System.out.println("To see you grades write A");
        System.out.println("To drop or add classes press B");
        System.out.println("To edit your information press C");
        System.out.println("To log out press D");
    }


    //inspired by StackOverFlow:
    // https://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
    public void printingAnArray(Object[][] currentArray) {
        for (int i = 0; i < currentArray.length;i++) {
            System.out.println(Arrays.deepToString(currentArray[i]));
        }

    }

    public void studentMenu(int id) {
        Student currentStudent = Student.getStudent(id);
        System.out.println("Welcome " + currentStudent.getFn() + " " + currentStudent.getLn());
        Scanner myScanner = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            printingForStudentMenu();
            String option = myScanner.next();
            if (option.equals("A")) {
                condition = false;
                seeGrades(id);
            } else if (option.equals("B")) {
                condition = false;
                addOrDropClasses(id);
            } else if (option.equals("C")) {
                condition = false;
                editInformation(id);
            } else if (option.equals("D")) {
                condition = false;
                runManagementSystem();
            }

        }

    }

    public void seeGrades(int id) {
        Student currentStudent = Student.getStudent(id);
        System.out.println("Welcome " + currentStudent.getFn() + ", here is you grades");
        Object[][] currentGrades = currentStudent.arrayGrades();
        printingAnArray(currentGrades);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter any key to go back");
        String option = myScanner.next();
        if (option != "") {
            studentMenu(id);
        } else {
            seeGrades(id);
        }
    }

    public void addOrDropClasses(int id) {
        Student currentStudent = Student.getStudent(id);
        System.out.println("Hello " + currentStudent.getFn() + ", here is the list of classes available");
        Object[][] listOfClasses = AcademyClass.informationDisplay();
        printingAnArray(listOfClasses);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Do you wanna register any class, press y for add, or d for drop or n for no");
        String option = myScanner.next();
        if (option.equals("y")) {
            registeringAClass(id);
        } else if (option.equals("d")) {
            dropppingAClass(id);
        } else {
            System.out.println("Okay, please enter any key to go back");
            String option2 = myScanner.next();
            if (option2 != "") {
                studentMenu(id);
            }
        }

    }

    public void sendingTheStudnetBakc(int id) {
        System.out.println("Please press any key to go back");
        Scanner myScanner = new Scanner(System.in);
        String gettingout1 = myScanner.next();
        if (gettingout1 != "") {
            addOrDropClasses(id);
        }
    }

    public void registeringAClass(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the id of the class or -1 to go back");
        int idOfTheClass = myScanner.nextInt();
        if (idOfTheClass >= 0) {
            AcademyClass classSelected = AcademyClass.findClass(idOfTheClass);
            if (classSelected == null) {
                System.out.println("Sorry that class does not exist");
                sendingTheStudnetBakc(id);

            } else if (currentStudent.hasClass(classSelected.getName())) {
                System.out.println("You already registered for this Class");
                sendingTheStudnetBakc(id);
            } else {
                System.out.println("Registering you for the class");
                currentStudent.addClass(classSelected);
                classSelected.addStudent(currentStudent);
                sendingTheStudnetBakc(id);
            }
        } else {
            sendingTheStudnetBakc(id);
        }
    }

    public void dropppingAClass(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter the id of the class you wanna drop");
        int classId = myScanner.nextInt();
        AcademyClass currentClass = AcademyClass.findClass(classId);
        if (classId < 0) {
            System.out.println("Sorry the id is invalid");
            sendingTheStudnetBakc(id);
        } else if (!currentStudent.hasClass(currentClass.getName())) {
            System.out.println("Sorry you are not register for that class");
            sendingTheStudnetBakc(id);
        } else {
            System.out.println("Dropping the class");
            currentClass.deleteStudent(currentStudent.getID());
            currentStudent.removeClass(currentClass.getName());
            sendingTheStudnetBakc(id);
        }
    }

    public void printingStudentInfo(int id) {
        Student currentStudent = Student.getStudent(id);
        System.out.println("First Name: " + currentStudent.getFn());
        System.out.println("Last Name: " + currentStudent.getLn());
        System.out.println("Id:" + currentStudent.getID());
        System.out.println("Adress: " + currentStudent.getAdress());
        System.out.println("Number of Classes " + currentStudent.getNumOfClasses());
        System.out.println("To edit your First Name put A");
        System.out.println("To edit your Last Name put B");
        System.out.println("To edit your address put C");
        System.out.println("To change your password put D");
        System.out.println("To go back put anything else");

    }

    public void editInformation(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Printing all your information");
        printingStudentInfo(id);
        String option = myScanner.next();
        if (option.equals("A")) {
            editFirstName(id);
        } else if (option.equals("B")) {
            editLastName(id);
        } else if (option.equals("C")) {
            editAdress(id);
        } else if (option.equals("D")) {
            changePassworld(id);
        } else {
            System.out.println("Press any key to back");
            String option2 = myScanner.next();
            if (option2 != "") {
                studentMenu(id);
            }
        }
    }

    public void goBackToEdit(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            editInformation(id);
        }
    }

    public void editFirstName(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new first Name");
        String fn = myScanner.next();
        currentStudent.setFn(fn);
        goBackToEdit(id);
    }

    public void editLastName(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new Last Name");
        String ln = myScanner.next();
        currentStudent.setLn(ln);
        goBackToEdit(id);
    }

    public void editAdress(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new Adress");
        String adress = myScanner.next();
        currentStudent.setAdress(adress);
        goBackToEdit(id);
    }

    public void changePassworld(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please insert your last Password");
        String lastPassword = myScanner.next();
        System.out.println("Please insert your new Password");
        String newPassword = myScanner.next();
        if (currentStudent.changePassword(lastPassword, newPassword)) {
            System.out.println("Password changed");
            goBackToEdit(id);
        } else {
            System.out.println("Password change failed");
            System.out.println("If you want to try again Press A, otherwise press any key");
            String option2 = myScanner.next();
            if (option2.equals("A")) {
                changePassworld(id);
            } else {
                editInformation(id);
            }
        }

    }

    public void displyOptions() {
        System.out.println("To see your classes type A");
        System.out.println("To add or drop a student to one of you classes B");
        System.out.println("To set a grade for a student in one of the classes press C ");
        System.out.println("To create a student Press D");
        System.out.println("To edit your information Press E");
        System.out.println("To logout just press any other key");
    }

    public void teacherMenu(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Welcome Dr " + currentTeacher.getLn());
        displyOptions();
        String option = myScanner.next();
        if (option.equals("A")) {
            seeClasses(id);
        } else if (option.equals("B")) {
            addOrDropAStudent(id);
        } else if (option.equals("C")) {
            setGradeorIncrementabsenceForStudent(id);
        } else if (option.equals("D")) {
            createStudent(id);
        } else if (option.equals("E")) {
            editInformationTeacher(id);
        } else {
            runManagementSystem();
        }
    }

    public void editInformationTeacher(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Printing all your information");
        printingTeacherInfo(id);
        String option = myScanner.next();
        if (option.equals("A")) {
            editFirstNameTeacher(id);
        } else if (option.equals("B")) {
            editLastNameTeacher(id);
        } else if (option.equals("C")) {
            changePassworldTeacher(id);
        }  else {
            System.out.println("Press any key to back");
            String option2 = myScanner.next();
            if (option2 != "") {
                teacherMenu(id);
            }
        }
    }

    public void changePassworldTeacher(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please insert your last Password");
        String lastPassword = myScanner.next();
        System.out.println("Please insert your new Password");
        String newPassword = myScanner.next();
        if (currentTeacher.setPassword(lastPassword, newPassword)) {
            System.out.println("Password changed");
            editInformationTeacher(id);
        } else {
            System.out.println("Password change failed");
            System.out.println("If you want to try again Press A, otherwise press any key");
            String option2 = myScanner.next();
            if (option2.equals("A")) {
                changePassworldTeacher(id);
            } else {
                editInformationTeacher(id);
            }
        }
    }

    public void goBackToEditTeacher(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            editInformationTeacher(id);
        }
    }

    public void editLastNameTeacher(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new Last Name");
        String ln = myScanner.next();
        currentTeacher.setLn(ln);
        goBackToEditTeacher(id);
    }


    public void editFirstNameTeacher(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new first Name");
        String fn = myScanner.next();
        currentTeacher.setfn(fn);
        goBackToEditTeacher(id);
    }


    public void printingTeacherInfo(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        System.out.println("First Name: " + currentTeacher.getFn());
        System.out.println("Last Name: " + currentTeacher.getLn());
        System.out.println("Id:" + currentTeacher.getId());
        System.out.println("Number of Classes " + currentTeacher.getNumClasses());
        System.out.println("To edit your First Name put A");
        System.out.println("To edit your Last Name put B");
        System.out.println("To change your password put C");
        System.out.println("To go back put anything else");

    }

    public void createStudent(int idOfTeacher) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please insert the id of the student");
        int id = getAGoodId();
        System.out.println("Please insert First Name");
        String fn = myScanner.next();
        System.out.println("Please insert Last Name");
        String ln = myScanner.next();
        System.out.println("Please inser temporary password");
        String passworld = myScanner.next();
        Student newStudent = new Student(id, fn, ln, passworld);
        goBacktoTeacherMenu(idOfTeacher);
    }

    public int getAGoodId() {
        Scanner myScanner = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            int x = myScanner.nextInt();
            if (x >= 0 && !Student.hasId(x)) {
                return x;
            } else if (Student.hasId(x)) {
                System.out.println("The id is already taken please try again");
            } else {
                System.out.println("Please try again");
            }
        }
        return 0;
    }

    public void goBacktoTeacherMenu(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            teacherMenu(id);
        }

    }

    public void setGradeorIncrementabsenceForStudent(int id) {
        Scanner myScanner = new Scanner(System.in);
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        System.out.println("These are the current classes you have");
        Object[][] arrayOfIdClasses = currentTeacher.listOfClassesId();
        printingAnArray(arrayOfIdClasses);
        System.out.println("Please put the id of the class were you want set a grade for a student");
        System.out.println("To go back input -1");
        int idOfClass = myScanner.nextInt();
        if (idOfClass == -1) {
            teacherMenu(id);
        } else if (checkIfItHasId(arrayOfIdClasses,idOfClass)) {
            settinGrade(id, idOfClass);
        } else {
            System.out.println("Sorry that was an invalid id");
            System.out.print("To continue in this setting grades");
            System.out.println(" and absences enter A otherwise enter any other key");
            String option = myScanner.next();
            if (option.equals("A")) {
                setGradeorIncrementabsenceForStudent(id);
            } else {
                teacherMenu(id);
            }
        }

    }

    public void goBacktoIncrementAbscences(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            setGradeorIncrementabsenceForStudent(id);
        }
    }

    public void settinGrade(int idOfTeacher, int idOfClass) {
        Scanner myScanner = new Scanner(System.in);
        AcademyClass currentClass = AcademyClass.findClass(idOfClass);
        System.out.println(currentClass.getName());
        printingAnArray(currentClass.gradesforClass());
        System.out.println("Enter the id of the student");
        int idOfStudent = myScanner.nextInt();
        Student currentStudent = Student.getStudent(idOfStudent);
        if (currentClass.hasStudent(idOfStudent)) {
            finalsettingGrade(idOfTeacher, idOfStudent, idOfClass);
        } else if (Student.hasId(idOfStudent)) {
            System.out.println("This is student is not register for this class");
            goBacktoIncrementAbscences(idOfTeacher);
        } else if (!Student.hasId(idOfStudent)) {
            System.out.println("This Student does not exist");
            goBacktoIncrementAbscences(idOfTeacher);
        }

    }

    public void finalsettingGrade(int idOfTeacher, int idOfStudent, int isOfClass) {
        Scanner myScanner = new Scanner(System.in);
        Student currentStudent = Student.getStudent(idOfStudent);
        AcademyClass currentClass = AcademyClass.findClass(isOfClass);
        System.out.println("Please enter G for setting the grade or enter A for absences");
        System.out.println("Any other key will send you back");
        String option = myScanner.next();
        if (option.equals("G")) {
            System.out.println("Please input the grade");
            int grade = gettingAGoodValue();
            currentStudent.setGradeForClass(currentClass.getName(), grade);
            System.out.println("Grade Set");
            goBacktoIncrementAbscences(idOfTeacher);
        } else if (option.equals("A")) {
            System.out.println("Please input the number of absences ");
            int abscenses = gettingAGoodValue();
            for (int i = 0;i < abscenses;i++) {
                currentStudent.incrementAbsecences(currentClass.getName());
            }
            System.out.println("Absences Set");
            goBacktoIncrementAbscences(idOfTeacher);

        }
    }

    public int gettingAGoodValue() {
        Scanner myScanner = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            int x = myScanner.nextInt();
            if (x >= 0 && 100 >= x) {
                return x;
            } else {
                System.out.println("Please put a valid Number");
            }
        }
        return 0;
    }

    public void goBackFromSeeClasses(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("To continue looking at statistic enter A, otherwise press any key");
        String option = myScanner.next();
        if (option.equals("A")) {
            seeClasses(id);
        } else {
            goBacktoTeacherMenu(id);
        }
    }

    public void addOrDropAStudent(int id) {
        Scanner myScanner = new Scanner(System.in);
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        System.out.println("These are the current classes you have");
        Object[][] arrayOfIdClasses = currentTeacher.listOfClassesId();
        printingAnArray(arrayOfIdClasses);
        System.out.println("Please put the id of the class were you want to add the student or drop it from");
        System.out.println("To go back input -1");
        int idOfClass = myScanner.nextInt();
        if (idOfClass == -1) {
            teacherMenu(id);
        } else if (checkIfItHasId(arrayOfIdClasses,idOfClass)) {
            menuForselectingDroppingorAdding(id, idOfClass);
        } else {
            System.out.println("Sorry the index is not valid");
            System.out.println("to continue adding or dropping press A otherwise press any key");
            String option = myScanner.next();
            if (option.equals("A")) {
                addOrDropAStudent(id);
            } else {
                teacherMenu(id);
            }
        }
    }

    public void menuForselectingDroppingorAdding(int id, int idOfClass) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Press A to add a student or D to drop it from the class");
        System.out.println("Any other key will take you back to the the teachers menu");
        String option2 = myScanner.next();
        if (option2.equals("A")) {
            addAStudent(id, idOfClass);
        } else if (option2.equals("D")) {
            dropAStudent(id, idOfClass);
        } else {
            teacherMenu(id);
        }
    }

    public void goingBackToAddOrDrop(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            addOrDropAStudent(id);
        }
    }

    public void addAStudent(int idOfTeacher, int idOfClass) {
        Scanner myScanner = new Scanner(System.in);
        AcademyClass currentClass = AcademyClass.findClass(idOfClass);
        System.out.println(currentClass.getName());
        printingAnArray(currentClass.gradesforClass());
        System.out.println("Enter the id of the student");
        int idOfStudent = myScanner.nextInt();
        Student currentStudent = Student.getStudent(idOfStudent);
        if (currentClass.hasStudent(idOfStudent)) {
            System.out.println("Sorry this student is already register");
            goingBackToAddOrDrop(idOfTeacher);
        } else if (!Student.hasId(idOfStudent)) {
            System.out.println("This Student does not exist");
            goingBackToAddOrDrop(idOfTeacher);
        } else {
            System.out.println("Adding Student");
            currentClass.addStudent(currentStudent);
            currentStudent.addClass(currentClass);
            goingBackToAddOrDrop(idOfTeacher);

        }
    }

    public void dropAStudent(int idOfTeacher, int idOfClass) {
        Scanner myScanner = new Scanner(System.in);
        AcademyClass currentClass = AcademyClass.findClass(idOfClass);
        System.out.println(currentClass.getName());
        printingAnArray(currentClass.gradesforClass());
        System.out.println("Enter the id of the student");
        int idOfStudent = myScanner.nextInt();
        Student currentStudent = Student.getStudent(idOfStudent);
        if (!currentClass.hasStudent(idOfStudent)) {
            System.out.println("Sorry this student has not register for this course");
            goingBackToAddOrDrop(idOfTeacher);
        } else if (!Student.hasId(idOfStudent)) {
            System.out.println("This Student does not exist");
            goingBackToAddOrDrop(idOfTeacher);
        } else {
            System.out.println("Dropping Student");
            currentClass.deleteStudent(idOfStudent);
            currentStudent.removeClass(currentClass.getName());
            goingBackToAddOrDrop(idOfTeacher);
        }
    }

    public void seeClasses(int id) {
        Scanner myScanner = new Scanner(System.in);
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        System.out.println("These are the current Classes you have");
        Object[][] arrayOfIdClasses = currentTeacher.listOfClassesId();
        printingAnArray(arrayOfIdClasses);
        System.out.println("Put the id of the class you wanna look statistics of");
        int indexOfClass = myScanner.nextInt();
        if (checkIfItHasId(arrayOfIdClasses,indexOfClass)) {
            AcademyClass s = AcademyClass.findClass(indexOfClass);
            System.out.println("Class name: " + s.getName());
            System.out.println("Class id: " + s.getId());
            System.out.println("Class session: " + s.getSession());
            System.out.println("Class Teacher: " + s.getTeacher().getFn() + " " + s.getTeacher().getLn());
            System.out.println("Number of students: " + s.getNumOfStudents());
            System.out.println("Class average grade: " + s.getAverageGrade());
            printingAnArray(s.gradesforClass());
            goBackFromSeeClasses(id);
        } else {
            System.out.println("Sorry that was an invalid id");
            goBackFromSeeClasses(id);
        }
    }

    public boolean checkIfItHasId(Object[][] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if ((Object)x == array[i][1]) {
                return true;
            }
        }
        return false;
    }


}
