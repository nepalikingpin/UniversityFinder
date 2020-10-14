package model;

// Extends the choices class and declares the UserChoices object, which is where the user interests, major and
// location stored
public class UserChoices extends Choices {

    //MODIFIES: this
    //EFFECTS: creates a UserChoices objects and add the users interests to it
    public UserChoices(String interests, String major, String location) {
        this.interests = interests;
        this.major = major;
        this.location = location;
    }

}
