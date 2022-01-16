package de.qStivi.zettel8.Aufgabe1;

public class Caesar {

    public static String decode(String coded, char a, char b) {
        // Make chars uppercase
        a = String.valueOf(a).toUpperCase().charAt(0);
        b = String.valueOf(b).toUpperCase().charAt(0);

        char[] result = new char[coded.length()]; // Create char array with size of encoded string

        // Decode one char after another
        for (int i = 0; i < result.length; i++) {
            var diff = a - b;
            var c = (char) (coded.charAt(i) - diff);

            // If char gets out of range continue on the other end
            if (c < 'A') {
                c = (char) ('[' - (('A' - c))); // Calculate remaining difference then start decoding from the other end
            }
            if (c > 'Z') {
                c = (char) ('@' + ((c - 'Z')));
            }

            result[i] = c;
        }
        return new String(result);

    }
}
