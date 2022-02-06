package julian.zettel11.aufgabe1;

import julian.zettel11.aufgabe1.creatures.Leviathan;
import julian.zettel11.aufgabe1.creatures.Seacreature;
import julian.zettel11.aufgabe1.exceptions.CreatureNotAllowedException;

import java.util.ArrayList;
import java.util.List;

public class FishTank {

    ArrayList<Seacreature> creatures;

    public FishTank() {
        creatures = new ArrayList<>();
    }

    public void addCreature(Seacreature creature) throws CreatureNotAllowedException {

        if(creature instanceof Leviathan) {
            throw new CreatureNotAllowedException();
        } else {
            creatures.add(creature);
        }
    }

    public <T extends Seacreature> List<Seacreature> filter(T creature) {

        List<Seacreature> output = new ArrayList<>();

        for(Seacreature seacreature : this.creatures) {
            if(seacreature.getClass().isInstance(creature)) {
                output.add(seacreature);
            }
        }
        return output;
    }

}
