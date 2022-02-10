package julian.zettel11.aufgabe2;

import java.util.List;

public class Test {

    void listOperationsA(List<? super Number> l) { //Number
        Object a = "";
        l.add(new Double(3.14));
        l.add(new Integer(42));
    }

    void listOperationsB(List<?> l) { // ?
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    int listOperationsC(List<? extends Comparable> l) { // ? extends Comparable
        return l.get(0).compareTo(l.get(1));
    }

    void listOperationsD(List<Integer> l) { //Integer
        Integer i = l.get(0);
        l.remove(i);
        l.add(i);
    }


}
