package andi.zettel10;

public class TransitionAlreadyExists extends Exception {

    public TransitionAlreadyExists() {
        super("Transition already exists.");
    }

    public TransitionAlreadyExists(String message) {
        super(message);
    }
}
