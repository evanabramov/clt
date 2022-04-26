/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Menu instance;
    private Menu() {
        ;
    }

    public static Menu getInstance() {
        if(instance == null) {
            instance = new Menu();
        }

        return instance;
    }

    public void loop() {
        mainScreen();
    }

    private void mainScreen() {
        mainScreenText();
        //////////////////////////////////////////////////////////////////
        int input = -1;

        try {
            input = Integer.parseInt(reader.readLine());
        }

        catch(IOException e) {
            System.out.println("There was a problem with your input!");
        }

        switch (input) {
            case 1: viewingOptionsScreen();
                break;

            case 2: editingOptionsScreen();
                break;

            case 3: try {
                fileLoadingLogic();
            } catch (IOException e) {
                e.printStackTrace();
            }
                break;

            case 4: quitLogic();
                break;

            default: System.out.println("No such option, try again");
                mainScreen();
                break;
        }
    }

    private void viewingOptionsScreen() {
        viewingOptionsText();

        int input = -1;

        try {
            input = Integer.parseInt(inputHandler.read());
        }

        catch(IOException e) {
            System.out.println("There was a problem with your input!");
        }


        switch (input) {
            case 1:
        }


    }

    private void editingOptionsScreen() {

    }

    private Table fileLoadingLogic() throws IOException {

        System.out.println("Enter filepath: ");
        String filepath = reader.readLine();

        System.out.println("Is there a header (y/n): ");
        String header = reader.readLine();

        Initializer initializer = Initializer.getInstance();
        Table table = initializer.initializeTheTable(filepath, header);
        return table;
    }

    private void quitLogic() {
        System.exit(0);
    }

    private void mainScreenText() {
        System.out.println("Simple csv files' viewer and editor.\nMade by Evan Abramov @evanabramov.");
        System.out.println("Filepath: " + FileHandler.getInstance().getPATH());

        System.out.println("1. Viewing");
        System.out.println("2. Editing");
        System.out.println("3. Load new file");
        System.out.println("4. Quit");
        System.out.println();
    }

    private void viewingOptionsText() {
        System.out.println("1. View the file as a table");
        System.out.println("2. View the file as an csv");
        System.out.println("3. View specific columns");
        System.out.println("4. View the statistics");
        System.out.println("5. Back");
        System.out.println();
    }

    private void editingOptionsText() {
        System.out.println("1. Edit a specific cell");
        System.out.println("2. Back");
        System.out.println();
    }
}

 */