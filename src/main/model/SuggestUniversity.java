package model;

import java.util.ArrayList;


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
    public void suggestion() {
        for (int i = 0; i < userList.size(); i++) {
            UserChoices userTemp = (UserChoices) userList.get(i);

            for (Object data : dataList) {
                DataChoices dataTemp = (DataChoices) data;

                if (userTemp.getInterests().equals(dataTemp.getInterests())
                        || userTemp.getMajor().equals(dataTemp.getMajor())
                        || userTemp.getLocation().equals(dataTemp.getLocation())) {
                    System.out.println(dataTemp.getUniversity());
                }
            }
        }
    }
}
