package BusinessLogic;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String user;
    private String password;

    public User(int id, String user, String password) {
        this.id = id;
        this.user = user;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        return "User:" + "id" + id + ", Name='" + user + "\'";
    }
}
