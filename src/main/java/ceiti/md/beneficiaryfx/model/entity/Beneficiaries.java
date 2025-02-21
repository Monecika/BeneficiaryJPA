package ceiti.md.beneficiaryfx.model.entity;

public class Beneficiaries {
    private int ID;
    private String codeBen;
    private String nameBen;
    private String surnameBen;
    private String phoneBen;
    private String IDNP;
    private String addressBen;
    private String emailBen;
    private int localityID;
    private String environment;
    private int cardID;

    public Beneficiaries(String codeBen, String nameBen, String surnameBen, String phoneBen, String IDNP, String addressBen, String emailBen, String environment) {
        this.codeBen = codeBen;
        this.nameBen = nameBen;
        this.surnameBen = surnameBen;
        this.phoneBen = phoneBen;
        this.IDNP = IDNP;
        this.addressBen = addressBen;
        this.emailBen = emailBen;
        this.environment = environment;
    }

    public Beneficiaries(int ID, String codeBen, String nameBen, String surnameBen, String phoneBen, String addressBen, String emailBen, String environment) {
        this.ID = ID;
        this.codeBen = codeBen;
        this.nameBen = nameBen;
        this.surnameBen = surnameBen;
        this.phoneBen = phoneBen;
        this.addressBen = addressBen;
        this.emailBen = emailBen;
        this.environment = environment;
    }

    public Beneficiaries(int ID, String codeBen, String nameBen, String surnameBen, String phoneBen, String addressBen, String emailBen) {
        this.ID = ID;
        this.codeBen = codeBen;
        this.nameBen = nameBen;
        this.surnameBen = surnameBen;
        this.phoneBen = phoneBen;
        this.addressBen = addressBen;
        this.emailBen = emailBen;
    }

    public Beneficiaries(int ID, String codeBen, String nameBen, String surnameBen, String phoneBen, String IDNP, String addressBen, String emailBen, int localityID, String environment, int cardID) {
        this.ID = ID;
        this.codeBen = codeBen;
        this.nameBen = nameBen;
        this.surnameBen = surnameBen;
        this.phoneBen = phoneBen;
        this.IDNP = IDNP;
        this.addressBen = addressBen;
        this.emailBen = emailBen;
        this.localityID = localityID;
        this.environment = environment;
        this.cardID = cardID;
    }


    public String getCodeBen() {
        return codeBen;
    }

    public void setCodeBen(String codeBen) {
        this.codeBen = codeBen;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNameBen() {
        return nameBen;
    }

    public void setNameBen(String nameBen) {
        this.nameBen = nameBen;
    }

    public String getSurnameBen() {
        return surnameBen;
    }

    public void setSurnameBen(String surnameBen) {
        this.surnameBen = surnameBen;
    }

    public String getPhoneBen() {
        return phoneBen;
    }

    public void setPhoneBen(String phoneBen) {
        this.phoneBen = phoneBen;
    }

    public String getIDNP() {
        return IDNP;
    }

    public void setIDNP(String IDNP) {
        this.IDNP = IDNP;
    }

    public String getAddressBen() {
        return addressBen;
    }

    public void setAddressBen(String addressBen) {
        this.addressBen = addressBen;
    }

    public String getEmailBen() {
        return emailBen;
    }

    public void setEmailBen(String emailBen) {
        this.emailBen = emailBen;
    }

    public int getLocalityID() {
        return localityID;
    }

    public void setLocalityID(int localityID) {
        this.localityID = localityID;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    @Override
    public String toString() {
        return "Beneficiaries{" + "ID=" + ID + ", codeBen='" + codeBen + '\'' + ", nameBen='" + nameBen + '\'' + ", surnameBen='" + surnameBen + '\'' + ", phoneBen='" + phoneBen + '\'' + ", IDNP='" + IDNP + '\'' + ", addressBen='" + addressBen + '\'' + ", emailBen='" + emailBen + '\'' + ", localityID=" + localityID + ", environment='" + environment + '\'' + ", cardID=" + cardID + '}';
    }
}
