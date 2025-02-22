import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;

public class UsernameValidator {
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";
    private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

    public boolean isValidUsername(String username) {
        return username != null && pattern.matcher(username).matches();
    }

    public static class UsernameValidatorTest {
        private final UsernameValidator validator = new UsernameValidator();

        @Test
        void testValidUsername() {
            assertTrue(validator.isValidUsername("user_123"));
        }

        @Test
        void testStartsWithNumber() {
            assertFalse(validator.isValidUsername("123user"));
        }

        @Test
        void testTooShort() {
            assertFalse(validator.isValidUsername("us"));
        }

        @Test
        void testTooLong() {
            assertFalse(validator.isValidUsername("verylongusername123"));
        }

        @Test
        void testInvalidCharacters() {
            assertFalse(validator.isValidUsername("user@name"));
        }
    }
}
