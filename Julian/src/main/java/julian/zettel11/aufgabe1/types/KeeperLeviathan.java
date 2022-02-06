package julian.zettel11.aufgabe1.types;

import julian.zettel11.aufgabe1.exceptions.IllegalSizeException;
import julian.zettel11.aufgabe1.creatures.Leviathan;

public class KeeperLeviathan extends Leviathan {

    public KeeperLeviathan(int size) throws IllegalSizeException {
        if(size >= 5400 && size <= 5600) {
            setSize(size);
        } else {
            throw new IllegalSizeException();
        }
    }

}
