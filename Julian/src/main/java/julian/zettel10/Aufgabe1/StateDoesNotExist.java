package julian.zettel10.Aufgabe1;

public class StateDoesNotExist extends Exception {

    public StateDoesNotExist(String id) {
        super("State does not exist: " + id);
    }
}
