package ceiti.md.beneficiaryfx.model.entity;

public class Roles {
    private int ID;
    private String role;

    public Roles(int ID, String role) {
        this.ID = ID;
        this.role = role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
