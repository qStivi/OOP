package julian.zettel8;

import java.util.Arrays;

public class Card implements Comparable<Card> {

    private final String name;
    private final String type;
    private final int releaseYear;

    private static final String EFFECT_MONSTER = "EFFECT MONSTER";
    private static final String MONSTER = "MONSTER";
    private static final String SPELL = "SPELL";
    private static final String TRAP = "TRAP";

    public Card(String name, String type, int releaseYear) {
        this.type = type;
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public String getName() {
        return name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    //Vergleiche Karte1 mit Karte o

    @Override
    public int compareTo(Card o) {
        int sortForYear = this.releaseYear - o.releaseYear;
        if(sortForYear != 0) {
            return sortForYear;
        } else { //Nach Typ sortieren
            if(!this.type.equals(o.type)) {

                if(this.type.equals(Card.MONSTER)) {
                    return -1;
                } else if(o.type.equals(Card.MONSTER)) {
                    return 1;
                }

                if(this.type.equals(Card.EFFECT_MONSTER)) {
                    return -1;
                } else if(o.type.equals(Card.EFFECT_MONSTER)) {
                    return 1;
                }

                if(this.type.equals(Card.SPELL)) {
                    return -1;
                } else if(o.type.equals(Card.SPELL)) {
                    return 1;
                }

                return -1; //Wird nie abgefragt

            } else { //Nach Namen sortieren
                return this.getName().compareTo(o.getName());
            }
        }
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", releaseYear=" + releaseYear +
                '}';
    }

    public static void main(String[] args) {

        Card card2 = new Card("Test2", Card.TRAP, 2003);
        Card card1 = new Card("Test1", Card.TRAP, 2003);


        Card[] arr = new Card[]{card1, card2};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }


}
