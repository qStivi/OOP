package julian.zettel11.aufgabe2;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Test {

    void listOperationsA(List<Number> l) { //Number
        l.add(3.14);
        l.add(42);
    }

    void listOperationsB(List<?> l) { // ?
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    int listOperationsC(List<? extends Comparable> l) { // ? extends Comparable
        return l.get(0).compareTo(l.get(1));
    }

    void listOperationsD(List<Integer>l) { //Integer
        Integer i = l.get(0);
        l.remove(i);
        l.add(i);
    }


}
