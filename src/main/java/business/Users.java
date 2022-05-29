package business;

import java.util.Objects;

public class Users {
    private long id;
    private String username;
    private String password;
    private int type;

    public Users(long id, String username, String password, int type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Users user = (Users) obj;
        return id == user.id && username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public String toString() {
        return "id= " + id + " username= " + username + " password= " + password;
    }
}
