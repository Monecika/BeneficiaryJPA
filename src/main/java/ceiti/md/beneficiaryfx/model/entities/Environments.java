package ceiti.md.beneficiaryfx.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Environments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name ="environmenttype")
    private String environment;
    @Column(name = "popularitypercentage")
    private int popularityPercentage;

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
