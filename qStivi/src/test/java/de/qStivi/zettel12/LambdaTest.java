package de.qStivi.zettel12;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LambdaTest {
    ArrayList<String> list = new ArrayList<>();

    @BeforeEach
    void setUp() {
        list.clear();

        list.add("Kappa");
        list.add("Sadge");
        list.add("5Head");
        list.add("KEKW");
        list.add("FeelsBadMan");
        list.add("HYPERS");
        list.add("LUL");
        list.add("LULW");
        list.add("monkaS");
        list.add("NotLikeThis");
        list.add("OMEGALUL");
        list.add("PogChamp");
        list.add("Pepega");
        list.add("PepeHands");
        list.add("POGGERS");
        list.add("WeirdChamp");
    }

    @Test
    void removeIf1() {
        Lambda.removeIf(list, s -> s.toLowerCase().contains("m"));

        Logger.getLogger("m").info(Lambda.listToString(list));

        assertEquals(11, list.size());
    }

    @Test
    void removeIf2() {
        Lambda.removeIf(list, s -> s.contains("z"));

        Logger.getLogger("z").info(Lambda.listToString(list));

        assertEquals(16, list.size());
    }

    @Test
    void sortBy() {
        Lambda.sortBy(list, String::compareToIgnoreCase);

        Logger.getLogger("sort").info(Lambda.listToString(list));

        assertEquals("5Head", list.get(0));
        assertEquals("FeelsBadMan", list.get(1));
        assertEquals("WeirdChamp", list.get(15));
    }
}