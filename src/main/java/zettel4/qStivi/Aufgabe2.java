package zettel4.qStivi;

public class Aufgabe2 {


    private static String toBinary(int n) {
        if (n < 0) return "-1";
        var quotient = n / 2;
        var modulo = n % 2;
        if (n != 0) return toBinary(quotient) + modulo;
        return "0";
    }

    private static String toOctal(int n) {
        if (n < 0) return "-1";
        var quotient = n / 8;
        var modulo = n % 8;
        if (n != 0) return toOctal(quotient) + modulo;
        return "0";
    }

    private static String toTwosComplement(int n) {
        if (n < -128 || n > 127) return "-1";
        String binary = "";
        boolean negative = false;
        if (n < 0) {
            n += 128;
            negative = true;
        }
        while (n > 0) {
            var quotient = n / 2;
            var modulo = n % 2;
            binary = modulo + binary;
            n = quotient;
        }
        if (negative) {
            binary = "1" + binary;
        } else {
            binary = "0" + binary;
        }
        while (binary.length() < 8) {
            if (negative) {
                binary = "1" + binary;
            } else {
                binary = "0" + binary;
            }
        }
        return binary;
    }
}
