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
public class Localities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    private String localityName;
    private String localityType;
    private int population;
    private double area;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "environmentID", referencedColumnName = "ID")
    private Environments environment;

    @OneToMany(mappedBy = "locality", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Beneficiaries> beneficiaries;

    @Override
    public String toString() {
        return "Localities{" + "ID=" + ID + ", localityName='" + localityName + '\'' + ", localityType='" + localityType + '\'' + ", population=" + population + ", area=" + area + ", environment=" + environment.getEnvironment() + ", beneficiaries=" + beneficiaries.size() + '}';
    }
}
