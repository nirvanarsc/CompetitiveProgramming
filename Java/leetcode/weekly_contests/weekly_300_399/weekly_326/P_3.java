package leetcode.weekly_contests.weekly_300_399.weekly_326;

import java.util.Arrays;

public class P_3 {

    public int minimumPartition(String s, int k) {
        final int n = s.length();
        final int[] dp = new int[n + 1];
        Arrays.fill(dp, (int) 1e9);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 10 && i + j <= n; j++) {
                final long l = Long.parseLong(s.substring(i, i + j));
                if (l > k) {
                    break;
                }
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        return dp[n] == (int) 1e9 ? -1 : dp[n];
    }
}
