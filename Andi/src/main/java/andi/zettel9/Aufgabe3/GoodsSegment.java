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
            if(getEmptyCompartment(0) == -1){
                System.out.println("Das Lagerregal ist voll.");
            } else if (doesItFit(crate)) {
                compartments[getEmptyCompartment(0)] = crate;
            } else {
                System.out.println("Die Kiste ist zu groß.");
            }
        }
    }

    private boolean doesItFit(GoodsCrate crate) {
        if (depth >= crate.depth && height / 3 >= crate.height && width / 3 >= crate.width) {
            return true;
        }
        if (depth >= crate.width && height / 3 >= crate.depth && width / 3 >= crate.height) {
            return true;
        }
        if (depth >= crate.height && height / 3 >= crate.width && width / 3 >= crate.depth) {
            return true;
        }

        return false;
    }

    private double sumWeight() {
        double result = 0;
        for (GoodsCrate crate : compartments) {
            if(crate!=null){
                result += crate.weight;
            }

        }
        return result;
    }

    private int getEmptyCompartment(int pos) {
        for (int i = pos; i < compartments.length; i++) {
            if (compartments[i] == null) {
                return i;
            }
        }
        return -1;
    }
}
