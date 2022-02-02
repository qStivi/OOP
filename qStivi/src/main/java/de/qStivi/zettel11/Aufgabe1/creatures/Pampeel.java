package de.qStivi.zettel11.Aufgabe1.creatures;

import de.qStivi.zettel11.Aufgabe1.types.Carnivore;

public class Pampeel extends Carnivore {
    public Pampeel(int size) throws WrongSizeException {
        if (size < 2000 || size > 2200) {
            throw new WrongSizeException(size + " is not a valid size!");
        } else {
            setSize(size);
        }
    }
}
