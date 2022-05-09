package menu;

// thrown when viewing or editing menus are called with no file loaded
public class NoTableLoadedException extends Exception {
    @Override
    public String getMessage() {
        return "There's no table loaded";
    }
}
