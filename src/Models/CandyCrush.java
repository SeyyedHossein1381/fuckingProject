package Models;

import java.util.ArrayList;

public class CandyCrush {
    private ArrayList<User> users = new ArrayList<User>();

    public void addUser(User user) {
        users.add(user);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUserByNickname(String nickname) {
        for (User user : users) {
            if (user.getNickName().equals(nickname)) {
                return user;
            }
        }
        return null;
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

}
