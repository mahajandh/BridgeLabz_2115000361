import java.util.HashMap;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i}; // Return indices
            }

            map.put(nums[i], i); // Store number and its index
        }
        return new int[]{}; // No valid pair found
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);

        if (result.length > 0) {
            System.out.println("Indices: " + result[0] + ", " + result[1]); // Output: 0, 1
        } else {
            System.out.println("No valid pair found");
        }
    }
}
