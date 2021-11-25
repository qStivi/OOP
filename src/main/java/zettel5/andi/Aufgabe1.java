package zettel5.andi;

public class Aufgabe1 {

    public static void main(String[] args) {
        testAll();
    }

    static void testAll() {
        float[] test = {13.37f, 4.2f, 6.66f, 6.9f};
        float[] test2 = {4.2f, 6.66f, 6.9f, 13.37f};
        float[] test3 = {13.37f, 6.9f, 6.66f, 4.2f};

        float minimum1 = 4.2f;
        float maximum1 = 13.37f;
        float average1 = 15.565f;

        float minimum2 = getMinimum(test);
        float maximum2 = getMaximum(test);
        float average2 = calculateAverage(test);

        testAllHelp(minimum1, minimum2, "getMinimum");
        testAllHelp(maximum1, maximum2, "getMaximum");
        testAllHelp(average1, average2, "calculateAverage");

        testAllHelpSort(isSorted(test, true), true);
        testAllHelpSort(isSorted(test, false), false);
        testAllHelpSort(isSorted(test2, true), true);
        testAllHelpSort(isSorted(test3, false), false);
    }

    static void testAllHelp(float f1, float f2, String testName) {
        if (f1 == f2) {
            System.out.println("Your test \"" + testName + "\" was successful. Your number is: " + f2);
        } else {
            System.out.println("Your test \"" + testName + "\" failed.");
        }
    }

    static void testAllHelpSort(boolean result, boolean ascending) {
        if (result && ascending) {
            System.out.println("Your test \" isSorted \" was successful. Your array is in ascending order.");
        } else if (result && !ascending) {
            System.out.println("Your test \" isSorted \" was successful. Your array is in descending order.");
        } else if (!result && ascending) {
            System.out.println("Your test \" isSorted \" failed. Your array is not in order or try descending.");
        } else if (!result && !ascending) {
            System.out.println("Your test \" isSorted \" failed. Your array is not in order or try ascending.");
        }
    }

    static float getMinimum(float[] numbers) {
        float result = numbers[0];
        int i = 1;
        while (i < numbers.length) {
            if (numbers[i] < result) {
                result = numbers[i];
            }
            i++;
        }
        return result;
    }

    static float getMaximum(float[] numbers) {
        float result = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > result) {
                result = numbers[i];
            }
        }
        return result;
    }

    static float calculateAverage(float[] numbers) {
        float result = 0;
        for (float number : numbers) {
            result += number;
        }
        result /= 2;
        return result;
    }

    static boolean isSorted(float[] numbers, boolean ascending) {
        if (ascending) {
            return isSortedAscending(numbers, 0);
        } else {
            return isSortedDescending(numbers, 0);
        }
    }

    static boolean isSortedAscending(float[] numbers, int index) {
        boolean condition = false;
        if (index < numbers.length - 1) {
            if (numbers[index] < numbers[index + 1]) {
                index++;
                condition = isSortedAscending(numbers, index);
            }
        } else {
            condition = true;
        }
        return condition;
    }

    static boolean isSortedDescending(float[] numbers, int index) {
        boolean condition = false;
        if (index < numbers.length - 1) {
            if (numbers[index] > numbers[index + 1]) {
                index++;
                condition = isSortedDescending(numbers, index);
            }
        } else {
            condition = true;
        }
        return condition;
    }
}
