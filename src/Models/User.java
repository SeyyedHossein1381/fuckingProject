package Models;

public class User {
    private String username;
    private String password;
    private String nickname;
    private int highScore;
    private int money;

    public User(String username , String password , String nickname){
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.money = 100;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickname;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}