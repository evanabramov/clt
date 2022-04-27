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

    }

    @Override
    public void logic() {

    }


}
