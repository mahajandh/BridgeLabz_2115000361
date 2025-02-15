import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicates(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Handle edge cases
        }

        StringBuilder result = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input = "programming";
        System.out.println("Without Duplicates: " + removeDuplicates(input));
    }
}
