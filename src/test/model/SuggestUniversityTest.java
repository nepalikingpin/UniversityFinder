package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SuggestUniversityTest {

    @Test
    public void SuggestNoUniversityTest() {
        ChoicesList<Object> userList = new ChoicesList<>();
        ArrayList<Object> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","cs","canada"));
        dataList.add((new DataChoices("robotics","math","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        assertEquals("Sorry, cannot find any universities",suggestion.suggestion());
    }
    @Test
    public void SuggestUniversityBasedOnMajorTest() {
        ChoicesList<Object> userList = new ChoicesList<>();
        ArrayList<Object> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","canada"));
        dataList.add((new DataChoices("robotics","math","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        assertEquals("UC Berkley" + "\n",suggestion.suggestion());
    }

    @Test
    public void SuggestUniversityBasedOnInterestTest() {
        ChoicesList<Object> userList = new ChoicesList<>();
        ArrayList<Object> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","canada"));
        dataList.add((new DataChoices("gaming","cs","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        assertEquals("UC Berkley" + "\n",suggestion.suggestion());
    }

    @Test
    public void SuggestUniversityBasedOnLocationTest() {
        ChoicesList<Object> userList = new ChoicesList<>();
        ArrayList<Object> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","usa"));
        dataList.add((new DataChoices("robotics","cs","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        assertEquals("UC Berkley" + "\n",suggestion.suggestion());
    }

    @Test
    public void SuggestUniversityBasedOnMultipleTest() {
        ChoicesList<Object> userList = new ChoicesList<>();
        ArrayList<Object> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","canada"));
        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        assertEquals("UC Berkley" + "\n",suggestion.suggestion());
    }

    @Test
    public void SuggestUniversityBasedOnAllTest() {
        ChoicesList<Object> userList = new ChoicesList<>();
        ArrayList<Object> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","usa"));
        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
        dataList.add((new DataChoices("robotics","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        assertEquals("UC Berkley" + "\n",suggestion.suggestion());
    }

    @Test
    public void SuggestTwoUniversitiesTest() {
        ChoicesList<Object> userList = new ChoicesList<>();
        ArrayList<Object> dataList = new ArrayList<>();

        userList.add(new UserChoices("gaming","math","canada"));
        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
        dataList.add((new DataChoices("gaming","Information Technology","india",
                "IIT Bombay")));

        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);

        assertEquals("UC Berkley" + "\n"+ "IIT Bombay" +"\n",suggestion.suggestion());

    }

    @Test
    public void SuggestMoreThanFiveUniversitiesTest() {
        ChoicesList<Object> userList = new ChoicesList<>();
        ArrayList<Object> dataList = new ArrayList<>();

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

        assertEquals("UC Berkley" + "\n"+ "UCSD" +"\n" + "NYU" + "\n"+ "Stanford" +"\n" + "UofC" +"\n"
                ,suggestion.suggestion());
    }


}
