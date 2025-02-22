import java.util.*;
import java.util.regex.*;

public class RepeatingWordsFinder {
    public static Set<String> findRepeatingWords(String text) {
        Set<String> repeatedWords = new HashSet<>();
        Set<String> seenWords = new HashSet<>();

        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {
            if (seenWords.contains(word)) {
                repeatedWords.add(word);
            }
            seenWords.add(word);
        }

        return repeatedWords;
    }

    public static void main(String[] args) {
        String text = "This is is a repeated repeated word test.";
        System.out.println(String.join(", ", findRepeatingWords(text)));  
        // Output: is, repeated
    }
}
