package julian.zettel10.Aufgabe1;

public class StateAlreadyExists extends Exception {

    public StateAlreadyExists(State in) {
        super("State already exists: " + in);
    }

}
