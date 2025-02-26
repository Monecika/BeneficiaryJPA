package ceiti.md.beneficiaryfx.model.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String cardNr;
    private String cardType;
    private Date dateExpire;

    @OneToOne(mappedBy = "card")
    private Beneficiaries beneficiary;

    public Cards(String cardNr, String cardType, Date daexpire, Beneficiaries beneficiary) {
        this.cardNr = cardNr;
        this.cardType = cardType;
        this.dateExpire = daexpire;
        this.beneficiary = beneficiary;
    }

    @Override
    public String toString() {
        return "Cards{" + "ID=" + ID + ", cardNr='" + cardNr + '\'' + ", cardType='" + cardType + '\'' + ", " +
                "dateExpire=" + dateExpire + ", beneficiary=" + (beneficiary != null ? beneficiary.getCodeBen() :
                "null") + '}';
    }

}
