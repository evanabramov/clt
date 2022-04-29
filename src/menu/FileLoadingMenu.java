package menu;

import main.FileHandler;
import main.Table;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileLoadingMenu implements Menuable {

    private static FileLoadingMenu instance;

    private FileLoadingMenu() {
        ;
    }

    public static FileLoadingMenu getInstance() {
        if(instance == null)
            instance = new FileLoadingMenu();
        return instance;
    }

    @Override
    public void show() {
        System.out.println("1. Proceed");
        System.out.println("2. Back");
    }

    @Override
    public void logic() {
        switch(input()) {
            case 1:
                load();
                break;
            case 2:
                return;
            case -1:
                System.out.println("There's no such an option!");
                return;
            default:
                System.out.println("There's a problem with your input");
                return;
        }
    }

    private void load() {
        FileHandler fileHandler = FileHandler.getInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String PATH, header;

        try {
            System.out.println("Filepath: ");
            PATH = reader.readLine();
            System.out.println("Is there a header?(y/n)");
            header = reader.readLine();

            if(!(header.equals("y") || header.equals("n"))) {
                throw new IOException();
            }

            fileHandler.setPATH(PATH);

            fileHandler.setTable(new Table(fileHandler.readFile(), header));
        }

        catch(FileNotFoundException e) {
            System.out.println("File was not found!");
            return;
        }

        catch(IOException e) {
            System.out.println("There was a problem (IOException)");
            return;
        }
    }


}
