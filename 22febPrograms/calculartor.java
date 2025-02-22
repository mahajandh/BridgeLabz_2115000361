import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static class CalculatorTest {
        private final Calculator calculator = new Calculator();

        @Test
        void testAdd() {
            assertEquals(5, calculator.add(2, 3));
        }

        @Test
        void testSubtract() {
            assertEquals(1, calculator.subtract(4, 3));
        }

        @Test
        void testMultiply() {
            assertEquals(6, calculator.multiply(2, 3));
        }

        @Test
        void testDivide() {
            assertEquals(2, calculator.divide(6, 3));
        }

        @Test
        void testDivideByZero() {
            Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0));
            assertEquals("Cannot divide by zero", exception.getMessage());
        }
    }
}