package andi.zettel10;

public class Alphabet {

    private final Character[] SYMBOLS;

    public Alphabet(Character[] SYMBOLS) {
        this.SYMBOLS = SYMBOLS;
    }

    public boolean isSymbolInAlpabet(char symbol) {
        for (char element : SYMBOLS) {
            if (element == symbol) {
                return true;
            }
        }
        return false;
    }
}
