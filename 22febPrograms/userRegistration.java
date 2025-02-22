import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistration {
    public void registerUser(String username, String email, String password) {
        if (username == null || username.isEmpty() || 
            email == null || !email.contains("@") || 
            password == null || password.length() < 8) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    public static class UserRegistrationTest {
        private final UserRegistration registration = new UserRegistration();

        @Test
        void testValidRegistration() {
            assertDoesNotThrow(() -> registration.registerUser("JohnDoe", "john@example.com", "Password1"));
        }

        @Test
        void testInvalidUsername() {
            assertThrows(IllegalArgumentException.class, () -> registration.registerUser("", "john@example.com", "Password1"));
        }

        @Test
        void testInvalidEmail() {
            assertThrows(IllegalArgumentException.class, () -> registration.registerUser("JohnDoe", "johnexample.com", "Password1"));
        }

        @Test
        void testShortPassword() {
            assertThrows(IllegalArgumentException.class, () -> registration.registerUser("JohnDoe", "john@example.com", "short"));
        }
    }
}
