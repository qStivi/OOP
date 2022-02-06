package julian.zettel11.aufgabe1.types;

import julian.zettel11.aufgabe1.exceptions.IllegalSizeException;
import julian.zettel11.aufgabe1.creatures.Carnivore;

public class Pampeel extends Carnivore {

    public Pampeel(int size) throws IllegalSizeException {
        if(size >= 2000 && size <= 2200) {
            setSize(size);
        } else {
            throw new IllegalSizeException();
        }
    }

}
