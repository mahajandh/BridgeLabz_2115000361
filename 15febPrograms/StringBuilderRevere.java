public class StringBuilderReverse {
    public static String reverseString(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Handle edge cases
        }
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        String input = "hello";
        System.out.println("Reversed: " + reverseString(input));
    }
}
