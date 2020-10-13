package model;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToDataTest {

    @Test
    public void addToDataTest() {
        DataChoices dataChoices = new DataChoices("", "", "", "");
        ArrayList<Object> list = new ArrayList<>();

        AddToData atd = new AddToData(dataChoices, list);

        DataChoices temp = (DataChoices) list.get(0);

        assertEquals("esports", temp.getInterests());
        assertEquals("cs", temp.getMajor());
        assertEquals("canada", temp.getLocation());
        assertEquals("University of British Columbia", temp.getUniversity());


    }

}
