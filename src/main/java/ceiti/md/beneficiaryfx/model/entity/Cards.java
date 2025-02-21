package ceiti.md.beneficiaryfx.model.entity;


import java.sql.Date;

public class Cards {
    private int ID;
    private String cardNr;
    private String cardType;
    private Date dateExpire;

    public Cards(int ID, String cardNr, String cardType, Date dateExpire) {
        this.ID = ID;
        this.cardNr = cardNr;
        this.cardType = cardType;
        this.dateExpire = dateExpire;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCardNr() {
        return cardNr;
    }

    public void setCardNr(String cardNr) {
        this.cardNr = cardNr;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Date getDateExpire() {
        return dateExpire;
    }

    public void setDateExpire(Date dateExpire) {
        this.dateExpire = dateExpire;
    }
}
