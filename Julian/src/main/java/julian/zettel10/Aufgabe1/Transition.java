package julian.zettel10.Aufgabe1;

public class Transition {

    private final String idStart;
    private final String idEnd;
    private final Character symbol;

    public Transition(String idStart, String idEnd, Character symbol) {
        this.idStart = idStart;
        this.idEnd = idEnd;
        this.symbol = symbol;
    }

    public String getIdStart() {
        return idStart;
    }

    public String getIdEnd() {
        return idEnd;
    }

    public Character getSymbol() {
        return symbol;
    }

}
