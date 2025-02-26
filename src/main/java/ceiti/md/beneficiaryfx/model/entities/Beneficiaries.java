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

    @ManyToOne
    @JoinColumn(name = "localityid", referencedColumnName = "ID")
    private Localities locality;

    private String environment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cardid", referencedColumnName = "id")
    private Cards card;

    public Beneficiaries(String codeBen, String name, String surname, String phoneNumber, String idnp, String address
            , String email, Localities locality, String environment, Cards card) {
        this.codeBen = codeBen;
        this.nameBen = name;
        this.surnameBen = surname;
        this.phoneBen = phoneNumber;
        this.IDNP = idnp;
        this.addressBen = address;
        this.emailBen = email;
        this.locality = locality;
        this.environment = environment;
        this.card = card;
    }

    @Override
    public String toString() {
        return "Beneficiaries{" + "ID=" + ID + ", codeBen='" + codeBen + '\'' + ", nameBen='" + nameBen + '\'' + ", " +
                "surnameBen='" + surnameBen + '\'' + ", phoneBen='" + phoneBen + '\'' + ", IDNP='" + IDNP + '\'' + "," +
                " addressBen='" + addressBen + '\'' + ", emailBen='" + emailBen + '\'' + ", locality=" + locality.getLocalityName() + ", environment='" + environment + '\'' + ", card=" + card.getCardNr() + '}';
    }
}
