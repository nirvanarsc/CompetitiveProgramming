package leetcode.weekly_contests.weekly_400_499.weekly_473;

import java.util.Arrays;

public class P_2 {

    public long maxAlternatingSum(int[] nums) {
        final int n = nums.length;
        final long[] sq = new long[n];
        long res = 0;
        for (int i = 0; i < n; i++) {
            sq[i] = (long) nums[i] * nums[i];
            res += sq[i];
        }
        Arrays.sort(sq);
        for (int i = 0; i < n / 2; i++) {
            res -= 2L * sq[i];
        }
        return res;
    }
}
