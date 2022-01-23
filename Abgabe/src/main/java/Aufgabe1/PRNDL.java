package Aufgabe1;

public class PRNDL {
    public static boolean isReverse(String a, String b) {
        if (a.isEmpty() || b.isEmpty() || a.length() != b.length()) {
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(b.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}