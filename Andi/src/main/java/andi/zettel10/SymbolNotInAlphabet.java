package andi.zettel10;

public class SymbolNotInAlphabet extends Exception {

    public SymbolNotInAlphabet() {
        super("Symbol is not in Alphabet.");
    }

    public SymbolNotInAlphabet(String message) {
        super(message);
    }
}
