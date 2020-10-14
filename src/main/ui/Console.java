package ui;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;


public class Console {
    String interests = "";
    String major = "";
    String location = "";
    UserChoices uc = new UserChoices("", "", "");
    ChoicesList<Object> userList = new ChoicesList<Object>();
    ArrayList<Object> dataList = new ArrayList<>();

    DataChoices dc = new DataChoices("","","","");
    AddToData atd = new AddToData(dc, dataList);
    SuggestUniversity suggest = new SuggestUniversity(userList, dataList);

    Scanner in = new Scanner(System.in);

    public Console() {

        System.out.println("Welcome to University Finder! Find the best suited universities for you based"
                + " on your interests, major and location!");
        System.out.println("Enter 0 to quit" + "| Enter 1 to display a list of universities in the database, and start;"
                + "| Enter any other number to directly start");
        int start = in.nextInt();
        displayDatabase(start);

        while (start != 0) {

            System.out.println("Please select interests" + "\n" + "1: E sports" + "\n" + "2: Robotics"
                    + "\n" + "3: Soccer ");
            interestsChoice();

            System.out.println("Please select major" + "\n" + "1: CompSci" + "\n" + "2: Math" + "\n" + "3: Commerce ");

            majorChoice();

            System.out.println("Please select location" + "\n" + "1: Canada" + "\n" + "2: USA" + "\n" + "3: India ");
            locationChoice();

            uc = new UserChoices(interests, major, location);
            userList.add(uc);

            System.out.println("Enter 9 to delete current choices"
                    + "| Enter any number to continue | Enter 0 to quit and see your recommendations");
            start = in.nextInt();
            removeAll(start);

        }

        System.out.println("Check these universities out" + "\n");

        System.out.println(suggest.suggestion() + "\n");


    }

    void displayDatabase(int start) {
        switch (start) {
            case 1:
                for (Object data : dataList) {
                    DataChoices dataTemp = (DataChoices) data;
                    System.out.println(((DataChoices) data).getUniversity());
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
}
