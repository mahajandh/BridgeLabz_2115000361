import java.util.HashSet;

class PairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true; // Pair found
            }
            seen.add(num);
        }
        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 12, 15};
        int target = 19;
        System.out.println(hasPairWithSum(nums, target)); // Output: true (7 + 12)
    }
}
