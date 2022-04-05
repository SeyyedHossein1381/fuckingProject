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

    public boolean run(){
        System.out.println("entered Profile menu!");
        String input;
        MainController controller = new MainController(scanner , candyCrush);
        Matcher matcher;
        while (true) {
            input = scanner.nextLine();
            if (MainCommands.getMatcher(input, MainCommands.backRegex) != null) {
                return true;
            } else if (MainCommands.getMatcher(input, MainCommands.removeAccountRegex) != null) {
                matcher = MainCommands.getMatcher(input, MainCommands.removeAccountRegex);
                assert matcher != null;
//                System.out.println(controller.removeAccount(user , matcher.group("currentPassword")));
                return false;
            } else if (MainCommands.getMatcher(input, MainCommands.changePasswordRegex) != null) {
                matcher = MainCommands.getMatcher(input, MainCommands.changePasswordRegex);
                assert matcher != null;
                System.out.println(controller.changePassword(user , matcher.group("oldPassword"), matcher.group("newPassword")));
            } else if (MainCommands.getMatcher(input, MainCommands.showInformationRegex) != null) {
                System.out.println(controller.showInformation(user));
            } else if (MainCommands.getMatcher(input, MainCommands.showMenuRegex) != null) {
                System.out.println("Profile Menu");
            } else {
                System.out.println("invalid command");
            }
        }
    }
}
