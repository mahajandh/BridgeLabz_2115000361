import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static int countWordOccurrences(String filePath, String targetWord) {
        int count = 0;
        targetWord = targetWord.toLowerCase(); // Ensure case-insensitive matching

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("\\W+"); // Split by non-word characters
                for (String word : words) {
                    if (word.equals(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        String filePath = "example.txt"; // Change to your file path
        String targetWord = "hello"; // Change to the word you want to count

        int occurrences = countWordOccurrences(filePath, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times.");
    }
}
