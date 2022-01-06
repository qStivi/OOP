package andi.zettel8.Aufgabe2;

public class Card {
    private final String name;
    private final String type;
    private final String releaseDate;

    private static final String EFFECT_MONSTER = "EFFECT MONSTER";
    private static final String NORMAL_MONSTER = "NORMAL MONSTER";
    private static final String SPELL = "SPELL";
    private static final String TRAP = "TRAP";

    public Card(String name, String releaseDate, String type) {
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
