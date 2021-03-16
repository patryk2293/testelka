package Utils;

import java.util.Properties;

public class Card {
    private final String cardNumber;
    private final String dateOfExpire;
    private final String CVCNumber;

    public Card(Properties properties) {
        cardNumber = properties.getProperty("card.cardNumber");
        dateOfExpire = properties.getProperty("card.dateOfExpire");
        CVCNumber = properties.getProperty("card.CVC");
    }

    public String getCVCNumber() {
        return CVCNumber;
    }

    public String getDateOfExpire() {
        return dateOfExpire;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
