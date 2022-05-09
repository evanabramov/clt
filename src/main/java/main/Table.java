package main;

import java.io.IOException;
import java.util.ArrayList;

// class that describes table entity; table object essentially is the header and the values
public class Table {
    private ArrayList<String[]> tableValues;
    private String[] header;

    public Table(ArrayList<String[]> list, String header) throws IOException {
        if (header.equals("y")) {
            this.header = list.get(0);
            list.remove(0);
            this.tableValues = list;
        }

        else if (header.equals("n")) {
            this.tableValues = list;
        }

        else {
            throw new IOException();
        }
    }

    public ArrayList<String[]> getTableValues() {
        return tableValues;
    }

    public void setTableValues(ArrayList<String[]> tableValues) {
        this.tableValues = tableValues;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    // returns representation of the table as arrayList;
    public ArrayList<String[]> getTable() {
        ArrayList<String[]> table = new ArrayList<>();

        if(this.header != null) {
            table.add(this.header);
        }

        table.addAll(this.tableValues);
        return table;
    }
}
