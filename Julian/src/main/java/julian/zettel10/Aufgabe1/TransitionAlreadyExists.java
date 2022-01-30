package julian.zettel10.Aufgabe1;

public class TransitionAlreadyExists extends Exception {

    public TransitionAlreadyExists(Transition t) {
        super("Transition already exists " + t);
    }

}
