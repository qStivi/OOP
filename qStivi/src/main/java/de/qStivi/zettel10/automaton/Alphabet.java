package de.qStivi.zettel10.automaton;

public class Alphabet {
    private final Character[] alphabet;

    public Alphabet(Character[] alphabet) {
        this.alphabet = alphabet;
    }

    /**
     * Checks if a given {@link Character} is present in the {@link Alphabet}.
     *
     * @param c the {@link Character} to be checked for
     * @return true if {@link Character} is present and false otherwise
     */
    boolean contains(Character c) {
        for (Character letter : alphabet) {
            if (letter.equals(c)) {
                return true;
            }
        }
        return false;
    }
}
