import java.util.Arrays;

public class SearchChallenge {
    
    // Linear Search: Find the first missing positive integer
    public static int findFirstMissingPositive(int[] nums) {
        int n = nums.length;
        
        // Step 1: Place each number in its correct index position if possible
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // Swap nums[i] with nums[nums[i] - 1]
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        // Step 2: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        
        return n + 1; // If all numbers are in place, return the next positive integer
    }
    
    // Binary Search: Find the index of the target number
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Avoid overflow
            
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println("First missing positive: " + findFirstMissingPositive(nums));
        
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 6;
        System.out.println("Target index: " + binarySearch(sortedArray, target));
    }
}
