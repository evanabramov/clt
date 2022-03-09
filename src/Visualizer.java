import java.util.ArrayList;

public class Visualizer {

    private FileHandler fileHandler;
    private ArrayList<String[]> file;

    public Visualizer() {

            this.fileHandler = FileHandler.getInstance();
            file = fileHandler.readFile();
    }

    public void printTable() {

        for(int i = 0; i < fileHandler.getHeight(); i++) {

            for(int j = 0; j < fileHandler.getWidth(); j++) {

                System.out.print(file.get(i)[j] + " \t");
            }
            System.out.println();
        }
    }

    public void printSeparateColumns(ArrayList<Integer> list) {

        for(int i = 0; i < fileHandler.getHeight(); i++) {

            for(int j = 0; j < fileHandler.getWidth(); j++) {

                if(!list.contains(j)) {
                    System.out.print(file.get(i)[j] + "\t");
                }
            }
        }
    }


}
