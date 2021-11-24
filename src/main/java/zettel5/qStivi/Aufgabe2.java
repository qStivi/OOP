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
        System.out.println(distance(new double[]{1, 1, 1, 2, 2, 2, 3, 3, 3})); // 3,464101615137755
        System.out.println(velocity(new double[]{1, 1, 1, 2, 2, 2, 3, 3, 3})); // 1,154700538379252
        System.out.println(maxVelocity(new double[]{1, 1, 1, 2, 2, 2, 3, 3, 3})); // 1,154700538379252
    }

    private static double distance(double[] gps) {
        if (gps.length % 3 != 0) return -1; // Abort if coordinates are in the wrong format
        var total = 0.0;
        var vectors = new double[gps.length / 3 - 1][3]; // Create array of vector3s
        // We want the dintance of AB BC CD DE ...
        for (int i = 0, j = 0; i < gps.length / 3 - 1; i++) { // Iterate through every vector
            vectors[i] = Arrays.copyOfRange(gps, j, j + 6); // A vector consists of two points
            j += 3; // Next point
        }
        // calculate length of every vetor and add it to the total
        for (double[] point : vectors) {
            total += Math.sqrt(Math.pow(point[3] - point[0], 2) + Math.pow(point[4] - point[1], 2) + Math.pow(point[5] - point[2], 2));
        }
        return total;
    }

    private static double velocity(double[] gps) {
        var numOfPoints = gps.length / 3;
        return distance(gps) / numOfPoints;
    }

    private static double maxVelocity(double[] gps) { // Aka greates distance
        if (gps.length % 3 != 0) return -1; // Abort if coordinates are in the wrong format
        var vectorLengths = new double[gps.length / 3 - 1]; // Create array to store all lenthgs of the arrays
        var vectors = new double[gps.length / 3 - 1][3]; // Create array of vector3s
        // We want the dintance of AB BC CD DE ...
        for (int i = 0, j = 0; i < gps.length / 3 - 1; i++) { // Iterate through every vector
            vectors[i] = Arrays.copyOfRange(gps, j, j + 6); // A vector consists of two points
            j += 3; // Next point
        }
        // calculate length of every vetor and add it to the total
        for (int i = 0; i < vectors.length; i++) {
            double[] vector = vectors[i];
            vectorLengths[i] = Math.sqrt(Math.pow(vector[3] - vector[0], 2) + Math.pow(vector[4] - vector[1], 2) + Math.pow(vector[5] - vector[2], 2));
        }
        Arrays.sort(vectorLengths);
        return vectorLengths[vectorLengths.length - 1];
    }
}
