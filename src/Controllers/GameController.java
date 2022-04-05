package Controllers;

import Models.Bord;
import Models.DeleteingObjects;
import Models.User;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class GameController {
    private User user;
    private Bord bord;

    public GameController(User user, Bord bord) {
        this.user = user;
        this.bord = bord;
    }

    public String swipeCandy(Matcher matcher) {
        int x = Integer.parseInt(matcher.group("X")); // 5
        int y = Integer.parseInt(matcher.group("Y")); // 0
        String direction = matcher.group("direction");
        if (xyCheck(x, y)) {
            return "invalid cell";
        }
        if (!checkDestination(x, y, direction)) {
            return "invalid destination";
        }
        if (!checkSwipe(x, y, direction)) {
            return "invalid move";
        }
        return "swipe cell successful";
    }

    public boolean xyCheck(int x, int y) {
        return (x >= 11 || x < 0 || y >= 11 || y < 0);
    }

    public boolean checkDestination(int x, int y, String direction) {
        if (y == 10 && direction.equals("D")) {
            return false;
        }
        if (x == 10 && direction.equals("R")) {
            return false;
        }
        if (x == 0 && direction.equals("L")) {
            return false;
        }
        if (y == 0 && direction.equals("U")) {
            return false;
        }
        return true;
    }

    public boolean checkSwipe(int x, int y, String direction) {
        if (direction.equals("R")) {
            swipe(x, y, x, y+1);
            y=y+1;
            if ((x + 1) < 11 && (x + 2) < 11 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x + 1, y)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x + 2, y))) {
                return true;
            }
            else if ((y + 1) < 11 && (y + 2) < 11 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 2))) {
                return true;
            }
            else if ((y - 1) >= 0 && (y - 2) >= 0 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y - 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y - 2))) {
                return true;
            }
            else if ((y - 1 >= 0) && (y + 1 < 11) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y - 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 1))) {
                return true;
            }
            swipe(x, y, x - 1, y);
            return false;
        } else if (direction.equals("L")) {
            swipe(x, y, x - 1, y);
            x = x - 1;
            if ((x - 1) >= 0 && (x - 2) >= 0 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x - 1, y)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x - 2, y))) {
                return true;
            }
            else if ((y + 1) < 11 && (y + 2) < 11 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 2))) {
                return true;
            }
            else if ((y - 1) >= 0 && (y - 2) >= 0 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y - 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y - 2))) {
                return true;
            }
            else if ((y - 1 >= 0) && (y + 1 < 11) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y - 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 1))) {
                return true;
            }
            swipe(x, y, x + 1, y);
            return false;
        } else if (direction.equals("U")) {
            swipe(x, y, x, y - 1);
            y = y - 1;
            if ((x + 1) < 11 && (x + 2) < 11 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x + 1, y)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x + 2, y))) {
                return true;
            }
            else if ((x - 1) >= 0 && (x - 2) >= 0 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x - 1, y)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x - 2, y))) {
                return true;
            }
            else if ((y + 1) < 11 && (y + 2) < 11 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 2))) {
                return true;
            }
            else if ((x - 1 >= 0) && (x + 1 < 11) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x - 1, y)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x + 1, y))) {
                return true;
            }
            swipe(x, y, x, y + 1);
            return false;
        } else if (direction.equals("D")) {
            System.out.println("it was found 1");
            swipe(x, y, x+1, y);
            x = x + 1;
            if (x + 2 < 11 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x + 1, y)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x + 2, y))) {
                return true;
            }
            if (y - 2 >= 0 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y - 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y - 2))) {
                return true;
            }
            if (y + 2 < 11 && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 2))) {
                return true;
            }
            if ((y - 1 >= 0) && (y + 1 < 11) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y - 1)) && bord.getElementOfBord(x, y).equals(bord.getElementOfBord(x, y + 1))) {
                System.out.println("it was found 2");
                return true;
            }
            swipe(x, y, x-1, y);
            return false;
        }
        return false;
    }

    public void swipe(int x1, int y1, int x2, int y2) {
        String temp = bord.getElementOfBord(x1, y1);
        bord.setElementOfBord(x1, y1, bord.getElementOfBord(x2, y2));
        bord.setElementOfBord(x2, y2, temp);
    }

    public void deletCandies() {
        ArrayList<DeleteingObjects> deleteingObjectsList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 9; j++) {
                if (bord.getElementOfBord(j, i).equals(bord.getElementOfBord(j + 1, i)) && bord.getElementOfBord(j, i).equals(bord.getElementOfBord(j + 2, i))) {
                    int k = j + 2;
                    while (bord.getElementOfBord(j, i).equals(bord.getElementOfBord(j + k, i))) {
                        k++;
                    }
                    deleteingObjectsList.add(new DeleteingObjects(j, k, i, 'H'));
                }
            }
        }
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 9; j++) {
                if (bord.getElementOfBord(i, j).equals(bord.getElementOfBord(i, j + 1)) && bord.getElementOfBord(i, j).equals(bord.getElementOfBord(i, j + 2))) {
                    int k = j + 2;
                    while (bord.getElementOfBord(i, j).equals(bord.getElementOfBord(i, j + k))) {
                        k++;
                    }
                    deleteingObjectsList.add(new DeleteingObjects(j, k, i, 'V'));
                }
            }
        }
        for (int i = 0; i < deleteingObjectsList.size(); i++) {

        }
    }

    public void setBord(int seed) {
        Function function = new Function(seed);
        int m;
        String temp;
        for (int i = 10; i >= 0; i--) {
            for (int j = 10; j >= 0; j--) {
                m = function.nextInt();
                if (m == 0) {
                    bord.setElementOfBord(i, j, "R");
                } else if (m == 1) {
                    bord.setElementOfBord(i, j, "O");
                } else if (m == 2) {
                    bord.setElementOfBord(i, j, "Y");
                } else if (m == 3) {
                    bord.setElementOfBord(i, j, "G");
                } else if (m == 4) {
                    bord.setElementOfBord(i, j, "B");
                } else if (m == 5) {
                    bord.setElementOfBord(i, j, "P");
                }
            }
        }
    }

    public String showGameBord() {
        String output = "";
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                output += bord.getElementOfBord(i,j) + "\t";
            }
            output += "\n";
        }
        return output;
    }
}
