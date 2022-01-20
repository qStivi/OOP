package andi.zettel9.Aufgabe1;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String a = "Frühstück";
        String b = "Kcütshürf";
        System.out.println(isReverse(a,b));

        String one = "Da steht ein rotes Auto und ein blaues Auto.";
        System.out.println(replace(one, "Auto", "Spielzeug"));

    }

    public static String replace(String source, String search, String replace){
        if(source.indexOf(search) != -1) {
            String result = source;
            int n = source.indexOf(search);
            result = result.substring(0, n) + replace + result.substring(n + search.length(), source.length());
            return replace(result, search , replace);
        } else {
            return source;
        }
    }

    public static boolean isReverse(String a, String b){
        if(a.isEmpty() || b.isEmpty() || a.length() != b.length()){
            return false;
        }
        a = a.toLowerCase();
        b = b.toLowerCase();
        for (int i = 0; i<a.length(); i++){
            if(a.charAt(i)!= b.charAt(b.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }
}
