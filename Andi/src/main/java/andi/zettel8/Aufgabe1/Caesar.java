package andi.zettel8.Aufgabe1;

public class Caesar {

    public static String decode(String coded, char a, char b) {
        a = Character.toUpperCase(a);
        b = Character.toUpperCase(b);

        int difference = b - a;
        Character[] word = new Character[coded.length()];
        for (int i = 0; i < coded.length(); i++) {
            if (coded.charAt(i) + difference > 90) {
                int s = coded.charAt(i) + difference - 26;
                word[i] = (char) (s);
            } else if (coded.charAt(i) + difference < 64) {
                int s = coded.charAt(i) + difference + 26;
                word[i] = (char) (s);
            } else {
                word[i] = (char) (coded.charAt(i) + difference);
            }
        }
        String result = "";
        for (char c : word) {
            result += c;
        }
        return result;
    }
}