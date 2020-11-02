package persistence;

// Code partly taken from JsonSerializationDemo

import org.json.JSONObject;

//Represents interface return this as a Json Object
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
