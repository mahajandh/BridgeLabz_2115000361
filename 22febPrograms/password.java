import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidator {
    public boolean isValidPassword(String password) {
        return password.length() >= 8 && 
               password.chars().anyMatch(Character::isUpperCase) && 
               password.chars().anyMatch(Character::isDigit);
    }

    public static class PasswordValidatorTest {
        private final PasswordValidator validator = new PasswordValidator();

        @Test
        void testValidPassword() {
            assertTrue(validator.isValidPassword("StrongPass1"));
        }

        @Test
        void testShortPassword() {
            assertFalse(validator.isValidPassword("Short1"));
        }

        @Test
        void testNoUpperCase() {
            assertFalse(validator.isValidPassword("weakpassword1"));
        }

        @Test
        void testNoDigit() {
            assertFalse(validator.isValidPassword("NoDigitPass"));
        }
    }
}
