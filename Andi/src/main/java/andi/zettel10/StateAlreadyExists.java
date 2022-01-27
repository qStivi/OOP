package andi.zettel10;

public class StateAlreadyExists extends Exception {

    public StateAlreadyExists() {
        super("State already exists.");
    }

    public StateAlreadyExists(String message) {
        super(message);
    }
}
