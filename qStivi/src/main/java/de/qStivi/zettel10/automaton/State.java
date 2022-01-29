package de.qStivi.zettel10.automaton;

public class State {
    private final String ID;
    private final boolean isAccepting;

    public State(String ID, boolean isAccepting) {
        this.ID = ID;
        this.isAccepting = isAccepting;
    }

    public boolean isAccepting() {
        return isAccepting;
    }

    String getID() {
        return ID;
    }
}
