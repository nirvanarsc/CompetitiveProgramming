package leetcode.weekly_contests.weekly_200_299.weekly_282;

import java.util.Arrays;

public class P_4 {

    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        final long[] min = new long[20];
        Arrays.fill(min, (long) 1e18);
        min[0] = changeTime;
        for (int[] tire : tires) {
            long curr = tire[0];
            long ct = changeTime;
            for (int j = 1; j < 20; j++) {
                if (curr > (int) 2e9) {
                    break;
                }
                ct += curr;
                min[j] = Math.min(min[j], ct);
                curr *= tire[1];
            }
        }
        final long[] dp = new long[numLaps + 1];
        Arrays.fill(dp, (long) 1e18);
        dp[0] = -changeTime;
        for (int i = 0; i <= numLaps; i++) {
            for (int j = 1; j < 20 && i - j >= 0; ++j) {
                dp[i] = Math.min(dp[i], dp[i - j] + min[j]);
            }
        }
        return (int) dp[numLaps];
    }
}
