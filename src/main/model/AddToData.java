package model;

import java.util.List;

public class AddToData {

    //MODIFIES: list
    //EFFECTS: creates a DataChoices object and adds it to list
    public AddToData(DataChoices dc, List<Object> list) {

        list.add(new DataChoices("esports", "cs", "canada",
                "University of British Columbia"));
        list.add(new DataChoices("esports", "cs", "canada",
                "University of Toronto"));
        list.add(new DataChoices("robotics", "math", "usa",
                "UC Berkley"));
    }
}
