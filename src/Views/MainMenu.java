package Views;

import Controllers.MainController;
import Enums.MainCommands;
import Models.CandyCrush;
import Models.User;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu {
    User user;
    Scanner scanner;
    CandyCrush candyCrush;

    public MainMenu(User user, Scanner scanner, CandyCrush candyCrush) {
        this.user = user;
        this.scanner = scanner;
        this.candyCrush = candyCrush;
    }

    public String run() {
        System.out.println("user successfully logged in!");
        String input;
        MainController controller = new MainController(scanner, candyCrush);
        Matcher matcher;
        while (true) {
            input = scanner.nextLine();
            if (MainCommands.getMatcher(input, MainCommands.logoutRegex) != null) {
                return "user logged out!\n";
            } else if (MainCommands.getMatcher(input, MainCommands.startNewGameRegex) != null) {
                matcher = MainCommands.getMatcher(input, MainCommands.startNewGameRegex);
                assert matcher != null;
                System.out.println(controller.startGame(scanner , user , matcher));
            } else if (MainCommands.getMatcher(input, MainCommands.enterMenuRegex) != null) {
                matcher = MainCommands.getMatcher(input, MainCommands.enterMenuRegex);
                assert matcher != null;
                if (!controller.enterMenu(matcher, user)) {
                    return "";
                }
            } else if (MainCommands.getMatcher(input, MainCommands.showScoreboardRegex) != null) {

            } else {
                System.out.println("invalid command");
            }
        }
    }
}
