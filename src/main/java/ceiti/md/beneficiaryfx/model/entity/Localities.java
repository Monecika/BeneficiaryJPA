package ceiti.md.beneficiaryfx.model.entity;

public class
Localities {
    private int ID;
    private String localityName;
    private String localityType;
    private int environmentID;
    private int population;
    private double area;

    public Localities(int ID, String localityName, String localityType, int environmentID, int population, double area) {
        this.ID = ID;
        this.localityName = localityName;
        this.localityType = localityType;
        this.environmentID = environmentID;
        this.population = population;
        this.area = area;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLocalityName() {
        return localityName;
    }

    public void setLocalityName(String localityName) {
        this.localityName = localityName;
    }

    public String getLocalityType() {
        return localityType;
    }

    public void setLocalityType(String localityType) {
        this.localityType = localityType;
    }

    public int getEnvironmentID() {
        return environmentID;
    }

    public void setEnvironmentID(int environmentID) {
        this.environmentID = environmentID;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
