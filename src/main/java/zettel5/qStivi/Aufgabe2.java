package zettel5.qStivi;

import java.util.Arrays;

public class Aufgabe2 {
    public static void main(String[] args) {
        var gps = new double[]{
                -20.0, 0.0, 200.0,
                -18.5, -0.647, 200.577,
                -16.85, -1.237, 201.16,
                -15.035, -1.763, 201.739,
                -13.038, -2.219, 202.299,
                -10.842, -2.599, 202.824,
                -8.426, -2.894, 203.289,
                -5.769, -3.096, 203.667,
                -2.846, -3.195, 203.918,
                0.369, -3.182, 203.998,
                3.861, -3.205, 203.85,
                7.284, -3.176, 203.469,
                10.638, -3.209, 202.868,
                13.926, -3.175, 202.06,
                17.147, -3.209, 201.059,
                20, -3.174, 199.877
        };
        System.out.println(distance(gps));
        System.out.println(velocity(gps));
        System.out.println(maxVelocity(gps));

        System.out.println("-----------------------------------------------------------------");

        test("distance() #1", distance(new double[]{0, 1, 0, 0, 2, 0, 0, 3, 0}), 2d);
        test("distance() #2", distance(new double[]{0, 1, 0, 0, -2, 0, 0, 3, 0}), 8d);
        test("distance() #2", distance(new double[]{3}), -1d);
        test("distance() #3", distance(new double[9]), 0d);
        test("distance() #4", distance(new double[]{}), -1d);

        test("velocity() #1", velocity(new double[]{1, 0, 0, 2, 0, 0, 3, 0, 0}), 1d);
        test("velocity() #2", velocity(new double[]{1, 0, 0, -2, 0, 0, -3, 0, 0}), 2d);
        test("velocity() #2", velocity(new double[]{3}), -1d);
        test("velocity() #3", velocity(new double[9]), 0d);
        test("velocity() #4", velocity(new double[]{}), -1d);

        test("maxVelocity() #1", maxVelocity(new double[]{0, 0, 0, 0, 0, 2, 0, 0, 3}), 2d);
        test("maxVelocity() #2", maxVelocity(new double[]{0, 0, 0, 0, 0, -2, 0, 0, -3}), 2d);
        test("maxVelocity() #3", velocity(new double[]{3}), -1d);
        test("maxVelocity() #4", velocity(new double[9]), 0d);
        test("maxVelocity() #5", velocity(new double[]{}), -1d);
    }

    private static double[][] convertToVectorArray(double[] gps) {
        var vectors = new double[gps.length / 3 - 1][3]; // Create array of vector3s
        // We want the dintance of AB BC CD DE ...
        for (int i = 0, j = 0; i < gps.length / 3 - 1; i++) { // Iterate through every vector
            vectors[i] = Arrays.copyOfRange(gps, j, j + 6); // A vector consists of two points
            j += 3; // Next point
        }
        return vectors;
    }

    private static double distance(double[] gps) {
        if (gps.length % 3 != 0 || gps.length == 0) return -1; // Abort if coordinates are in the wrong format. No points have no distance.
        var total = 0.0;
        // calculate length of every vetor and add it to the total
        for (double[] point : convertToVectorArray(gps)) {
            total += Math.sqrt(Math.pow(point[3] - point[0], 2) + Math.pow(point[4] - point[1], 2) + Math.pow(point[5] - point[2], 2));
        }
        return total;
    }

    private static double velocity(double[] gps) {
        if (gps.length % 3 != 0 || gps.length == 0) return -1; // Abort if coordinates are in the wrong format. No points have no distance.
        return distance(gps) / ((gps.length / 3f) - 1); // Divide distance with time
    }

    private static double maxVelocity(double[] gps) { // Aka greates distance
        if (gps.length % 3 != 0) return -1; // Abort if coordinates are in the wrong format
        var vectorLengths = new double[gps.length / 3 - 1]; // Create array to store all lenthgs of the arrays
        var vectors = convertToVectorArray(gps);
        // calculate length of every vetor and add it to the total
        for (int i = 0; i < vectors.length; i++) {
            double[] vector = vectors[i];
            vectorLengths[i] = Math.sqrt(Math.pow(vector[3] - vector[0], 2) + Math.pow(vector[4] - vector[1], 2) + Math.pow(vector[5] - vector[2], 2));
        }
        // Copied from getMaximum()
        var max = Double.MAX_VALUE * -1; // Very small value.
        for (double vectorLength : vectorLengths) {
            if (vectorLength > max) max = vectorLength; // Compare to current maximum value and set new value when current is smaller.
        }
        return max;
    }

    private static void test(String name, Object calculated, Object expected) {
        if (calculated.equals(expected)) {
            System.out.println(name + " passed.");
        } else {
            System.out.println(name + " failed!");
            System.out.println("Expected: " + expected + " But got: " + calculated);
        }
        System.out.println("-----------------------------------------------------------------");
    }
}
