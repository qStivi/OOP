package julian.zettel10.Aufgabe1;

public class SymbolNotInAlphabet extends Exception {

    public SymbolNotInAlphabet(Character c) {
        super("Symbol not in Alphabet" + c);
    }

}
