package de.qStivi.zettel9.Aufgabe2;


public class Replace {
    static String replace(String source, String search, String replace) {
        while (true) {
            var i = source.indexOf(search);
            if (i == -1) {
                return source; // Return result when no search was found
            }
            var front = "";
            if (i != 0) {
                front = source.substring(0, i);
            }
            var back = source.substring(i + search.length());
            source = front + replace + back;
        }
    }
}