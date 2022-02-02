package de.qStivi.zettel11.Aufgabe1.creatures;

import de.qStivi.zettel11.Aufgabe1.types.Herbivore;

public class Bellyray extends Herbivore {
    public Bellyray(int size) throws WrongSizeException {
        if (size < 700 || size > 900) {
            throw new WrongSizeException(size + " is not a valid size!");
        } else {
            setSize(size);
        }
    }
}
