package menu;

import main.FileHandler;
import main.Visualizer;

import java.io.File;

public class ViewingMenu implements Menuable {

    private static ViewingMenu instance;

    private ViewingMenu() {
        ;
    }

    public static ViewingMenu getInstance() {
        if(instance == null)
            instance = new ViewingMenu();
        return instance;
    }

    @Override
    public void show() {
        System.out.println("1. View the table");
        System.out.println("2. View the original file");
        System.out.println("4. View the statistics");
        System.out.println("5. Back");
    }

    @Override
    public void logic() {
        Visualizer visualizer = Visualizer.getInstance();
        switch (this.input()) {
            case 1:
                visualizer.printTable(FileHandler.getInstance().getTable());
                break;
            case 2:
                visualizer.printCSV(FileHandler.getInstance().getTable());
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                return;
            case -1:
                System.out.println("There's a problem with your input");
                return;
            default:
                System.out.println("There's no such an option");
                return;
        }
    }
}
