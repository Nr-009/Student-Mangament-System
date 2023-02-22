package ui;

import model.AcademyClass;
import model.Student;
import model.Teacher;

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


    //SECTION: Setting all the basic fields


    //Modifies: This
    //Effects: Sets the nicolas field with initial grades and absences for the classes of CPSC110, CPSC121,
    // CPSC210, AND DSCI 100. Also adds the address to the nicolas field
    public void setUpNicolas() {
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

    public void setUpGyuany() {
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

        yotas.addClass(dsci100);
        dsci100.addStudent(yotas);
        yotas.setGradeForClass("DSCI100",90);
        yotas.incrementAbsences("DSCI100");

        yotas.addClass(phil100);
        phil100.addStudent(yotas);
        yotas.setGradeForClass("PHIL100", 78);
        yotas.incrementAbsences("PHIL100");
        yotas.incrementAbsences("PHIL100");


    }

    //Modifies: This
    //Effects: Sets each teacher with the respective subject
    public void setTeachers() {
        cpsc110.setTeacher(gregor);
        gregor.addClass(cpsc110);

        cpsc121.setTeacher(tien);
        tien.addClass(cpsc121);

        cpsc210.setTeacher(steven);
        steven.addClass(cpsc210);

        math101.setTeacher(eulogio);
        eulogio.addClass(math101);

        math100.setTeacher(eulogio);
        eulogio.addClass(math100);

        dsci100.setTeacher(anthony);
        anthony.addClass(dsci100);

        phil100.setTeacher(jhonathan);
        jhonathan.addClass(phil100);
    }

    //SECTION: Login page for the school management system
    //Modifies: This
    // Effects: Runs all the initial changes to the fields and sets up the application basic features
    public ManagmentSystem() {
        setUpNicolas();
        setUpGyuany();
        setUpCarlitos();
        setUpYotas();
        setTeachers();
        runManagementSystem();

    }

    //Modifies: This
    //Effects: runs the login page for the initial login page for the management system

    public void runManagementSystem() {
        Scanner myScanner = new Scanner(System.in);
        boolean continuing = true;
        lineDivider();
        while (continuing) {
            System.out.println("Hello, please insert you id:");
            int id = gettingAInt();
            System.out.println("Please now insert you Password");
            String password = myScanner.next();
            if (Student.checkLogin(id, password)) {
                continuing = false;
                studentMenu(id);
            } else if (Teacher.checkLogin(id, password)) {
                continuing = false;
                teacherMenu(id);
            } else {
                boolean result = elseCaseForRunManagementSystem();
                if (!result) {
                    break;
                }

            }

        }
    }

    //Effects: returns an int number, while taking into account the possibility  of the user of inserting something
    //else that is not a number
    public int gettingAInt() {
        Scanner myScanner = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            try {
                int output = myScanner.nextInt();
                return output;
            } catch (Exception e) {
                System.out.println("Sorry you try to input the wrong type of data");
                System.out.println("Please try again");
                return gettingAInt();
            }

        }
        return 0;

    }

    //Effects: returns a boolean based if the user wants to continue or not using the application
    public boolean elseCaseForRunManagementSystem() {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Sorry the login was unsuccessful");
        System.out.println("To quit press Q to quit, to try again any other quiz");
        String option2 = myScanner.next();
        if (option2.equalsIgnoreCase("Q")) {
            System.out.println("Thanks for using the management System");
            return false;
        }
        lineDivider();
        return true;
    }



    //Section: Student initial menu

    //Effects: Takes the user input to choose an option
    public void studentMenu(int id) {
        Student currentStudent = Student.getStudent(id);
        lineDivider();
        System.out.println("Welcome " + currentStudent.getFn() + " " + currentStudent.getLn());
        Scanner myScanner = new Scanner(System.in);
        boolean condition = true;
        while (condition) {
            printingForStudentMenu();
            String option = myScanner.next();
            if (option.equalsIgnoreCase("A")) {
                condition = false;
                seeGrades(id);
            } else if (option.equalsIgnoreCase("B")) {
                condition = false;
                addOrDropClasses(id);
            } else if (option.equalsIgnoreCase("C")) {
                condition = false;
                editInformation(id);
            } else if (option.equalsIgnoreCase("D")) {
                condition = false;
                runManagementSystem();
            }

        }

    }

    //Effects: Prints the options for the student menu
    public void printingForStudentMenu() {
        System.out.println("What would you like to do");
        System.out.println("To see you grades write A");
        System.out.println("To drop or add classes press B");
        System.out.println("To edit your information press C");
        System.out.println("To log out press any other key");
    }

    //Effects: Prints an array of objects
    //Sources: inspired from https://stackoverflow.com/questions/409784/whats-the-simplest-way-to-print-a-java-array
    public void printingAnArray(Object[][] currentArray) {
        for (int i = 0; i < currentArray.length;i++) {
            for (int j = 0; j < currentArray[i].length; j++) {
                String x = currentArray[i][j].toString();
                System.out.print(x);
                printingWhiteSpaces(30 - x.length());
            }
            System.out.println("\n");
        }

    }

    //Effects: prints the number provided of white spaces
    public void printingWhiteSpaces(int n) {
        for (int i = 0;i < n;i++) {
            System.out.print(" ");
        }
    }

    //Effects: prints /// to divide the screens of the user
    public void lineDivider() {
        for (int i = 0; i < 100; i++) {
            System.out.print("/");
        }
        System.out.print("\n");
    }

    //Section: See grades of the students
    //Effects: Prints all the information of the student classes, grades and absences
    public void seeGrades(int id) {
        Student currentStudent = Student.getStudent(id);
        lineDivider();
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

    //Section: Add or drop classes in the Student menu

    //Effects: prints the user the information of all the classes and gives him th option to drop or add classes
    public void addOrDropClasses(int id) {
        Student currentStudent = Student.getStudent(id);
        lineDivider();
        System.out.println("Hello " + currentStudent.getFn() + ", here is the list of classes available");
        Object[][] listOfClasses = AcademyClass.informationDisplay();
        printingAnArray(listOfClasses);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Do you wanna register any class, press y for add, or d for drop, any other key to go back");
        String option = myScanner.next();
        if (option.equalsIgnoreCase("y")) {
            registeringAClass(id);
        } else if (option.equalsIgnoreCase("d")) {
            droppingAClass(id);
        } else {
            System.out.println("Okay, please enter any key to go back");
            String option2 = myScanner.next();
            if (option2 != "") {
                studentMenu(id);
            }
        }

    }


    //Modifies: This
    //Effects: if given a valid id register the student for the class
    public void registeringAClass(int id) {
        Student currentStudent = Student.getStudent(id);
        lineDivider();
        System.out.println("Please enter the id of the class or -1 to go back");
        int idOfTheClass = gettingAInt();
        if (idOfTheClass >= 0) {
            AcademyClass classSelected = AcademyClass.findClass(idOfTheClass);
            if (classSelected == null) {
                System.out.println("Sorry that class does not exist");
                sendingTheStudentBack(id);

            } else if (currentStudent.hasClass(classSelected.getName())) {
                System.out.println("You already registered for this Class");
                sendingTheStudentBack(id);
            } else {
                System.out.println("Registering you for the class");
                currentStudent.addClass(classSelected);
                classSelected.addStudent(currentStudent);
                sendingTheStudentBack(id);
            }
        } else {
            sendingTheStudentBack(id);
        }
    }

    //Modifies: This
    //Effects: If given a valid id, drops the class for teh given student
    public void droppingAClass(int id) {
        Student currentStudent = Student.getStudent(id);
        lineDivider();
        System.out.println("Please enter the id of the class you wanna drop");
        int classId = gettingAInt();
        AcademyClass currentClass = AcademyClass.findClass(classId);
        if (classId < 0) {
            System.out.println("Sorry the id is invalid");
            sendingTheStudentBack(id);
        } else if (!currentStudent.hasClass(currentClass.getName())) {
            System.out.println("Sorry you are not register for that class");
            sendingTheStudentBack(id);
        } else {
            System.out.println("Dropping the class");
            currentClass.deleteStudent(currentStudent.getID());
            currentStudent.removeClass(currentClass.getName());
            sendingTheStudentBack(id);
        }
    }

    //Effects: Returns the student to add or drop classes menu when pressing a key
    public void sendingTheStudentBack(int id) {
        System.out.println("Please press any key to go back");
        Scanner myScanner = new Scanner(System.in);
        String getting1 = myScanner.next();
        if (getting1 != "") {
            addOrDropClasses(id);
        }
    }

    //Section: Editing the information in the Student Menu

    //Effects: Menu for the student to any information of his profile
    public void editInformation(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        lineDivider();
        System.out.println("Printing all your information");
        printingStudentInfo(id);
        String option = myScanner.next();
        if (option.equalsIgnoreCase("A")) {
            editFirstName(id);
        } else if (option.equalsIgnoreCase("B")) {
            editLastName(id);
        } else if (option.equalsIgnoreCase("C")) {
            editAdress(id);
        } else if (option.equalsIgnoreCase("D")) {
            changePassword(id);
        } else {
            System.out.println("Press any key to back");
            String option2 = myScanner.next();
            if (option2 != "") {
                studentMenu(id);
            }
        }
    }

    //Effects: Returns the student back to the edit main menu if a key is pressed
    public void goBackToEdit(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            editInformation(id);
        }
    }

    //Modifies: This
    //Effects: Changes the first name of the student in question
    public void editFirstName(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new first Name");
        String fn = myScanner.next();
        currentStudent.setFn(fn);
        goBackToEdit(id);
    }

    //Modifies: This
    //Effects: Changes the lastname of the student in question
    public void editLastName(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new Last Name");
        String ln = myScanner.next();
        currentStudent.setLn(ln);
        goBackToEdit(id);
    }

    //Modifies: This
    //Effects: Changes the address of the student in question
    public void editAdress(int id) {
        Student currentStudent = Student.getStudent(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new Adress");
        String adress = myScanner.next();
        currentStudent.setAddress(adress);
        goBackToEdit(id);
    }

    //Modifies: This
    //Effects: if provided the correct password it changes the password of the student
    public void changePassword(int id) {
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
            if (option2.equalsIgnoreCase("A")) {
                changePassword(id);
            } else {
                editInformation(id);
            }
        }

    }

    //Effects: Prints all the information of the student
    public void printingStudentInfo(int id) {
        Student currentStudent = Student.getStudent(id);
        System.out.println("First Name: " + currentStudent.getFn());
        System.out.println("Last Name: " + currentStudent.getLn());
        System.out.println("Id:" + currentStudent.getID());
        System.out.println("Adress: " + currentStudent.getAddress());
        System.out.println("Number of Classes " + currentStudent.getNumOfClasses());
        System.out.println("To edit your First Name put A");
        System.out.println("To edit your Last Name put B");
        System.out.println("To edit your address put C");
        System.out.println("To change your password put D");
        System.out.println("To go back put anything else");

    }

    //Section: Main Teacher's menu
    //Effects: send the user to the correct menu based on the option they choose
    public void teacherMenu(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        lineDivider();
        System.out.println("Welcome Dr " + currentTeacher.getLn());
        displayOptions();
        choosingAnOption(id);
    }

    public void choosingAnOption(int id) {
        Scanner myScanner = new Scanner(System.in);
        String option = myScanner.next();
        if (option.equalsIgnoreCase("A")) {
            seeClasses(id);
        } else if (option.equalsIgnoreCase("B")) {
            addOrDropAStudent(id);
        } else if (option.equalsIgnoreCase("C")) {
            setGradeOrIncrementAbsencesForStudent(id);
        } else if (option.equalsIgnoreCase("D")) {
            createStudent(id);
        } else if (option.equalsIgnoreCase("E")) {
            editInformationTeacher(id);
        } else if (option.equalsIgnoreCase("F")) {
            createAClass(id);
        } else if (option.equalsIgnoreCase("G")) {
            deletingClass(id);
        } else if (option.equalsIgnoreCase("H")) {
            createATeacher(id);
        } else if (option.equalsIgnoreCase("I")) {
            deletingTeacher(id);
        } else {
            runManagementSystem();
        }
    }

    //Effects: Prints all the options available in the teachers menu
    public void displayOptions() {
        System.out.println("To see your classes type A");
        System.out.println("To add or drop a student to one of you classes B");
        System.out.println("To set a grade for a student in one of the classes press C ");
        System.out.println("To create a student Press D");
        System.out.println("To edit your information Press E");
        System.out.println("To create a class press F");
        System.out.println("To delete a class press G");
        System.out.println("To create a Teacher press H");
        System.out.println("To delete a teacher press I");
        System.out.println("To logout just press any other key");
    }

    //Section: Edit information in the teachers menu
    //Effects: send teh teacher to the correct menu based on what they want to change
    public void editInformationTeacher(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Printing all your information");
        lineDivider();
        printingTeacherInfo(id);
        String option = myScanner.next();
        if (option.equalsIgnoreCase("A")) {
            editFirstNameTeacher(id);
        } else if (option.equalsIgnoreCase("B")) {
            editLastNameTeacher(id);
        } else if (option.equalsIgnoreCase("C")) {
            changePasswordTeacher(id);
        }  else {
            System.out.println("Press any key to back");
            String option2 = myScanner.next();
            if (option2 != "") {
                teacherMenu(id);
            }
        }
    }

    //Modifies: This
    //Effects: changes the first name of the given teacher
    public void editFirstNameTeacher(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new first Name");
        String fn = myScanner.next();
        currentTeacher.setFn(fn);
        goBackToEditTeacher(id);
    }

    //Modifies: This
    //Effects: changes the lastname of the given teacher
    public void editLastNameTeacher(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your new Last Name");
        String ln = myScanner.next();
        currentTeacher.setLn(ln);
        goBackToEditTeacher(id);
    }

    //Modifies: This
    //Effects: changes the password of the teacher in question
    public void changePasswordTeacher(int id) {
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
            if (option2.equalsIgnoreCase("A")) {
                changePasswordTeacher(id);
            } else {
                editInformationTeacher(id);
            }
        }
    }

    //Effects: Prints all the information of the user
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

    //Effects: puts the teacher back to the edit menu
    public void goBackToEditTeacher(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            editInformationTeacher(id);
        }
    }

    //Section: create student menu for the teacher

    //Modifies: This
    //Effects: Creates a new student and adds it to the system
    public void createStudent(int idOfTeacher) {
        Scanner myScanner = new Scanner(System.in);
        lineDivider();
        System.out.println("Please insert the id of the student");
        int id = getAGoodId();
        System.out.println("Please insert First Name");
        String fn = myScanner.next();
        System.out.println("Please insert Last Name");
        String ln = myScanner.next();
        System.out.println("Please insert temporary password");
        String passworld = myScanner.next();
        Student newStudent = new Student(id, fn, ln, passworld);
        goBackToTheTeacherMenu(idOfTeacher);
    }

    //Effects: returns an id that has not been used
    public int getAGoodId() {
        boolean condition = true;
        while (condition) {
            int x = gettingAInt();
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

    //Effects: pus the teacher back to the main teacher manu
    public void goBackToTheTeacherMenu(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            teacherMenu(id);
        }

    }

    //Section: set grade or increment absences for the teacher

    //Effects: send the teacher to correct menu for either set a grade, increment the absence of a student, or go
    //back
    public void setGradeOrIncrementAbsencesForStudent(int id) {
        Scanner myScanner = new Scanner(System.in);
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        lineDivider();
        System.out.println("These are the current classes you have");
        Object[][] arrayOfIdClasses = currentTeacher.listOfClassesId();
        printingAnArray(arrayOfIdClasses);
        miniMessageForGradeIncrementForStudent();
        int idOfClass = gettingAInt();
        if (idOfClass == -1) {
            teacherMenu(id);
        } else if (checkIfItHasId(arrayOfIdClasses,idOfClass)) {
            settingGrade(id, idOfClass);
        } else {
            System.out.println("Sorry that was an invalid id");
            System.out.print("To continue in this setting grades");
            System.out.println(" and absences enter A otherwise enter any other key");
            String option = myScanner.next();
            if (option.equalsIgnoreCase("A")) {
                setGradeOrIncrementAbsencesForStudent(id);
            } else {
                teacherMenu(id);
            }
        }

    }

    //Effects: prints to line needed for the main menu of setting a grade or an absence for the teachers menu
    public void miniMessageForGradeIncrementForStudent() {
        System.out.println("Please put the id of the class were you want set a grade for a student");
        System.out.println("To go back input -1");
    }


    //Effects: goes back to the main menu of incrementing absences or setting grades
    public void goBackToIncrementAbsencesOrSetGrade(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            setGradeOrIncrementAbsencesForStudent(id);
        }
    }

    //Effects: send the teacher to the final menu for setting a grade
    public void settingGrade(int idOfTeacher, int idOfClass) {
        AcademyClass currentClass = AcademyClass.findClass(idOfClass);
        lineDivider();
        System.out.println(currentClass.getName());
        printingAnArray(currentClass.gradesForClass());
        System.out.println("Enter the id of the student");
        int idOfStudent = gettingAInt();
        if (currentClass.hasStudent(idOfStudent)) {
            finalSettingGrade(idOfTeacher, idOfStudent, idOfClass);
        } else if (Student.hasId(idOfStudent)) {
            System.out.println("This is student is not register for this class");
            goBackToIncrementAbsencesOrSetGrade(idOfTeacher);
        } else if (!Student.hasId(idOfStudent)) {
            System.out.println("This Student does not exist");
            goBackToIncrementAbsencesOrSetGrade(idOfTeacher);
        }

    }

    //Modifies: This
    //Effects: Sets the correct grade for the student
    public void finalSettingGrade(int idOfTeacher, int idOfStudent, int isOfClass) {
        Scanner myScanner = new Scanner(System.in);
        Student currentStudent = Student.getStudent(idOfStudent);
        AcademyClass currentClass = AcademyClass.findClass(isOfClass);
        lineDivider();
        System.out.println("Please enter G for setting the grade or enter A for absences");
        System.out.println("Any other key will send you back");
        String option = myScanner.next();
        if (option.equalsIgnoreCase("G")) {
            System.out.println("Please input the grade");
            int grade = gettingAGoodValue();
            currentStudent.setGradeForClass(currentClass.getName(), grade);
            System.out.println("Grade Set");
            goBackToIncrementAbsencesOrSetGrade(idOfTeacher);
        } else if (option.equalsIgnoreCase("A")) {
            System.out.println("Please input the number of absences ");
            int absences = gettingAGoodValue();
            for (int i = 0;i < absences;i++) {
                currentStudent.incrementAbsences(currentClass.getName());
            }
            System.out.println("Absences Set");
            goBackToIncrementAbsencesOrSetGrade(idOfTeacher);

        }
    }

    //Effects: Returns a good number for setting a grade or absence
    public int gettingAGoodValue() {
        boolean condition = true;
        while (condition) {
            int x = gettingAInt();
            if (x >= 0 && 100 >= x) {
                return x;
            } else {
                System.out.println("Please put a valid Number");
            }
        }
        return 0;
    }

    //Section: adding or dropping a student

    //Effects: send the teacher to the correct menu of adding or dropping if the teacher put a valid index
    public void addOrDropAStudent(int id) {
        Scanner myScanner = new Scanner(System.in);
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        lineDivider();
        System.out.println("These are the current classes you have");
        Object[][] arrayOfIdClasses = currentTeacher.listOfClassesId();
        printingAnArray(arrayOfIdClasses);
        System.out.println("Please put the id of the class were you want to add the student or drop it from");
        System.out.println("To go back input -1");
        int idOfClass = gettingAInt();
        if (idOfClass == -1) {
            teacherMenu(id);
        } else if (checkIfItHasId(arrayOfIdClasses,idOfClass)) {
            menuForSelectingDroppingOrAdding(id, idOfClass);
        } else {
            System.out.println("Sorry the index is not valid");
            System.out.println("to continue adding or dropping press A otherwise press any key");
            String option = myScanner.next();
            if (option.equalsIgnoreCase("A")) {
                addOrDropAStudent(id);
            } else {
                teacherMenu(id);
            }
        }
    }

    //Effects: Send the teacher to the menu for adding a student or for deleting the student
    public void menuForSelectingDroppingOrAdding(int id, int idOfClass) {
        Scanner myScanner = new Scanner(System.in);
        lineDivider();
        System.out.println("Press A to add a student or D to drop it from the class");
        System.out.println("Any other key will take you back to the the teachers menu");
        String option2 = myScanner.next();
        if (option2.equalsIgnoreCase("A")) {
            addAStudent(id, idOfClass);
        } else if (option2.equalsIgnoreCase("D")) {
            dropAStudent(id, idOfClass);
        } else {
            teacherMenu(id);
        }
    }

    //Modifies: This
    //Effects: adds a student to a given class of the current teacher, if the student is already register or
    //the id is invalid you can try again, or it can send you back to the add or drop main menu
    public void addAStudent(int idOfTeacher, int idOfClass) {
        AcademyClass currentClass = AcademyClass.findClass(idOfClass);
        lineDivider();
        System.out.println(currentClass.getName());
        printingAnArray(currentClass.gradesForClass());
        System.out.println("These are all the students present in the system");
        printingAnArray(Student.arrayAllStudents());
        System.out.println("Enter the id of the student");
        int idOfStudent = gettingAInt();
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

    //Modifies: This
    //Effects:  Drops the student of teh current class if the student is register for it otherwise you can try again or
    //it returns you to the main add or drop menu
    public void dropAStudent(int idOfTeacher, int idOfClass) {
        AcademyClass currentClass = AcademyClass.findClass(idOfClass);
        lineDivider();
        System.out.println(currentClass.getName());
        printingAnArray(currentClass.gradesForClass());
        System.out.println("Enter the id of the student");
        int idOfStudent = gettingAInt();
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

    //Effects: send the teacher back to the main edit menu
    public void goingBackToAddOrDrop(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please press any key to go back");
        String option = myScanner.next();
        if (option != "") {
            addOrDropAStudent(id);
        }
    }

    //Section: See classes for the teachers menu

    //Effects: displays the main statistics of the classes a teacher has, if invalid id the teacher can try again,
    //or it sends you back to the main menu
    public void seeClasses(int id) {
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        lineDivider();
        System.out.println("These are the current Classes you have");
        Object[][] arrayOfIdClasses = currentTeacher.listOfClassesId();
        printingAnArray(arrayOfIdClasses);
        System.out.println("Put the id of the class you wanna look statistics of");
        int indexOfClass = gettingAInt();
        lineDivider();
        if (checkIfItHasId(arrayOfIdClasses,indexOfClass)) {
            AcademyClass s = AcademyClass.findClass(indexOfClass);
            System.out.println("Class name: " + s.getName());
            System.out.println("Class id: " + s.getId());
            System.out.println("Class session: " + s.getSession());
            System.out.println("Class Teacher: " + s.getTeacher().getFn() + " " + s.getTeacher().getLn());
            System.out.println("Number of students: " + s.getNumOfStudents());
            System.out.println("Class average grade: " + s.getAverageGrade());
            printingAnArray(s.gradesForClass());
            goBackFromSeeClasses(id);
        } else {
            System.out.println("Sorry that was an invalid id");
            goBackFromSeeClasses(id);
        }
    }

    //Effects: returns true if the teacher has the given class based on its id
    public boolean checkIfItHasId(Object[][] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if ((Object)x == array[i][1]) {
                return true;
            }
        }
        return false;
    }

    //Effects: returns the teacher to the main teachers menu or to see again to see their statistics
    public void goBackFromSeeClasses(int id) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("To continue looking at statistic enter A, otherwise press any key");
        String option = myScanner.next();
        if (option.equalsIgnoreCase("A")) {
            seeClasses(id);
        } else {
            goBackToTheTeacherMenu(id);
        }
    }

    //Section creating a Class
    //Modifies: This
    //Effects: Creates a class and adds it to the system
    public void createAClass(int id) {
        lineDivider();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("These are all the classes that are currently in the system");
        Object[][] allClasses = AcademyClass.informationDisplay();
        printingAnArray(allClasses);
        System.out.println("To create a class press any key to go back press q");
        String option = myScanner.next();
        if (!option.equalsIgnoreCase("Q")) {
            System.out.println("Please insert the Name of the Class");
            String name = myScanner.next();
            Teacher validTeacher = choosingAGoodTeacher(id);
            System.out.println("Please insert the session for teh Class");
            String session = myScanner.next();
            AcademyClass newClass = new AcademyClass(name, validTeacher, session);
            System.out.println("Class Created");
            System.out.println("Class has the id of " + newClass.getId());
            System.out.println("Press any key to go back");
            String option4 = myScanner.next();
            teacherMenu(id);
        } else {
            teacherMenu(id);
        }

    }

    //Effects: returns a teacher based on the choosing of the user
    public Teacher choosingAGoodTeacher(int idOfTeacherChoosing) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Will you be teaching the class? Pres y for yes, any other for no");
        String option2 = myScanner.next();
        if (option2.equalsIgnoreCase("y")) {
            Teacher currentTeacher = Teacher.returnsTeacher(idOfTeacherChoosing);
            return currentTeacher;
        } else {
            System.out.println("Do you know the id of the one who will be teaching the class?");
            System.out.println("Pres y for yes, any other for no");
            String option3 = myScanner.next();
            if (option3.equalsIgnoreCase("y")) {
                int id = getAGoodIdTeacher();
                Teacher teacherWhoWillTeach = Teacher.returnsTeacher(id);
                return teacherWhoWillTeach;
            } else {
                return null;
            }
        }
    }

    //Effects: returns a teacher id that is valid to assign to the new class
    public int getAGoodIdTeacher() {
        boolean condition = true;
        while (condition) {
            int x = gettingAInt();
            if (x >= 0 && !Teacher.containsTeacher(x)) {
                return x;
            } else if (Student.hasId(x)) {
                System.out.println("The id is already taken please try again");
            } else {
                System.out.println("Please try again");
            }
        }
        return 0;
    }

    //Section: Delete Class
    //Modifies: This
    //Effects: Deletes a class from the teacher
    public void deletingClass(int id) {
        lineDivider();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("These are the current classes you have");
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        Object[][] currentClasses = currentTeacher.listOfClassesId();
        printingAnArray(currentClasses);
        System.out.println("Would you like to delete a class?");
        System.out.println("Press y for yes, any other key will take you back in the menu");
        String option = myScanner.next();
        if (option.equalsIgnoreCase("y")) {
            int idForClass = getAValidIdForClass(id);
            if (idForClass == -1) {
                teacherMenu(id);
            }
            AcademyClass.removeClass(idForClass);
            System.out.println("Deleting the Class");
            teacherMenu(id);
            System.out.println("Press any key to go back");
            String option2 = myScanner.next();
            teacherMenu(id);
        }
        teacherMenu(id);

    }

    //Effects: returns a valid class id to be deleted for the current teacher
    public int getAValidIdForClass(int id) {
        System.out.println("Please insert an id for the class you want to delete");
        System.out.println("Insert -1 if you want to go back");
        boolean condition = true;
        Teacher currentTeacher = Teacher.returnsTeacher(id);
        while (condition) {
            int idOfTheClass = gettingAInt();
            if (!AcademyClass.doesThisClassExist(idOfTheClass)) {
                System.out.println("This id doesn't exist please try again");
            }
            if (AcademyClass.doesThisClassExist(idOfTheClass)) {
                AcademyClass currentClass = AcademyClass.findClass(idOfTheClass);
                if (currentTeacher.isTeacherTeaching(currentClass.getName())) {
                    return idOfTheClass;
                } else {
                    System.out.println("Sorry you are not teaching this class");
                    System.out.println("You can not delete classes you do not teach");
                    System.out.println("Please Try again");
                }
            } else if (idOfTheClass == -1) {
                break;
            }
        }
        return -1;

    }

    //Section: Create a Teacher
    //Effects: prints a message required for the delete Teacher method
    public void printingMiniMessage2() {
        System.out.println("Would you like to create a new Teacher");
        System.out.println("Enter y if yes any other key will take you back to the main menu");
    }

    //Modifies: This
    //Effects: If the option is chosen it creates a new Teacher and adds it to the system
    public void createATeacher(int id) {
        lineDivider();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("These are all the teachers currently in the system");
        Object[][] arrayOfTeachers = Teacher.displayAllTeachers();
        printingAnArray(arrayOfTeachers);
        printingMiniMessage2();
        String option = myScanner.next();
        if (option.equalsIgnoreCase("Y")) {
            System.out.println("Please enter the first Name");
            String firstName = myScanner.next();
            System.out.println("Please enter the last Name");
            String lastName = myScanner.next();
            System.out.println("Please insert the id");
            int idOfNewTeacher = getAGoodIdTeacher();
            System.out.println("Please insert the password");
            String password = myScanner.next();
            Teacher newTeacher = new Teacher(firstName, lastName, idOfNewTeacher, password);
            System.out.println("Teacher Created");
            System.out.println("Please insert any key to go back");
            String option6 = myScanner.next();
            teacherMenu(id);
        }
        teacherMenu(id);

    }

    //Section: Deleting a teacher
    //Modifies: This
    //Effects:If the option is chosen it deletes a Teacher
    public void deletingTeacher(int id) {
        lineDivider();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("To delete a teacher press y, other keys will take you back to the previus menu");
        String option = myScanner.next();
        if (option.equalsIgnoreCase("y")) {
            printingAnArray(Teacher.displayAllTeachers());
            System.out.println("Please insert the id of the teacher you want to delete");
            int idToBeDeleted = getAGoodIdToBeDeleted(id);
            Teacher.removeTeacher(idToBeDeleted);
            System.out.println("Teacher deleted");
            System.out.println("Please press any key to continue");
            String option2 = myScanner.next();
        }
        teacherMenu(id);

    }

    //Modifies: This
    //Effects: returns an id valid for deleting a teacher
    public int getAGoodIdToBeDeleted(int id) {
        boolean condition = true;
        while (condition) {
            int x = gettingAInt();
            if (x >= 0 && Teacher.containsTeacher(x) && x != id) {
                return x;
            } else if (!Teacher.containsTeacher(x)) {
                System.out.println("The id does not exist");
            } else if (x == id) {
                System.out.println("this is your id you can not delete your account");
            } else {
                System.out.println("Please try again");
            }
        }
        return 0;
    }





}
