import java.io.IOException;
import java.util.ArrayList;

//Class that describes table entity. Table object essentially is the header and the values
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

    //Method that returns representation of the table as a single arrayList;
    public ArrayList<String[]> getTable() {
        ArrayList<String[]> table = new ArrayList<>();

        if(this.header != null || this.header.length != 0) {
            table.add(this.header);
        }

        table.addAll(this.tableValues);
        return table;
    }
}
