package ui;

// Code partly taken from JsonSerializationDemo

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Console implements ActionListener {

    String interests = "";
    String major = "";
    String location = "";
    UserChoices uc = new UserChoices("", "", "");
    ChoicesList<Object> userList = new ChoicesList<>();
    ArrayList<Object> dataList = new ArrayList<>();
    ArrayList<String> string;
    Set<String> set = new HashSet<>();
    DataChoices dc = new DataChoices("","","","");
    AddToData atd = new AddToData(dc, dataList);
    SuggestUniversity suggest = new SuggestUniversity(userList, dataList);
    String guiDisplay = "";
    boolean interestsSelected = false;
    boolean majorSelected = false;
    boolean locationSelected = false;
    Scanner in = new Scanner(System.in);
    private static final String JSON_STORE = "./data/universitySuggestions.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    JFrame frame;
    JPanel initialPanel;
    JPanel interestsPanel;
    JPanel majorPanel;
    JPanel locationPanel;
    JPanel thirdPanel;
    JButton initialPanelB1;
    JButton initialPanelB2;
    JButton initialPanelB3;
    JButton thirdPanelB1;
    JButton thirdPanelB2;
    JButton thirdPanelB3;
    JButton thirdPanelB4;
    JLabel label;

    JComboBox choicesList;
    JComboBox majorList;
    JComboBox locationList;

    public Console() throws IllegalStateException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        initializeGui();

    }

    void initializeGui() {
        frame = new JFrame();
        initialPanel = new JPanel();
        initialPanel.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        initialPanel.setLayout(new GridLayout(0,1));

        interestsPanel = new JPanel();
        interestsPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,50));
        interestsPanel.setLayout(new GridLayout(2,1));

        majorPanel = new JPanel();
        majorPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,50));
        majorPanel.setLayout(new GridLayout(2,1));

        locationPanel = new JPanel();
        locationPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,50));
        locationPanel.setLayout(new GridLayout(2,1));

        sceneOne();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("University Finder");
        frame.pack();
        frame.setVisible(true);
    }

    void sceneOne() {


        label = new JLabel("<html>" + "Welcome to University Finder! Find the best suited universities for you "
                + "based on your interests, major and location!" + "</html>");
        initialPanel.add(label);

        label = new JLabel("\n");
        initialPanel.add(label);

        initialPanelB1 = new JButton("Display List of Universities (and start)");
        initialPanelB1.addActionListener(this);
        initialPanel.add(initialPanelB1);

        initialPanelB2 = new JButton("Start the Program");
        initialPanelB2.addActionListener(this);
        initialPanel.add(initialPanelB2);

        initialPanelB3 = new JButton("Load previous recommendations");
        initialPanelB3.addActionListener(this);
        initialPanel.add(initialPanelB3);

        frame.add(initialPanel, BorderLayout.CENTER);

    }

    void sceneTwoInterests() {
        frame.remove(initialPanel);

        sceneTwoSelectInterests();

        frame.add(interestsPanel, BorderLayout.CENTER);
        frame.validate();

    }

    void sceneTwoSelectInterests() {
        label = new JLabel("<html>" + "Please select your interests" + "</html>");
        interestsPanel.add(label);
        String[] list = { "E sports", "Robotics", "Soccer"};

        choicesList = new JComboBox(list);
        interestsPanel.add(choicesList);
        choicesList.addActionListener(this);

    }

    void sceneTwoMajor() {
        frame.remove(interestsPanel);
        sceneTwoSelectMajor();

        frame.add(majorPanel, BorderLayout.CENTER);
        frame.validate();
    }

    void sceneTwoSelectMajor() {
        label = new JLabel("<html>" + "Please select your intended Major" + "</html>");
        majorPanel.add(label);
        String[] list = { "Comp Sci", "Math", "Commerce"};

        majorList = new JComboBox(list);
        majorPanel.add(majorList);
        majorList.addActionListener(this);
    }

    void sceneTwoLocation() {
        frame.remove(majorPanel);
        sceneTwoSelectLocation();

        frame.add(locationPanel, BorderLayout.CENTER);
        frame.validate();
    }

    void sceneTwoSelectLocation() {
        label = new JLabel("<html>" + "Please select your intended location" + "</html>");
        locationPanel.add(label);
        String[] list = { "Canada", "USA", "India"};

        locationList = new JComboBox(list);
        locationPanel.add(locationList);
        locationList.addActionListener(this);
    }

//    void sceneThree() {
//        frame.remove(interestsPanel);
//
//        thirdPanel = new JPanel();
//        thirdPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,50));
//        thirdPanel.setLayout(new GridLayout(0,1));
//
//        sceneThreeOptions();
//
//        frame.add(thirdPanel, BorderLayout.CENTER);
//        frame.validate();
//    }
//
//    void sceneThreeOptions() {
//
//        thirdPanelB1 = new JButton("Save Suggested Universities");
//        thirdPanel.add(thirdPanelB1);
//
//        thirdPanelB2 = new JButton("Add More Choices");
//        thirdPanel.add(thirdPanelB2);
//
//        thirdPanelB3 = new JButton("Delete Current Choices");
//        thirdPanel.add(thirdPanelB3);
//
//        thirdPanelB4 = new JButton("Quit and See Recommendations");
//        thirdPanel.add(thirdPanelB4);
//    }

    void start(int start) {
        while (start != 0) {

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
        String universitiesInDatabase = "";
        switch (start) {
            case 1:
                for (Object data : dataList) {
                    DataChoices dataTemp = (DataChoices) data;
                    universitiesInDatabase += dataTemp.getUniversity();

                }
                break;
            default:
                break;
        }
        label = new JLabel("<html>" + universitiesInDatabase + "</html>");
        interestsPanel.add(label,0);
    }

    void interestsChoice(int interestChoice) {

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

    void majorChoice(int majorChoice) {

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

    void locationChoice(int locationChoice) {

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

    // Code partly taken from JsonSerializationDemo
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

    // Code partly taken from JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads workroom from file
    void loadSuggestions() {
        try {
            suggest = jsonReader.read();
            guiDisplay += suggest.getSuggestionList() + "\n";
            System.out.println(guiDisplay);
            System.out.println("Loaded from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if (obj == initialPanelB1) {
            displayDatabase(1);
            sceneTwoInterests();
        } else if (obj == initialPanelB2) {
            start(7);
        } else if (obj == initialPanelB3) {
            loadSuggestions();
        } else if (obj == choicesList) {
            choicesManagerInterests();
        } else if (obj == majorList) {
            choicesManagerMajor();
        } else if (obj == locationList) {
            choicesManagerLocation();
        }
    }

    void choicesManagerInterests() {

        if (choicesList.getSelectedItem().toString() == "E sports") {
            interestsChoice(1);
        } else if (choicesList.getSelectedItem().toString() == "Robotics") {
            interestsChoice(2);
        } else if (choicesList.getSelectedItem().toString() == "Soccer") {
            interestsChoice(3);
        }

        sceneTwoMajor();
    }

    void choicesManagerMajor() {
        if (majorList.getSelectedItem().toString() == "Comp Sci") {
            majorChoice(1);
        } else if (majorList.getSelectedItem().toString() == "Math") {
            majorChoice(2);
        } else if (majorList.getSelectedItem().toString() == "Commerce") {
            majorChoice(3);
        }

        sceneTwoLocation();
    }

    void choicesManagerLocation() {
        if (locationList.getSelectedItem().toString() == "Canada") {
            locationChoice(1);
        } else if (locationList.getSelectedItem().toString() == "USA") {
            locationChoice(2);
        } else if (locationList.getSelectedItem().toString() == "India") {
            locationChoice(3);
        }

        userChoicesObject();
    }

    void userChoicesObject() {
        uc = new UserChoices(interests, major, location);
        userList.add(uc);
        System.out.println("Created User Choices Object");
    }
}
