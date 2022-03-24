import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Initializer initializer = Initializer.getInstance();
        Table table = initializer.initializeTheTable("K:\\SampleCSVFile_119kb.csv", "y");
        Visualizer.printCSV(table);
        Visualizer.printTable(table);

    }
}
