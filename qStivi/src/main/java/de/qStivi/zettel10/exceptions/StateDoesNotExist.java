package de.qStivi.zettel10.exceptions;

public class StateDoesNotExist extends Exception {
    public StateDoesNotExist(String startID) {
        super("This state does not exist!\n" + startID);
    }
}
