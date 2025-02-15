public class LinearSearchNegative {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i; // Return index of first negative number
            }
        }
        return -1; // Return -1 if no negative number is found
    }

    public static void main(String[] args) {
        int[] numbers = {3, 7, 1, -4, 5, -2};
        int index = findFirstNegative(numbers);
        System.out.println("First negative number index: " + index);
    }
}
