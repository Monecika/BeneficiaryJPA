package ceiti.md.beneficiaryfx.model.entity;

import java.util.Date;

public class
Users {
    private int ID;
    private String username;
    private String password;
    private Date createdAt;
    private int roleID;

    public Users(int ID, String username, String password, Date createdAt, int roleID) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.roleID = roleID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
}
