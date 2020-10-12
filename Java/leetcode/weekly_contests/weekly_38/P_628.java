package leetcode.weekly_contests.weekly_38;

import java.util.Arrays;

public class P_628 {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        return Math.max(nums[0] * nums[1] * nums[nums.length - 1],
                        nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
    }
}
