package Models;

public class User {
    private String username;
    private String password;
    private String nickname;

    public User(String username , String password , String nickname){
        this.username = username;
        this.password = password;
        this.nickname = nickname;
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
}