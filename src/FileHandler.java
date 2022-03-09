import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static FileHandler instance;
    private BufferedReader reader;
    private String PATH;
    private ArrayList<String[]> list;
    private int width, height;

    private FileHandler() {
        ;
    }

    public static FileHandler getInstance() {
        if(instance == null)
            instance = new FileHandler();
        return instance;
    }

    public void setPATH (String PATH) {
        this.PATH = PATH;

        try {
            reader = new BufferedReader(new FileReader(PATH));
        }

        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public String getPATH() {
        return this.PATH;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<String[]> readFile () {

        list = new ArrayList<>();

        try {
            while (reader.ready()) {
                list.add(reader.readLine().split(","));
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        height = list.size();
        width = list.get(height - 1).length;

        return list;
    }
}
