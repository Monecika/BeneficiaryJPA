package ceiti.md.beneficiaryfx.model.entities;

import lombok.Data;

@Data
public class DisplayData extends Beneficiaries {
    private String localityName;
    private String cardNumber;

    public DisplayData(int ID, String codeBen, String nameBen, String surnameBen, String phoneBen, String addressBen, String emailBen) {
        super(ID, codeBen, nameBen, surnameBen, phoneBen, addressBen, emailBen);
    }

    public DisplayData(String codeBen, String nameBen, String surnameBen, String phoneBen, String IDNP, String addressBen, String emailBen, String localityName, String environment, String cardNumber) {
        super(codeBen, nameBen, surnameBen, phoneBen, IDNP, addressBen, emailBen, environment);
        this.localityName = localityName;
        this.cardNumber = cardNumber;
    }
}
