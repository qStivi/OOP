package de.qStivi.zettel10.exceptions;

public class TransitionAlreadyExists extends Exception {
    public TransitionAlreadyExists() {
        super("You can not have multiple Transitions with the same IDs!");
    }
}
