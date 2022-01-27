package andi.zettel10.Exceptions;

public class SymbolNotInAlphabetException extends Exception {

    public SymbolNotInAlphabetException() {
        super("Symbol is not in Alphabet.");
    }

    public SymbolNotInAlphabetException(String message) {
        super(message);
    }
}
