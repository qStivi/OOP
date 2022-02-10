package de.qStivi.zettel11.Aufgabe1;

import de.qStivi.zettel11.Aufgabe1.types.Leviathan;
import de.qStivi.zettel11.Aufgabe1.types.SeaCreature;
import de.qStivi.zettel11.Aufgabe1.types.WrongTypeException;

import java.util.ArrayList;
import java.util.List;

public class FishTank {

    private final ArrayList<SeaCreature> creatures;

    public FishTank() {
        this.creatures = new ArrayList<>();
    }

    public ArrayList<SeaCreature> getCreatures() {
        return creatures;
    }

    public void addCreature(SeaCreature sc) throws WrongTypeException {
        if (sc instanceof Leviathan) {
            throw new WrongTypeException("You are not allowed to add leviathans to the fish tank!");
        } else {
            this.creatures.add(sc);
        }
    }

    public <T extends SeaCreature> List<T> filter(T creature) {
        var list = new ArrayList<T>();
        for (SeaCreature seaCreature : creatures) {
            if (seaCreature.getClass().isInstance(creature)) {
                list.add((T) seaCreature);
            }
        }
        return list;
    }
}
