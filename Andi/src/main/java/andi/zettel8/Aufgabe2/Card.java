package andi.zettel8.Aufgabe2;

public class Card {
    private String name;
    private final String type;
    private String releaseDate;

    public Card(String name, String releaseDate, final String type) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public static void main(String[] args) {
        Card monster = new Card("monster1", "1999", "Normal Monster");
        System.out.println(monster.type);
       // monster.type = "sdasdas";
        System.out.println(monster.type);
        Card monster1 = new Card("monster1", "1999", "Normal Monster");
        System.out.println(monster1.type);
    }
}
