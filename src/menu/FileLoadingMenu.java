package menu;

public class FileLoadingMenu implements Menuable {

    private static FileLoadingMenu instance;

    private FileLoadingMenu() {
        ;
    }

    public static FileLoadingMenu getInstance() {
        if(instance == null)
            instance = new FileLoadingMenu();
        return instance;
    }

    @Override
    public void show() {
        System.out.println("1. Proceed");
        System.out.println("2. Back");
    }

    @Override
    public void logic() {
        switch(input()) {
            case 1:
                break;
            case 2:
                return;
            case -1:
                System.out.println("There's no such an option!");
                return;
            default:
                System.out.println("There's a problem with your input");
                return;
        }
    }


}
