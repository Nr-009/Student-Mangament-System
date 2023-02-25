package persistance;

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
        myWritter.print(currentJason.toString());
    }

    //Modifies: This
    //Effects: writes the JSON representation of the given Teacher to the file
    public void write(Teacher s) {
        JSONObject currentJason = new JSONObject();
        currentJason = s.toJson();
        myWritter.print(currentJason.toString());
    }

    //Modifies: This
    //Effects: writes the JSON representation of the given AcademyClass to the file
    public void write(AcademyClass s) {
        JSONObject currentJason = new JSONObject();
        currentJason = s.toJson();
        myWritter.print(currentJason.toString());
    }

    //Modifies: This
    //Effects: writes the JSON representation of the given AcademyClass to the file
    public void write(DataSystem s) {
        JSONObject currentJason = new JSONObject();
        currentJason = s.toJson();
        myWritter.print(currentJason.toString());
    }






}
