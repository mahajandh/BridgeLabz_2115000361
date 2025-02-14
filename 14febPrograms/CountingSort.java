import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] ages, int maxAge) {
        int[] count = new int[maxAge + 1];
        int[] output = new int[ages.length];
        
        // Count occurrences
        for (int age : ages) {
            count[age]++;
        }
        
        // Compute cumulative count
        for (int i = 1; i <= maxAge; i++) {
            count[i] += count[i - 1];
        }
        
        // Place elements in sorted order
        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i]] - 1] = ages[i];
            count[ages[i]]--;
        }
        
        // Copy sorted elements back
        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    public static void main(String[] args) {
        int[] studentAges = {12, 15, 10, 18, 14, 13, 12, 16};
        System.out.println("Original Student Ages: " + Arrays.toString(studentAges));
        
        countingSort(studentAges, 18);
        
        System.out.println("Sorted Student Ages: " + Arrays.toString(studentAges));
    }
}
