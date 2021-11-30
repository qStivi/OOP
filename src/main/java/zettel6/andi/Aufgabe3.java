package zettel6.andi;

public class Aufgabe3 {
    public static void main(String[] args) {
        System.out.println(krt(9, 2, 0.00001));
        System.out.println(krt(-9, 2, 0.00001));
        System.out.println(krt(9, -2, 0.0001));
        System.out.println(krt(27, 3, 0.00001));
        System.out.println(krt(7, 5, 0.00001));
    }

    static double krt(double a, double k, double d){
        if(a < 0 || k < 0){
            return 0;
        }
        return krtH(a, k, d, a);
    }

    static double krtH(double a, double k, double d, double x_n){
        double x_n1;
        x_n1 = 1 / k * ((k-1) * x_n + a / Math.pow(x_n, (k - 1)));
        double result = x_n1;
        if( x_n - x_n1 > d){
            result = krtH(a, k, d, x_n1);
        }
        return result;
    }
}
