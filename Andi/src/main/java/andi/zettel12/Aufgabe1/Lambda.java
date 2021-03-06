package andi.zettel12.Aufgabe1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class Lambda {

    public static <T> void removeIf(ArrayList<T> list, Predicate<T> filter){
            list.removeIf(filter);
    }

    public static <T> void sortBy(ArrayList<T> list, Comparator<T> comparator){
        list.sort(comparator);
    }

    public static <T> String listToString(ArrayList<T> list){
        StringBuilder output= new StringBuilder("");
        list.forEach(x -> output.append(x + " "));
        return  output.toString();
    }
}
