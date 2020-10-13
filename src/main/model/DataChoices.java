package model;

public class DataChoices extends Choices {
    private String university;

    //MODIFIES: this
    //EFFECTS: creates a DataChoices object, and sets interests, major, location and university equal to the passed
    // values
    public DataChoices(String interests, String major, String location, String university) {
        this.interests = interests;
        this.major = major;
        this.location = location;
        this.university = university;
    }

    //EFFECTS: returns name of the university
    public String getUniversity() {
        return university;
    }

}

