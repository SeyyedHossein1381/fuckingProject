package Controllers;

import Enums.MainCommands;
import Models.CandyCrush;
import Models.User;
import Views.MainMenu;
import Views.ProfileMenu;
import Views.ShopMenu;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainController {
    private final Scanner scanner;
    private final CandyCrush candyCrush;

    public MainController(Scanner scanner, CandyCrush candyCrush) {
        this.scanner = scanner;
        this.candyCrush = candyCrush;
    }

    public String registerUser(Matcher matcher) {
        User user = new User(matcher.group("username"),
                matcher.group("password"), matcher.group("nickname"));
        String usernameCheck = usernameCheck(user.getUsername());
        boolean passwordCheck = passwordCheck(user.getPassword());
        boolean nicknameCheck = nicknameCheck(user.getNickName());
        if (!usernameCheck.equals("Correct")) {
            return usernameCheck;
        }
        if (!passwordCheck) {
            return "password is weak!";
        }
        if (!nicknameCheck) {
            return "nickname's format is invalid!";
        }
        candyCrush.addUser(user);
        return "user successfully created!";
    }

    public String usernameCheck(String username) {
        for (int i = 0; i < username.length(); i++) {
            if (!((username.charAt(i) >= 'a' && username.charAt(i) <= 'z') || (username.charAt(i) >= 'A' && username.charAt(i) <= 'Z')
                    || (username.charAt(i) >= '0' && username.charAt(i) <= '9') || (username.charAt(i) == '_'))) {
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
        if (password.length() < 8 || password.length() > 32) {
            return false;
        }
        if (password.matches(MainCommands.specialCharactersRegex.name())) {
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

    public boolean nicknameCheck(String nickname) {
        for (int i = 0; i < nickname.length(); i++) {
            if (!((nickname.charAt(i) >= 'a' && nickname.charAt(i) <= 'z') || (nickname.charAt(i) >= 'A' && nickname.charAt(i) <= 'Z')
                    || (nickname.charAt(i) >= '0' && nickname.charAt(i) <= '9') || (nickname.charAt(i) == '_') || (nickname.charAt(i) == ' '))) {
                return false;
            }
        }
        return true;
    }

    public String loginUsers(Matcher matcher) {
        if (usernameCheck(matcher.group("username")).equals("username's format is invalid!")) {
            return "username's format is invalid!";
        }
        if (!usernameCheck(matcher.group("username")).equals("username already exists!")) {
            return "username doesn't exist!";
        }
        for (int i = 0; i < candyCrush.getUsers().size(); i++) {
            if (candyCrush.getUsers().get(i).getUsername().equals(matcher.group("username"))
                    && !candyCrush.getUsers().get(i).getPassword().equals(matcher.group("password"))) {
                return "incorrect password!";
            }
        }
        User user = new User(matcher.group("username"), matcher.group("password"), matcher.group("nickname"));
        MainMenu mainMenu = new MainMenu(user, scanner, candyCrush);
        mainMenu.run();
        return "user logged out!";
    }

    public String listOfUsers() {
        String output;
        output = candyCrush.getUsers().size() + " " + "users have registered!" + "\n";
        int count = 1;
        for (User user : candyCrush.getUsers()) {
            output += count + " - " + user.getNickName() + "\n";
        }
        return output;
    }

    public void enterMenu(Matcher matcher , User user) {
        if (matcher.group("menuName").equals("Shop")){
            ShopMenu shopMenu = new ShopMenu(user , scanner);
            shopMenu.run();
        }
        else{
            ProfileMenu profileMenu = new ProfileMenu(user , scanner);
            profileMenu.run();
        }
    }

}
