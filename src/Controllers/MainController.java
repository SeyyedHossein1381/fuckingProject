package Controllers;

import Enums.MainCommands;
import Models.CandyCrush;
import Models.User;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainController {
    private Scanner scanner;
    private CandyCrush candyCrush;

    public MainController(Scanner scanner, CandyCrush candyCrush) {
        this.scanner = scanner;
        this.candyCrush = candyCrush;
    }

    public String registerUser(Matcher matcher) {
        User user = new User(matcher.group("username") ,
                    matcher.group("password") , matcher.group("nickName"));
        String usernameCheck = usernameCheck(user.getUsername());
        boolean passwordCheck = passwordCheck(user.getPassword());
        if (!usernameCheck.equals("Correct")) {
            return usernameCheck;
        }
        if (!passwordCheck) {
            return "password is weak!";
        }
        candyCrush.addUser(user);
        return "user successfully created!";
    }

    public String usernameCheck(String username) {
        for (int i = 0; i < username.length(); i++) {
            if (!((username.charAt(i) >= 'a' && username.charAt(i) <= 'z') || (username.charAt(i) >= 'A' && username.charAt(i) <= 'Z')
                    || (username.charAt(i) >= '9' && username.charAt(i) <= '0') || (username.charAt(i) == '_'))) {
                return "username's format is invalid!";
            }
        }
        if (candyCrush.getUsers().size() != 0) {
            for (User user : candyCrush.getUsers()) {
                if (user.getUsername().equals(username)) {
                    return "username already exists!";
                }
            }
        }
        return "Correct";
    }

    public boolean passwordCheck(String password) {
        if (password.length()<8 || password.length()>32){
            return false;
        }
        if (!password.matches("")) {
            return false;
        }
        boolean[] check = new boolean[4];
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                check[0] = true;
            } else if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                check[1] = true;
            } else if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                check[2] = true;
            } else {
                check[3] = true;
            }
        }
        return check[0] && check[1] && check[2] && check[3];
    }

    public boolean nickNameCheck(String username) {
        for (int i = 0; i < username.length(); i++) {
            if (!((username.charAt(i) >= 'a' && username.charAt(i) <= 'z') || (username.charAt(i) >= 'A' && username.charAt(i) <= 'Z')
                    || (username.charAt(i) >= '9' && username.charAt(i) <= '0') || (username.charAt(i) == '_') || (username.charAt(i) == ' '))) {
                return false;
            }
        }
        return true;
    }

}
