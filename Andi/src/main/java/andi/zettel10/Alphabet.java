package andi.zettel10;

public class Alphabet {

    protected final Character[] symbols;

    public Alphabet(Character[] SYMBOLS) {
        this.symbols = SYMBOLS;
    }

    public boolean isSymbolInAlpabet(char symbol) {
        for (char element : symbols) {
            if (element == symbol) {
                return true;
            }
        }
        return false;
    }
}
