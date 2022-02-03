package andi.zettel11.Aufgabe1.creatures;

import andi.zettel11.Aufgabe1.exception.WrongSizeException;
import andi.zettel11.Aufgabe1.types.Leviathan;

public class KeeperLeviathan extends Leviathan {

    public KeeperLeviathan(int size) throws WrongSizeException {
        if (size >= 5400 && size <= 5600) {
            this.size = size;
        } else {
            throw new WrongSizeException(size);
        }
    }
}
