package andi.zettel11.Aufgabe1;

import andi.zettel11.Aufgabe1.types.Leviathan;
import andi.zettel11.Aufgabe1.types.SeaCreature;
import andi.zettel11.Aufgabe1.exception.DontDoThatException;

import java.util.ArrayList;
import java.util.List;

public class FishTank {

    private ArrayList<SeaCreature> creatures;

    public FishTank() {
        this.creatures = new ArrayList<>();
    }

    public ArrayList<SeaCreature> getCreatures() {
        return creatures;
    }

    public void addCreature(SeaCreature creature) throws DontDoThatException{
        if(creature instanceof Leviathan){
            throw new DontDoThatException();
        } else {
            this.creatures.add(creature);
        }
    }

    public <T extends SeaCreature> List<SeaCreature> filter(T creature){
        ArrayList<SeaCreature> list = new ArrayList();
            for (SeaCreature seaCreature : creatures){
                if (seaCreature.getClass().isInstance(creature)){
                    list.add(seaCreature);
                }
            }
        return list;
    }
}
