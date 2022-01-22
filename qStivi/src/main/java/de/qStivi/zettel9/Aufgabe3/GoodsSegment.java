package de.qStivi.zettel9.Aufgabe3;

public class GoodsSegment implements Comparable<GoodsSegment> {
    public double maxHeight;
    public double maxWidth;
    public double maxDepth;
    public double maxWeight;
    public GoodsCrate[] shelfs;

    public GoodsSegment(double maxHeight, double maxWidth, double maxDepth, double maxWeight) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
        this.maxDepth = maxDepth;
        this.maxWeight = maxWeight;
        this.shelfs = new GoodsCrate[9];
    }

    void addCrate(GoodsCrate crate) {
        var success = putCrate(crate);

        if (!success) {
            System.out.println("Create does not fit!");
        }
    }

    boolean putCrate(GoodsCrate crate) {
        var maxShelfHeight = maxHeight / 3;
        var maxShelfWidth = maxWeight / 3;
        var maxShelfDepth = maxDepth / 3;
        var weight = getTotalWeight() + crate.weight;

        if (crate.height <= maxShelfHeight && crate.width <= maxShelfWidth && crate.depth <= maxShelfDepth && weight <= this.maxWeight) {
            return insertCrate(crate);
        } else if (crate.width <= maxShelfHeight && crate.depth <= maxShelfWidth && crate.height <= maxShelfDepth && weight <= this.maxWeight) {
            return insertCrate(crate);
        } else if (crate.depth <= maxShelfHeight && crate.height <= maxShelfWidth && crate.width <= maxShelfDepth && weight <= this.maxWeight) {
            return insertCrate(crate);
        } else {
            return false;
        }
    }

    private boolean insertCrate(GoodsCrate crate) {
        for (int i = 0; i < this.shelfs.length; i++) {
            if (this.shelfs[i] == null) {
                this.shelfs[i] = crate;
                return true;
            }
        }
        return false;
    }

    private double getTotalWeight() {
        var weight = 0d;
        for (GoodsCrate shelf : this.shelfs) {
            if (shelf != null) {
                weight += shelf.weight;
            }
        }
        return weight;
    }

    @Override
    public int compareTo(GoodsSegment o) {
        return (int) Math.round((this.maxHeight / 3 * this.maxWidth / 3 * this.maxDepth / 3) - (o.maxHeight / 3 * o.maxWidth / 3 * o.maxDepth / 3));
    }
}
