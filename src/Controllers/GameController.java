package Controllers;

import Models.Bord;
import Models.User;

import java.util.regex.Matcher;

public class GameController {
    private User user;
    private Bord bord;

    public GameController(User user , Bord bord) {
        this.user = user;
        this.bord = bord;
    }

    public String swipeCandy(Matcher matcher){
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        String diriction = matcher.group("diriction");
        return "Hello";
    }
}
