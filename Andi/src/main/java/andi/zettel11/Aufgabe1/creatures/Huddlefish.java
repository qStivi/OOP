package andi.zettel11.Aufgabe1.creatures;

import andi.zettel11.Aufgabe1.exception.WrongSizeException;
import andi.zettel11.Aufgabe1.types.Herbivore;

public class Huddlefish extends Herbivore {

    public Huddlefish(int size) throws WrongSizeException {
        if (size >= 1700 && size <= 900) {
            this.size = size;
        } else {
            throw new WrongSizeException(size);
        }
    }
}
