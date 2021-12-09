package andi.zettel7.Aufgabe2;

public class DVD {

    private final String titel;
    private final String ISBN;
    private final Director director;
    private final Actor[] headliner;

    public DVD (String titel, String ISBN, Director director, Actor[] headliner){
        this.titel = titel;
        this.ISBN = ISBN;
        this.director = director;
        this.headliner = headliner;
    }

    public String getTitel() {
        return titel;
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
