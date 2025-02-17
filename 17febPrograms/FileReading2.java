import java.io.*;

public class FileReadingPerformance {
    public static void main(String[] args) {
        String filePath = "largefile.txt"; // Replace with actual large file path
        
        System.out.println("Reading file using FileReader...");
        long start = System.nanoTime();
        readUsingFileReader(filePath);
        long fileReaderTime = System.nanoTime() - start;
        System.out.println("FileReader Time: " + fileReaderTime / 1_000_000.0 + " ms\n");
        
        System.out.println("Reading file using InputStreamReader...");
        start = System.nanoTime();
        readUsingInputStreamReader(filePath);
        long inputStreamReaderTime = System.nanoTime() - start;
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1_000_000.0 + " ms\n");
        
        System.out.println("Computing Fibonacci using Recursive and Iterative methods...");
        int n = 30; // Change as needed
        
        start = System.nanoTime();
        int fibRec = fibonacciRecursive(n);
        long fibRecTime = System.nanoTime() - start;
        System.out.println("Recursive Fibonacci(" + n + ") = " + fibRec + ", Time: " + fibRecTime / 1_000_000.0 + " ms");
        
        start = System.nanoTime();
        int fibIter = fibonacciIterative(n);
        long fibIterTime = System.nanoTime() - start;
        System.out.println("Iterative Fibonacci(" + n + ") = " + fibIter + ", Time: " + fibIterTime / 1_000_000.0 + " ms");
    }

    public static void readUsingFileReader(String filePath) {
        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            while (bufferedReader.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readUsingInputStreamReader(String filePath) {
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            while (bufferedReader.read() != -1) {}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
