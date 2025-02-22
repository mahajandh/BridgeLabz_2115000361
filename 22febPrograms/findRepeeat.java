import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class FindRepeatingWords {
    private static final String WORD_PATTERN = "\\b(\\w+)\\b(?=.*\\b\\1\\b)";
    private static final Pattern pattern = Pattern.compile(WORD_PATTERN, Pattern.CASE_INSENSITIVE);

    public List<String> findRepeatingWords(String text) {
        HashSet<String> repeatedWords = new HashSet<>();
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            repeatedWords.add(matcher.group().toLowerCase());
        }
        return new ArrayList<>(repeatedWords);
    }

    public static class FindRepeatingWordsTest {
        private final FindRepeatingWords finder = new FindRepeatingWords();

        @Test
        void testFindRepeatingWords() {
            String input = "This is is a repeated repeated word test.";
            List<String> expected = List.of("is", "repeated");
            assertEquals(expected, finder.findRepeatingWords(input));
        }
        
        @Test
        void testNoRepeatingWords() {
            String input = "Each word is unique here.";
            List<String> expected = List.of();
            assertEquals(expected, finder.findRepeatingWords(input));
        }
    }
}
