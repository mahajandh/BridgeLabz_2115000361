import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class ExtractProgrammingLanguages {
    private static final String LANGUAGE_PATTERN = "\\b(JavaScript|Java|Python|Go|C\\+\\+|C#|Ruby|Swift|Kotlin|PHP|Rust|TypeScript)\\b";
    private static final Pattern pattern = Pattern.compile(LANGUAGE_PATTERN);

    public List<String> extractLanguages(String text) {
        List<String> languages = new ArrayList<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            languages.add(matcher.group());
        }
        return languages;
    }

    public static class ExtractProgrammingLanguagesTest {
        private final ExtractProgrammingLanguages extractor = new ExtractProgrammingLanguages();

        @Test
        void testExtractLanguages() {
            String input = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
            List<String> expected = List.of("Java", "Python", "JavaScript", "Go");
            assertEquals(expected, extractor.extractLanguages(input));
        }
        
        @Test
        void testNoLanguages() {
            String input = "I enjoy reading books and hiking.";
            List<String> expected = List.of();
            assertEquals(expected, extractor.extractLanguages(input));
        }
    }
}
