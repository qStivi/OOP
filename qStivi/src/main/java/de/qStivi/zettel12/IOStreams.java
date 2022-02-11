package de.qStivi.zettel12;

import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class IOStreams {
    public static Stream<String> words(String filePath) throws IOException {
        // region Get text
        var fis = new FileInputStream(filePath);
        var txt = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(fis))) {
            String line;
            while ((line = br.readLine()) != null) {
                txt += line + " ";
            }
        }
        // endregion

        // replaceAll("’", "") Converts all words like cushion’s and o’er to one word
        // replaceAll("[^((A-Z)(a-z))]", " ") Replaces all non alphabetic characters with spaces
        // replaceAll("  ", " ") Now we have double spaces so we merge these
        // split(" ") Getting words as Array
        // Arrays.stream() To stream
        return Arrays.stream(txt.replaceAll("’", "").replaceAll("[^((A-Z)(a-z))]", " ").replaceAll("  +", " ").strip().split(" "));
    }

    public static Map<String, Integer> countWords(Stream<String> words) {
        return words.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(e -> 1)));
    }

    public static void writeCountedWords(Map<String, Integer> countedWords, String filepath) throws IOException {
        var file = new File(filepath);
        var fw = new FileWriter(file);
        countedWords.forEach((k, v) -> {
            try {
                fw.write(k + " : " + v + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fw.close();
    }

    public static void writeCoundedWordsSortedJustForFun(Map<String, Integer> countedWords, String filepath) throws IOException {
        countedWords = sortByValueSolenFromTheInternet(countedWords);
        writeCountedWords(countedWords, filepath);
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValueSolenFromTheInternet(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        writeCountedWords(countWords(words("theRaven.txt")), "test.txt");
        writeCoundedWordsSortedJustForFun(countWords(words("theRaven.txt")), "sorted.txt");
    }
}
