package zettel11.Aufgabe1;

import andi.zettel11.Aufgabe1.FishTank;
import andi.zettel11.Aufgabe1.creatures.*;
import andi.zettel11.Aufgabe1.exception.DontDoThatException;
import andi.zettel11.Aufgabe1.exception.WrongSizeException;
import andi.zettel11.Aufgabe1.types.Carnivore;
import andi.zettel11.Aufgabe1.types.Herbivore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FishTankTest {

    @Test
    void fishTank() {
        var ft = new FishTank();
        assertThrows(WrongSizeException.class, () -> new Bellyray(699));
        assertThrows(WrongSizeException.class, () -> new Bellyray(901));
        assertThrows(DontDoThatException.class, () -> ft.addCreature(new KeeperLeviathan(5410)));
        assertThrows(DontDoThatException.class, () -> ft.addCreature(new PeaDragonLeviathan(11500)));
        Bellyray bellyray;
        Huddlefish huddlefish;
        Pampeel pampeel;
        Quidshark quidshark;
        try {
            bellyray = new Bellyray(700);
            huddlefish = new Huddlefish(80);
            pampeel = new Pampeel(2000);
            quidshark = new Quidshark(1100);

            ft.addCreature(bellyray);
            ft.addCreature(new Bellyray(900));
            ft.addCreature(huddlefish);
            ft.addCreature(new Huddlefish(90));
            ft.addCreature(pampeel);
            ft.addCreature(new Pampeel(2200));
            ft.addCreature(new Pampeel(2100));
            ft.addCreature(quidshark);
            ft.addCreature(new Quidshark(1200));
            ft.addCreature(new Quidshark(1150));

            assertEquals(700, ft.getCreatures().get(0).getSize());
            assertEquals(2200, ft.getCreatures().get(5).getSize());
            assertEquals(1150, ft.getCreatures().get(9).getSize());

            assertInstanceOf(Herbivore.class, ft.filter(bellyray).get(0));
            assertEquals(2, ft.filter(bellyray).size());

            assertInstanceOf(Carnivore.class, ft.filter(quidshark).get(0));
            assertEquals(3, ft.filter(quidshark).size());

        } catch (DontDoThatException | WrongSizeException e) {
            e.printStackTrace();
        }
    }
}