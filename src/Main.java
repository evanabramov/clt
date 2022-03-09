import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        FileHandler fileHandler = FileHandler.getInstance();
        fileHandler.setPATH("/home/kawa1sou/Workspace/qwe.txt");

           Visualizer visualizer = new Visualizer();
            fileHandler.readFile();
        visualizer.printTable();
    }
}
