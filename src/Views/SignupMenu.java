package Views;

import Controllers.MainController;
import Enums.MainCommands;
import Models.CandyCrush;

import java.util.Scanner;
import java.util.regex.Matcher;

public class SignupMenu {
    private final Scanner scanner;

    public SignupMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String input;
        Matcher matcher;
        CandyCrush candyCrush = new CandyCrush();
        MainController controller = new MainController(scanner, candyCrush);
        while (true) {
            input = scanner.nextLine();
            if (input.equals("exit")) {
                return;
            } else if (MainCommands.getMatcher(input, MainCommands.registerRegex) != null) {
                matcher = MainCommands.getMatcher(input, MainCommands.registerRegex);
                assert matcher != null;
                System.out.println(controller.registerUser(matcher));
            } else if (MainCommands.getMatcher(input, MainCommands.loginRegex) != null) {
                System.out.println("This is login command");
            } else if (MainCommands.getMatcher(input, MainCommands.listOfUsersRegex) != null) {
                System.out.print(controller.listOfUsers());
            } else {
                System.out.println("invalid command");
            }
        }
    }
}
