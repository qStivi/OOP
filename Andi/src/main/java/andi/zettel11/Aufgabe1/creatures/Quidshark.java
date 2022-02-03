package andi.zettel11.Aufgabe1.creatures;

import andi.zettel11.Aufgabe1.exception.WrongSizeException;
import andi.zettel11.Aufgabe1.types.Carnivore;

public class Quidshark extends Carnivore {

    public Quidshark(int size) throws WrongSizeException {
        if (size >= 1100 && size <= 1200) {
            this.size = size;
        } else {
            throw new WrongSizeException(size);
        }
    }
}
