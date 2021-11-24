package zettel5.qStivi;

import java.util.Arrays;

public class Aufgabe1 {
    public static void main(String[] args) {
        testAll();
    }

    private static void testAll() {

/////// getMinimum() tests ///////
        test("getMinimum() #1", getMinimum(new float[]{1337.1f, 1337.5f, 1337.8f}), 1337.1f);
        test("getMinimum() #2", getMinimum(new float[]{42.5f, 42.1f, 42.8f}), 42.1f);
        test("getMinimum() #3", getMinimum(new float[]{17.5f, 17.8f, 17.1f}), 17.1f);
        test("getMinimum() #4", getMinimum(new float[]{Float.MAX_VALUE, Float.MIN_VALUE, 0f}), 0.0f);
        test("getMinimum() #5", getMinimum(new float[]{0, 0, 0}), 0.0f);
        test("getMinimum() #6", getMinimum(new float[]{3.141f, 3.141f, 3.141f}), 3.141f);

/////// getMaximum() tests ///////
        test("getMaximum() #1", getMaximum(new float[]{1337.8f, 1337.1f, 1337.5f}), 1337.8f);
        test("getMaximum() #2", getMaximum(new float[]{42.5f, 42.8f, 42.1f}), 42.8f);
        test("getMaximum() #3", getMaximum(new float[]{17.5f, 17.1f, 17.8f}), 17.8f);
        test("getMaximum() #4", getMaximum(new float[]{Float.MIN_VALUE, Float.MAX_VALUE, 0f}), Float.MAX_VALUE);
        test("getMaximum() #5", getMaximum(new float[]{0, 0, 0}), 0.0f);
        test("getMaximum() #6", getMaximum(new float[]{3.141f, 3.141f, 3.141f}), 3.141f);

/////// calculateAverage() tests ///////
        test("calculateAverage() #1", calculateAverage(new float[]{1337.8f, 1337.1f, 1337.5f}), 1337.466f);
        test("calculateAverage() #2", calculateAverage(new float[]{42.5f, 42.8f, 42.1f}), 42.466f);
        test("calculateAverage() #3", calculateAverage(new float[]{17.5f, 17.1f, 17.8f}), 17.466f);
        test("calculateAverage() #4", calculateAverage(new float[]{0, 0, 0}), 0.0f);
        test("calculateAverage() #5", calculateAverage(new float[]{3.141f, 3.141f, 3.141f}), 3.141f);

/////// isSorted() tests ///////
        test("isSorted() #1", isSorted(new float[]{1337.8f, 1337.5f, 1337.1f}, false), true);
        test("isSorted() #2", isSorted(new float[]{1337.8f, 1337.5f, 1337.1f}, true), false);
        test("isSorted() #3", isSorted(new float[]{42.5f, 42.8f, 42.1f}, true), false);
        test("isSorted() #4", isSorted(new float[]{17.1f, 17.5f, 17.8f}, true), true);
        test("isSorted() #5", isSorted(new float[]{17.1f, 17.5f, 17.8f}, false), false);
        test("isSorted() #6", isSorted(new float[]{0, 0, 0}, true), true);
        test("isSorted() #7", isSorted(new float[]{0, 0, 0}, false), true);
        test("isSorted() #8", isSorted(new float[]{3.141f, 3.141f, 3.141f}, true), true);
        test("isSorted() #9", isSorted(new float[]{3.141f, 3.141f, 3.141f}, false), true);
    }

    private static boolean isSorted(float[] numbers, boolean ascending) {
        if (ascending) {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (numbers[i] < numbers[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static float calculateAverage(float[] numbers) {
        var sum = 0f;
        for (float number : numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    private static float getMaximum(float[] numbers) {
        Arrays.sort(numbers);
        return numbers[numbers.length - 1];
    }

    private static float getMinimum(float[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
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
