package main.java.menu;

import main.java.main.FileHandler;
import main.java.main.Table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// menu for editing options
public class EditingMenu implements Menuable {

    private static EditingMenu instance;

    private EditingMenu() {
    }

    public static EditingMenu getInstance() {
        if(instance == null)
            instance = new EditingMenu();
        return instance;
    }
    @Override
    public void show() {
        System.out.println("1. Edit a cell");
        System.out.println("2. Back");
    }

    @Override
    public void logic() {
        switch (this.input()) {
            case 1 -> edit(FileHandler.getInstance().getTable());
            case 2 -> {return;}
            case -1 -> System.out.println("There's a problem with your input\n");
            default -> System.out.println("There's no such an option\n");
        }
    }

    // edits a chosen cell
    private void edit(Table table) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What cell to change? (row, column):");
        try {
            String[] input = reader.readLine().split(", ");
            int[] integerInput = {Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]) - 1};

            System.out.println("New value: ");
            String value = reader.readLine();
            System.out.println();

            if(integerInput[0] == 0 && table.getHeader() != null) {
                String[] header = table.getHeader();
                header[integerInput[1]] = value;
                table.setHeader(header);
            }

            else if(integerInput[0] != 0 && table.getHeader() != null) {
                ArrayList<String[]> valuesAsList = table.getTableValues();
                String[] row = valuesAsList.get(integerInput[0] - 1);
                row[integerInput[1]] = value;
                valuesAsList.set(integerInput[0] - 1, row);
                table.setTableValues(valuesAsList);
            }

            else if(table.getHeader() == null) {
                ArrayList<String[]> valuesAsList = table.getTableValues();
                String[] row = valuesAsList.get(integerInput[0]);
                row[integerInput[1]] = value;
                valuesAsList.set(integerInput[0], row);
                table.setTableValues(valuesAsList);
            }
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds!\n");
        }
        catch (IOException e) {
            System.out.println("There was a problem with your input(IOException)\n");
        }

        catch (NumberFormatException e) {
            System.out.println("NumberFormatException!\n");
        }
    }

}
