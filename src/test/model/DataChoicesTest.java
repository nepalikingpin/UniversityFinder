package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataChoicesTest {

    @Test
    public void getInterestsTest() {
        DataChoices dataChoices = new DataChoices("gaming", "cs", "canada", "ubc");
        assertEquals("gaming",dataChoices.getInterests());
    }

    @Test
    public void getMajorTest() {
        DataChoices dataChoices = new DataChoices("gaming", "cs", "canada", "ubc");
        assertEquals("cs",dataChoices.getMajor());
    }

    @Test
    public void getLocationTest() {
        DataChoices dataChoices = new DataChoices("gaming", "cs", "canada", "ubc");
        assertEquals("canada",dataChoices.getLocation());
    }

    @Test
    public void getUniversityTest() {
        DataChoices dataChoices = new DataChoices("gaming", "cs", "canada", "ubc");
        assertEquals("ubc",dataChoices.getUniversity());
    }
}
