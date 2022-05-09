package main.java.menu;

import main.java.main.FileHandler;
import main.java.main.Table;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// menu for handling files
public class FileHandlingMenu implements Menuable {

    private static FileHandlingMenu instance;

    private FileHandlingMenu() {}

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
            case 1 -> load();
            case 2 -> write();
            case 3 -> {return;}
            case -1 -> System.out.println("There's no such an option!\n");
            default -> System.out.println("There's a problem with your input\n");
        }
    }

    // loads and assigns files to filehandler's inner table variable
    private void load() {
        FileHandler fileHandler = FileHandler.getInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String PATH, header, regex;

        try {
            System.out.println("Filepath: ");
            PATH = reader.readLine();
            System.out.println("Is there a header?(y/n)");
            header = reader.readLine();
            System.out.println("Separator: (default:(,))");
            regex = reader.readLine();

            if(!(header.equals("y") || header.equals("n"))) {
                throw new IOException();
            }

            // check if regex is valid
            try {
                Pattern.compile(regex);
            }

            catch (PatternSyntaxException e) {
                System.out.println("Invalid separator");
                return;
            }

            fileHandler.setTable(new Table(fileHandler.readFile(PATH, regex), header));
        }

        catch(FileNotFoundException e) {
            System.out.println("File was not found!\n");
        }

        catch(IOException e) {
            System.out.println("There was a problem (IOException)\n");
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
        }

        catch (NullPointerException e) {
            System.out.println("There's nothing to write!\n");
        }
    }
}
