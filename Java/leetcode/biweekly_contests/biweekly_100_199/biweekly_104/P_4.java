package leetcode.biweekly_contests.biweekly_100_199.biweekly_104;

import java.util.Arrays;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long res = 0;
        long lower = 0;
        for (int num : nums) {
            final long sq = ((long) num * num) % MOD;
            res = (res + (sq * lower) % MOD) % MOD;
            res = (res + (sq * num) % MOD) % MOD;
            lower = (lower * 2) % MOD;
            lower = (lower + num) % MOD;
        }
        return (int) res;
    }
}
