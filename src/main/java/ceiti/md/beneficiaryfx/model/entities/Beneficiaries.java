package ceiti.md.beneficiaryfx.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Beneficiaries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "nrben")
    private String codeBen;
    @Column(name = "name")
    private String nameBen;
    @Column(name = "surname")
    private String surnameBen;
    @Column(name = "phone")
    private String phoneBen;
    @Column(name = "idnp")
    private String IDNP;
    @Column(name = "address")
    private String addressBen;
    @Column(name = "email")
    private String emailBen;
    @Column(name = "localityid")
    private int localityID;
    @Column(name = "environment")
    private String environment;
    @Column(name = "cardid")
    private int cardID;

    public Beneficiaries(String codeBen, String nameBen, String surnameBen, String phoneBen, String IDNP,
                         String addressBen, String emailBen, String environment) {
        this.codeBen = codeBen;
        this.nameBen = nameBen;
        this.surnameBen = surnameBen;
        this.phoneBen = phoneBen;
        this.IDNP = IDNP;
        this.addressBen = addressBen;
        this.emailBen = emailBen;
        this.environment = environment;
    }

    public Beneficiaries(int ID, String codeBen, String nameBen, String surnameBen, String phoneBen,
                         String addressBen, String emailBen) {
        this.ID = ID;
        this.codeBen = codeBen;
        this.nameBen = nameBen;
        this.surnameBen = surnameBen;
        this.phoneBen = phoneBen;
        this.addressBen = addressBen;
        this.emailBen = emailBen;
    }

    public Beneficiaries(String codeBen, String nameBen, String surnameBen, String phoneBen, String idnp,
                         String addressBen, String emailBen, int localityID, String environment, int cardID) {
        this.codeBen = codeBen;
        this.nameBen = nameBen;
        this.surnameBen = surnameBen;
        this.phoneBen = phoneBen;
        this.IDNP = idnp;
        this.addressBen = addressBen;
        this.emailBen = emailBen;
        this.localityID = localityID;
        this.environment = environment;
        this.cardID = cardID;
    }
}


