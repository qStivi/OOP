package andi.zettel10;

public class Transition {

    protected String startID;
    protected String endID;
    protected final char symbol;

    public Transition(String startID, String endID, char SYMBOL) {
        this.startID = startID;
        this.endID = endID;
        this.symbol = SYMBOL;
    }
}
