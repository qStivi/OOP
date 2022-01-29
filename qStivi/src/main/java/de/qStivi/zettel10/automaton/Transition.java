package de.qStivi.zettel10.automaton;

public class Transition {
    private final String startID;
    private final String endID;
    private final Character symbol;

    public Transition(String startID, String endID, Character symbol) {
        this.startID = startID;
        this.endID = endID;
        this.symbol = symbol;
    }

    public String getStartID() {
        return startID;
    }

    public String getEndID() {
        return endID;
    }

    public Character getSymbol() {
        return symbol;
    }
}
