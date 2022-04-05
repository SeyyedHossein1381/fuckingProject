package Views;

import Controllers.GameController;
import Controllers.MainController;
import Enums.MainCommands;
import Models.Bord;
import Models.User;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu {
    User user;
    Scanner scanner;

    public GameMenu(User user , Scanner scanner){
        this.user = user;
        this.scanner = scanner;
    }

    public int run(){
        String input;
        Bord bord = new Bord();
        GameController controller = new GameController(user , bord);
        Matcher matcher;
        while (true) {
            input = scanner.nextLine();
            if (MainCommands.getMatcher(input, MainCommands.startNewGameRegex) != null) {

            } else if (MainCommands.getMatcher(input, MainCommands.startNewGameRegex) != null) {
            } else if (MainCommands.getMatcher(input, MainCommands.startNewGameRegex) != null) {
            } else if (MainCommands.getMatcher(input, MainCommands.showScoreboardRegex) != null) {
            } else {
                System.out.println("invalid command");
            }
        }
    }
}
