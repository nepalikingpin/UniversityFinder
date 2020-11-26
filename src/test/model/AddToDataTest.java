package model;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddToDataTest {

    @Test
    public void addToDataTest() {
        DataChoices dataChoices = new DataChoices("", "", "", "");
        ArrayList<DataChoices> list = new ArrayList<>();

        AddToData atd = new AddToData(list);

        DataChoices temp = (DataChoices) list.get(0);

        assertEquals("esports", temp.getInterests());
        assertEquals("psychology", temp.getMajor());
        assertEquals("canada", temp.getLocation());
        assertEquals("University of British Columbia https://www.ubc.ca/" + "\n"
                + "Location: Vancouver, Canada" + "\n"
                + "World Ranking: 45 (2021)", temp.getUniversity());


    }

}
