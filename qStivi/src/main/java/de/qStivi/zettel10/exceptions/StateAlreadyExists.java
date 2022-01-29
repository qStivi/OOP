package de.qStivi.zettel10.exceptions;

public class StateAlreadyExists extends Exception {
    public StateAlreadyExists() {
        super("You can not have multiple states with the same ID!");
    }
}
