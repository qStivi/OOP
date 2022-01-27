package andi.zettel10;

public class State extends Exception {

    protected final String ID;
    private boolean acceptingState;

    public State(String ID, boolean acceptingState) {
        this.ID = ID;
        this.acceptingState = acceptingState;
    }


}
