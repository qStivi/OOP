package andi.zettel7.Aufgabe1;

import java.util.Arrays;

public class Playfair {

    private final Character[][] playfairSquare = new Character[5][5];
    private final static String LETTERS = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

    public Playfair(String codeword) {
        codeword = clearDuplications(codeword.toUpperCase(), 0);
        codeword = getMissingLetters(codeword);

        int counter = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                playfairSquare[i][j] = codeword.charAt(counter);
                counter++;
            }
        }
    }

    public void printSquare() {
        for (Character[] c : playfairSquare) {
            System.out.println(Arrays.toString(c).replace("[", "").replace("]", "").
                    replace(",", ""));
        }
    }

    private String getMissingLetters(String s) {
        for (int i = 0; i < LETTERS.length(); i++) {
            if (!characterInString(s, LETTERS.charAt(i))) {
                s += LETTERS.charAt(i);
            }
        }
        return s;
    }

    private String clearDuplications(String s, int index) {
        if (!hasDuplications(s)) {
            return s;
        }

        if (index < s.length()) {
            if (s.charAt(index) == 'J') {
                s = s.replace("J", "");
                if (index == 0) {
                    index--;
                }
            } else {
                char first = s.charAt(index);
                for (int i = index + 1; i < s.length(); i++) {
                    if (s.charAt(i) == first) {
                        s = s.substring(0, i) + s.substring(i + 1).replace(String.valueOf(first), "");
                        break;
                    }
                }
            }
        }
        return clearDuplications(s, index + 1);
    }

    private boolean hasDuplications(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (characterInString(s.substring(i + 1), s.charAt(i))) {
                return true;
            }
        }
        return false;
    }


    boolean characterInString(String s, Character character) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == character) {
                return true;
            }
        }
        return false;
    }
}
