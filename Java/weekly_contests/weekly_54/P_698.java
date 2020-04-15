package weekly_contests.weekly_54;

import java.util.Arrays;

public class P_698 {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        final int sum = Arrays.stream(nums).sum();
        final int target = sum / k;
        if (target * k != sum) {
            return false;
        }
        return recurse(nums, new boolean[nums.length], 0, target, k, nums.length - 1);
    }

    private static boolean recurse(int[] nums, boolean[] taken, int currSum, int target, int k, int idx) {
        if (k == 0 && currSum == 0) {
            return true;
        }
        if (currSum == target && recurse(nums, taken, 0, target, k - 1, nums.length - 1)) {
            return true;
        }
        for (int i = idx; i >= 0; i--) {
            if (!taken[i] && currSum + nums[i] <= target) {
                taken[i] = true;
                if (recurse(nums, taken, currSum + nums[i], target, k, i - 1)) {
                    return true;
                }
                taken[i] = false;
            }
        }
        return false;
    }
}
