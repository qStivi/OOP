package andi.zettel9.Aufgabe3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsShelfSystemTest {


    @Test
    void findSegmentForCrate() {
        GoodsShelfSystem lager1 = new GoodsShelfSystem();
        GoodsCrate crate0 = new GoodsCrate(3, 6.6, 50, 15);
        GoodsCrate crate1 = new GoodsCrate(10, 13, 20, 15);
        GoodsCrate crate2 = new GoodsCrate(5, 20, 35, 15);
        GoodsCrate crate3 = new GoodsCrate(13, 20, 15, 15);
        GoodsCrate crate4 = new GoodsCrate(4, 18, 61, 15);
        Assertions.assertTrue(lager1.findSegmentForCrate(crate0));
        Assertions.assertTrue(lager1.findSegmentForCrate(crate1));
        Assertions.assertTrue(lager1.findSegmentForCrate(crate2));
        Assertions.assertTrue(lager1.findSegmentForCrate(crate3));
        Assertions.assertTrue(lager1.findSegmentForCrate(crate4));

    }

    @Test
    void findCrateInSegment() {
        GoodsShelfSystem lager1 = new GoodsShelfSystem();
        GoodsCrate crate0 = new GoodsCrate(3, 6.6, 50, 15);
        GoodsCrate crate1 = new GoodsCrate(10, 13, 20, 15);
        GoodsCrate crate2 = new GoodsCrate(5, 20, 35, 15);
        GoodsCrate crate3 = new GoodsCrate(13, 20, 15, 15);
        GoodsCrate crate4 = new GoodsCrate(4, 18, 61, 15);
        lager1.findSegmentForCrate(crate0);
        lager1.findSegmentForCrate(crate1);
        lager1.findSegmentForCrate(crate2);
        lager1.findSegmentForCrate(crate3);
        lager1.findSegmentForCrate(crate4);

        Assertions.assertEquals(0, lager1.findCrateInSegment(crate0));
        Assertions.assertEquals(1, lager1.findCrateInSegment(crate1));
        Assertions.assertEquals(2, lager1.findCrateInSegment(crate2));
        Assertions.assertEquals(3, lager1.findCrateInSegment(crate3));
        Assertions.assertEquals(4, lager1.findCrateInSegment(crate4));
    }
}