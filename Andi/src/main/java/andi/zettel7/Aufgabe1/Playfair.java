package andi.zettel7.Aufgabe1;

import java.util.Arrays;

public class Playfair {

    private static final Character[][] playfairSquare = new Character[5][5];
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

    public static Character[][] getPlayfairSquare(){
        return playfairSquare;
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

    private Position findInSquare(Character c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (playfairSquare[i][j] == c) {
                    return new Position(j, i);
                }
            }
        }
        return null;
    }

    private String cleanWord(String word) {
        word = word.replaceAll("[^a-zA-Z]", "");
        for (int i = 0; i < word.length() - 1; i += 3) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                word = word.substring(0, i + 1) + "X " + word.substring(i + 1);
            } else {
                word = word.substring(0, i + 2) + " " + word.substring(i + 2);
            }
        }
        if (word.charAt(word.length() - 2) == ' ') {
            word += "A";
        }
        word = word.toUpperCase();
        return word;
    }

    public String encode(String word) {
        String result = "";
        for (int i = 0; i < word.length() - 1; i += 3) {
            Position pos1 = findInSquare(word.charAt(i));
            Position pos2 = findInSquare(word.charAt(i + 1));

            if (pos1.y == pos2.y) {
                if (pos2.x + 1 > 4) {
                    result += String.valueOf(playfairSquare[pos1.y][pos1.x + 1]) + playfairSquare[pos2.y][0] + " ";
                } else {
                    result += String.valueOf(playfairSquare[pos1.y][pos1.x + 1]) + playfairSquare[pos2.y][pos2.x + 1] + " ";
                }
            } else if (pos1.x == pos2.x) {
                if (pos2.y + 1 > 4) {
                    result += String.valueOf(playfairSquare[pos1.y + 1][pos1.x]) + playfairSquare[0][pos2.x] + " ";
                } else {
                    result += String.valueOf(playfairSquare[pos1.y + 1][pos1.x]) + playfairSquare[pos2.y + 1][pos2.x] + " ";
                }
            } else {
                result += String.valueOf(playfairSquare[pos1.y][pos2.x]) + playfairSquare[pos2.y][pos1.x] + " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Playfair play = new Playfair("Apfelstrudel");
        String s = "APELPTMWAUHK";
        s = play.encode(play.cleanWord(s));

        String s1 = "Regentanz";
        s1 = play.encode(play.cleanWord(s1));

        String s2 = "Mittwoch";
        s2 = play.encode(play.cleanWord(s2));

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);

    }
}
