package zettel4.qStivi;

public class Aufgabe2 {
    public static void main(String[] args) {
        my_tests();
    }

    private static String toBinary(int n) {
        if (n < 0) return "-1";
        var quotient = n / 2;
        var modulo = n % 2;
        if (n > 0) return toBinary(quotient) + modulo;
        return "0";
    }

    private static String toOctal(int n) {
        if (n < 0) return "-1";
        var quotient = n / 8;
        var modulo = n % 8;
        if (n > 0) return toOctal(quotient) + modulo;
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

    private static void my_tests() {
////////////////////Binary tests////////////////////
        test("-1", toBinary(-17), "1", "Binary");
        test("0", toBinary(0), "2", "Binary");
        test("010100111001", toBinary(1337), "3", "Binary");
        test("01111111111111111111111111111111", toBinary(Integer.MAX_VALUE), "4", "Binary");
        test("-1", toBinary(Integer.MIN_VALUE), "5", "Binary");


////////////////////Octal tests////////////////////
        test("-1", toOctal(-42), "1", "Octal");
        test("0", toOctal(0), "2", "Octal");
        test("0234325", toOctal(80085), "3", "Octal");
        test("017777777777", toOctal(Integer.MAX_VALUE), "4", "Octal");
        test("-1", toOctal(Integer.MIN_VALUE), "5", "Octal");

////////////////////Two's complement tests////////////////////
        test("11101111", toTwosComplement(-17), "1", "Two's complement");
        test("00000000", toTwosComplement(0), "2", "Two's complement");
        test("00101010", toTwosComplement(42), "3", "Two's complement");
        test("-1", toTwosComplement(666), "3", "Two's complement");
        test("-1", toTwosComplement(Integer.MAX_VALUE), "4", "Two's complement");
        test("-1", toTwosComplement(Integer.MIN_VALUE), "4", "Two's complement");
    }

    private static void test(String expected, String calculated, String testNumber, String testName) {
        if (expected.equals(calculated)) {
            System.out.println(testName + " test " + testNumber + " passed.");
        } else {
            System.out.println(testName + " test " + testNumber + " failed!");
            System.out.println("Expected was: " + expected);
            System.out.println("But result was: " + calculated);
        }
        System.out.println("-----------------------------------------------------");
    }
}
