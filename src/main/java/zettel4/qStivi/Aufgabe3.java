package zettel4.qStivi;

public class Aufgabe3 {
    public static void main(String[] args) {
        System.out.println(canIWin(1, 5));
        System.out.println(canIWin(1, 6));
        System.out.println(canIWin(1, 7));
    }

    static boolean canIWin(int pileA, int pileB) {
        boolean condition = (pileA < 2 && pileB == 2) || (pileA < 2 && pileB == 3) || (pileA < 2 && pileB == 4) || (pileB < 2 && pileA == 2) || (pileB < 2 && pileA == 3) || (pileB < 2 && pileA == 4);
        if (pileA >= 0 && pileB >= 0) {
            if (canIWin(pileA, pileB - 4) || canIWin(pileA, pileB - 5) ||
                    canIWin(pileA, pileB - 6) || canIWin(pileA - 2, pileB - 2) ||
                    canIWin(pileA - 3, pileB - 2) || canIWin(pileA - 3, pileB - 3) ||
                    canIWin(pileA - 2, pileB - 3) || canIWin(pileA - 4, pileB) ||
                    canIWin(pileA - 5, pileB - 3) || canIWin(pileA - 6, pileB - 3)) {
                condition = true;
            }
        }
        return condition;
    }
}
/*
Link: https://docs.google.com/spreadsheets/d/1y6KEg52JTS6ACOFXPgbSQirOVc-mDdy9DYvrG6Vyrjo/edit?usp=sharing

Muster bei PileA <= 1
3, 8, 13, 18

und jeweils ±1, also bei

 2,  3,  4
12, 13, 14
17, 18, 19

Gewinnt immer Der Spieler , der als nächstes zieht

Muster bei PileA == 2
5, 10, 15, 20

und jeweils ±1, also bei

 4,  5,  6
 9, 10, 11
14, 15, 16
19, 20, 21

Gewinnt immer Der Spieler , der als nächstes zieht
 */