package zettel5.qStivi;

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
        test("getMinimum() #7", getMinimum(new float[3]), null);
        test("getMinimum() #8", getMinimum(new float[]{}), null);

/////// getMaximum() tests ///////
        test("getMaximum() #1", getMaximum(new float[]{1337.8f, 1337.1f, 1337.5f}), 1337.8f);
        test("getMaximum() #2", getMaximum(new float[]{42.5f, 42.8f, 42.1f}), 42.8f);
        test("getMaximum() #3", getMaximum(new float[]{17.5f, 17.1f, 17.8f}), 17.8f);
        test("getMaximum() #4", getMaximum(new float[]{Float.MIN_VALUE, Float.MAX_VALUE, 0f}), Float.MAX_VALUE);
        test("getMaximum() #5", getMaximum(new float[]{0, 0, 0}), 0.0f);
        test("getMaximum() #6", getMaximum(new float[]{3.141f, 3.141f, 3.141f}), 3.141f);
        test("getMaximum() #7", getMaximum(new float[3]), null);
        test("getMaximum() #8", getMaximum(new float[]{}), null);

/////// calculateAverage() tests ///////
        test("calculateAverage() #1", calculateAverage(new float[]{1337.8f, 1337.1f, 1337.5f}), 1337.466f);
        test("calculateAverage() #2", calculateAverage(new float[]{42.5f, 42.8f, 42.1f}), 42.466f);
        test("calculateAverage() #3", calculateAverage(new float[]{17.5f, 17.1f, 17.8f}), 17.466f);
        test("calculateAverage() #4", calculateAverage(new float[]{0, 0, 0}), 0.0f);
        test("calculateAverage() #5", calculateAverage(new float[]{3.141f, 3.141f, 3.141f}), 3.141f);
        test("calculateAverage() #6", calculateAverage(new float[3]), null);
        test("calculateAverage() #7", calculateAverage(new float[]{}), null);

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
        test("isSorted() #10", isSorted(new float[3], true), null);
        test("isSorted() #11", isSorted(new float[]{}, false), null);
    }

    private static boolean isSorted(float[] numbers, boolean ascending) {
        return isSortedRecurcive(numbers, numbers.length, ascending); // We iterate from the last to the first elemet.
    }

    private static boolean isSortedRecurcive(float[] arr, int n, boolean ascending) {
        if (n < 2) {
            return true; // All elemnts have been checked. Return true.
        }

        if (ascending) {
            if (arr[n - 1] > arr[n - 2]) {
                return false;
            }
        } else {
            if (arr[n - 1] < arr[n - 2]) {
                return false;
            }
        }
        return isSortedRecurcive(arr, n - 1, ascending);
    }

    private static float calculateAverage(float[] numbers) {
        if (numbers.length < 2) return -1;
        var sum = 0f;
        int i = 0, numbersLength = numbers.length;
        while (i < numbersLength) {
            float number = numbers[i];
            sum += number;
            i++;
        }
        return sum / numbers.length - 1;
    }

    private static float getMaximum(float[] numbers) {
        var max = Float.MAX_VALUE * -1;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > max) max = numbers[i];
        }
        return max;
    }

    private static float getMinimum(float[] numbers) {
        var min = Float.MAX_VALUE;
        for (float number : numbers) {
            if (number < min) min = number;
        }
        return min;
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
