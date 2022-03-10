import java.io.*;
import java.util.ArrayList;


// FileHandler class is a singleton that provides basic read and write methods.
public class FileHandler {

    private static FileHandler instance;
    private BufferedReader reader;
    private BufferedWriter writer;
    private ArrayList<String[]> originalList;
    private String PATH;

    private FileHandler() {
        ;
    }

    public static FileHandler getInstance() {
        if(instance == null)
            instance = new FileHandler();
        return instance;
    }

    public void setPATH (String PATH) throws FileNotFoundException {
        this.PATH = PATH;
        reader = new BufferedReader(new FileReader(PATH));
    }


    //Reads a file by the given earlier PATH
    public ArrayList<String[]> readFile () throws IOException {
        originalList = new ArrayList<>();

            while (reader.ready()) {
                originalList.add(reader.readLine().split(","));
            }

        return originalList;
    }

    //Cleans all possible whitespaces in the read strings, requires readFile() prior to this method .
    public ArrayList<String[]> cleanFile() throws IOException {
        if(originalList.isEmpty()) {
            throw new IOException();
        }

        ArrayList<String[]> cleanList = new ArrayList<>();

        for(int i = 0; i < originalList.size(); i++) {
            String[] line = originalList.get(i);
            for(int j = 0; j < line.length; j++) {
                line[j] = line[j].replaceAll(" ", "");
            }

            cleanList.add(line);
        }

        return cleanList;
    }

    //Writes to a file with a given list
    public void writeFile(ArrayList<String[]> list, String path) throws IOException {
        String prompt;
        writer = new BufferedWriter(new FileWriter(path));

        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.get(i).length; j++) {
                if(j != list.get(i).length - 1)
                    writer.write(list.get(i)[j] + ",");
                else
                    writer.write(list.get(i)[j]);
            }
        }
    }
}
