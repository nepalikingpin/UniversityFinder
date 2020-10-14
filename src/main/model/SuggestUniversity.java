package model;

import java.util.ArrayList;

import static java.lang.Integer.min;

//Class to suggest the university to user, if the interests or major or location of the UserChoices object in userlist
// are the same as DataChoices object in the dataList

public class SuggestUniversity {
    private ChoicesList<Object> userList;
    private ArrayList<Object> dataList;

    //MODIFIES: this
    //EFFECTS: creates a SuggestUniversity object and assigns userList and dataList
    public SuggestUniversity(ChoicesList<Object> userList, ArrayList<Object> dataList) {
        this.userList = userList;
        this.dataList = dataList;
    }

    //EFFECTS: compares interests, major and location of userList object with every object in dataList; and prints
    // out the related university if the match is found
    public String suggestion() {
        ArrayList<String> suggestionList = new ArrayList<>();
        String universities = "";
        for (int i = 0; i < userList.size(); i++) {
            UserChoices userTemp = (UserChoices) userList.get(i);

            for (Object data : dataList) {
                DataChoices dataTemp = (DataChoices) data;

                if (userTemp.getInterests().equals(dataTemp.getInterests())
                        || userTemp.getMajor().equals(dataTemp.getMajor())
                        || userTemp.getLocation().equals(dataTemp.getLocation())) {

                    if (!universities.contains(dataTemp.getUniversity())) {
                        suggestionList.add(((DataChoices) data).getUniversity());
                    }
                }
            }
        }
        if (!suggestionList.isEmpty()) {
            for (int i = 0; i < min(suggestionList.size(), 5); i++) {
                universities += suggestionList.get(i) + "\n";
            }
            return universities;
        } else {
            return "Sorry, cannot find any universities";
        }
    }
}

