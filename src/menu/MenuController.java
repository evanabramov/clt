package menu;

public class MenuController {
    public static void loop() {
        while(true) {
            MainMenu.getInstance().show();
            MainMenu.getInstance().logic();
        }
    }
}
