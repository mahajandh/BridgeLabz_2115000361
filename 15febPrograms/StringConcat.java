public class StringBufferConcatenation {
    public static String concatenateStrings(String[] strings) {
        if (strings == null || strings.length == 0) {
            return ""; // Handle edge cases
        }

        StringBuffer result = new StringBuffer();
        for (String str : strings) {
            result.append(str);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Hello", " ", "World", "!"};
        System.out.println("Concatenated String: " + concatenateStrings(words));
    }
}
