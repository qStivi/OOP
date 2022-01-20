package de.qStivi.zettel8.Aufgabe2;

public class Card implements Comparable<Card> {
    public static final int NORMAL_MONSTER = 0;
    public static final int EFFECT_MONSTER = 1;
    public static final int SPELL = 2;
    public static final int TRAP = 3;
    private final String name;
    private final int type;
    private final int release;

    public Card(String name, int type, int release) {
        this.name = name;
        this.type = type;
        this.release = release;
    }

    public int getRelease() {
        return release;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    @Override
    public int compareTo(Card o) {
        var result = this.release - o.release;
        if (result == 0) {
            result = this.type - o.type;
            if (result == 0) {
                result = this.name.compareTo(o.name);
            }
        }
        return result;
    }
}

