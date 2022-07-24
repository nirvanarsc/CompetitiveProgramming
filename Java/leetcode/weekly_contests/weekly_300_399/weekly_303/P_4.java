package leetcode.weekly_contests.weekly_300_399.weekly_303;

import java.util.Arrays;

public class P_4 {

    public long countExcellentPairs(int[] nums, int k) {
        nums = Arrays.stream(nums).distinct().toArray();
        final int[] f = new int[64];
        for (int num : nums) {
            f[Integer.bitCount(num)]++;
        }
        final int[] pre = new int[65];
        for (int i = 1; i <= 64; i++) {
            pre[i] = pre[i - 1] + f[i - 1];
        }
        long res = 0;
        for (int num : nums) {
            res += pre[64] - pre[Math.max(0, k - Integer.bitCount(num))];
        }
        return res;
    }
}
