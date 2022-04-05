package Models;

public class Bord {
    private String[][] bord = new String[11][11];

    public String[][] getBord() {
        return bord;
    }

    public void setBord(String[][] bord) {
        this.bord = bord;
    }

    public String getElementOfBord(int x , int y){
        return bord[y][x];
    }

    public void setElementOfBord(int x , int y , String element){
        bord[y][x] = element;
    }
}
