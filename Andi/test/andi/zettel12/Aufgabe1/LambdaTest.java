package andi.zettel12.Aufgabe1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class LambdaTest {


    @Test
    void removeIf() {
        ArrayList<String> list1 = new ArrayList<>();
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

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("Lucy");
        list2.add("Amy");
        list2.add("Finja");
        list2.add("Lukas");
        list2.add("Konstantin");
        list2.add("Ben");
        list2.add("Jonas");

        Lambda.removeIf(list1, x -> x.contains("E"));

        Assertions.assertEquals(list1, list2);


    }

    @Test
    void sortBy() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Lucy");
        list.add("Ella");
        list.add("Amy");
        list.add("Finja");
        list.add("Emely");
        list.add("Lukas");
        list.add("Konstantin");
        list.add("Ben");
        list.add("Jonas");
        list.add("Elias");
        Lambda.sortBy(list, (x,y) -> x.compareTo(y));


    }

    @Test
    void listToString() {
    }
}