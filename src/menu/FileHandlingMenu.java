package menu;

import main.FileHandler;
import main.Table;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// menu for handling files
public class FileHandlingMenu implements Menuable {

    private static FileHandlingMenu instance;

    private FileHandlingMenu() {
        ;
    }

    public static FileHandlingMenu getInstance() {
        if(instance == null)
            instance = new FileHandlingMenu();
        return instance;
    }

    @Override
    public void show() {
        System.out.println("1. Load a file");
        System.out.println("2. Write to a file");
        System.out.println("3. Back");
    }

    @Override
    public void logic() {
        switch(input()) {
            case 1:
                load();
                break;
            case 2:
                write();
                break;
            case 3:
                return;
            case -1:
                System.out.println("There's no such an option!\n");
                return;
            default:
                System.out.println("There's a problem with your input\n");
                return;
        }
    }

    // loads and assigns files to filehandler's inner table variable
    private void load() {
        FileHandler fileHandler = FileHandler.getInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String PATH, header;

        try {
            System.out.println("Filepath: ");
            PATH = reader.readLine();
            System.out.println("Is there a header?(y/n)");
            header = reader.readLine();
            System.out.println();

            if(!(header.equals("y") || header.equals("n"))) {
                throw new IOException();
            }

            fileHandler.setTable(new Table(fileHandler.readFile(PATH), header));
        }

        catch(FileNotFoundException e) {
            System.out.println("File was not found!\n");
            return;
        }

        catch(IOException e) {
            System.out.println("There was a problem (IOException)\n");
            return;
        }
    }

    // writes filehandler's inner table to a file
    private void write() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Filepath: ");
            String PATH = reader.readLine();
            System.out.println();
            FileHandler.getInstance().writeFile(FileHandler.getInstance().getTable(), PATH);
        }

        catch (IOException e) {
            System.out.println("There was a problem writing to a file(IOException)\n");
            return;
        }

        catch (NullPointerException e) {
            System.out.println("There's nothing to write!\n");
            return;
        }
    }
}
