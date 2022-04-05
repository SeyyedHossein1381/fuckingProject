package Views;

import Controllers.GameController;
import Controllers.MainController;
import Enums.GameCommands;
import Enums.MainCommands;
import Models.Bord;
import Models.User;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu {
    User user;
    Scanner scanner;
    private int seed;
    private int move;

    public GameMenu(User user , Scanner scanner , int seed , int move){
        this.user = user;
        this.scanner = scanner;
        this.move = move;
        this.seed = seed;
    }

    public int run(){
        String input;
        Bord bord = new Bord();
        GameController controller = new GameController(user , bord);
        controller.setBoard(seed);
        Matcher matcher;
        while (true) {
            input = scanner.nextLine();
            if (GameCommands.getMatcher(input, GameCommands.showBoardRegex) != null) {
                System.out.print(controller.showBoard());
            } else if (GameCommands.getMatcher(input, GameCommands.swipeRegex) != null) {
                matcher = GameCommands.getMatcher(input, GameCommands.swipeRegex) ;
                assert matcher != null;
                System.out.println(controller.swipeCandy(matcher));
            } else {
                System.out.println("invalid command");
            }
        }
    }
}
