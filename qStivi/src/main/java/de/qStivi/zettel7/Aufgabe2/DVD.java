package de.qStivi.zettel7.Aufgabe2;

public class DVD {
    private final String name;
    private final String ISBN;
    private final Director director;
    private final Actor[] headliner;

    public DVD(String name, String ISBN, Director director, Actor[] headliner) {
        this.name = name;
        this.ISBN = ISBN;
        this.director = director;
        this.headliner = headliner;
    }

    public String getName() {
        return name;
    }

    public String getISBN() {
        return ISBN;
    }

    public Director getDirector() {
        return director;
    }

    public Actor[] getHeadliner() {
        return headliner;
    }
}
