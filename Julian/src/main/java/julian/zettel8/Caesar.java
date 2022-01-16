package julian.zettel8;

public class Caesar {

    public String decode(String coded, char a, char b) {

        coded = coded.toUpperCase();
        a = Character.toUpperCase(a);
        b = Character.toUpperCase(b);
        StringBuilder sb = new StringBuilder();
        int shifted = ((int) a) - ((int) b);
        char[] letters = coded.toCharArray();

        for (char letter : letters) {
            int asciiCode = letter - shifted;
            if (asciiCode >= 90) {
                asciiCode = asciiCode - 26;
            }
            sb.append((char) asciiCode);
        }
        return sb.toString();
    }
}
