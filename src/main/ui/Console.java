package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Console {
    int start;
    String interests = "";
    String major = "";
    String location = "";
    UserChoices uc = new UserChoices("", "", "");
    ChoicesList<Object> userList = new ChoicesList<Object>();
    ArrayList<Object> dataList = new ArrayList<>();
    ArrayList<String> string;
    Set<String> set = new HashSet<>();
    DataChoices dc = new DataChoices("","","","");
    AddToData atd = new AddToData(dc, dataList);
    SuggestUniversity suggest = new SuggestUniversity(userList, dataList);

    Scanner in = new Scanner(System.in);
    private static final String JSON_STORE = "./data/universitySuggestions.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public Console() throws IllegalStateException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        System.out.println("Welcome to University Finder! Find the best suited universities for you based"
                + " on your interests, major and location!");
        System.out.println("Enter 0 to quit" + "| Enter 1 to display a list of universities in the database, and start|"
                + "Enter any other number to directly start | Enter 3 to load previously recommended universities");
        start = in.nextInt();
        loadSuggestions(start);
        start();
    }

    void start() {
        while (start != 0) {
            displayDatabase(start);
            System.out.println("Please select interests" + "\n" + "1: E sports" + "\n" + "2: Robotics"
                    + "\n" + "3: Soccer ");
            interestsChoice();

            System.out.println("Please select major" + "\n" + "1: CompSci" + "\n" + "2: Math" + "\n" + "3: Commerce ");
            majorChoice();

            System.out.println("Please select location" + "\n" + "1: Canada" + "\n" + "2: USA" + "\n" + "3: India ");
            locationChoice();

            uc = new UserChoices(interests, major, location);
            userList.add(uc);

            System.out.println("Enter 0 to quit and see your recommendations | Enter 9 to delete current choices"
                    + "| Enter 2 to save suggested universities | Enter any number to continue | ");

            start = in.nextInt();

            removeAll(start);

            string = suggest.suggestion();

            if (start == 0) {
                listToSet();
            }
            saveSuggestions(start);
        }
    }

    void listToSet() {
        for (String x : string) {
            set.add(x);
        }
        for (String x : set) {
            System.out.println(x);
        }
    }

    void displayDatabase(int start) {
        switch (start) {
            case 1:
                for (Object data : dataList) {
                    DataChoices dataTemp = (DataChoices) data;
                    System.out.println(dataTemp.getUniversity());
                }
                break;
            default:
                break;
        }
    }

    void interestsChoice() {
        int interestChoice = in.nextInt();

        switch (interestChoice) {
            case 1:
                interests = "esports";
                break;
            case 2:
                interests = "robotics";
                break;
            case 3:
                interests = "soccer";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + interestChoice);
        }
    }

    void majorChoice() {
        int majorChoice = in.nextInt();

        switch (majorChoice) {
            case 1:
                major = "cs";
                break;
            case 2:
                major = "math";
                break;
            case 3:
                major = "commerce";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + majorChoice);
        }
    }

    void locationChoice() {
        int locationChoice = in.nextInt();

        switch (locationChoice) {
            case 1:
                location = "canada";
                break;
            case 2:
                location = "usa";
                break;
            case 3:
                location = "india";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + locationChoice);
        }
    }

    void removeAll(int start) {
        if (start == 9) {
            userList.removeAll();
        }
    }

    // EFFECTS: saves the suggestions to file
    private void saveSuggestions(int start) {
        if (start == 2) {
            try {
                jsonWriter.open();
                jsonWriter.write(suggest);
                jsonWriter.close();

                System.out.println("Saved to " + JSON_STORE);
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to file: " + JSON_STORE);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    void loadSuggestions(int start) {
        if (start == 3) {
            try {
                suggest = jsonReader.read();
                System.out.println(suggest.getSuggestionList() + "\n");
                System.out.println("Loaded from " + JSON_STORE);
            } catch (IOException e) {
                System.out.println("Unable to read from file: " + JSON_STORE);
            }
            this.start = 0;
        }
    }
}
