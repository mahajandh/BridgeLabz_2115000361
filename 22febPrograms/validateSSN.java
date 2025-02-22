import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.*;

public class ValidateSSN {
    private static final String SSN_PATTERN = "\\b\\d{3}-\\d{2}-\\d{4}\\b";
    private static final Pattern pattern = Pattern.compile(SSN_PATTERN);

    public boolean isValidSSN(String ssn) {
        return pattern.matcher(ssn).matches();
    }

    public static class ValidateSSNTest {
        private final ValidateSSN validator = new ValidateSSN();

        @Test
        void testValidSSN() {
            assertTrue(validator.isValidSSN("123-45-6789"));
        }

        @Test
        void testInvalidSSN_NoDashes() {
            assertFalse(validator.isValidSSN("123456789"));
        }

        @Test
        void testInvalidSSN_WrongFormat() {
            assertFalse(validator.isValidSSN("123-456-789"));
        }
    }
}
