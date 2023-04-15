/* This Class represent a fileReader that reads JSON files and creates the object based on the given file.
The object could be either a DataSystem, Student, Teacher or AcademyClass, depending on the method use
 */


package model;

import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileReader {
    private String destination;

    //Effects: construct a given file reader for a specific destination
    public FileReader(String destination) {
        this.destination = destination;
    }

    //Effects: reads source file as string and return it
    //Method copied from the repo mention in the description
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> streamOfString = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            streamOfString.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    //Effects: reads a file where a student is written and then returns it
    //throws IO exception if there is a problem when reading the file
    public Student readStudent() throws IOException {
        String data = readFile(destination);
        JSONObject student = new JSONObject(data);
        return parseStudent(student);
    }
    
    //Effects: parses a Student from Jason Object and returns it
    public Student parseStudent(JSONObject s) {
        int id = s.getInt("id");
        List<Integer> listOfIDClasses = toListOfInt(s.getJSONArray("ListOfAllIdOfClasses"));
        String fn = s.getString("fn");
        String ln = s.getString("ln");
        String password = s.getString("password");
        String address = s.optString("address");
        List<Integer> listOfGrades = toListOfInt(s.getJSONArray("listOfGrades"));
        List<Integer> arrayOfAbscenes = toListOfInt(s.getJSONArray("listOfAbsences"));
        Student currentStudent = new Student(id, fn,ln,password,listOfGrades,arrayOfAbscenes);
        currentStudent.setAllIDOfClasses(listOfIDClasses);
        return currentStudent;
    }

    //Effects: returns a list with the same elements as the JSON array but in the List format
    public List<Integer> toListOfInt(JSONArray s) {
        List<Integer> result = new ArrayList<>();
        Stream<Object> currentList = s.toList().stream();
        currentList.forEach(m -> result.add((int) m));
        return result;
    }

    // Effects: returns AcademyClass based on the file provided
    public AcademyClass readAcademyClass() throws IOException {
        String data = readFile(destination);
        JSONObject currentData = new JSONObject(data);
        AcademyClass currentClass = parseAcademyClass(currentData);
        return currentClass;
    }

    //Effects: Creates a new AcademyClass objects that is based on the JSONObject
    public AcademyClass parseAcademyClass(JSONObject s) {
        String name = s.getString("name");
        int id = s.getInt("id");
        int idOfTeacher = s.getInt("IdTeacher");
        List<Integer> isOfAllStudents = toListOfInt(s.getJSONArray("IdsOfAllStudents"));
        String session = s.getString("session");
        AcademyClass currentClass = new AcademyClass(id,name,session);
        currentClass.setIdOfTeacher(idOfTeacher);
        currentClass.setAllIdStudent(isOfAllStudents);
        return  currentClass;
    }

    // Effects: returns AcademyClass based on the file provided
    public Teacher readTeacher() throws IOException {
        String data = readFile(destination);
        JSONObject dataObject = new JSONObject(data);
        return parseToTeacher(dataObject);
    }

    //Effects: Creates a new Teacher objects that is based on the JSONObject
    public Teacher parseToTeacher(JSONObject s) {
        String fn = s.getString("fn");
        String ln = s.getString("ln");
        int id = s.getInt("id");
        String password = s.getString("password");
        List<Integer> allIdsOfTheCurrentClass = toListOfInt(s.getJSONArray("allIdsOfTheCurrentClasses"));
        Teacher currentTeacher = new Teacher(fn,ln,id,password, false);
        currentTeacher.setAllClassesIds(allIdsOfTheCurrentClass);
        return currentTeacher;
    }

    //Effects: Returns a Data system based on the file given
    public DataSystem readDataSystem() throws IOException {
        String data = readFile(destination);
        EventLog eventlog = EventLog.getInstance();
        if (destination == "data/SavedChangesDataSystem.json") {
            Event currentEvent = new Event("User started with Saved DataSystem");
            eventlog.logEvent(currentEvent);
        } else if (destination == "data/BaseDataSystem.json") {
            Event currentEvent = new Event("User started with Original DataSystem");
            eventlog.logEvent(currentEvent);
        }
        JSONObject dataObject = new JSONObject(data);
        return parseToDataSystem(dataObject);

    }

    //Effects: returns a data system based on the JSONObjects description given
    @SuppressWarnings("methodlength")
    private DataSystem parseToDataSystem(JSONObject dataObject) {
        List<Student> allStudents = readStudentsList(dataObject.getJSONArray("ListOfAllStudents"));
        List<Integer> allIDStudents = toListOfInt(dataObject.getJSONArray("ListOfIDStudents"));
        List<String> allPasswordsStudents = toStringList(dataObject.getJSONArray("listOfPasswordStudents"));
        int counterStudents = dataObject.getInt("counterStudents");

        List<AcademyClass> allClasses = readAcademyClassList(dataObject.getJSONArray("listOfAllClasses"));
        List<Integer> allIdClasses = toListOfInt(dataObject.getJSONArray("listOfAllIdClasses"));
        int counterAcademyClass = dataObject.getInt("counterAcademyClasses");

        List<Teacher> allTeachers = readTeacherList(dataObject.getJSONArray("listOfAllTeachers"));
        List<Integer> allIdsTeachers = toListOfInt(dataObject.getJSONArray("listOfAllIdTeacher"));
        List<String> allPasswordsTeacher = toStringList(dataObject.getJSONArray("listOfAllPasswordTeachers"));
        int counterTeacher = dataObject.getInt("counterTeacher");
        DataSystem result = new DataSystem(allStudents,
                allIDStudents,
                allPasswordsStudents,
                counterStudents,
                allClasses,
                allIdClasses,
                counterAcademyClass,
                allTeachers,
                allIdsTeachers,
                allPasswordsTeacher,
                counterTeacher
                );

        Stream<Student> streamOfStudents = allStudents.stream();
        streamOfStudents.forEach(Student -> setReferencesStudents(Student,result));
        Stream<AcademyClass> streamOfAcademyClass = allClasses.stream();
        streamOfAcademyClass.forEach(AcademyClass -> setReferencesAcademyClass(AcademyClass,result));
        Stream<Teacher> streamOfTeacher = allTeachers.stream();
        streamOfTeacher.forEach(Teacher -> setReferencesTeacher(Teacher, result));

        return result;
    }

    //Modifies: DataSystem
    //Effects: Matches all the references for given student to its respective class
    private void setReferencesStudents(Student student, DataSystem dataSystem) {
        for (int classId: student.getAllIDOfClasses()) {
            student.addClasForReading(dataSystem.getAcademyClass(classId));
        }
        List<Integer> newListOfIds = new ArrayList<>();
        student.setAllIDOfClasses(newListOfIds);
    }

    //Modifies: DataSystem
    //Effects: matches all the references for the given class to each student they have and their given teacher if
    // it exits
    private void setReferencesAcademyClass(AcademyClass academyClass, DataSystem dataSystem) {
        for (int studentsId: academyClass.getAllIdStudent()) {
            academyClass.addStudentReadingFile(dataSystem.getStudent(studentsId));
        }
        List<Integer> newListOfIds = new ArrayList<>();
        if (academyClass.getIdOfTeacher() == -1) {
            academyClass.setTeacherReadingFile(null);
        } else {
            academyClass.setTeacherReadingFile(dataSystem.getTeacher(academyClass.getIdOfTeacher()));
        }
        academyClass.setIdOfTeacher(-1);
        academyClass.setAllIdStudent(newListOfIds);
    }

    //Modifies: dataSystem
    //Effects: matches all the references of the teacher to the given classes
    private void setReferencesTeacher(Teacher teacher, DataSystem dataSystem) {
        for (int classId: teacher.getAllClassesIds()) {
            teacher.addClassReadingFile(dataSystem.getAcademyClass(classId));
        }
        List<Integer> newListOfIds = new ArrayList<>();
        teacher.setAllClassesIds(newListOfIds);
    }

    //Effects: returns a list with all the students based on the JSONArray
    private List<Student> readStudentsList(JSONArray s) {
        List<Student> result = new ArrayList<>();
        for (Object jason : s) {
            JSONObject currentStudent = (JSONObject) jason;
            result.add(parseStudent(currentStudent));
        }
        return result;
    }

    //Effects: returns a list with all the Teacher based on the JSONArray
    private List<Teacher> readTeacherList(JSONArray jsonArray) {
        List<Teacher> result = new ArrayList<>();
        for (Object o : jsonArray) {
            JSONObject currentTeacher = (JSONObject) o;
            result.add(parseToTeacher(currentTeacher));
        }
        return result;
    }

    //Effects: returns a list with all the AcademyClasses based on the JSONArray
    private List<AcademyClass> readAcademyClassList(JSONArray jsonArray) {
        List<AcademyClass> result = new ArrayList<>();
        for (Object o : jsonArray) {
            JSONObject currentClass = (JSONObject) o;
            result.add(parseAcademyClass(currentClass));
        }
        return result;
    }

    //Effects: returns a list with all the strings based on the JSONArray
    private List<String> toStringList(JSONArray jsonArray) {
        List<String> result = new ArrayList<>();
        for (Object o : jsonArray) {
            String currentString = (String) o;
            result.add(currentString);
        }
        return result;
    }


}
