package ceiti.md.beneficiaryfx.model.entities;

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
    @Column(name = "environmenttype")
    private String environment;
    @Column(name = "popularitypercentage")
    private int popularityPercentage;
}
