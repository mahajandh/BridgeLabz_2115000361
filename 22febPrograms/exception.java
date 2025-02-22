import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionHandling {
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static class ExceptionHandlingTest {
        private final ExceptionHandling exceptionHandling = new ExceptionHandling();

        @Test
        void testDivideByZero() {
            Exception exception = assertThrows(ArithmeticException.class, () -> exceptionHandling.divide(6, 0));
            assertEquals("Cannot divide by zero", exception.getMessage());
        }
    }
}
