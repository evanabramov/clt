import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Initializer {

    private static Initializer instance;

    private Initializer() {
        ;
    }

    public static Initializer getInstance() {
        if(instance == null)
            instance = new Initializer();
        return instance;
    }

    //Initializes the table by the given path. Returns the table if succeeded, null otherwise.
    public Table initializeTheTable(String PATH, String header) {
        FileHandler fileHandler = FileHandler.getInstance();
        Table table = null;

        try {
            fileHandler.setPATH(PATH);
            ArrayList<String[]> list = fileHandler.readFile();
            table = new Table(list, header);
        }

        catch(FileNotFoundException e) {
            System.out.println("File was not found!");
        }

        catch (IOException e) {
            System.out.println("File couldn't be read!");
        }
        
        return table;
    }
}
