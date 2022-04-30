package menu;

import main.FileHandler;
import main.Table;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

    private void write() {
        FileHandler fileHandler = FileHandler.getInstance();
        Table table = fileHandler.getTable();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String[]> tableAsList = new ArrayList<>();

        try {
            if(table.getHeader() != null)
                tableAsList.add(table.getHeader());
            tableAsList.addAll(table.getTableValues());

            System.out.println("Filepath: ");
            String PATH = reader.readLine();
            fileHandler.writeFile(tableAsList, PATH);
        }

        catch (IOException e) {
            System.out.println("There was a problem writing to a file(IOException)");
            return;
        }

        catch (NullPointerException e) {
            System.out.println("There's nothing to write!");
            return;
        }
    }
}