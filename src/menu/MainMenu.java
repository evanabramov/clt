package menu;
import main.*;
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
        System.out.println("3. Load a file");
        System.out.println("4. Quit");
    }

    private void pass(Menuable menuableEntity) {
        menuableEntity.show();
        menuableEntity.logic();
    }

    @Override
    public void logic() {

        switch (this.input()) {
            case 1:
                pass(ViewingMenu.getInstance());
                break;
            case 2:
                pass(EditingMenu.getInstance());
                break;
            case 3:
                pass(FileLoadingMenu.getInstance());
                break;
            case 4:
                for(StackTraceElement e : Thread.currentThread().getStackTrace()) {
                    System.out.println(e.toString());
                }
                System.exit(0);
                break;
            case -1:
                System.out.println("There's a problem with your input");
                return;
            default:
                System.out.println("There's no such an option");
                return;
        }
    }
}
