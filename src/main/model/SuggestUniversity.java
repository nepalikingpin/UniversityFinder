package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

import static java.lang.Integer.min;

//Class to suggest the university to user, if the interests or major or location of the UserChoices object in userlist
// are the same as DataChoices object in the dataList

public class SuggestUniversity implements Writable {
    private ChoicesList<Object> userList;
    private ArrayList<Object> dataList;
    private ArrayList<String> suggestionList;
    private String universities;
    //MODIFIES: this
    //EFFECTS: creates a SuggestUniversity object and assigns userList and dataList

    public SuggestUniversity(ChoicesList<Object> userList, ArrayList<Object> dataList) {
        this.userList = userList;
        this.dataList = dataList;
        suggestionList = new ArrayList<>();
    }

    public SuggestUniversity() { //Testing
        suggestionList = new ArrayList<>();

    }
    //EFFECTS: compares interests, major and location of userList object with every object in dataList; and prints
    // out the related university if the match is found

    public void addTestingValues() {
        this.suggestionList.add("TestVal 1");
        this.suggestionList.add("TestVal 2");
    }

    public String suggestion() {
        for (int i = 0; i < userList.size(); i++) {
            UserChoices userTemp = (UserChoices) userList.get(i);

            for (Object data : dataList) {
                DataChoices dataTemp = (DataChoices) data;

                if (userTemp.getInterests().equals(dataTemp.getInterests())
                        || userTemp.getMajor().equals(dataTemp.getMajor())
                        || userTemp.getLocation().equals(dataTemp.getLocation())) {

                    if (!(suggestionList.contains(dataTemp.getUniversity()))) {
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

    public void addToSuggestionList(String suggestion) {
        suggestionList.add(suggestion);
    }

    public ArrayList<String> getSuggestionList() {
        return this.suggestionList;
    }

    public void loadSuggestions(ArrayList<String> suggestionList) {
        for (int i = 0; i < suggestionList.size(); i++) {
            this.suggestionList.add(suggestionList.get(i));
        }
    }

    public int listSize() {
        return suggestionList.size();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Suggested", suggestedToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray suggestedToJson() {
        JSONArray jsonArray = new JSONArray();

        try {
            for (int i = 0; i < suggestionList.size(); i++) {
                jsonArray.put(suggestionList.get(i));
            }
        } catch (NullPointerException e) {
            System.out.println("No Universities in the Database");
        }

        return jsonArray;
    }


}

