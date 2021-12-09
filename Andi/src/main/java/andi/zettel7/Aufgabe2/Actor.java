package andi.zettel7.Aufgabe2;

import java.util.Date;

public class Actor {

    private final String name;
    private final String lastname;
    private final Date birthday;

    public Actor(String name, String lastname, Date birthday){
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthday() {
        return birthday;
    }
}
