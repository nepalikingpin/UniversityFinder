package model;

import exception.NoSuggestionsException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//Class to test Suggest University
public class SuggestUniversityTest {

    @Test
    public void SuggestNoUniversityTest() {
        ChoicesList<UserChoices> userList = new ChoicesList<>();
        ArrayList<DataChoices> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming", "cs", "canada"));
        dataList.add((new DataChoices("robotics", "math", "usa", "UC Berkley")));
        dataList.add((new DataChoices("robotics", "Information Technology", "india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        try {
            suggestion.suggestion();
        } catch (NoSuggestionsException e) {
            //pass
        }
    }
    @Test
    public void SuggestUniversityBasedOnMajorTest() {
        ChoicesList<UserChoices> userList = new ChoicesList<>();
        ArrayList<DataChoices> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","canada"));
        dataList.add((new DataChoices("robotics","math","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

    }

    @Test
    public void SuggestUniversityBasedOnInterestTest() {
        ChoicesList<UserChoices> userList = new ChoicesList<>();
        ArrayList<DataChoices> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","canada"));
        dataList.add((new DataChoices("gaming","cs","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        try {
            assertEquals("UC Berkley" ,suggestion.suggestion().get(0));
        } catch (NoSuggestionsException e) {
            fail();
        }
    }

    @Test
    public void SuggestUniversityBasedOnLocationTest() {
        ChoicesList<UserChoices> userList = new ChoicesList<>();
        ArrayList<DataChoices> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","usa"));
        dataList.add((new DataChoices("robotics","cs","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        try {
            assertEquals("UC Berkley" ,suggestion.suggestion().get(0));
        } catch (NoSuggestionsException e) {
            fail();
        }
    }

    @Test
    public void SuggestUniversityBasedOnMultipleTest() {
        ChoicesList<UserChoices> userList = new ChoicesList<>();
        ArrayList<DataChoices> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","canada"));
        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        try {
            assertEquals("UC Berkley" ,suggestion.suggestion().get(0));
        } catch (NoSuggestionsException e) {
            fail();
        }
    }

    @Test
    public void SuggestUniversityBasedOnAllTest() {
        ChoicesList<UserChoices> userList = new ChoicesList<>();
        ArrayList<DataChoices> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","usa"));
        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        try {
            assertEquals("UC Berkley" ,suggestion.suggestion().get(0));
        } catch (NoSuggestionsException e) {
            fail();
        }
    }

    @Test
    public void SuggestTwoUniversitiesTest() {
        ChoicesList<UserChoices> userList = new ChoicesList<>();
        ArrayList<DataChoices> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","canada"));
        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
        dataList.add((new DataChoices("gaming","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        try {
            assertEquals("UC Berkley" + "IIT Bombay",
                    suggestion.suggestion().get(0)+suggestion.suggestion().get(1));
        } catch (NoSuggestionsException e) {
            fail();
        }

    }

    @Test
    public void SuggestMoreThanFiveUniversitiesTest() {
        ChoicesList<UserChoices> userList = new ChoicesList<>();
        ArrayList<DataChoices> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","canada"));
        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
        dataList.add((new DataChoices("gaming","math","usa","UCSD")));
        dataList.add((new DataChoices("gaming","math","usa","NYU")));
        dataList.add((new DataChoices("robotics","math","usa","NYU")));
        dataList.add((new DataChoices("gaming","math","usa","Stanford")));
        dataList.add((new DataChoices("gaming","math","usa","UofC")));
        dataList.add((new DataChoices("gaming","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        try {
            assertEquals("UC Berkley" + "UCSD" + "NYU" + "Stanford" + "UofC"
                    ,suggestion.suggestion().get(0)+suggestion.suggestion().get(1)
                            +suggestion.suggestion().get(2)+suggestion.suggestion().get(3)+suggestion.suggestion().get(4));
        } catch (NoSuggestionsException e) {
            fail();
        }
    }


}
