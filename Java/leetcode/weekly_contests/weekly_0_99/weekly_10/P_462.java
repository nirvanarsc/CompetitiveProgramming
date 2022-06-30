package leetcode.weekly_contests.weekly_0_99.weekly_10;

import java.util.Arrays;

public class P_462 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        final int n = nums.length;
        final int median = nums[n / 2];
        int res = 0;
        for (int num : nums) {
            res += Math.abs(num - median);
        }
        return res;
    }
}
