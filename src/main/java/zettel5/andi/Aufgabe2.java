package zettel5.andi;

import static java.util.Arrays.copyOfRange;

public class Aufgabe2 {
    public static void main(String[] args) {
        double[] gps = {-20.0, 0.0, 200.0, -18.5, -0.647, 200.577, -16.85, -1.237,
                201.16, -15.035, -1.763, 201.739, -13.038, -2.219,
                202.299, -10.842, -2.599, 202.824, -8.426, -2.894,
                203.289, -5.769, -3.096, 203.667, -2.846, -3.195, 203.918,
                0.369, -3.182, 203.998, 3.861, -3.205, 203.85, 7.284,
                -3.176, 203.469, 10.638, -3.209, 202.868, 13.926, -3.175,
                202.06, 17.147, -3.209, 201.059, 20, -3.174, 199.877};

        double[] start1 = {-20.0, 0.0, 200.0};
        double[] end1 = {-5.769, -3.096, 203.667};

        double[] end3 = {-20.0, 0.0, 200.0};
        double[] start3 = {-5.769, -3.096, 203.667};

        double[] start2 = {500, 60, 700};
        double[] end2 = {800, 90, 1000};

        double[] start4 = {-20.0, 0.0, 200.577};
        double[] end4 = {-5.769, -3.096, 203.667};

        System.out.println(distance(gps));
        System.out.println(velocity(gps));
        System.out.println(maxVelocity(gps));

        testPartialGPS(gps, start1, end1);
        System.out.println("________________________________________________________________________________________");
        testPartialGPS(gps, start2, end2);
        System.out.println("________________________________________________________________________________________");
        testPartialGPS(gps, start3, end3);
        System.out.println("________________________________________________________________________________________");
        testPartialGPS(gps, null, end3);

    }

    static void testPartialGPS(double[] gps, double[]start, double[]end){
        double[] result = partialGPS(gps, start, end);
        for (double element : result) {
            System.out.println(element);
        }
    }

    static double distance(double[] gps) {
        double result = 0;
        for (int i = 0; i < gps.length - 3; i += 3) {
            result += Math.sqrt(Math.pow(Math.abs(gps[i] - gps[i + 3]), 2) + Math.pow(Math.abs(gps[i + 1] - gps[i + 4]), 2) +
                    Math.pow(Math.abs(gps[i + 2] - gps[i + 5]), 2));
        }
        return result;
    }

    static double velocity(double[] gps) {
        return distance(gps) / (gps.length / 3 - 1);
    }

    static double maxVelocity(double[] gps) {
        double[] velocities = new double[gps.length / 3 - 1];
        for (int i = 0; i < gps.length - 3; i += 3) {
            velocities[i] = Math.sqrt(Math.pow(Math.abs(gps[i] - gps[i + 3]), 2) +
                    Math.pow(Math.abs(gps[i + 1] - gps[i + 4]), 2) +
                    Math.pow(Math.abs(gps[i + 2] - gps[i + 5]), 2));
        }
        return searchMaxVelocity(velocities);
    }

    static double searchMaxVelocity(double[] velocities) {
        double result = 0;
        for (double velocity : velocities) {
            if (velocity > result) {
                result = velocity;
            }
        }
        return result;
    }

    static double[] partialGPS(double[] gps, double[] start, double[] end) {
        double[] result;
        if (start == null || end == null || !searchPartialGPS(start[0], gps) || !searchPartialGPS(start[1], gps) || !searchPartialGPS(start[2], gps)
                || !searchPartialGPS(end[0], gps) || !searchPartialGPS(end[1], gps) || !searchPartialGPS(end[2], gps)) {
            return gps;
        } else {
            int startIndex = 0;
            int endIndex = 0;
            for (int i = 0; start[0] != gps[i]; i++) {
                startIndex = i;
            }
            for (int i = 0; end[2] != gps[i]; i++) {
                endIndex = i;
            }
            if (startIndex > endIndex) {
                return gps;
            }
            result = copyOfRange(gps, startIndex, endIndex);
        }
        return result;
    }

    static boolean searchPartialGPS(double value, double[] gps) {
        boolean conditition = false;
        for (double c : gps) {
            if (value == c) {
                conditition = true;
            }
        }
        return conditition;
    }
}
