package andi.zettel8.Aufgabe2;

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

    }
}