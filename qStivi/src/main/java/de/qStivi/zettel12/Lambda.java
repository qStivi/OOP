package de.qStivi.zettel12;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class Lambda {
    public static <T> void removeIf(ArrayList<T> list, Predicate<T> filter) { // Schreibfehler in Aufgabe "<T>"?
        list.removeIf(filter);
    }

    public static <T> void sortBy(ArrayList<T> list, Comparator<T> comparator) {
        list.sort(comparator);
    }

    public static <T> String listToString(ArrayList<T> list) {
        var sb = new StringBuilder();
        list.forEach(t -> sb.append(t).append("\n"));
        return sb.toString();
    }
}
