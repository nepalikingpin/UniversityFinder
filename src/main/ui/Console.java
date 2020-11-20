package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// Handles the entire UI functionality of the application
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

    private static final String JSON_STORE = "./data/universitySuggestions.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    JFrame frame;
    JPanel initialPanel;
    JPanel interestsPanel;
    JPanel majorPanel;
    JPanel locationPanel;
    JPanel thirdPanel;
    JPanel quitPanel;
    JButton initialPanelB1;
    JButton initialPanelB2;
    JButton initialPanelB3;
    JButton thirdPanelB1;
    JButton thirdPanelB2;
    JButton thirdPanelB3;

    JLabel label;

    JComboBox choicesList;
    JComboBox majorList;
    JComboBox locationList;

    Clip clip;
    AudioInputStream audioInputStream;


    //MODIFIES: this
    //EFFECTS: creates a new jsonWriter and jsonReader object
    //         calls the initializeGui method to initialize the graphical user interface
    public Console() throws IllegalStateException, IOException {
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        initializeGui();
    }

    //MODIFIES: this
    //EFFECTS: creates and initializes the JFrame
    //         creates and initializes the initial, major, location and quit JPanels
    //         calls sceneOne() to start displaying the GUI
    void initializeGui() throws IOException {

        frame = new JFrame();
        initialPanel = new JPanel();
        initialPanel.setBorder(BorderFactory.createEmptyBorder(30,30,50,30));
        initialPanel.setLayout(new GridLayout(0,1));

        interestsPanel = new JPanel();
        interestsPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        interestsPanel.setLayout(new GridLayout(2,1));

        majorPanel = new JPanel();
        majorPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        majorPanel.setLayout(new GridLayout(2,1));

        locationPanel = new JPanel();
        locationPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        locationPanel.setLayout(new GridLayout(2,1));

        quitPanel = new JPanel();
        quitPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        quitPanel.setLayout(new GridLayout(2,1));

        sceneOne();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("University Finder");
        frame.pack();
        frame.setVisible(true);
    }

    //MODIFIES: this
    //EFFECTS: displays the first scene with 2 panels and 3 buttons
    void sceneOne() throws IOException {

        JLabel imgLabel = new JLabel(new ImageIcon("./data/UniversityFinder.png"));

        initialPanel.add(imgLabel);

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

    //MODIFIES: this
    //EFFECTS: removes initial panel
    //         calls the sceneTwoSelectInterests method and validates the panel
    void sceneTwoInterests() {
        frame.remove(initialPanel);

        sceneTwoSelectInterests();

        frame.add(interestsPanel, BorderLayout.CENTER);
        frame.validate();

    }

    //MODIFIES: this
    //EFFECTS: provides a list interests to choose from
    void sceneTwoSelectInterests() {
        label = new JLabel("<html>" + "Please select your interests" + "</html>");
        interestsPanel.add(label);
        String[] list = { "E sports", "Robotics", "Soccer"};

        choicesList = new JComboBox(list);
        interestsPanel.add(choicesList);
        choicesList.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: removes interests panel
    //         calls the sceneTwoSelectMajor method and validates the panel
    void sceneTwoMajor() {
        frame.remove(interestsPanel);
        sceneTwoSelectMajor();

        frame.add(majorPanel, BorderLayout.CENTER);
        frame.validate();
    }

    //MODIFIES: this
    //EFFECTS: provides a list of majors to choose from
    void sceneTwoSelectMajor() {
        label = new JLabel("<html>" + "Please select your intended Major" + "</html>");
        majorPanel.add(label);
        String[] list = { "Comp Sci", "Math", "Commerce"};

        majorList = new JComboBox(list);
        majorPanel.add(majorList);
        majorList.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: removes major panel
    //         calls the sceneTwoSelectLocation method and validates the panel
    void sceneTwoLocation() {
        frame.remove(majorPanel);
        sceneTwoSelectLocation();

        frame.add(locationPanel, BorderLayout.CENTER);
        frame.validate();
    }

    //MODIFIES: this
    //EFFECTS: provides a list of locations to choose from
    void sceneTwoSelectLocation() {
        label = new JLabel("<html>" + "Please select your intended location" + "</html>");
        locationPanel.add(label);
        String[] list = { "Canada", "USA", "India"};

        locationList = new JComboBox(list);
        locationPanel.add(locationList);
        locationList.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: removes the location panel
    //         initializes thirdPanel, calls sceneThreeOptions and validates the panel
    void sceneThree() {
        frame.remove(locationPanel);

        thirdPanel = new JPanel();
        thirdPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,50));
        thirdPanel.setLayout(new GridLayout(0,1));

        sceneThreeOptions();

        frame.add(thirdPanel, BorderLayout.CENTER);
        frame.validate();
    }

    //MODIFIES: this
    //EFFECTS: provides options to save recommendations, delete choices and see the recommendations
    void sceneThreeOptions() {

        thirdPanelB1 = new JButton("Save Suggested Universities and Quit");
        thirdPanel.add(thirdPanelB1);
        thirdPanelB1.addActionListener(this);

        thirdPanelB2 = new JButton("Delete Current Choices");
        thirdPanel.add(thirdPanelB2);
        thirdPanelB2.addActionListener(this);

        thirdPanelB3 = new JButton("See Recommendations");
        thirdPanel.add(thirdPanelB3);
        thirdPanelB3.addActionListener(this);
    }

    //MODIFIES: this
    //EFFECTS: takes in start and calls the methods according to the input
    void start(int start) {
        removeAll(start);

        string = suggest.suggestion();

        if (start == 0) {
            listToSet();
        }
        saveSuggestions(start);

    }

    //MODIFIES: this
    //EFFECTS: displays the recommended universities as a Message Dialog Box
    void listToSet() {
        String recommendedUnis = "";
        for (String x : string) {
            set.add(x);
        }
        for (String x : set) {
            recommendedUnis += x + "\n";
        }
        JOptionPane.showMessageDialog(null, recommendedUnis);
        System.exit(0);
    }

    //MODIFIES: this
    //EFFECTS: displays all the universities in the database as a Message Dialog Box
    void displayDatabase(int start) {
        String universitiesInDatabase = "";
        switch (start) {
            case 1:
                for (Object data : dataList) {
                    DataChoices dataTemp = (DataChoices) data;
                    universitiesInDatabase += dataTemp.getUniversity() + "\n";

                }
                break;
            default:
                break;
        }
        JOptionPane.showMessageDialog(null, universitiesInDatabase);
    }

    //MODIFIES: this
    //EFFECTS: sets the interests according to the interestsChoice
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

    //MODIFIES: this
    //EFFECTS: sets the major according to the majorChoice
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

    //MODIFIES: this
    //EFFECTS: sets the location according to the locationChoice
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

    //MODIFIES: this
    //EFFECTS: removes all user choices objects from the userList
    void removeAll(int start) {
        if (start == 9) {
            userList.removeAll();
            JOptionPane.showMessageDialog(null, "Deleted Current Choices From the Database");
            System.exit(0);
        }
    }

    // Code partly taken from JsonSerializationDemo
    //MODIFIES:
    // EFFECTS: saves the suggestions to file
    private void saveSuggestions(int start) {
        if (start == 2) {
            try {
                jsonWriter.open();
                jsonWriter.write(suggest);
                jsonWriter.close();
                JOptionPane.showMessageDialog(null, "Saved to Database");
                System.exit(0);
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
            for (int i = 0; i < suggest.getSuggestionList().size(); i++) {
                guiDisplay += suggest.getSuggestionList().get(i);
            }
            JOptionPane.showMessageDialog(null, guiDisplay);
            System.out.println("Loaded from " + JSON_STORE);
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }

    //EFFECTS: checks which button is pressed and calls the respective backend method
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == initialPanelB1) {
            displayDatabase(1);
            sceneTwoInterests();
        } else if (obj == initialPanelB2) {
            sceneTwoInterests();
        } else if (obj == initialPanelB3) {
            loadSuggestions();
        } else if (obj == choicesList) {
            choicesManagerInterests();
        } else if (obj == majorList) {
            choicesManagerMajor();
        } else if (obj == locationList) {
            choicesManagerLocation();
        } else if (obj == thirdPanelB1) {
            start(2);
        } else if (obj == thirdPanelB2) {
            fartSound();
            start(9);
        } else if (obj == thirdPanelB3) {
            start(0);
        }
    }

    //MODIFIES: this
    //EFFECTS: plays a fart sound if the file exists and is read properly
    void fartSound() {
        try {
            clip = AudioSystem.getClip();
            audioInputStream = AudioSystem.getAudioInputStream(new File("./data/fart-01.wav")
                    .getAbsoluteFile());
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fart Sound Failed");
        }

    }

    //EFFECTS: finds the major chosen by the user and sends it to interestsChoice
    //         calls sceneTwoLocation to set the user selected location
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

    //EFFECTS: finds the major chosen by the user and sends it to majorChoice
    //         calls sceneTwoLocation to set the user selected location
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

    //EFFECTS: finds the location chosen by the user and sends it to locationChoice
    //         calls userChoicesObject to display the next panel
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

    //MODIFIES: this
    //EFFECTS: creates a user choices object and adds it to userList
    //         calls sceneThree to continue displaying the application
    void userChoicesObject() {
        uc = new UserChoices(interests, major, location);
        userList.add(uc);
        sceneThree();
    }
}
