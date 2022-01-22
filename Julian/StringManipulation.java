import java.util.Arrays;

public class StringManipulation {

    public static boolean isReverse(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        } else {
            for (int i = 0; i < a.length(); i++) {
                char charOfA = a.charAt(i);
                char charOfB = b.charAt((b.length() - 1) - i);
                if (charOfA != charOfB) {
                    return false;
                }
            }
            return true;
        }
    }

    public static String replace(String source, String search, String replace) {
        if (source.length() == 0 || search.length() == 0) {
            return source;
        }
        int[] startIndexesOfSearch = new int[source.length()];
        String[] keep = new String[source.length()];
        for (int i = 0; i < startIndexesOfSearch.length; i++) {
            startIndexesOfSearch[i] = -1;
        }
        int arrayIndex = 0;
        int j = 0;
        while (source.indexOf(search, j) != -1) {
            int foundAt = source.indexOf(search, j);
            startIndexesOfSearch[arrayIndex] = foundAt;
            arrayIndex++;
            j = search.length() + foundAt;
        }
        int currentStart = 0;
        int currentEnding = 0;
        int h = 0;
        for (int i = 0; startIndexesOfSearch[i] != -1; i++) {
            currentEnding = startIndexesOfSearch[i];

            String word = source.substring(currentStart, currentEnding);

            if (word.length() > 0) {
                keep[h++] = word;
            }
            currentStart = currentEnding + search.length();
        }
        String remainingWord = source.substring(currentEnding + search.length());
        keep[h] = remainingWord;
        String output = "";
        if (startIndexesOfSearch[0] == 0) { //Am Anfang replace
            output = output + replace;
        }
        for (int i = 0; keep[i] != null; i++) {
            if (keep[i + 1] == null) {
                output = output + keep[i];
            } else {
                output = output + keep[i] + replace;
            }
        }
        if (startIndexesOfSearch[arrayIndex + replace.length()] == source.length()) {
            output = output + replace;
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(isReverse("Test12", "tseT")); //tseT
        System.out.println(replace("stHalHalHallolloTeHallostHalHalloloTestHallost", "Hallo", ""));
        System.out.println("stHalHalHallolloTeHallostHalHalloloTestHallost".replace("Hallo", ""));
    }

}
