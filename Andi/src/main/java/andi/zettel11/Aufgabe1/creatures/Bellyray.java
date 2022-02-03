package andi.zettel11.Aufgabe1.creatures;

import andi.zettel11.Aufgabe1.exception.WrongSizeException;
import andi.zettel11.Aufgabe1.types.Herbivore;

public class Bellyray extends Herbivore {

    public Bellyray(int size) throws WrongSizeException {
        if (size >= 700 && size <= 900) {
            this.size = size;
        } else {
            throw new WrongSizeException(size);
        }
    }
}
