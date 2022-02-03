package andi.zettel11.Aufgabe1.creatures;

import andi.zettel11.Aufgabe1.exception.WrongSizeException;
import andi.zettel11.Aufgabe1.types.Leviathan;

public class PeaDragonLeviatha extends Leviathan {

    public PeaDragonLeviatha(int size) throws WrongSizeException {
        if (size >= 11000 && size <= 11600) {
            this.size = size;
        } else {
            throw new WrongSizeException(size);
        }

    }
}
