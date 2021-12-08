package de.qStivi.zettel7.Aufgabe2;

import java.util.Date;

public class Director {
    private final String firstName;
    private final String lastName;
    private final Date birthday;

    public Director(String firstName, String lastName, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }
}
