package ui;

import model.AddToData;
import model.ChoicesList;
import model.DataChoices;
import model.UserChoices;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        boolean loopBool = false;
        String interests = "";
        String major = "";
        String location = "";
        UserChoices uc = new UserChoices("", "", "");
        ChoicesList<Object> userList = new ChoicesList<Object>();
        ArrayList<Object> dataList = new ArrayList<>();

        DataChoices dc = new DataChoices("","","","");
        AddToData atd = new AddToData(dc, dataList);

        Scanner in = new Scanner(System.in);

        System.out.println("Enter any number to start, Enter 0 to quit");
        int start = in.nextInt();

        while (start != 0) {

            System.out.println("Please select your interests" + "\n" + "1: E sports" + "\n" + "2: Robotics" +
                    "\n" + "3: Soccer ");

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

            System.out.println("Please select your major" + "\n" + "1: CompSci" + "\n" + "2: Math" +
                    "\n" + "3: Commerce ");

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
                    throw new IllegalStateException("Unexpected value: " + interestChoice);
            }

            System.out.println("Please select your location" + "\n" + "1: Canada" + "\n" + "2: USA" +
                    "\n" + "3: India ");

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
                    throw new IllegalStateException("Unexpected value: " + interestChoice);
            }

            uc = new UserChoices(interests, major, location);
            userList.add(uc);

            System.out.println("Enter any number to start, Enter 0 to quit");
            start = in.nextInt();

        }


        for (int i = 0; i < Math.min(dataList.size(), userList.size()); i++) {
            UserChoices userTemp = (UserChoices) userList.get(i);
            DataChoices dataTemp = (DataChoices) dataList.get(i);

            if (userTemp.getInterests().equals(dataTemp.getInterests())) {
                System.out.println(dataTemp.getUniversity());
            }
        }

    }

}

