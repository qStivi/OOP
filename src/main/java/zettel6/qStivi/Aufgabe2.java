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

    static int[] primesUpTo(int n) {
        if (n < 2) {
            return new int[]{};
        }
        int[] numbersToN = new int[n - 1];
        for (int i = 2; i <= n; i++) {
            numbersToN[(i - 2)] = i;
        }
        for (int i = 0; i <= Math.sqrt(n) + 2; i++) {
            if (i >= numbersToN.length) {
                break;
            }
            if (numbersToN[i] == 0) {
                continue;
            }
            for (int j = i + 1; j <= n - 2; j++) {
                if (numbersToN[j] % numbersToN[i] == 0) {
                    numbersToN[j] = 0;
                }
            }
        }
        return filterZeros(numbersToN);
    }

    public static int[] filterZeros(int[] toBeFiltered) {
        int elementCount = 0;
        for (int i = 0; i < toBeFiltered.length; i++) {
            if (toBeFiltered[i] != 0) {
                elementCount++;
            }
        }
        int[] filtered = new int[elementCount];
        int k = 0;
        for (int i = 0; i < toBeFiltered.length; i++) {
            if (toBeFiltered[i] != 0) {
                filtered[k] = toBeFiltered[i];
                k++;
            }
        }
        return filtered;
    }
}
