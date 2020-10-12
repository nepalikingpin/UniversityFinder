package model;

import java.util.ArrayList;
import java.util.List;

public class SuggestUniversity {
    private ChoicesList<Object> userList = new ChoicesList<>();
    private ArrayList<Object> dataList = new ArrayList<>();

    public SuggestUniversity(ChoicesList<Object> userList, ArrayList<Object> dataList) {
        this.userList = (ChoicesList<Object>) userList;
        this.dataList = (ArrayList<Object>) dataList;
    }

    public void suggestion() {
        for (int i = 0; i < userList.size(); i++) {
            UserChoices userTemp = (UserChoices) userList.get(i);

            for (int j = 0; j < dataList.size(); j++) {
                DataChoices dataTemp = (DataChoices) dataList.get(j);

                if (userTemp.getInterests().equals(dataTemp.getInterests())
                        || userTemp.getInterests().equals(dataTemp.getInterests())
                        || userTemp.getInterests().equals(dataTemp.getInterests())) {
                    System.out.println(dataTemp.getUniversity());
                }
            }
        }
    }
}
