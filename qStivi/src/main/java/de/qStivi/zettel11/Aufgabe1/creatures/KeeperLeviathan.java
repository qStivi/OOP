package de.qStivi.zettel11.Aufgabe1.creatures;

import de.qStivi.zettel11.Aufgabe1.types.Leviathan;

public class KeeperLeviathan extends Leviathan {
    public KeeperLeviathan(int size) throws WrongSizeException {
        if (size < 5400 || size > 5600) {
            throw new WrongSizeException(size + " is not a valid size!");
        } else {
            setSize(size);
        }
    }
}
