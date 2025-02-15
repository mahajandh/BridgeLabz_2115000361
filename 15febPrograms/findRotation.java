public class RotatedArraySearch {
    public static int findRotationPoint(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2; // Avoid overflow

            if (arr[mid] > arr[right]) {
                left = mid + 1; // Rotation point is in the right half
            } else {
                right = mid; // Rotation point is in the left half
            }
        }

        return left; // Index of the smallest element (rotation point)
    }

    public static void main(String[] args) {
        int[] rotatedArray = {7, 8, 9, 1, 2, 3, 4, 5, 6};
        int rotationIndex = findRotationPoint(rotatedArray);
        System.out.println("Rotation point index: " + rotationIndex);
    }
}
