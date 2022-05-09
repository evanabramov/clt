package main.java.menu;

public class MenuController {
    private MenuController() {}

    // main loop that calls menu
    public static void loop() {
        while(true) {
            MainMenu.getInstance().show();
            MainMenu.getInstance().logic();
        }
    }
}
