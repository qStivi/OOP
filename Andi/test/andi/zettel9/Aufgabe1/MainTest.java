package andi.zettel9.Aufgabe1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MainTest {

    @Test
    void replace() {
        String a1 = "Da steht ein rotes Auto und ein blaues Auto.";
        String b1 = "Da steht ein rotes Spielzeug und ein blaues Spielzeug.";
        Assertions.assertEquals(b1, Main.replace(a1, "Auto", "Spielzeug"));

        String a2 = "Noch ein Satz, um die Methode auszutesten.";
        String b2 = "Noch ein Satz, um die Methode au$zute$ten.";
        Assertions.assertEquals(b2, Main.replace(a2, "s", "$"));
    }

    @Test
    void isReverse() {
        Assertions.assertTrue(Main.isReverse("Frühstück", "Kcütshürf"));
        Assertions.assertTrue(Main.isReverse("Hallo", "Ollah"));
        Assertions.assertFalse(Main.isReverse("Wahr", "Falsch"));
    }
}