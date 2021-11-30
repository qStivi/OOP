package zettel6.qStivi;

public class Aufgabe1 {
    public static void main(String[] args) {
        var r1 = 60d;
        var r2 = 40d;
        var r3 = 50d;
        var r4 = 50d;
        var r5 = 70d;
        var r6 = 80d;
        System.out.println(parallelCircuit(seriesCircuit(parallelCircuit(r1, r2), r3), parallelCircuit(seriesCircuit(r4, r5), r6)));
    }

    private static double seriesCircuit(double rOne, double rTwo) {
        return rOne + rTwo;
    }

    private static double parallelCircuit(double rOne, double rTwo) {
        return (rOne * rTwo) / (rOne + rTwo);
    }
}
