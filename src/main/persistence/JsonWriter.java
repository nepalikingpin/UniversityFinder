package persistence;

// Code partly taken from JsonSerializationDemo

import model.SuggestUniversity;
import org.json.JSONObject;

import java.io.*;

// Represents a writer that writes JSON representation of SuggestUniversity to file
public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;

    // Code partly taken from JsonSerializationDemo
    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
        this.destination = destination;
    }

    // Code partly taken from JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    // Code partly taken from JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: writes JSON representation of SuggestUniversity to file
    public void write(SuggestUniversity uniWriter) {
        JSONObject json = uniWriter.toJson();
        saveToFile(json.toString(TAB));
    }

    // Code partly taken from JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    // Code partly taken from JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
}
