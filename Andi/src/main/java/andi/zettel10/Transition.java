package andi.zettel10;

public class Transition {

    private String startID;
    private String endID;
    private final char SYMBOL;

    public Transition(String startID, String endID, char SYMBOL) {
        this.startID = startID;
        this.endID = endID;
        this.SYMBOL= SYMBOL;
    }
}
