package zettel6.qStivi;

import java.util.Arrays;

public class Aufgabe2 {
    public static void main(String[] args) {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
        var success = Arrays.equals(primes, primesUpTo(100));
        if (success) {
            System.out.println("yee");
        } else {
            System.out.println("nyeh");
        }
        System.out.println(Arrays.toString(primesUpTo(0)));
        System.out.println(Arrays.toString(primesUpTo(-5)));
        System.out.println(Arrays.toString(primesUpTo(5)));
    }

    /**
     * das wäre mit Recursion bestimmt viel einfacher
     * aber da müsste man ja nachdenken
     * XD
     */
    private static int[] primesUpTo(int n) {
        if (n < 1) {
            return null;
        }
        // create array of number from 2 to n
        var numbers = new int[n - 1];
        for (int i = 2; i < n + 1; i++) {
            numbers[i - 2] = i;
        }
        // applie rules mentioned in task. but replacing numbers that are supposed to be removed bc arrays are not lists
        for (int j = 0; j < numbers.length; j++) {
            int number = numbers[j];
            if (number != -1) {
                for (int i = j + 1; i < numbers.length; i++) {
                    int multiple = numbers[i];
                    if (multiple % number == 0) {
                        numbers[i] = -1;
                    }
                }
            }
        }
        // getting size of array of remaining numbers
        var primesLength = 0;
        for (int number : numbers) {
            if (number != -1) {
                primesLength++;
            }
        }
        // adding only number that are not -1 to new array
        var primes = new int[primesLength];
        for (int number : numbers) {
            if (number != -1) {
                for (int j = 0; j < primesLength; j++) {
                    if (primes[j] == 0) {
                        primes[j] = number;
                        break;
                    }
                }
            }
        }
        return primes;
    }
}
