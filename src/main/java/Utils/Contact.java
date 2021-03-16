package Utils;

import java.util.Properties;

public class Contact {
    private final String email;
    private final String phone;
    private final String adress;
    private final String postalCode;
    private final String city;

    public Contact(Properties properties) {
        email = properties.getProperty("contact.newEmail");
        phone = properties.getProperty("contact.phoneNumber");
        adress = properties.getProperty("contact.adress");
        postalCode = properties.getProperty("contact.postalCode");
        city = properties.getProperty("contact.city");
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }
}
