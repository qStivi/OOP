package de.qStivi.zettel9.Aufgabe3;

import java.util.Arrays;
import java.util.Random;

@SuppressWarnings("all") // Please don't judge us ;)
public class GoodsShelfSystem {
    GoodsSegment[] segments;

    public GoodsShelfSystem() {
        this.segments = new GoodsSegment[5];
        var r = new Random();
        for (int i = 0; i < this.segments.length; i++) {
            this.segments[i] = new GoodsSegment(9 * i + r.nextDouble() + 3, 9 * i + r.nextDouble() + 9, 9 * i + r.nextDouble() + 17, 50);
        }
    }

    public boolean findSegmentForCrate(GoodsCrate crate) {
        Arrays.sort(this.segments); // Sort segments by volume
        // Insert crate if it fits the smalles if not try next larger one
        for (GoodsSegment segment : this.segments) {
            if (segment.putCrate(crate)) {
                return true;
            }
        }
        return false;
    }
}
