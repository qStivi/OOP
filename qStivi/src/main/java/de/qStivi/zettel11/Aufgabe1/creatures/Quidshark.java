package de.qStivi.zettel11.Aufgabe1.creatures;

import de.qStivi.zettel11.Aufgabe1.types.Carnivore;

public class Quidshark extends Carnivore {
    public Quidshark(int size) throws WrongSizeException {
        if (size < 1100 || size > 1200) {
            throw new WrongSizeException(size + " is not a valid size!");
        } else {
            setSize(size);
        }
    }
}
