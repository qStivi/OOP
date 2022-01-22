public class GoodsShelfSystem {

    GoodsSegment[] segments;

    public GoodsShelfSystem() {
        this.segments = new GoodsSegment[5];
        segments[0] = new GoodsSegment(10, 12, 11, 20);
        segments[1] = new GoodsSegment(13, 14, 17, 13);
        segments[2] = new GoodsSegment(21, 24, 13, 26);
        segments[3] = new GoodsSegment(23, 45, 17, 21);
        segments[4] = new GoodsSegment(29, 13, 14, 45);
    }

    public boolean findSegmentForCrate(GoodsCrate crate) {
        GoodsSegment[] candidateSegments = new GoodsSegment[this.segments.length];
        double crateMeasurements = crate.depth * crate.width * crate.height;
        int countCandidates = 0;

        for (GoodsSegment segment : segments) {
            if (calculateShelfCap(segment) >= crateMeasurements && segment.carryingWeight >= crate.weight) {
                candidateSegments[countCandidates] = segment;
                countCandidates++;
            }
        }
        GoodsSegment[] candidateSegmentsCleaned = new GoodsSegment[countCandidates];
        for (int i = 0; i < candidateSegmentsCleaned.length; i++) {
            candidateSegmentsCleaned[i] = candidateSegments[i];
        }
        mergeSort(candidateSegmentsCleaned, candidateSegmentsCleaned.length);
        for (GoodsSegment segment : candidateSegmentsCleaned) {
            if (crate.height <= segment.height / 3 && crate.width <= segment.width / 3 && crate.depth <= segment.depth) {
                segment.addCrate(crate);
                return true;
            } else if (crate.height <= segment.width / 3 && crate.width <= segment.depth / 3 && crate.depth <= segment.height / 3) {
                segment.addCrate(crate);
                return true;
            } else if (crate.height <= segment.depth / 3 && crate.width <= segment.width / 3 && crate.depth <= segment.height / 3) {
                segment.addCrate(crate);
                return true;
            } else if (crate.height <= segment.width / 3 && crate.width <= segment.height / 3 && crate.depth <= segment.depth / 3) {
                segment.addCrate(crate);
                return true;
            } else if (crate.height <= segment.height / 3 && crate.width <= segment.depth / 3 && crate.depth <= segment.width / 3) {
                segment.addCrate(crate);
                return true;
            } else if (crate.height <= segment.depth / 3 && crate.width <= segment.height / 3 && crate.depth <= segment.width / 3) {
                segment.addCrate(crate);
                return true;
            }
        }
        return false;
    }

    public static void mergeSort(GoodsSegment[] segments, int length) {
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        GoodsSegment[] left = new GoodsSegment[mid];
        GoodsSegment[] right = new GoodsSegment[length - mid];
        for (int i = 0; i < mid; i++) {
            left[i] = segments[i];
        }
        for (int i = mid; i < length; i++) {
            right[i - mid] = segments[i];
        }
        mergeSort(left, mid);
        mergeSort(right, length - mid);
        merge(segments, left, right, mid, length - mid);
    }

    public static double calculateShelfCap(GoodsSegment segment) {
        return (segment.depth / 3) * (segment.height / 3) * (segment.width / 3);
    }

    public static void merge(GoodsSegment[] merged, GoodsSegment[] left, GoodsSegment[] right, int leftLength, int rightLength) {
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            if (calculateShelfCap(left[i]) <= calculateShelfCap(right[j])) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
            }
        }
        while (i < leftLength) {
            merged[k++] = left[i++];
        }
        while (j < rightLength) {
            merged[k++] = right[j++];
        }
    }
}
