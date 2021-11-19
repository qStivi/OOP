package zettel4.qStivi;

public class Main {
    public static void main(String[] args) {
        System.out.println("0 = " + toTwosComplement(0));
        System.out.println("1 = " + toTwosComplement(1));
        System.out.println("2 = " + toTwosComplement(2));
        System.out.println("3 = " + toTwosComplement(3));
        System.out.println("16 = " + toTwosComplement(16));
        System.out.println("-1 = " + toTwosComplement(-1));
        System.out.println("-2 = " + toTwosComplement(-2));
        System.out.println("-3 = " + toTwosComplement(-3));
        System.out.println("-16 = " + toTwosComplement(-16));
        System.out.println("127 = " + toTwosComplement(127));
        System.out.println("-128 = " + toTwosComplement(-128));
        System.out.println("-129 = " + toTwosComplement(-129));
        System.out.println("128 = " + toTwosComplement(128));
        System.out.println(Integer.MAX_VALUE + " = " + toBinary(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE + " = " + toBinary(Integer.MIN_VALUE));
        System.out.println("1337 = " + toBinary(1337));
        System.out.println("0 = " + toBinary(0));
        System.out.println(Integer.MAX_VALUE + " = " + toOctal(Integer.MAX_VALUE));
        System.out.println(Integer.MIN_VALUE + " = " + toOctal(Integer.MIN_VALUE));
        System.out.println("1337 = " + toOctal(1337));
        System.out.println("0 = " + toOctal(0));
    }

    public static String toBinary(int n){
        if (n < 0) return "-1";
        var quotient = n / 2;
        var modulo = n % 2;
        if (n != 0) return toBinary(quotient) + modulo;
        return "0";
    }

    public static String toOctal(int n){
        if (n < 0) return "-1";
        var quotient = n / 8;
        var modulo = n % 8;
        if (n != 0) return toOctal(quotient) + modulo;
        return "0";
    }

    public static String toTwosComplement(int n) {
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
