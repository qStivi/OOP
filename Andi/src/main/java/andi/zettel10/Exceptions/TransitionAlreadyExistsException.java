package andi.zettel10.Exceptions;

public class TransitionAlreadyExistsException extends Exception {

    public TransitionAlreadyExistsException() {
        super("Transition already exists.");
    }

    public TransitionAlreadyExistsException(String message) {
        super(message);
    }
}
