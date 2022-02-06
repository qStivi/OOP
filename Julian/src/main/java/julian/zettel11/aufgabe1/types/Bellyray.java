package julian.zettel11.aufgabe1.types;

import julian.zettel11.aufgabe1.exceptions.IllegalSizeException;
import julian.zettel11.aufgabe1.creatures.Herbivore;

public class Bellyray extends Herbivore {

    public Bellyray(int size) throws IllegalSizeException{
        if(size >= 700 && size <= 900) {
            setSize(size);
        } else {
            throw new IllegalSizeException();
        }
    }
}
