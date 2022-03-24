import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class MenuUtilities {

    private MenuUtilities() throws Exception {
        throw new Exception();
    }

    public static void mainScreenText() {
        System.out.println("Simple csv files' viewer and editor.\nMade by Evan Abramov @evanabramov.");
        System.out.println("Filepath: " + FileHandler.getInstance().getPATH());

        System.out.println("1. Viewing");
        System.out.println("2. Editing");
        System.out.println("3. Load new file");
        System.out.println("4. Quit");
        System.out.println();
    }

    public static void viewingOptionsText() {
        System.out.println("1. View the file as a table");
        System.out.println("2. View the file as an csv");
        System.out.println("3. View specific columns");
        System.out.println("4. View the statistics");
        System.out.println("5. Back");
        System.out.println();
    }

    public static void editingOptionsText() {
        System.out.println("1. Edit a specific cell");
        System.out.println("2. Back");
        System.out.println();
    }

    public static int inputHandler() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int input = Integer.parseInt(reader.readLine());
            return input;
        }

        catch (IOException e) {
            System.out.println("There was a problem with your input, try again.");
        }

        return -1;
    }

    public static void mainScreenLogic() {
        mainScreenText();
        int input = inputHandler();

        switch (input) {
            case 1: viewingOptionsLogic();
                break;

            case 2: editingOptionsLogic();
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
        }
    }

    public static void viewingOptionsLogic() {

    }

    public static void editingOptionsLogic() {

    }

    public static Table fileLoadingLogic() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter filepath: ");
        String filepath = reader.readLine();

        System.out.println("Is there a header (y/n): ");
        String header = reader.readLine();

        Initializer initializer = Initializer.getInstance();
        Table table = initializer.initializeTheTable(filepath, header);
        return table;
    }

    public static void quitLogic() {
        return;
    }
}
