package de.qStivi.zettel7.Aufabe1;

public class Position {

    public final int x;
    public final int y;
    private final Character[][] playfairSquare;

    public Position(int x, int y, Character[][] playfairSquare) {
        this.x = x;
        this.y = y;
        this.playfairSquare = playfairSquare;
    }

    public Position(Character[][] playfairSquare) {
        this(0, 0, playfairSquare);
    }

    public static void main(String[] args) {
        var yee = new Position(new Playfair("Apfelstrudel").getPlayfairSquare()).findInSquare('L');
        var yo = new Position(new Playfair("Apfelstrudel").getPlayfairSquare()).findInSquare('K');
        System.out.println(yee.x);
        System.out.println(yee.y);
        System.out.println(yee.cleanWord("guz89r03ßoüpeigj0ßvdepwü+fkgpqrw3ükdlgio"));
        System.out.println(yee.cleanWord("vcfgdret56t7890ß´´JHGVFTR&/()=?ÜP*``ÖKLJå∂∑€®≠¿•π"));
        System.out.println(yee.cleanWord("Hallo"));
        System.out.println(yee.cleanWord("Hell"));
        System.out.println(yee.cleanWord("HalloHallo"));
    }

    private Position findInSquare(Character c) {
        for (int i = 0; i < playfairSquare.length; i++) {
            Character[] row = playfairSquare[i];
            for (int j = 0; j < row.length; j++) {
                Character letter = row[j];
                if (letter.equals(c)) {
                    return new Position(j, i, playfairSquare);
                }
            }
        }
        return null;
    }

    private String cleanWord(String word) {
        word = word.replaceAll("[^a-zA-Z]", "").toUpperCase();
        for (int i = 0; i < word.length() - 1; i++) {
            var charArray = word.toCharArray();
            if (charArray[i] == charArray[i + 1]) {
                word = word.substring(0, i + 1) + "X" + word.substring(i + 1);
            }
        }
        var j = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                j++;
                if (j % 2 == 0) {
                    word = word.substring(0, i + 1) + " " + word.substring(i + 1);
                }
            }
        }
        if (word.length() % 2 != 0) {
            word = word + "A";
        }
        return word;
    }
}