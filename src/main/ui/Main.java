package ui;


public class Main {
    public static void main(String[] args) {
        try {
            new Console();
        } catch (IllegalStateException e) {
            System.out.println("Unable to run application: The choice doesn't exist");
        }
    }

}

