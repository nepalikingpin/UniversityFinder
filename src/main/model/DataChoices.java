package model;

public class DataChoices extends Choices {
    protected String university;

    public DataChoices(String interests, String major, String location, String university) {
        this.interests = interests;
        this.major = major;
        this.location = location;
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

}

