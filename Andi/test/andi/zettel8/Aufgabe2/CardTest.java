package andi.zettel8.Aufgabe2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


class CardTest {

    @Test
    void compareTo() {
        Card[] cards1 = new Card[10];
        cards1[0] = new Card(1955, Card.NORMAL_MONSTER, "Kevin");
        cards1[1] = new Card(1965, Card.SPELL, "Reee");
        cards1[2] = new Card(1985, Card.EFFECT_MONSTER, "Bee");
        cards1[3] = new Card(1985, Card.EFFECT_MONSTER, "Cee");
        cards1[4] = new Card(1995, Card.NORMAL_MONSTER, "Max");
        cards1[5] = new Card(2001, Card.NORMAL_MONSTER, "Max");
        cards1[6] = new Card(2015, Card.SPELL, "Trash");
        cards1[7] = new Card(2015, Card.TRAP, "Trash");
        cards1[8] = new Card(2022, Card.EFFECT_MONSTER, "Uga");
        cards1[9] = new Card(2022, Card.EFFECT_MONSTER, "Uga");

        Card[] cards2 = new Card[10];
        cards2[1] = new Card(1955, Card.NORMAL_MONSTER, "Kevin");
        cards2[5] = new Card(1965, Card.SPELL, "Reee");
        cards2[9] = new Card(1985, Card.EFFECT_MONSTER, "Bee");
        cards2[4] = new Card(1985, Card.EFFECT_MONSTER, "Cee");
        cards2[3] = new Card(1995, Card.NORMAL_MONSTER, "Max");
        cards2[2] = new Card(2001, Card.NORMAL_MONSTER, "Max");
        cards2[8] = new Card(2015, Card.SPELL, "Trash");
        cards2[6] = new Card(2015, Card.TRAP, "Trash");
        cards2[7] = new Card(2022, Card.EFFECT_MONSTER, "Uga");
        cards2[0] = new Card(2022, Card.EFFECT_MONSTER, "Uga");
        Arrays.sort(cards2);

        for (int i = 0; i < cards1.length; i++) {
            Assertions.assertEquals(cards1[i].getType(), cards2[i].getType());
            Assertions.assertEquals(cards1[i].getName(), cards2[i].getName());
            Assertions.assertEquals(cards1[i].getReleaseDate(), cards2[i].getReleaseDate());
        }

    }
}