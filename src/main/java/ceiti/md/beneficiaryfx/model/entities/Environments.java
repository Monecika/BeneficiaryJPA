package ceiti.md.beneficiaryfx.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Environments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "environmenttype")
    private String environment;

    @Column(name = "popularitypercentage")
    private int popularityPercentage;

    @OneToMany(mappedBy = "environment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Localities> localities;

    @Override
    public String toString() {
        return "Environments{" +
                "ID=" + ID +
                ", environment='" + environment + '\'' +
                ", popularityPercentage=" + popularityPercentage +
                ", localities=" + (localities != null ? localities.size() : 0) + " localities" +
                '}';
    }
}
