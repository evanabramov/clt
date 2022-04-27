package main;

import menu.MainMenu;
import menu.MenuController;

public class Main {
    public static void main(String[] args) {

        // Input's bufferedreader bothers cause I cannot close or implement try-with
        Initializer initializer = Initializer.getInstance();
        Table table = initializer.initializeTheTable("data/a.csv", "y");
        Visualizer.printCSV(table);
        Visualizer.printTable(table);
        Visualizer.printAColumn(table, 1);
        MenuController.loop();
    }
}
