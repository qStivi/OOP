import java.util.Arrays;

public class GoodsSegment {

    public double height;
    public double width;
    public double depth;
    public double carryingWeight;
    public GoodsCrate[] crates;
    public int freeShelf;

    public GoodsSegment(double height, double width, double depth, double carryingWeight) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.carryingWeight = carryingWeight;
        this.crates = new GoodsCrate[9];
        this.freeShelf = 0;
    }

    void addCrate(GoodsCrate crate) {
        if (this.freeShelf == 9) {
            System.out.println("Segment is full");
        }
        if (crate.weight > this.carryingWeight) {
            System.out.println("Crate is too heavy");
        }
        if (crate.height <= this.height / 3 && crate.width <= this.width / 3 && crate.depth <= this.depth) {
            this.crates[freeShelf] = crate;
            freeShelf++;
        } else if (crate.height <= this.width / 3 && crate.width <= this.depth / 3 && crate.depth <= this.height / 3) {
            this.crates[freeShelf] = crate;
            freeShelf++;
        } else if (crate.height <= this.depth / 3 && crate.width <= this.width / 3 && crate.depth <= this.height / 3) {
            this.crates[freeShelf] = crate;
            freeShelf++;
        } else if (crate.height <= this.width / 3 && crate.width <= this.height / 3 && crate.depth <= this.depth / 3) {
            this.crates[freeShelf] = crate;
            freeShelf++;
        } else if (crate.height <= this.height / 3 && crate.width <= this.depth / 3 && crate.depth <= this.width / 3) {
            this.crates[freeShelf] = crate;
            freeShelf++;
        } else if (crate.height <= this.depth / 3 && crate.width <= this.height / 3 && crate.depth <= this.width / 3) {
            this.crates[freeShelf] = crate;
            freeShelf++;
        } else {
            System.out.println("Crate does not fit");
        }
    }

    @Override
    public String toString() {
        return "GoodsSegment{" +
                "height=" + height +
                ", width=" + width +
                ", depth=" + depth +
                ", carryingWeight=" + carryingWeight +
                ", crates=" + Arrays.toString(crates) +
                ", freeShelf=" + freeShelf +
                '}';
    }
}
