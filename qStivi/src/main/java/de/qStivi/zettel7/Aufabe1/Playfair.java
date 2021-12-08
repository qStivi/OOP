package de.qStivi.zettel7.Aufabe1;

import java.util.Arrays;

public class Playfair {

    private final static String LETTERS = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
    private final Character[][] playfairSquare = new Character[5][5];

    public Playfair(String codeword) {

        codeword = cleanFromDoubles(codeword.toUpperCase(), 0);

        while (codeword.length() != 25) {
            codeword = codeword + getFirstMissing(codeword);
        }

        for (int i = 0, k = 0; i < playfairSquare.length; i++) {
            Character[] row = playfairSquare[i];
            for (int j = 0; j < row.length; j++) {
                row[j] = codeword.toCharArray()[k];
                k++;
            }
        }
    }

    public Character[][] getPlayfairSquare() {
        return playfairSquare;
    }

    boolean characterInString(String s, Character character) {
        for (char c : s.toCharArray()) {
            if (c == character) {
                return true;
            }
        }
        return false;
    }

    private boolean hasDoubles(String strg) {
        for (char c : strg.toCharArray()) {
            var s = getWithouCurrent(strg, c);
            if (characterInString(s, c)) {
                return true;
            }
        }
        return false;
    }

    public void printSquare() {
        for (Character[] row : playfairSquare) {
            System.out.println(Arrays.toString(row));
        }
    }

    private String getWithouCurrent(String strg, char c) {
        var first = strg.indexOf(c);
        var secondHalf = strg.substring(first + 1);
        var firstHalf = strg.substring(0, first);
        strg = firstHalf + secondHalf;
        return strg;
    }

    private String cleanFromDoubles(String strg, int i) {
        if (!hasDoubles(strg)) {
            return strg;
        }

        if (i < strg.toCharArray().length) {
            var current = strg.toCharArray()[i];
            var first = strg.indexOf(current);
            strg = strg.replaceAll(String.valueOf(current), "");
            var secondHalf = strg.substring(first);
            var firstHalf = strg.substring(0, first);
            strg = firstHalf + current + secondHalf;
        }

        return cleanFromDoubles(strg, i + 1);
    }

    private char getFirstMissing(String strg) {
        var chars = strg.toCharArray();
        var missing = LETTERS;
        for (char c : chars) {
            missing = missing.replaceAll(String.valueOf(c), "");
        }
        return missing.toCharArray()[0];
    }
}
