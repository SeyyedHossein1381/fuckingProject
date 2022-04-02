package Models;

public class User {
    private String username;
    private String password;
    private String nickName;

    public User(String username , String password , String nickName){
        this.username = username;
        this.password = password;
        this.nickName = nickName;
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
        return nickName;
    }
}