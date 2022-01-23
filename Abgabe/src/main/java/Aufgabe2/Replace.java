package Aufgabe2;

@SuppressWarnings("all")
public class Replace {
    public static String replace(String source, String search, String replace) {
        if (source.indexOf(search) != -1) {
            String result = source;
            int n = source.indexOf(search);
            result = result.substring(0, n) + replace + result.substring(n + search.length(), source.length());
            return replace(result, search, replace);
        } else {
            return source;
        }
    }
}