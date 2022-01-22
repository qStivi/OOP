package andi.zettel9.Aufgabe3;

public class GoodsShelfSystem {
    public GoodsSegment[] segments;

    public GoodsShelfSystem() {
        this.segments = new GoodsSegment[]{new GoodsSegment(10, 20, 50, 100),
                new GoodsSegment(30, 40, 20, 90),
                new GoodsSegment(15, 60, 35, 150),
                new GoodsSegment(40, 60, 15, 200),
                new GoodsSegment(12, 54, 61, 60)};
    }

    public boolean findSegmentForCrate(GoodsCrate crate) {
        int pos = -1;
        double difference = Double.MAX_VALUE;
        for (int i = 0; i < segments.length; i++) {
            if (doesItFit(segments[i], crate)) {
                double volumeCompartment = segments[i].depth * segments[i].width / 3 * segments[i].height / 3;
                double volumeCrate = crate.depth * crate.width * crate.height;
                if (difference > volumeCompartment - volumeCrate) {
                    difference = volumeCompartment - volumeCrate;
                    pos = i;
                }
            }
        }
        if (pos != -1) {
            segments[pos].addCrate(crate);
            return true;
        }
        return false;
    }

    private boolean doesItFit(GoodsSegment segment, GoodsCrate crate) {
        if (segment.depth >= crate.depth && segment.height / 3 >= crate.height && segment.width / 3 >= crate.width) {
            return true;
        }
        if (segment.depth >= crate.width && segment.height / 3 >= crate.depth && segment.width / 3 >= crate.height) {
            return true;
        }
        if (segment.depth >= crate.height && segment.height / 3 >= crate.width && segment.width / 3 >= crate.depth) {
            return true;
        }

        return false;
    }

    public int findCrateInSegment(GoodsCrate crate) {
        int counter = 0;
        for (GoodsSegment segment : segments) {
            for (GoodsCrate crate1 : segment.compartments) {
                if (crate1 != null) {
                    if (crate1.height == crate.height) {
                        return counter;
                    }
                }
            }
            counter++;
        }
        return -1;
    }
}
