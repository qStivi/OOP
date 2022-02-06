package julian.zettel11.aufgabe1.types;

import julian.zettel11.aufgabe1.exceptions.IllegalSizeException;
import julian.zettel11.aufgabe1.creatures.Leviathan;

public class PeaDragonLeviathan extends Leviathan {

    public PeaDragonLeviathan(int size) throws IllegalSizeException {
        if(size >= 11000 && size <= 11600) {
            setSize(size);
        } else {
            throw new IllegalSizeException();
        }
    }

}
