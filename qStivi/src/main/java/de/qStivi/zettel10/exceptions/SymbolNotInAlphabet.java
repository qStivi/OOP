package de.qStivi.zettel10.exceptions;

public class SymbolNotInAlphabet extends Exception {
    public SymbolNotInAlphabet(Character symbol) {
        super("You can only use symbols from the set alphabet!\n" + symbol);
    }
}
