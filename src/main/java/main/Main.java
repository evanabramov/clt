package main.java.main;

import main.java.menu.MainMenu;
import main.java.menu.MenuController;

/* TODO:
1. close readers in filehandler DONE
2. comments DONE
3. different regex or clean just read file DONE
4. solve bottomline issue DONE
5. setup gradle, make another branch probably
*/

public class Main {
    public static void main(String[] args) {
        MenuController.loop();
    }
}
