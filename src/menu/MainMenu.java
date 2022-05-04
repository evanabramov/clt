package menu;
import main.*;
// main menu
public class MainMenu implements Menuable {

    private static MainMenu instance;

    private MainMenu() {
        ;
    }

    public static MainMenu getInstance() {
        if(instance == null)
            instance = new MainMenu();
        return instance;
    }

    @Override
    public void show() {
        System.out.println("Simple csv files' viewer and editor.\nMade by Evan Abramov @evanabramov.");
        System.out.println("Filepath: " + FileHandler.getInstance().getPATH());

        System.out.println("1. Viewing");
        System.out.println("2. Editing");
        System.out.println("3. File handling");
        System.out.println("4. Quit");
    }

    // calls another menuable object
    private void pass(Menuable menuableEntity) {
        menuableEntity.show();
        menuableEntity.logic();
    }

    @Override
    public void logic() {

        try {
        switch (this.input()) {
            case 1:
                if (FileHandler.getInstance().getTable() == null)
                    throw new NoTableLoadedException();
                pass(ViewingMenu.getInstance());
                break;
            case 2:
                if (FileHandler.getInstance().getTable() == null)
                    throw new NoTableLoadedException();
                pass(EditingMenu.getInstance());
                break;
            case 3:
                pass(FileHandlingMenu.getInstance());
                break;
            case 4:
                System.exit(0);
                break;
            case -1:
                System.out.println("There's a problem with your input\n");
                return;
            default:
                System.out.println("There's no such an option\n");
                return;
            }
        }

        catch (NoTableLoadedException e) {
            System.out.println(e.getMessage() + "\n");
        }
    }
}
