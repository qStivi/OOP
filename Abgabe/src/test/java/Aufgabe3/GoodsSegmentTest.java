package Aufgabe3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoodsSegmentTest {

    @Test
    void addCrate1() {
        var gs = new GoodsSegment(10, 10, 10, 10);
        var crate1 = new GoodsCrate(1, 1, 1, 1);
        gs.addCrate(crate1);
        assertNotNull(gs.shelfs[0]);
        assertNull(gs.shelfs[1]);
        assertNull(gs.shelfs[2]);
        assertNull(gs.shelfs[3]);
        assertNull(gs.shelfs[4]);
        assertNull(gs.shelfs[5]);
        assertNull(gs.shelfs[6]);
        assertNull(gs.shelfs[7]);
        assertNull(gs.shelfs[8]);
    }

    @Test
    void addCrate2() {
        var gs = new GoodsSegment(10, 10, 10, 10);
        var crate1 = new GoodsCrate(1, 1, 1, 1);
        gs.addCrate(crate1);
        gs.addCrate(crate1);
        assertNotNull(gs.shelfs[0]);
        assertNotNull(gs.shelfs[1]);
        assertNull(gs.shelfs[2]);
        assertNull(gs.shelfs[3]);
        assertNull(gs.shelfs[4]);
        assertNull(gs.shelfs[5]);
        assertNull(gs.shelfs[6]);
        assertNull(gs.shelfs[7]);
        assertNull(gs.shelfs[8]);
    }

    @Test
    void addCrate3() {
        var gs = new GoodsSegment(10, 10, 10, 10);
        var crate1 = new GoodsCrate(1, 1, 1, 1);
        var crate2 = new GoodsCrate(3, 3, 3, 8);
        gs.addCrate(crate1);
        gs.addCrate(crate1);
        gs.addCrate(crate2);
        assertNotNull(gs.shelfs[0]);
        assertNotNull(gs.shelfs[1]);
        assertNotNull(gs.shelfs[2]);
        assertNull(gs.shelfs[3]);
        assertNull(gs.shelfs[4]);
        assertNull(gs.shelfs[5]);
        assertNull(gs.shelfs[6]);
        assertNull(gs.shelfs[7]);
        assertNull(gs.shelfs[8]);
        assertEquals(3, gs.shelfs[2].height);
    }
}