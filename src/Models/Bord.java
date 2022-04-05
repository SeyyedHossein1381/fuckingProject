package Models;

public class Bord {
    private String[][] board = new String[11][11];

    public String[][] getBord() {
        return board;
    }

    public void setBord(String[][] board) {
        this.board = board;
    }

    public String getElementOfBord(int i , int j){
        return board[i][j];
    }

    public void setElementOfBord(int i , int j , String element){
        board[i][j] = element;
    }
}
