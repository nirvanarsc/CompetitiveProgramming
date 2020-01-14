package medium;

import java.util.Arrays;

public class P_473 {

    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum == 0 || sum % 4 != 0) {
            return false;
        }
        Arrays.sort(nums);
        return recurse(nums, nums.length - 1, new boolean[nums.length], sum / 4, 0, 4);
    }

    private static boolean recurse(int[] nums, int start, boolean[] used, int targetSum, int currSum, int k) {
        if (k == 1 && currSum == targetSum) {
            return true;
        }
        if (currSum == targetSum && recurse(nums, nums.length - 1, used, targetSum, 0, k - 1)) {
            return true;
        }

        for (int i = start; i >= 0; i--) {
            if (!used[i] && currSum + nums[i] <= targetSum) {
                used[i] = true;
                if (recurse(nums, i - 1, used, targetSum, currSum + nums[i], k)) {
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }
}
