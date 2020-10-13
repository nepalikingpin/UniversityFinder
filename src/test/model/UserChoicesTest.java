package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserChoicesTest {

    @Test
    public void getInterestsTest() {
        UserChoices userChoices = new UserChoices("gaming", "cs", "canada");
        assertEquals("gaming",userChoices.getInterests());
    }

    @Test
    public void getMajorTest() {
        UserChoices userChoices = new UserChoices("gaming", "cs", "canada");
        assertEquals("cs",userChoices.getMajor());
    }

    @Test
    public void getLocationTest() {
        UserChoices userChoices = new UserChoices("gaming", "cs", "canada");
        assertEquals("canada",userChoices.getLocation());
    }

}
