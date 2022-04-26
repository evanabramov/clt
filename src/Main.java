public class Main {
    public static void main(String[] args) {
        Initializer initializer = Initializer.getInstance();
        Table table = initializer.initializeTheTable("data/a.csv", "y");
        Visualizer.printCSV(table);
        Visualizer.printTable(table);

    }
}
