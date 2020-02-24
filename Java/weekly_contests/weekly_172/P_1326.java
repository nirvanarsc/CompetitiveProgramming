package weekly_contests.weekly_172;

import java.util.Arrays;

public class P_1326 {

    public int minTaps(int n, int[] ranges) {
        final int[] dp = new int[n + 1];
        final int MAX_VALUE = (int) 1e9;
        Arrays.fill(dp, MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; ++i) {
            final int left = Math.max(0, i - ranges[i]);
            final int right = Math.min(n, i + ranges[i]);
            int t = MAX_VALUE;
            for (int x = left; x <= right; ++x) {
                t = Math.min(t, dp[x]);
            }
            dp[right] = Math.min(dp[right], t + 1);
        }
        return dp[n] < MAX_VALUE ? dp[n] : -1;
    }
}
