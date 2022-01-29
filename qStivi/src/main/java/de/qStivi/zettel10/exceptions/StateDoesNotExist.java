package de.qStivi.zettel10.exceptions;

public class StateDoesNotExist extends Exception {
    public StateDoesNotExist() {
        super("This state does not exist!");
    }
}
