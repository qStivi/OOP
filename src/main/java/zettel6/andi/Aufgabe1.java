package zettel6.andi;

public class Aufgabe1 {
    public static void main(String[] args) {
        double[] test = {60, 40, 50, 50, 70, 80};
        double result1;
        double result2;
        result1 = parallelCircuit(test[0], test[1]);
        result1 = seriesCircuit(result1, test[2]);
        result2 = seriesCircuit(test[3], test[4]);
        result2 = parallelCircuit(result2, test[5]);
        System.out.println(parallelCircuit(result1, result2));

    }

    static double seriesCircuit(double rOne, double rTwo) {
        return rOne + rTwo;
    }

    static double parallelCircuit(double rOne, double rTwo) {
        return (rOne * rTwo) / (rOne + rTwo);
    }
}
