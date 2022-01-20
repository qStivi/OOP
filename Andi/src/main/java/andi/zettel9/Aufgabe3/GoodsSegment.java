package andi.zettel9.Aufgabe3;

public class GoodsSegment {

    public double height;
    public double width;
    public double depth;
    public double maxWeight;
    public GoodsCrate[] compartments;

    public GoodsSegment(double height, double width, double depth, double maxWeight) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.maxWeight = maxWeight;
        this.compartments = new GoodsCrate[9];
    }

    public void addCrate(GoodsCrate crate) {
        if (sumWeight() + crate.weight > maxWeight) {
            System.out.println("Das würde die zulässige maximale Tragkraft überschreiten.");
        } else {
            int pos1 = 0;
            while (true) {
                int pos2 = getEmptyCompartment(pos1);
                if (doesItFit(crate, pos2)) {
                    compartments[pos2] = crate;
                    break;
                } else if (pos2 == compartments.length - 1) {
                    System.out.println("Die Kiste ist zu groß.");
                    break;
                }
                pos1 = pos2 + 1;
            }
        }
    }

    private boolean doesItFit(GoodsCrate crate, int pos) {
        if (compartments[pos].depth >= crate.depth && compartments[pos].height / 3 >= crate.height &&
                compartments[pos].width / 3 >= crate.width) {
            return true;
        }
        if (compartments[pos].depth >= crate.width && compartments[pos].height / 3 >= crate.depth &&
                compartments[pos].width / 3 >= crate.height) {
            return true;
        }
        if (compartments[pos].depth >= crate.height && compartments[pos].height / 3 >= crate.width &&
                compartments[pos].width / 3 >= crate.depth) {
            return true;
        }

        return false;
    }

    private double sumWeight() {
        double result = 0;
        for (GoodsCrate crate : compartments) {
            result += crate.weight;
        }
        return result;
    }

    private int getEmptyCompartment(int pos) {
        int result = 0;
        for (int i = pos; i < compartments.length; i++) {
            if (compartments[i] == null) {
                result = i;
            }
        }
        return result;
    }
}
