package model;

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
