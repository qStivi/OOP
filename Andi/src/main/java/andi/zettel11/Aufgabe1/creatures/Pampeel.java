package andi.zettel11.Aufgabe1.creatures;

import andi.zettel11.Aufgabe1.exception.WrongSizeException;
import andi.zettel11.Aufgabe1.types.Carnivore;

public class Pampeel extends Carnivore {

    public Pampeel(int size) throws WrongSizeException {
        if (size >= 2000 && size <= 2200) {
            this.size = size;
        } else {
            throw new WrongSizeException(size);
        }
    }
}
