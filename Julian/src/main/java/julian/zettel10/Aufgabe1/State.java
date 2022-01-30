package julian.zettel10.Aufgabe1;

public class State {

    private final String id;
    private final boolean isAcceptState;

    public State(String id, boolean isAcceptState) {
        this.id = id;
        this.isAcceptState = isAcceptState;
    }

    public String getId() {
        return id;
    }

    public boolean isAcceptState() {
        return isAcceptState;
    }
}
