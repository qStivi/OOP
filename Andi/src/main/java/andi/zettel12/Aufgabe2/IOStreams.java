package andi.zettel12.Aufgabe2;

import java.io.*;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IOStreams {

    public static Stream<String> words(String filePath) throws IOException {
        Stream<String> result;
        FileInputStream fis = new FileInputStream(filePath);
        String txt = "";
        try(BufferedReader br = new BufferedReader(new InputStreamReader(fis))){
            String line;
            while((line = br.readLine()) != null){
                txt += line;
            }
        }
        result = Stream.of(txt.replaceAll("[^((A-Z)(a-z))]", " ").replaceAll("  +", " ").split(" "));
        return result;
    }


    public static Map<String, Integer> countWords(Stream<String> words){
        return words.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(x -> 1)));
    }

    public static void writeCountedWords(Map<String, Integer> countedWords, String filepath) throws IOException {
        File file = new File(filepath);
        FileWriter fw = new FileWriter(file);
        countedWords.forEach((x,y) -> {
            try {
                fw.write(x + ": " + y + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fw.close();
    }

    public static void main(String[] args) throws IOException {
        writeCountedWords(countWords(words("theRaven.txt")), "testAndi.txt");
    }

}
