package de.qStivi.zettel7;

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
        System.out.println(yee.x);
        System.out.println(yee.y);
        System.out.println(yee.cleanWord("guz89r03ßoüpeigj0ßvdepwü+fkgpqrw3ükdlgio"));
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
        return word.replaceAll("[^a-zA-Z]", "").toUpperCase();
    }
}