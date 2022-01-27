package andi.zettel10;

public class StateDoesNotExist extends Exception {

    public StateDoesNotExist() {
        super("State does not exist.");
    }

    public StateDoesNotExist(String message) {
        super(message);
    }
}
