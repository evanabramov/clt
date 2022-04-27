package menu;

public class EditingMenu implements Menuable {

    private static EditingMenu instance;

    private EditingMenu() {
        ;
    }

    public static EditingMenu getInstance() {
        if(instance == null)
            instance = new EditingMenu();
        return instance;
    }
    @Override
    public void show() {
        System.out.println("1. Edit a specific cell");
        System.out.println("2. Back");
        System.out.println();
    }

    @Override
    public void logic() {
        switch (this.input()) {
            case 1:
                break;
            case 2:
                return;
            case -1:
                return;
            default:
                System.out.println("There's no such an option");
                return;
        }
    }
}
