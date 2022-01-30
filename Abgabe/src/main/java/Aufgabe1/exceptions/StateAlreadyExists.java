package Aufgabe1.exceptions;

public class StateAlreadyExists extends Exception {
    public StateAlreadyExists(String id) {
        super("You can not have multiple states with the same ID! \n" + id);
    }
}
