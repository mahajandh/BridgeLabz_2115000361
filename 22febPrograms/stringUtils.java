import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StringUtils {
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public boolean isPalindrome(String str) {
        String reversed = reverse(str);
        return str.equalsIgnoreCase(reversed);
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static class StringUtilsTest {
        private final StringUtils stringUtils = new StringUtils();

        @Test
        void testReverse() {
            assertEquals("cba", stringUtils.reverse("abc"));
        }

        @Test
        void testIsPalindrome() {
            assertTrue(stringUtils.isPalindrome("madam"));
            assertFalse(stringUtils.isPalindrome("hello"));
        }

        @Test
        void testToUpperCase() {
            assertEquals("HELLO", stringUtils.toUpperCase("hello"));
        }
    }
}
