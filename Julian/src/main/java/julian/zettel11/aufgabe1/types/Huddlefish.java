package julian.zettel11.aufgabe1.types;

import julian.zettel11.aufgabe1.exceptions.IllegalSizeException;
import julian.zettel11.aufgabe1.creatures.Herbivore;

public class Huddlefish extends Herbivore {

    public Huddlefish(int size) throws IllegalSizeException {
        if(size >= 80 && size <= 90) {
            setSize(size);
        } else {
            throw new IllegalSizeException();
        }
    }

}
