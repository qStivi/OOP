package de.qStivi.zettel9.Aufgabe3;

import org.junit.jupiter.api.Test;

class GoodsShelfSystemTest {

    @Test
    void findSegmentForCrate() {
        var gss = new GoodsShelfSystem();
        var crate1 = new GoodsCrate(1, 1, 1, 1);
        var crate2 = new GoodsCrate(5, 5, 5, 8);
        var crate3 = new GoodsCrate(8, 8, 8, 13);

        for (int i = 0; i < 50; i++) {
            gss.findSegmentForCrate(crate3);
        }
        for (int i = 0; i < 50; i++) {
            gss.findSegmentForCrate(crate2);
        }
        for (int i = 0; i < 50; i++) {
            gss.findSegmentForCrate(crate1);
        }
        System.out.println("Check with breakpoint here :)");
        assert true;
    }
}