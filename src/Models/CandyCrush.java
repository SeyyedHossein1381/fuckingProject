package Models;

import java.util.ArrayList;

public class CandyCrush {
    private ArrayList<User> users = new ArrayList<User>();

    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    /*public User getUserByNickname(String nickname){
        for (User user: users) {
            if (user == nickname){
                return user;
            }
        }
    }*/

}
