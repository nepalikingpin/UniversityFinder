package model;

import java.util.ArrayList;

public class UserChoices extends Choices {

    //MODIFIES: this
    //EFFECTS: creates a UserChoices objects and add the users interests to it
    public UserChoices(String interests, String major, String location) {
        this.interests = interests;
        this.major = major;
        this.location = location;
    }

}
