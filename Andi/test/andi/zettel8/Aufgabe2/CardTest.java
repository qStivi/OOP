package andi.zettel8.Aufgabe2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CardTest {

    @Test
    void compareTo() {
        Card[] cards = new Card[10];
        cards[0] = new Card(1955, Card.NORMAL_MONSTER, "Kevin");
        cards[1] = new Card(1965, Card.SPELL, "Reee");
        cards[2] = new Card(1985, Card.EFFECT_MONSTER, "Bee");
        cards[3] = new Card(1985, Card.EFFECT_MONSTER, "Cee");
        cards[4] = new Card(1995, Card.NORMAL_MONSTER, "Max");
        cards[5] = new Card(2001, Card.NORMAL_MONSTER, "Max");
        cards[6] = new Card(2015, Card.SPELL, "Trash");
        cards[7] = new Card( 2015, Card.TRAP, "Trash");
        cards[8] = new Card(2022, Card.EFFECT_MONSTER, "Uga");
        cards[9] = new Card(2022, Card.EFFECT_MONSTER, "Uga");

        Assertions.assertEquals(-10, cards[0].compareTo(cards[1]));
        Assertions.assertEquals(-20, cards[1].compareTo(cards[2]));
        Assertions.assertEquals(-1, cards[2].compareTo(cards[3]));
        Assertions.assertEquals(-10, cards[3].compareTo(cards[4]));
        Assertions.assertEquals(-6, cards[4].compareTo(cards[5]));
        Assertions.assertEquals(-14, cards[5].compareTo(cards[6]));
        Assertions.assertEquals(-1, cards[6].compareTo(cards[7]));
        Assertions.assertEquals(-7, cards[7].compareTo(cards[8]));
        Assertions.assertEquals(0, cards[8].compareTo(cards[9]));
        Assertions.assertEquals(67, cards[9].compareTo(cards[0]));

    }
}