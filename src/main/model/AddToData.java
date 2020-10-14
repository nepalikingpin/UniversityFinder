package model;

import java.util.List;

public class AddToData {

    //MODIFIES: list
    //EFFECTS: creates a DataChoices object and adds it to list
    public AddToData(DataChoices dc, List<Object> list) {

        list.add(new DataChoices("esports", "psychology", "canada",
                "University of British Columbia https://www.ubc.ca/" + "\n"
                        + "Location: Vancouver, Canada" + "\n"
                        + "World Ranking: 45 (2021)"));
        list.add(new DataChoices("robotics", "cs", "canada",
                "University of Toronto https://www.utoronto.ca/" + "\n"
                        + "Location: Toronto, Canada" + "\n"
                        + "World Ranking: 25 (2021)"));
        list.add(new DataChoices("sports", "math", "usa",
                "UC Berkley https://www.berkeley.edu/" + "\n"
                        + "Location: California, USA" + "\n"
                        + "World Ranking: 30 (2021)"));
        list.add(new DataChoices("research", "engineering", "india",
                "Indian Institute of Science https://www.iisc.ac.in/" + "\n"
                        + "Location: Bengaluru, India" + "\n"
                        + "World Ranking: 185 (2021)"));
        list.add(new DataChoices("painting", "arts", "canada",
                "Indian Institute of Science https://www.iisc.ac.in/" + "\n"
                        + "Location: Bengaluru, India" + "\n"
                        + "World Ranking: 185 (2021)"));
    }
}
