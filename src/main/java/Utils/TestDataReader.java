package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private final String testDataLocation = "src/test/java/TestData.properties";
    private Properties properties;

    private Card card;
    private Contact contact;
    private Person person;

    public TestDataReader() {
        loadFile();
        loadData();
    }

    public void loadFile() {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(getTestDataLocation()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        card = new Card(properties);
        contact = new Contact(properties);
        person = new Person(properties);
    }

    public String getTestDataLocation() {
        return testDataLocation;
    }

    public Card getCard() {
        return card;
    }

    public Contact getContact() {
        return contact;
    }

    public Person getPerson() {
        return person;
    }
}
