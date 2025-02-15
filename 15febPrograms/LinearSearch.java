public class LinearSearchWord {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence; // Return the first matching sentence
            }
        }
        return "Not Found"; // Return if no match is found
    }

    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog.",
            "Java is a powerful programming language.",
            "Data structures are important in computer science.",
            "Machine learning is fascinating."
        };
        String word = "java";

        String result = findSentenceWithWord(sentences, word);
        System.out.println("Sentence containing '" + word + "': " + result);
    }
}
