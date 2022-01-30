package Aufgabe1.exceptions;

public class TransitionAlreadyExists extends Exception {
    public TransitionAlreadyExists(String startID, Character symbol) {
        super("You can not have multiple Transitions with the same IDs!\n" + "startId: " + startID + "\n" + "symbol: " + symbol);
    }
}
