import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;
import java.util.List;
import java.util.Arrays;

public class CensorBadWords {
    private static final List<String> BAD_WORDS = Arrays.asList("damn", "stupid");
    
    public String censorBadWords(String text) {
        if (text == null) return "";
        String regex = String.join("|", BAD_WORDS);
        return text.replaceAll("\\b(" + regex + ")\\b", "****");
    }

    public static class CensorBadWordsTest {
        private final CensorBadWords censor = new CensorBadWords();

        @Test
        void testCensorBadWords() {
            String input = "This is a damn bad example with some stupid words.";
            String expected = "This is a **** bad example with some **** words.";
            assertEquals(expected, censor.censorBadWords(input));
        }
        
        @Test
        void testNoBadWords() {
            String input = "This is a clean sentence.";
            assertEquals("This is a clean sentence.", censor.censorBadWords(input));
        }
    }
}
