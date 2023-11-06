package leetcode.biweekly_contests.biweekly_100_199.biweekly_115;

import java.util.Arrays;
import java.util.List;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int countSubMultisets(List<Integer> nums, int l, int r) {
        final int[] f = new int[(int) (2e4 + 5)];
        for (int num : nums) {
            f[num]++;
        }
        final long[] dp = new long[r + 1];
        dp[0] = 1;
        for (int i = 0; i < f.length; i++) {
            if (f[i] == 0) {
                continue;
            }
            final long[] pre = Arrays.copyOf(dp, r + 1);
            for (int j = i; j <= r; j++) {
                pre[j] = (pre[j] + pre[j - i]) % MOD;
            }
            for (int j = 0; j <= r; j++) {
                if (i == 0) {
                    dp[j] = (dp[j] * (f[0] + 1)) % MOD;
                } else {
                    long add = pre[j];
                    if (j >= (f[i] + 1) * i) {
                        add = (add - pre[j - ((f[i] + 1) * i)] + MOD) % MOD;
                    }
                    dp[j] = add;
                }
            }
        }
        long res = 0;
        for (int i = l; i <= r; i++) {
            res = (res + dp[i]) % MOD;
        }
        return (int) res;
    }
}
