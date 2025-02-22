import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Path.of(filename)));
    }

    public static class FileProcessorTest {
        private final FileProcessor fileProcessor = new FileProcessor();
        private final String testFilename = "testfile.txt";

        @Test
        void testWriteAndReadFile() throws IOException {
            String content = "Hello, JUnit!";
            fileProcessor.writeToFile(testFilename, content);
            String readContent = fileProcessor.readFromFile(testFilename);
            assertEquals(content, readContent);
        }

        @Test
        void testFileExistsAfterWrite() throws IOException {
            fileProcessor.writeToFile(testFilename, "Sample Content");
            assertTrue(Files.exists(Path.of(testFilename)));
        }

        @Test
        void testReadNonExistentFileThrowsException() {
            assertThrows(IOException.class, () -> fileProcessor.readFromFile("nonexistent.txt"));
        }
    }
}
