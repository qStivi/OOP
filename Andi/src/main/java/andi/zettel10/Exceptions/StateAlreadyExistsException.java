package andi.zettel10.Exceptions;

public class StateAlreadyExistsException extends Exception {

    public StateAlreadyExistsException() {
        super("State already exists.");
    }

    public StateAlreadyExistsException(String message) {
        super(message);
    }
}
