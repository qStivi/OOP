package julian.zettel11.aufgabe1.types;

import julian.zettel11.aufgabe1.exceptions.IllegalSizeException;
import julian.zettel11.aufgabe1.creatures.Carnivore;

public class Quidshark extends Carnivore {

    public Quidshark(int size) throws IllegalSizeException {
        if(size >= 1100 && size <= 1200) {
            setSize(size);
        } else {
            throw new IllegalSizeException();
        }
    }
}
