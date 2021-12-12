package de.qStivi.zettel7.Aufabe1;

import java.util.Arrays;

public class Playfair {

    /**
     * The alphabet without the letter "J".
     */
    private final static String LETTERS = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

    /**
     * A two-dimensional array whitch represets our encoding matrix.
     */
    private final Character[][] playfairSquare = new Character[5][5];

    /**
     * This constructor creates our encoding matrix using the given password.
     *
     * @param codeword is the word which is used to encode another word. So this parameter acts like a password.
     */
    private Playfair(String codeword) {

        codeword = cleanFromDoubles(codeword.toUpperCase(), 0); // Prepare password

        // Add a letter from LETTERS which is not already incuded until we reach a lengh of 25
        while (codeword.length() != 25) {
            codeword = codeword + getFirstMissing(codeword);
        }

        // Go through every row and collumn of our empty matrix and fill it with our generated letters
        for (int i = 0, k = 0; i < playfairSquare.length; i++) {
            for (int j = 0; j < playfairSquare[i].length; j++) {
                playfairSquare[i][j] = codeword.charAt(k);
                k++; // k for getting the next letter in codeeword
            }
        }
    }

    public static void main(String[] args) {
        var yo = new Playfair("Apfelstrudel");
        yo.printSquare();
        System.out.println("G€h€îm");
        System.out.println(yo.cleanWord("G€h€îm"));
        System.out.println(yo.encode(yo.cleanWord("G€h€îm")));
    }

    /**
     * Tells you if a given {@link String} contains a specific {@link Character}.
     *
     * @param s         is the {@link String} in which the {@link Character} will be seached.
     * @param character is the {@link Character} to be searched for.
     * @return a boolean true if the {@link Character} was found and false if it was not.
     */
    boolean characterInString(String s, Character character) {
        for (char c : s.toCharArray()) {
            if (c == character) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method tells you if a given {@link String} contains a letter mor than once.
     *
     * @param strg is the {@link String} to checked for double accuring letters.
     * @return a boolean true if it has found a letter which occurs more than once.
     */
    private boolean hasDoubles(String strg) {
        // Go through every letter
        for (char c : strg.toCharArray()) {
            // If the string, without the first occurence of the current letter, contains the current letter return true
            if (characterInString(removeFirstOccurence(strg, c), c)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method formats a {@link String} in the way descibed in the task.
     *
     * @param word is a {@link String} which is supposed to be cleaned and formatted in to letter pairs.
     * @return the resulting {@link String}.
     */
    private String cleanWord(String word) {
        word = word.replaceAll("[^a-zA-Z]", "");

        // Insert Xes
        for (int i = 0; i < word.length() - 1; i++) {
            var charArray = word.toCharArray();
            if (charArray[i] == charArray[i + 1]) {
                word = word.substring(0, i + 1) + "X" + word.substring(i + 1);
            }
        }

        var wordLength = word.length(); // Save word lentgh for later use

        // Insert space every two letters
        for (int i = 0, j = 0; i < word.length(); i++) { // Go through every symbol of word
            // If symbol is not a space add 1 to j and check if it is even
            if (word.charAt(i) != ' ') {
                if (++j % 2 == 0) {
                    // If j is even we have reached a symbol par not containing spaces so we can add one
                    word = word.substring(0, i + 1) + " " + word.substring(i + 1);
                }
            }
        }

        // If our resulting string does not end with a pair add an A
        if (wordLength % 2 != 0) {
            word = word + "A";
        }

        return word.toUpperCase();
    }

    /**
     * Tries to find a {@link Character} in our matrix.
     *
     * @param c is the {@link Character} to be searched for in our matrix.
     * @return a Position object containing the coordinates of the given {@link Character} or null if it was not found.
     */
    private Position findInSquare(Character c) {
        // Go through every row and collumn
        for (int i = 0; i < playfairSquare.length; i++) {
            for (int j = 0; j < playfairSquare[i].length; j++) {
                // Return Position object if character at current coordinates equals the given character
                if (playfairSquare[i][j].equals(c)) {
                    return new Position(j, i);
                }
            }
        }
        return null;
    }

    /**
     * Prints the matrix rather nicely formatted.
     */
    private void printSquare() {
        for (Character[] row : playfairSquare) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Removes the first occurence of a char in a {@link String}.
     *
     * @param strg is the {@link String} where the char is supposed to be removed.
     * @param c    is the char which is supposed to be removed.
     * @return a {@link String} where the first occurence of a char is removed.
     */
    private String removeFirstOccurence(String strg, char c) {
        var first = strg.indexOf(c); // Get index of first occurence
        var secondHalf = strg.substring(first + 1); // Get string after first occurence (excluded)
        var firstHalf = strg.substring(0, first); // Get string before first occurence (excluded)
        return firstHalf + secondHalf; // Return the two strings combined
    }

    /**
     * Recursivly removes doubleing occurences of chars in a String.
     *
     * @param strg is the {@link String} which is to be cleaned.
     * @param i    is the index at which character to start at.
     * @return a {@link String} where no char occures more than once.
     */
    private String cleanFromDoubles(String strg, int i) {
        // Finished if strg consists every char only once or less
        if (!hasDoubles(strg)) {
            return strg;
        }

        if (i < strg.toCharArray().length) {
            // Remember first char and index of it
            var current = strg.toCharArray()[i];
            var first = strg.indexOf(current);

            strg = strg.replaceAll(String.valueOf(current), ""); // Remove all occurences

            // Get strings before and after the first occurence then combine them and readd first ocurence
            var secondHalf = strg.substring(first);
            var firstHalf = strg.substring(0, first);
            strg = firstHalf + current + secondHalf;
        }

        return cleanFromDoubles(strg, i + 1); // Do it again! But this time for the next char in strg
    }

    /**
     * Returns the first char in LETTERS which is not already in the provided {@link String}
     *
     * @param strg is the {@link String} to be checked against LETTERS.
     * @return a char.
     */
    private char getFirstMissing(String strg) {
        var chars = strg.toCharArray();
        var missing = LETTERS;
        for (char c : chars) {
            missing = missing.replaceAll(String.valueOf(c), "");
        }
        return missing.toCharArray()[0];
    }

    /**
     * Encodes a word like specified in the task.
     *
     * @param word is a {@link String} to be encoded.
     * @return the encoded {@link String}.
     */
    public String encode(String word) {
        String result = "";
        for (int i = 0; i < word.length() - 1; i += 3) { // For every letter
            Position pos1 = findInSquare(word.charAt(i));
            Position pos2 = findInSquare(word.charAt(i + 1));

            if (pos1.y == pos2.y) { // If they are in same row
                if (pos2.x + 1 > 4) { // If it is the last in its row
                    result += String.valueOf(playfairSquare[pos2.y][pos2.x]) + playfairSquare[pos2.y][0];
                } else {
                    result += String.valueOf(playfairSquare[pos2.y][pos2.x]) + playfairSquare[pos2.y][pos2.x + 1];
                }
            } else if (pos1.x == pos2.x) { // If they are in the same collumn
                if (pos2.y + 1 > 4) { // If it is the last in its collumn
                    result += playfairSquare[pos2.y][pos2.x] + playfairSquare[0][pos2.x].toString();
                } else {
                    result += playfairSquare[pos2.y][pos2.x] + playfairSquare[pos2.y + 1][pos2.x].toString();
                }
            } else { // If they are not in the same row or collumn
                result += playfairSquare[pos1.y][pos2.x] + playfairSquare[pos2.y][pos1.x].toString();
            }
        }
        return result;
    }
}
