package ui;


import java.io.IOException;

// Runs of the application by calling Console
public class Main {
    public static void main(String[] args) {
        try {
            new Console();
        } catch (IllegalStateException | IOException e) {
            System.out.println("Unable to run application");
        }
    }

}

