package persistence;

// Code partly taken from JsonSerializationDemo

import model.SuggestUniversity;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonReaderTest {

    // Code partly taken from JsonSerializationDemo
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            SuggestUniversity suggestUniversity = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    // Code partly taken from JsonSerializationDemo
    @Test
    void testReaderEmptyWorkRoom() {
        JsonReader reader = new JsonReader("./data/emptySuggestions.json");
        try {
            SuggestUniversity suggestUniversity = reader.read();
            assertEquals(0, suggestUniversity.listSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // Code partly taken from JsonSerializationDemo
    @Test
    void testReaderGeneralWorkRoom() {
        JsonReader reader = new JsonReader("./data/suggestions.json");
        try {
            SuggestUniversity suggestUniversity = reader.read();
            ArrayList<String> storedSuggestions = suggestUniversity.getSuggestionList();

            assertEquals(2, storedSuggestions.size());
            assertEquals("TestVal 1", storedSuggestions.get(0));
            assertEquals("TestVal 2", storedSuggestions.get(1));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
