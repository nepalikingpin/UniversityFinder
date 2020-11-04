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

    Scanner in = new Scanner(System.in);
    private static final String JSON_STORE = "./data/universitySuggestions.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    JFrame frame;
    JPanel initialPanel;
    JPanel secondPanel;
    JPanel thirdPanel;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JLabel label;

    public Console() throws IllegalStateException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        initializeGui();

    }

    void initializeGui() {
        frame = new JFrame();

        sceneOne();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("University Finder");
        frame.pack();
        frame.setVisible(true);
    }

    void sceneOne() {
        initialPanel = new JPanel();
        initialPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,50));
        initialPanel.setLayout(new GridLayout(0,1));

        label = new JLabel("<html>" + "Welcome to University Finder! Find the best suited universities for you "
                + "based on your interests, major and location!" + "</html>");
        initialPanel.add(label);

        label = new JLabel("\n");
        initialPanel.add(label);

        b1 = new JButton("Display List of Universities (and start)");
        b1.addActionListener(this);
        initialPanel.add(b1);

        b2 = new JButton("Start the Program");
        b2.addActionListener(this);
        initialPanel.add(b2);

        b3 = new JButton("Load previous recommendations");
        b3.addActionListener(this);
        initialPanel.add(b3);

        frame.add(initialPanel, BorderLayout.CENTER);


    }

    void sceneTwo() {
        frame.remove(initialPanel);

        secondPanel = new JPanel();
        secondPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,50));
        secondPanel.setLayout(new GridLayout(0,1));

        sceneTwoSelectInterests();
        sceneTwoSelectMajor();
        sceneTwoSelectLocation();

        frame.add(secondPanel, BorderLayout.CENTER);
        frame.validate();

    }

    void sceneTwoSelectInterests() {
        label = new JLabel("<html>" + "Please select your interests" + "</html>");
        secondPanel.add(label);

        b1 = new JButton("E sports");
        secondPanel.add(b1);

        b2 = new JButton("Robotics");
        secondPanel.add(b2);

        b3 = new JButton("Soccer");
        secondPanel.add(b3);
    }

    void sceneTwoSelectMajor() {
        label = new JLabel("<html>" + "Please select your intended Major" + "</html>");
        secondPanel.add(label);

        b1 = new JButton("CompSci");
        secondPanel.add(b1);

        b2 = new JButton("Math");
        secondPanel.add(b2);

        b3 = new JButton("Commerce");
        secondPanel.add(b3);
    }

    void sceneTwoSelectLocation() {
        label = new JLabel("<html>" + "Please select your intended location" + "</html>");
        secondPanel.add(label);

        b1 = new JButton("CompSci");
        secondPanel.add(b1);

        b2 = new JButton("Math");
        secondPanel.add(b2);

        b3 = new JButton("Commerce");
        secondPanel.add(b3);
    }

    void sceneThree() {
        frame.remove(secondPanel);

        thirdPanel = new JPanel();
        thirdPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,50));
        thirdPanel.setLayout(new GridLayout(0,1));

        sceneThreeOptions();

        frame.add(thirdPanel, BorderLayout.CENTER);
        frame.validate();
    }

    void sceneThreeOptions() {

        b1 = new JButton("Save Suggested Universities");
        thirdPanel.add(b1);

        b2 = new JButton("Add More Choices");
        thirdPanel.add(b2);

        b3 = new JButton("Delete Current Choices");
        thirdPanel.add(b3);

        b4 = new JButton("Quit and See Recommendations");
    }

    void start(int start) {
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

        if (obj == b1) {
            displayDatabase(1);
            sceneTwo();
        } else if (obj == b2) {
            start(7);
        } else if (obj == b3) {
            loadSuggestions();
        }
    }
}
