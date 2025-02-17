import java.util.Arrays;
import java.util.Random;

public class SearchComparison {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random rand = new Random();

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size * 10); // Random data
            }
            int target = data[rand.nextInt(size)]; // Random target from array

            // Measure Linear Search Time
            long start = System.nanoTime();
            int linearResult = linearSearch(data, target);
            long linearTime = System.nanoTime() - start;

            // Measure Binary Search Time
            Arrays.sort(data);
            start = System.nanoTime();
            int binaryResult = binarySearch(data, target);
            long binaryTime = System.nanoTime() - start;

            // Print results
            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1_000_000.0 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1_000_000.0 + " ms");
            System.out.println();
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}
