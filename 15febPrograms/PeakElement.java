public class PeakElementSearch {
    public static int findPeakElement(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid overflow

            if (arr[mid] > arr[mid + 1]) {
                right = mid; // Peak is in the left half or at mid
            } else {
                left = mid + 1; // Peak is in the right half
            }
        }

        return left; // Index of a peak element
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 6, 4, 2};
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak element index: " + peakIndex);
    }
}
