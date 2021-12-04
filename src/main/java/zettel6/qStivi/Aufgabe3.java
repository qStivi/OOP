package zettel6.qStivi;

public class Aufgabe3 {
    public static void main(String[] args) {
        testAll();
    }

    static double krt(double a, double k, double d) {
        if (a < 0 || k < 0) {
            return 0;
        }
        return krtH(a, k, d, a);
    }

    static double krtH(double a, double k, double d, double x_n) {
        if (k == 0) {
            return Double.NaN;
        }
        if (a == 0) {
            return 0;
        }
        double result = 1 / k * ((k - 1) * x_n + a / Math.pow(x_n, (k - 1)));
        if (x_n - result > d) {
            result = krtH(a, k, d, result);
        }
        return result;
    }

    static void testAll() {
        test("#1", krt(4, 2, Double.MIN_VALUE), 2d);
        test("#2", krt(4, 2, 0.1), 2.000609756097561);
        test("#3", krt(4, 2, 0.000001), 2.000000000000002);
        test("#4", krt(17, 1337, Double.MIN_VALUE), 1.0021213293732696);
        test("#5", krt(1764, 2, Double.MIN_VALUE), 42d);

        test("#6", krt(4, -2, Double.MIN_VALUE), 0d);
        test("#7", krt(-4, 2, Double.MIN_VALUE), 0d);

        test("#8", krt(0, 2, Double.MIN_VALUE), 0d);
        test("#9", krt(4, 0, Double.MIN_VALUE), Double.NaN);
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
