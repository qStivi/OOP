package de.qStivi.zettel9.Aufgabe1;

public class PRNDL {
    public static boolean isReverse(String a, String b) {
        if (a.length() != b.length()) {
            return false; // Skip rest of method on size mismatch
        }
        for (int i = 0; i < a.length(); i++) {
            // These are only their own vars for better readability
            var ss1 = a.toLowerCase().substring((a.length() - 1) - i, (a.length() - i)); // Get each "char" from behind
            var ss2 = b.toLowerCase().substring(i, (i + 1)); // Get each "char"
            if (!ss1.contentEquals(ss2)) {
                return false; // Return false when mismatch was found
            }
        }
        return true; // If no mismatch was found return true
    }
}