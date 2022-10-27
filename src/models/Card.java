package models;

public class Card {
    private final String number;
    private final String expireData;
    private final CardType cardType;
    private double balans;


    public Card(String number, String expireData, CardType cardType) {
        this.number = number;
        this.expireData = expireData;
        this.cardType = cardType;
    }

    public String getNumber() {
        return number;
    }

    public double getBalans(){
        return balans;
    }

    public void setBalans(double balans){
        this.balans = balans;
    }

    public String toString(){
        return "Карты -> " +
                "номер: " + number +
                " срок: " + expireData +
                " вид: " + cardType +
                " \nБаланс: " + balans;
    }

}
