package model;

public class UserChoices {
    private String interests;
    private String major;
    private String location;

    public UserChoices(String interests, String major, String location) {
        this.interests = interests;
        this.major = major;
        this.location = location;
    }

    public String getInterests() {
        return interests;
    }

    public String getMajor() {
        return major;
    }

    public String getLocation() {
        return location;
    }
}
