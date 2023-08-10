package leetcode.weekly_contests.weekly_300_399.weekly_351;

import java.util.Arrays;

public class P_3 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfGoodSubarraySplits(int[] nums) {
        final int n = nums.length;
        if (Arrays.equals(nums, new int[n])) {
            return 0;
        }
        long res = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                int j = i + 1;
                while (j < n && nums[j] == 0) {
                    j++;
                }
                if (j != n) {
                    res = res * (j - i) % MOD;
                }
                i = j - 1;
            }
        }
        return (int) res;
    }
}
