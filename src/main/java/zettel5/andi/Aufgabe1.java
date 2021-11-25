package zettel5.andi;

public class Aufgabe1 {

    public static void main(String[] args) {
        testAll();
    }

    static void testAll() {
        float[] test = new float[4];
        test[0] = 13.37f;
        test[1] = 4.20f;
        test[2] = 6.66f;
        test[3] = 6.9f;

        float minimum1 = 4.20f;
        float maximum1 = 13.37f;
        float average1 = 25.955f;

        float minimum2 = getMinimum(test);
        float maximum2 = getMaximum(test);
        float average2 = calculateAverage(test);

        testAllHelp(minimum1, minimum2, "getMinimum");
        testAllHelp(maximum1, maximum2, "getMaximum");
        testAllHelp(average1, average2, "calculateAverage");
    }

    static void testAllHelp(float f1, float f2, String testName) {
        if (f1 == f2) {
            System.out.println("Dein Test \"" + testName + "\" war erfolgreich.");
        } else {
            System.out.println("Dein Test \"" + testName + "\" war nicht erfolgreich.");
        }
    }

    static float getMinimum(float[] numbers) {
        float number = 0;
        return number;
    }

    static float getMaximum(float[] numbers) {
        float number = 0;
        return number;
    }

    static float calculateAverage(float[] numbers) {
        float number = 0;
        return number;
    }

    static boolean isSorted(float[] numbers, boolean ascending) {
        boolean condition = false;
        return condition;
    }
}
