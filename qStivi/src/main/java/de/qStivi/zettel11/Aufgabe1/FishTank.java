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
            creatures.add(sc);
        }
    }

    public <T extends SeaCreature> List<SeaCreature> filter(T creature) {
        var list = new ArrayList<SeaCreature>();
        for (SeaCreature seaCreature : creatures) {
            if (seaCreature.getClass().isInstance(creature)) {
                list.add(seaCreature);
            }
        }
        return list;
    }
}
