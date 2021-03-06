package andi.zettel8.Aufgabe2;

public class Card implements Comparable<Card> {
    private final String name;
    private final String type;
    private final int releaseYear;

    public static final String EFFECT_MONSTER = "EFFECT MONSTER";
    public static final String NORMAL_MONSTER = "NORMAL MONSTER";
    public static final String SPELL = "SPELL";
    public static final String TRAP = "TRAP";

    public Card(int releaseYear, String type, String name) {
        this.releaseYear = releaseYear;
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getReleaseDate() {
        return releaseYear;
    }

    public String getType() {
        return type;
    }

    public int compareTo(Card o) {
        int sortYear = this.releaseYear - o.releaseYear;
        if(sortYear !=0){
            return sortYear;
        } else {
            if(!this.type.equals(o.type)){

                if(this.type.equals(NORMAL_MONSTER)){
                    return -1;
                } else if (o.type.equals(NORMAL_MONSTER)){
                    return 1;
                }

                if(this.type.equals(EFFECT_MONSTER)){
                    return -1;
                } else if (o.type.equals(EFFECT_MONSTER)){
                    return 1;
                }

                if(this.type.equals(SPELL)){
                    return -1;
                } else if (o.type.equals(SPELL)){
                    return 1;
                }

            } else {
                return this.name.compareTo(o.name);
            }
        }
        return 0;
    }
}
