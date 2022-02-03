package andi.zettel11.Aufgabe1.creatures;

import andi.zettel11.Aufgabe1.exception.WrongSizeException;
import andi.zettel11.Aufgabe1.types.Carnivore;

public class Quidshark extends Carnivore {

    public Quidshark(int size) throws WrongSizeException {
        if (size >= 80 && size <= 90) {
            this.size = size;
        } else {
            throw new WrongSizeException(size);
        }
    }
}
