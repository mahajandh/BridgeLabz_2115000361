import java.util.*;
import java.util.regex.*;


public class ProgrammingLanguageExtractor {
    public static List<String> extractLanguages(String text) {
        List<String> languages = Arrays.asList("Java", "Python", "JavaScript", "Go", "C", "C++", "Ruby", "Swift", "Kotlin", "PHP");
        List<String> foundLanguages = new ArrayList<>();


        for (String lang : languages) {
            if (text.contains(lang)) {
                foundLanguages.add(lang);
            }
        }


        return foundLanguages;
    }


    public static void main(String[] args) {
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        System.out.println(String.join(", ", extractLanguages(text)));  // Output: Java, Python, JavaScript, Go
    }
}


