/* This Class represent a fileWriter that writes a JSON file with the object provided.
The object could be either a DataSystem, Student, Teacher or AcademyClass, depending on the method use.
The structure of FileReader and writer is based on teh repo:
https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo*/

package model;

import model.AcademyClass;
import model.DataSystem;
import model.Student;
import model.Teacher;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriter {

    private PrintWriter myWritter;
    private String fileDestination;
    private static final int SPACE = 4;

    public FileWriter(){
    }

    //Modifies: This
    //Effects: Sets teh file destination for the writer to write
    public void setFileDestination(String s) {
        this.fileDestination = s;
    }

    //Modifies: This
    //Effects: Instantiates the writer to be used, throws no File exception if destination not found
    public void  open() throws FileNotFoundException {
        myWritter =  new PrintWriter(fileDestination);
    }

    //Modifies: This
    //Effects: closes the writer
    public void close() {
        myWritter.close();
    }

    //Modifies: This
    //Effects: writes the JSON representation of the Student to the file
    public void write(Student s) {
        JSONObject currentJason = new JSONObject();
        currentJason = s.toJson();
        myWritter.print(currentJason.toString(SPACE));
        if (fileDestination.equals("data/SavedChangesDataSystem.json")) {
            Event myEvent = new Event("User saved the changes");
            EventLog myLog = EventLog.getInstance();
            myLog.logEvent(myEvent);
        }
    }

    //Modifies: This
    //Effects: writes the JSON representation of the given Teacher to the file
    public void write(Teacher s) {
        JSONObject currentJason = new JSONObject();
        currentJason = s.toJson();
        myWritter.print(currentJason.toString(SPACE));
    }

    //Modifies: This
    //Effects: writes the JSON representation of the given AcademyClass to the file
    public void write(AcademyClass s) {
        JSONObject currentJason = new JSONObject();
        currentJason = s.toJson();
        myWritter.write(currentJason.toString(SPACE));
    }

    //Modifies: This
    //Effects: writes the JSON representation of the given AcademyClass to the file
    public void write(DataSystem s) {
        JSONObject currentJason = new JSONObject();
        currentJason = s.toJson();
        myWritter.print(currentJason.toString(SPACE));
        if (fileDestination == "data/SavedChangesDataSystem.json") {
            Event currentEvent = new Event("User saved changes");
            EventLog eventlog = EventLog.getInstance();
            eventlog.logEvent(currentEvent);
        }
    }


}
