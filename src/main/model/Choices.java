package model;

public abstract class Choices {
    protected String interests;
    protected String major;
    protected String location;

    public String getInterests() {
        return interests;
    }

    public String getMajor() {
        return major;
    }

    public String getLocation() {
        return location;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
