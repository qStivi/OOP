package julian.zettel10.Aufgabe1;

public class Alphabet {

    Character[] availableSymbols;

    public Alphabet(Character[] availableSymbols) {
        this.availableSymbols = availableSymbols;
    }

    public boolean containsSymbol(Character symbol) {
        for (Character c : availableSymbols) {
            if (c.equals(symbol)) {
                return true;
            }
        }
        return false;
    }

    public Character[] getAvailableSymbols() {
        return availableSymbols;
    }
}
