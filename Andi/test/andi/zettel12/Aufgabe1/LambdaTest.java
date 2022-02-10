package andi.zettel12.Aufgabe1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class LambdaTest {

    ArrayList<String> list1 = new ArrayList<>();

    @BeforeEach
    void setUp() {
    list1.clear();

        list1.add("Lucy");
        list1.add("Ella");
        list1.add("Amy");
        list1.add("Finja");
        list1.add("Emely");
        list1.add("Lukas");
        list1.add("Konstantin");
        list1.add("Ben");
        list1.add("Jonas");
        list1.add("Elias");
    }

    @Test
    void removeIf() {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Lucy");
        list2.add("Amy");
        list2.add("Finja");
        list2.add("Lukas");
        list2.add("Konstantin");
        list2.add("Ben");
        list2.add("Jonas");

        Lambda.removeIf(list1, x -> x.contains("E"));

        Assertions.assertEquals(list2, list1);


    }

    @Test
    void sortBy() {
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Amy");
        list2.add("Ben");
        list2.add("Elias");
        list2.add("Ella");
        list2.add("Emely");
        list2.add("Finja");
        list2.add("Jonas");
        list2.add("Konstantin");
        list2.add("Lucy");
        list2.add("Lukas");

        Lambda.sortBy(list1, (x, y) -> x.compareTo(y));

        Assertions.assertEquals(list2, list1);


    }

    @Test
    void listToString() {
        String s = "Lucy Ella Amy Finja Emely Lukas Konstantin Ben Jonas Elias ";
        Assertions.assertEquals(s, Lambda.listToString(list1));

    }
}