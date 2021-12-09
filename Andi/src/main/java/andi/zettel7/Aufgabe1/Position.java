package andi.zettel7.Aufgabe1;

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

    private Position findInSquare(Character c) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (playfairSquare[i][j] == c) {
                    return new Position(j, i, playfairSquare);
                }
            }
        }
        return null;
    }

    private String cleanWord(String word) {
        word = word.replaceAll("[^a-zA-Z]", "").toUpperCase();
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
        return word;
    }

    public String encode(String word) {
        String result = "";
        for (int i = 0; i < word.length() - 1; i += 3) {
            Position pos1 = findInSquare(word.charAt(i));
            Position pos2 = findInSquare(word.charAt(i + 1));

            if (pos1.y == pos2.y) {
                if (pos2.x + 1 > 4) {
                    result += String.valueOf(playfairSquare[pos2.y][pos2.x]) + playfairSquare[pos2.y][0] + " ";
                } else {
                    result += String.valueOf(playfairSquare[pos2.y][pos2.x]) + playfairSquare[pos2.y][pos2.x + 1] + " ";
                }
            } else if (pos1.x == pos2.x) {
                if (pos2.y + 1 > 4) {
                    result += String.valueOf(playfairSquare[pos2.y][pos2.x]) + playfairSquare[0][pos2.x] + " ";
                } else {
                    result += String.valueOf(playfairSquare[pos2.y][pos2.x]) + playfairSquare[pos2.y + 1][pos2.x] + " ";
                }
            } else {
                result += String.valueOf(playfairSquare[pos1.y][pos2.x]) + playfairSquare[pos2.y][pos1.x] + " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Position pos = new Position(new Playfair("Apfelstrudel").getPlayfairSquare());
        System.out.println(pos.x + " " + pos.y);
        String s = "APELPTMWAUHK";
        s = pos.encode(pos.cleanWord(s));
        System.out.println(s);
    }
}
