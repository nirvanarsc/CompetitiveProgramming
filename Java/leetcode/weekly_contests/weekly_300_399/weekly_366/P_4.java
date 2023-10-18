package leetcode.weekly_contests.weekly_300_399.weekly_366;

import java.util.List;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int maxSum(List<Integer> nums, int k) {
        final int[] f = new int[32];
        long res = 0;
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num & (1 << i)) != 0) {
                    f[i]++;
                }
            }
        }
        for (int i = 0; i < k; i++) {
            long curr = 0;
            for (int j = 0; j < 32; j++) {
                if (f[j] > 0) {
                    curr |= 1 << j;
                    f[j]--;
                }
            }
            res = (res + curr * curr) % MOD;
        }
        return (int) res;
    }
}
