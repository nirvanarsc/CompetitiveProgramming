package leetcode.biweekly_contests.biweekly_100_199.biweekly_109;

import java.util.Arrays;

public class P_1 {

    public boolean isGood(int[] nums) {
        final int n = nums.length;
        Arrays.sort(nums);
        nums[n - 1]++;
        for (int i = 0; i < n; i++) {
            if (nums[i] != (i + 1)) {
                return false;
            }
        }
        return true;
    }
}
