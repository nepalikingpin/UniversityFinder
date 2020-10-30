package persistence;

import model.SuggestUniversity;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JsonWriterTest {
    @Test
    void testWriterSuggestions() {
        try {
            SuggestUniversity suggestUniversity = new SuggestUniversity();
            suggestUniversity.addTestingValues();
            JsonWriter writer = new JsonWriter("./data/suggestions.json");
            writer.open();
            writer.write(suggestUniversity);
            writer.close();

            JsonReader reader = new JsonReader("./data/suggestions.json");
            suggestUniversity = reader.read();

            ArrayList<String> storedSuggestions = suggestUniversity.getSuggestionList();

            assertEquals(2, storedSuggestions.size());
            assertEquals("TestVal 1", storedSuggestions.get(0));
            assertEquals("TestVal 2", storedSuggestions.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterEmptySuggestions() {
        try {
            SuggestUniversity suggestUniversity = new SuggestUniversity();
            JsonWriter writer = new JsonWriter("./data/emptySuggestions.json");
            writer.open();
            writer.write(suggestUniversity);
            writer.close();

            JsonReader reader = new JsonReader("./data/emptySuggestions.json");
            suggestUniversity = reader.read();

            ArrayList<String> storedSuggestions = suggestUniversity.getSuggestionList();

            assertEquals(0, storedSuggestions.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    void testWriterInvalidFile() {
        try {
            SuggestUniversity suggestUniversity = new SuggestUniversity();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }
}
