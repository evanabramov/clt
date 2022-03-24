/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenusLogic {

    private MenusLogic() {
        ;
    }


    private static int input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int prompt = Integer.parseInt(reader.readLine());
            return prompt;
        }

        catch (IOException e) {
            System.out.println("There's a problem with your input, try again");
        }

        return -1;
    }

    public static void mainScreenLogic() {
        MenusTexts.mainScreenText();
        int input = input();

        switch (input) {
            case 1: viewingOptionsLogic();
            break;

            case 2: editingOptionsLogic();
            break;

            case 3: fileLoadingLogic();
            break;

            case 4: quitLogic();
            break;

            default: System.out.println("No such option, try again");
        }
    }

    public static void viewingOptionsLogic(Table table) {
        MenusTexts.viewingOptionsText();
        int input = input();

        switch (input) {

        }
    }

    public static void editingOptionsLogic(Table table) {

    }

    public static void fileLoadingLogic() {

    }

    public static void quitLogic() {
        return;
    }
}

 */
