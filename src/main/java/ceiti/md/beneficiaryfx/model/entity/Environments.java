package ceiti.md.beneficiaryfx.model.entity;

public class Environments {
    private int ID;
    private String environment;
    private int popularityPercentage;

    public Environments(int ID, String environment, int popularityPercentage) {
        this.ID = ID;
        this.environment = environment;
        this.popularityPercentage = popularityPercentage;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getPopularityPercentage() {
        return popularityPercentage;
    }

    public void setPopularityPercentage(int popularityPercentage) {
        this.popularityPercentage = popularityPercentage;
    }
}
