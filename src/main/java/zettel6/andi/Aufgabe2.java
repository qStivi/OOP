package zettel6.andi;

import static java.util.Arrays.copyOfRange;

public class Aufgabe2 {
    public static void main(String[] args) {
        int[] test = primesUpTo(100);
        for (int value : test) {
            System.out.println(value);
        }
    }

    static int[] primesUpTo(int n) {
        int[] result = new int[n + 1];
        int endIndex = 0;
        if (n < 0) {
            System.out.println("Your number must not be negative.");
        } else {
            for (int i = 0; i <= n; i++) { //Filling Array with numbers up to n
                result[i] = i;
            }
            result[1] = 0;
            for (int i = 2; i < Math.sqrt(n) + 2; i++) { //Changing every non-prime number with 0
                for (int j = 2; j < result.length; j++) {
                    if (result[j] != i && result[j] % i == 0) {
                        result[j] = 0;
                    }
                }
            }
            for (int i = 0; i < result.length; i++) { //Bubble-Sort - switching numbers != 0 with a 0
                for (int j = 0; j < result.length; j++) {
                    if (result[j] == 0) {
                        result[j] = result[i];
                        result[i] = 0;
                    }
                }
            }
            while(result[endIndex] != 0){
                endIndex++;
            }
        }
        return copyOfRange(result, 0, endIndex);
    }
}
