package Controllers;

import Models.Bord;
import Models.Function;
import Models.User;

import java.util.regex.Matcher;

public class GameController {
    private User user;
    private Bord board;

    public GameController(User user, Bord board) {
        this.user = user;
        this.board = board;
    }

    public void setBoard(int seed) {
        Function function = new Function(seed);
        int n;
        for (int i = 10; i >= 0; i--) {
            for (int j = 10; j >= 0; j--) {
                n = function.nextInt();
                if (n == 0) {
                    board.setElementOfBord(i, j, "R");
                } else if (n == 1) {
                    board.setElementOfBord(i, j, "O");
                } else if (n == 2) {
                    board.setElementOfBord(i, j, "Y");
                } else if (n == 3) {
                    board.setElementOfBord(i, j, "G");
                } else if (n == 4) {
                    board.setElementOfBord(i, j, "B");
                } else if (n == 5) {
                    board.setElementOfBord(i, j, "P");
                }
            }
        }
    }

    public String showBoard() {
        String ouput = "";
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                ouput += board.getElementOfBord(i, j) + "\t";
            }
            ouput += "\n";
        }
        return ouput;
    }

    public String swipeCandy(Matcher matcher) {
        int i = Integer.parseInt(matcher.group("X")); // 5
        int j = Integer.parseInt(matcher.group("Y")); // 0
        String direction = matcher.group("direction");
        if (xyCheck(i, j)) {
            return "invalid cell";
        }
        if (checkDestination(i, j, direction)) {
            return "invalid destination";
        }
        if (!checkSwipe(i, j, direction)) {
            return "invalid move";
        }
        return "swipe cell successful";
    }

    public void swipe(int i1, int j1, int i2, int j2) {
        String temp = board.getElementOfBord(i1, j1);
        board.setElementOfBord(i1, j1, board.getElementOfBord(i2, j2));
        board.setElementOfBord(i2, j2, temp);
    }

    public boolean xyCheck(int i, int j) {
        return (i >= 11 || i < 0 || j >= 11 || j < 0);
    }

    public boolean checkDestination(int i, int j, String direction) {
        return ((i == 0 && direction.equals("U")) || (i == 10 && direction.equals("D")) || (j == 0 && direction.equals("L")) || (i == 10 && direction.equals("R")));
    }

    public boolean checkSwipe(int i, int j, String direction) {
        char mod = board.getElementOfBord(i, j).charAt(0);
        if (direction.equals("R")) {
            swipe(i, j, i, j + 1);
            j = j + 1;
            if ((j < 9) && (board.getElementOfBord(i, j + 1).charAt(0) == mod) && (board.getElementOfBord(i, j + 2).charAt(0) == mod)) {
                return true;
            } else if ((i < 9) && (board.getElementOfBord(i + 1, j).charAt(0) == mod) && (board.getElementOfBord(i + 2, j).charAt(0) == mod)) {
                return true;
            } else if ((i > 1) && (board.getElementOfBord(i - 1, j).charAt(0) == mod) && (board.getElementOfBord(i - 2, j).charAt(0) == mod)) {
                return true;
            } else if ((i >= 0 && i <= 10) && (board.getElementOfBord(i + 1, j).charAt(0) == mod) && (board.getElementOfBord(i - 1, j).charAt(0) == mod)) {
                return true;
            }
            swipe(i, j, i, j - 1);
            return false;
        } else if (direction.equals("L")) {
            swipe(i, j, i, j - 1);
            j = j - 1;
            if ((j > 1) && (board.getElementOfBord(i, j - 1).charAt(0) == mod) && (board.getElementOfBord(i, j - 2).charAt(0) == mod)) {
                return true;
            } else if ((i < 9) && (board.getElementOfBord(i + 1, j).charAt(0) == mod) && (board.getElementOfBord(i + 2, j).charAt(0) == mod)) {
                return true;
            } else if ((i > 1) && (board.getElementOfBord(i - 1, j).charAt(0) == mod) && (board.getElementOfBord(i - 2, j).charAt(0) == mod)) {
                return true;
            } else if ((i >= 0 && i <= 10) && (board.getElementOfBord(i + 1, j).charAt(0) == mod) && (board.getElementOfBord(i - 1, j).charAt(0) == mod)) {
                return true;
            }
            swipe(i, j, i, j + 1);
            return false;
        } else if (direction.equals("D")) {
            swipe(i, j, i + 1, j);
            i = i + 1;
            if ((j < 9) && (board.getElementOfBord(i, j + 1).charAt(0) == mod) && (board.getElementOfBord(i, j + 2).charAt(0) == mod)) {
                return true;
            } else if ((j > 1) && (board.getElementOfBord(i, j - 1).charAt(0) == mod) && (board.getElementOfBord(i, j - 2).charAt(0) == mod)) {
                return true;
            } else if ((i < 9) && (board.getElementOfBord(i + 1, j).charAt(0) == mod) && (board.getElementOfBord(i + 2, j).charAt(0) == mod)) {
                return true;
            } else if ((j >= 0 && j <= 10) && (board.getElementOfBord(i, j+1).charAt(0) == mod) && (board.getElementOfBord(i, j-1).charAt(0) == mod)) {
                return true;
            }
            swipe(i, j, i - 1, j);
            return false;
        } else {
            swipe(i, j, i - 1, j);
            i = i - 1;
            if ((j > 9) && (board.getElementOfBord(i, j + 1).charAt(0) == mod) && (board.getElementOfBord(i, j + 2).charAt(0) == mod)) {
                return true;
            } else if ((j > 1) && (board.getElementOfBord(i, j - 1).charAt(0) == mod) && (board.getElementOfBord(i, j - 2).charAt(0) == mod)) {
                return true;
            } else if ((i > 1) && (board.getElementOfBord(i - 1, j).charAt(0) == mod) && (board.getElementOfBord(i - 2, j).charAt(0) == mod)) {
                return true;
            } else if ((j >= 0 && j <= 10) && (board.getElementOfBord(i, j+1).charAt(0) == mod) && (board.getElementOfBord(i, j-1).charAt(0) == mod)) {
                return true;
            }
            swipe(i, j, i + 1, j);
            return false;
        }
    }


}
