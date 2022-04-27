package main;

import java.util.ArrayList;

// Class that takes care of viewing read file.
public class Visualizer {

    private Visualizer() {
        ;
    }

    public static void printCSV(Table table) {
        ArrayList<String[]> data = table.getTable();

        for(int i = 0; i < data.size(); i++) {
            for(int j = 0; j < data.get(i).length; j++) {
                if(j != data.get(i).length - 1)
                    System.out.print(data.get(i)[j] + ",");
                else
                    System.out.print(data.get(i)[j]);
            }

            System.out.println();
        }
    }

    //Gonna be done properly later.
    public static void printTable(Table table) {
        if(table.getHeader() != null) {
            String[] header = table.getHeader();

            for(int i = 0; i < header.length; i++) {
                System.out.format("%-15s", header[i]);
            }

            System.out.println();

            for(int i = 0; i < header.length; i++) {
                System.out.print("---------------");
            }

            System.out.println();
        }

        ArrayList<String[]> data = table.getTableValues();

        for(int i = 0; i < data.size(); i++) {
            for(int j = 0; j < data.get(i).length; j++) {
                    System.out.format("%-15s", data.get(i)[j]);
            }
            System.out.println();
        }
    }

    public static void printAColumn(Table table, int column) throws IndexOutOfBoundsException {
        if(column < 0 || column > table.getHeader().length)
            throw new IndexOutOfBoundsException();
        for(String[] row : table.getTable()) {
            System.out.println(row[column]);
        }
    }

    public static void statistics(Table table) {
        
    }
}
