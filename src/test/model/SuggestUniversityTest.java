//package model;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
////Class to test Suggest University
//public class SuggestUniversityTest {
//
//    @Test
//    public void SuggestNoUniversityTest() {
//        ChoicesList<UserChoices> userList = new ChoicesList<>();
//        ArrayList<DataChoices> dataList = new ArrayList<>();
//
//        userList.add(new UserChoices("gaming", "cs", "canada"));
//        dataList.add((new DataChoices("robotics", "math", "usa", "UC Berkley")));
//        dataList.add((new DataChoices("robotics", "Information Technology", "india",
//                "IIT Bombay")));
//
//        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);
//
////        assertEquals(0,suggestion.suggestion().size());
//    }
//    @Test
//    public void SuggestUniversityBasedOnMajorTest() {
//        ChoicesList<UserChoices> userList = new ChoicesList<>();
//        ArrayList<DataChoices> dataList = new ArrayList<>();
//
//        userList.add(new UserChoices("gaming","math","canada"));
//        dataList.add((new DataChoices("robotics","math","usa","UC Berkley")));
//        dataList.add((new DataChoices("robotics","Information Technology","india",
//                "IIT Bombay")));
//
//        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);
//
//        assertEquals("UC Berkley" ,suggestion.suggestion().get(0));
//    }
//
//    @Test
//    public void SuggestUniversityBasedOnInterestTest() {
//        ChoicesList<UserChoices> userList = new ChoicesList<>();
//        ArrayList<DataChoices> dataList = new ArrayList<>();
//
//        userList.add(new UserChoices("gaming","math","canada"));
//        dataList.add((new DataChoices("gaming","cs","usa","UC Berkley")));
//        dataList.add((new DataChoices("robotics","Information Technology","india",
//                "IIT Bombay")));
//
//        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);
//
//        assertEquals("UC Berkley" ,suggestion.suggestion().get(0));
//    }
//
//    @Test
//    public void SuggestUniversityBasedOnLocationTest() {
//        ChoicesList<UserChoices> userList = new ChoicesList<>();
//        ArrayList<DataChoices> dataList = new ArrayList<>();
//
//        userList.add(new UserChoices("gaming","math","usa"));
//        dataList.add((new DataChoices("robotics","cs","usa","UC Berkley")));
//        dataList.add((new DataChoices("robotics","Information Technology","india",
//                "IIT Bombay")));
//
//        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);
//
////        assertEquals("UC Berkley" ,suggestion.suggestion().get(0));
//    }
//
//    @Test
//    public void SuggestUniversityBasedOnMultipleTest() {
//        ChoicesList<UserChoices> userList = new ChoicesList<>();
//        ArrayList<DataChoices> dataList = new ArrayList<>();
//
//        userList.add(new UserChoices("gaming","math","canada"));
//        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
//        dataList.add((new DataChoices("robotics","Information Technology","india",
//                "IIT Bombay")));
//
//        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);
//
////        assertEquals("UC Berkley" ,suggestion.suggestion().get(0));
//    }
//
//    @Test
//    public void SuggestUniversityBasedOnAllTest() {
//        ChoicesList<UserChoices> userList = new ChoicesList<>();
//        ArrayList<DataChoices> dataList = new ArrayList<>();
//
//        userList.add(new UserChoices("gaming","math","usa"));
//        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
//        dataList.add((new DataChoices("robotics","Information Technology","india",
//                "IIT Bombay")));
//
//        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);
//
//        assertEquals("UC Berkley" ,suggestion.suggestion().get(0));
//    }
//
//    @Test
//    public void SuggestTwoUniversitiesTest() {
//        ChoicesList<UserChoices> userList = new ChoicesList<>();
//        ArrayList<DataChoices> dataList = new ArrayList<>();
//
//        userList.add(new UserChoices("gaming","math","canada"));
//        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
//        dataList.add((new DataChoices("gaming","Information Technology","india",
//                "IIT Bombay")));
//
//        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);
//
//        assertEquals("UC Berkley" + "IIT Bombay",
//                suggestion.suggestion().get(0)+suggestion.suggestion().get(1));
//
//    }
//
//    @Test
//    public void SuggestMoreThanFiveUniversitiesTest() {
//        ChoicesList<UserChoices> userList = new ChoicesList<>();
//        ArrayList<DataChoices> dataList = new ArrayList<>();
//
//        userList.add(new UserChoices("gaming","math","canada"));
//        dataList.add((new DataChoices("gaming","math","usa","UC Berkley")));
//        dataList.add((new DataChoices("gaming","math","usa","UCSD")));
//        dataList.add((new DataChoices("gaming","math","usa","NYU")));
//        dataList.add((new DataChoices("robotics","math","usa","NYU")));
//        dataList.add((new DataChoices("gaming","math","usa","Stanford")));
//        dataList.add((new DataChoices("gaming","math","usa","UofC")));
//        dataList.add((new DataChoices("gaming","Information Technology","india",
//                "IIT Bombay")));
//
//        SuggestUniversity suggestion = new SuggestUniversity(userList, dataList);
//
//        assertEquals("UC Berkley" + "UCSD" + "NYU" + "Stanford" + "UofC"
//                ,suggestion.suggestion().get(0)+suggestion.suggestion().get(1)
//                        +suggestion.suggestion().get(2)+suggestion.suggestion().get(3)+suggestion.suggestion().get(4));
//    }
//
//
//
//}
