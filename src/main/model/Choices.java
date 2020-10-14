package model;

//Abstract class Choices, extended by User and Data Choices classes. The choices object has protected elements
// interests, major and location. Also has the getter methods for these variables.

public abstract class Choices {
    protected String interests;
    protected String major;
    protected String location;

    //EFFECTS: returns interests of the current object
    public String getInterests() {
        return interests;
    }

    //EFFECTS: returns major of the current object
    public String getMajor() {
        return major;
    }

    //EFFECTS: returns location of the current object
    public String getLocation() {
        return location;
    }
}
