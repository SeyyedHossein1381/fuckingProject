import Views.SignupMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SignupMenu signupMenu = new SignupMenu(scanner);
        signupMenu.run();
    }
}
