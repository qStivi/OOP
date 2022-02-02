package de.qStivi.zettel11.Aufgabe1.creatures;

import de.qStivi.zettel11.Aufgabe1.types.Leviathan;

public class PeaDragonLeviathan extends Leviathan {
    public PeaDragonLeviathan(int size) throws WrongSizeException {
        if (size < 11000 || size > 11600) {
            throw new WrongSizeException(size + " is not a valid size!");
        } else {
            setSize(size);
        }
    }
}
