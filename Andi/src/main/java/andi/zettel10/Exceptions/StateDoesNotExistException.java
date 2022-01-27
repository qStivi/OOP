package andi.zettel10.Exceptions;

public class StateDoesNotExistException extends Exception {

    public StateDoesNotExistException() {
        super("State does not exist.");
    }

    public StateDoesNotExistException(String message) {
        super(message);
    }
}
