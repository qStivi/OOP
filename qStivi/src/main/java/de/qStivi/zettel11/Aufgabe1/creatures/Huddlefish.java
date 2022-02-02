package de.qStivi.zettel11.Aufgabe1.creatures;

import de.qStivi.zettel11.Aufgabe1.types.Herbivore;

public class Huddlefish extends Herbivore {
    public Huddlefish(int size) throws WrongSizeException {
        if (size < 80 || size > 90) {
            throw new WrongSizeException(size + " is not a valid size!");
        } else {
            setSize(size);
        }
    }
}
