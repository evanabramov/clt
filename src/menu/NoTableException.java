package menu;

public class NoTableException extends Exception {
    @Override
    public String getMessage() {
        return "There's no table loaded";
    }
}
