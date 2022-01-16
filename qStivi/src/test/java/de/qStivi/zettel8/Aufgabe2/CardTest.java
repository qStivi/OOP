package de.qStivi.zettel8.Aufgabe2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class CardTest {

    Card[] cards = new Card[12];

    @BeforeEach
    void setUp() {
        cards[0] = new Card("Blauäugiger weißer Drache", Card.NORMAL_MONSTER, 2000);
        cards[1] = new Card("Verräterische Schwerter", Card.SPELL, 1989);
        var sk = new Card("Spiegelkraft", Card.TRAP, 2012);
        cards[3] = new Card("Marschmallon", Card.EFFECT_MONSTER, 2016);
        cards[9] = new Card("Marschmallon", Card.EFFECT_MONSTER, 2015);
        cards[4] = new Card("Exodia, die Verbotene", Card.EFFECT_MONSTER, 2016);
        cards[8] = new Card("Exodia, die Verbotene", Card.EFFECT_MONSTER, 2016);
        cards[5] = sk;
        cards[6] = sk;
        cards[7] = new Card("Topf der Gier", Card.SPELL, 1989);
        cards[10] = new Card("Großschild Wache", Card.EFFECT_MONSTER, 1989);
        cards[2] = new Card("Großschild Wache", Card.NORMAL_MONSTER, 1989);
        cards[11] = new Card("Großschild", Card.NORMAL_MONSTER, 1989);
    }

    @Test
    void compareTo() {
        Card[] sortedCards = {cards[11], cards[2], cards[10], cards[7], cards[1], cards[0], cards[5], cards[6], cards[9], cards[4], cards[8], cards[3]};
        Arrays.sort(cards);
        for (Card card : cards) {
            System.out.println(card.getName() + " " + card.getType() + " " + card.getRelease());
        }
        assertArrayEquals(cards, sortedCards);
    }
}