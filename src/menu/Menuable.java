package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public interface Menuable {

    void show();

    void logic();

    default void pass(Menuable menuableEntity) {
        menuableEntity.show();
        menuableEntity.logic();
    }

    default int input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(reader.readLine());
        }

        catch(NumberFormatException e) {
            System.out.println("String can't be parsed to int");
        }

        catch(IOException e) {
            e.printStackTrace();
            System.out.println("There was a problem with your input");
        }

        return -1;
    }
}
