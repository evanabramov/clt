package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// menu entity blueprint; menus are singletons implementing menuable interface
public interface Menuable {

    void show();

    void logic();

    default int input() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int input = Integer.parseInt(reader.readLine());
            System.out.println();
            return input;
        }

        catch(NumberFormatException e) {
            System.out.println("String can't be parsed to int\n");
        }

        catch(IOException e) {
            e.printStackTrace();
            System.out.println("There was a problem with your input\n");
        }

        return -1;
    }
}
