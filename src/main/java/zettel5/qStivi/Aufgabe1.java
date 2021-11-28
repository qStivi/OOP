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
        test("getMinimum() #5", getMinimum(new float[]{0, 0, 0}), 0f);
        test("getMinimum() #6", getMinimum(new float[]{3.141f, 3.141f, 3.141f}), 3.141f);
        test("getMinimum() #7", getMinimum(new float[3]), 0f);
        test("getMinimum() #8", getMinimum(new float[]{}), Float.NaN);

/////// getMaximum() tests ///////
        test("getMaximum() #1", getMaximum(new float[]{1337.8f, 1337.1f, 1337.5f}), 1337.8f);
        test("getMaximum() #2", getMaximum(new float[]{42.5f, 42.8f, 42.1f}), 42.8f);
        test("getMaximum() #3", getMaximum(new float[]{17.5f, 17.1f, 17.8f}), 17.8f);
        test("getMaximum() #4", getMaximum(new float[]{Float.MIN_VALUE, Float.MAX_VALUE, 0f}), Float.MAX_VALUE);
        test("getMaximum() #5", getMaximum(new float[]{0, 0, 0}), 0.0f);
        test("getMaximum() #6", getMaximum(new float[]{3.141f, 3.141f, 3.141f}), 3.141f);
        test("getMaximum() #7", getMaximum(new float[3]), 0f);
        test("getMaximum() #8", getMaximum(new float[]{}), Float.NaN);

/////// calculateAverage() tests ///////
        test("calculateAverage() #1", calculateAverage(new float[]{1337.8f, 1337.1f, 1337.5f}), 1337.4667f);
        test("calculateAverage() #2", calculateAverage(new float[]{42.5f, 42.8f, 42.1f}), 42.466667f);
        test("calculateAverage() #3", calculateAverage(new float[]{17.5f, 17.1f, 17.8f}), 17.466665f);
        test("calculateAverage() #4", calculateAverage(new float[]{0, 0, 0}), 0.0f);
        test("calculateAverage() #5", calculateAverage(new float[]{3.141f, 3.141f, 3.141f}), 3.141f);
        test("calculateAverage() #6", calculateAverage(new float[3]), 0f);
        test("calculateAverage() #7", calculateAverage(new float[]{}), Float.NaN);

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
        test("isSorted() #10", isSorted(new float[3], true), true);
        test("isSorted() #11", isSorted(new float[]{}, false), true);
    }

    private static boolean isSorted(float[] numbers, boolean ascending) {
        return isSortedRecursive(numbers, numbers.length - 1, ascending); // We iterate from the last to the first elemet.
    }

    private static boolean isSortedRecursive(float[] arr, int n, boolean ascending) {
        if (n < 2) {
            return true; // All elements have been checked. Return true.
        }

        // Compare current value with value "to the left" and apply rule (ascending/descending). Equal means sorted.
        if (ascending) {
            if (arr[n] < arr[n - 1]) {
                return false;
            }
        } else {
            if (arr[n] > arr[n - 1]) {
                return false;
            }
        }
        return isSortedRecursive(arr, n - 1, ascending); // Next two values.
    }

    private static float calculateAverage(float[] numbers) {
        var sum = 0f;
        int i = 0, numbersLength = numbers.length;
        // Sum up all values.
        while (i < numbersLength) {
            sum += numbers[i];
            i++;
        }
        return sum / numbersLength; // Divide with amount. No numbers have no Average.
    }

    private static float getMaximum(float[] numbers) {
        if (numbers.length == 0) return Float.NaN; // No numbers have no maximum.
        var max = Float.MAX_VALUE * -1; // Very small value.
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) max = numbers[i]; // Compare to current maximum value and set new value when current is smaller.
        }
        return max;
    }

    private static float getMinimum(float[] numbers) {
        if (numbers.length == 0) return Float.NaN; // No numbrs have no minimum.
        var min = Float.MAX_VALUE; // Very large number.
        for (float number : numbers) {
            if (number < min) min = number; // Compare to current minimum value and set new value when current is greater.
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
