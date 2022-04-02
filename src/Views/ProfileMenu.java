package Views;

import Controllers.MainController;
import Enums.MainCommands;
import Models.CandyCrush;
import Models.User;

import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenu {
    User user;
    Scanner scanner;
    CandyCrush candyCrush;

    public ProfileMenu(User user , Scanner scanner , CandyCrush candyCrush){
        this.user = user;
        this.scanner = scanner;
        this.candyCrush = candyCrush;
    }

    public void run(){
        System.out.println("entered Profile menu!");
        String input;
        MainController controller = new MainController(scanner , candyCrush);
        Matcher matcher;
        while (true) {
            input = scanner.nextLine();
            if (MainCommands.getMatcher(input, MainCommands.backRegex) != null) {
                return;
            } else {
                System.out.println("invalid command");
            }
        }
    }
}
