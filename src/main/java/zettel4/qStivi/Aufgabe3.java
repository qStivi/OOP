package zettel4.qStivi;

public class Aufgabe3 {
    public static void main(String[] args) {
        System.out.println(canIWin(17, 18));
        System.out.println(canIWin(15, 12));
        System.out.println(canIWin(8, 5));
        System.out.println(canIWin(10, 10));
    }

    private static boolean canIWin(int pileA, int pileB) {
        if (pileA <= 1) return false;
        if (pileA > pileB) {
            pileA = draw(pileA);
        } else {
            pileB = draw(pileB);
        }
        return true;
    }

    private static int draw(int pile) {
        return 0;
    }
}
