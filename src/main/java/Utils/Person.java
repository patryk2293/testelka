package Utils;

import java.util.Properties;

public class Person {
    private final String firstName;
    private final String lastName;


    public Person(Properties properties) {
        firstName = properties.getProperty("person.firstName");
        lastName = properties.getProperty("person.lastName");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
