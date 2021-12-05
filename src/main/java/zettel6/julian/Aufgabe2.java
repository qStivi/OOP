package zettel6.julian;

public class Aufgabe2 {
    public static void main(String[] args) {
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

    static boolean testForEquality(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
