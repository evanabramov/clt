package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;
import java.util.stream.IntStream;

// visualization class.
public class Visualizer {

    public static Visualizer instance;

    private Visualizer() {
        ;
    }

    public static Visualizer getInstance() {
        if(instance == null)
            instance = new Visualizer();
        return instance;
    }

    // prints table as csv file, might not be the same as it was initially file-wise
    public void printCSV(Table table) {
        System.out.println();

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

        System.out.println("\n");
    }

    // prints the table
    public void printTable(Table table) {
        System.out.println();

        String leftAlignFormat = leftAlignFormat(table);
        /* since columnsWidth method gives us 1 less on each column than leftAlignFormat calculates,
           we count bottomLineSum like this */
        int[] widths = columnsWidth(table);
        int bottomLineSum = IntStream.of(widths).sum() + 2 * widths.length - 1;

        int header = 0;
        if (table.getHeader() != null)
            header = 1;

        for (String[] row : table.getTable()) {
            try {
                // varargs call, cast to object[] to make it obvious
                System.out.format(leftAlignFormat, (Object[]) row);
                if (header == 1) {
                    System.out.println(bottomLine(bottomLineSum));
                    header = 0;
                }
            } catch (MissingFormatArgumentException e) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    // row widths
    private int width(Table table) {
        int width = 0;
        ArrayList<String[]> tableAsList = table.getTable();

        for(String[] row : tableAsList) {
            if(width < row.length)
                width = row.length;
        }

        return width;
    }

    // maximum cell length in a column
    private int[] columnsWidth(Table table) {
        int[] columns = new int[width(table)];
        ArrayList<String[]> tableAsList = table.getTable();

        for(int i = 0; i < tableAsList.size(); i++) {
            for(int j = 0; j < tableAsList.get(i).length; j++) {
                if(columns[j] == 0 || columns[j] < tableAsList.get(i)[j].length()) {
                    columns[j] = tableAsList.get(i)[j].length();
                }
            }
        }
        return columns;
    }

    // assembles a string for formatting
    private String leftAlignFormat(Table table) {
        int[] widths = columnsWidth(table);
        String leftAlignFormat = "|%-";

        for(int width : widths) {
            int temp = width + 1;
            leftAlignFormat += temp;
            if(width != widths[widths.length - 1])
                leftAlignFormat += "s|%-";
        }

        leftAlignFormat += "s|%n";
        return leftAlignFormat;
    }

    // assembles a header-values divider
    private String bottomLine(int length) {
        return "+" + "-".repeat(length) + "+";
    }
}
