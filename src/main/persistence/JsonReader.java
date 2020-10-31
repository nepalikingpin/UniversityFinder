package persistence;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.SuggestUniversity;
import org.json.*;

// Represents a reader that reads suggestionList from SuggestUniversity as an JSON Array from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public SuggestUniversity read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSuggestUniversity(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses suggestionList, and returns it as a SuggestUniversity object
    private SuggestUniversity parseSuggestUniversity(JSONObject jsonObject) {
        SuggestUniversity  suggestUniversity = new SuggestUniversity();
        JSONArray jsonArray = jsonObject.getJSONArray("Suggested");
        for (int i = 0; i < jsonArray.length();i++) {
            suggestUniversity.addToSuggestionList(jsonArray.getString(i));
        }
        return suggestUniversity;
    }
}
