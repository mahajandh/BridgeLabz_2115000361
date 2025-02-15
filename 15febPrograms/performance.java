import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String text = "hello";

        // Compare StringBuilder and StringBuffer
        compareStringBuilderAndBuffer(text, iterations);

        // Compare FileReader and InputStreamReader
        String filePath = "largefile.txt"; // Change to your large file path
        compareFileReaders(filePath);
    }

    private static void compareStringBuilderAndBuffer(String text, int iterations) {
        // StringBuilder Performance Test
        long startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            stringBuilder.append(text);
        }
        long builderTime = System.nanoTime() - startTime;

        // StringBuffer Performance Test
        startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            stringBuffer.append(text);
        }
        long bufferTime = System.nanoTime() - startTime;

        System.out.println("StringBuilder time: " + builderTime / 1_000_000 + " ms");
        System.out.println("StringBuffer time: " + bufferTime / 1_000_000 + " ms");
    }

    private static void compareFileReaders(String filePath) {
        try {
            // FileReader Performance Test
            long startTime = System.nanoTime();
            int wordCountFR = countWordsUsingFileReader(filePath);
            long fileReaderTime = System.nanoTime() - startTime;

            // InputStreamReader Performance Test
            startTime = System.nanoTime();
            int wordCountISR = countWordsUsingInputStreamReader(filePath);
            long inputStreamReaderTime = System.nanoTime() - startTime;

            System.out.println("FileReader - Word Count: " + wordCountFR + ", Time: " + fileReaderTime / 1_000_000 + " ms");
            System.out.println("InputStreamReader - Word Count: " + wordCountISR + ", Time: " + inputStreamReaderTime / 1_000_000 + " ms");

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static int countWordsUsingFileReader(String filePath) throws IOException {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Count words
            }
        }
        return wordCount;
    }

    private static int countWordsUsingInputStreamReader(String filePath) throws IOException {
        int wordCount = 0;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                wordCount += line.split("\\s+").length; // Count words
            }
        }
        return wordCount;
    }
}
