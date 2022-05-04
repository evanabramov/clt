package main;

import menu.MainMenu;
import menu.MenuController;

/* TODO:
1. close readers in filehandler DONE
2. comments DONE
3. different regex or clean just read file
4. solve bottomline issue
5. setup gradle, make another branch probably
*/

public class Main {
    public static void main(String[] args) {
        MenuController.loop();
    }
}
