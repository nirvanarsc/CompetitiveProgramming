package leetcode.weekly_contests.weekly_93;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P_871 {

    public int minRefuelStopsPQ(int target, int startFuel, int[][] stations) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int ans = 0, i = 0;
        while (startFuel < target) {
            while (i < stations.length && startFuel >= stations[i][0]) {
                pq.offer(stations[i++][1]);
            }
            if (pq.isEmpty()) {
                return -1;
            }
            startFuel += pq.remove();
            ans++;
        }
        return ans;
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        final int n = stations.length;
        final long[][] dp = new long[n + 1][n + 1];
        for (long[] row : dp) {
            Arrays.fill(row, (long) -1e18);
        }
        dp[0][0] = startFuel;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i - 1][j] - stations[i - 1][0] >= 0) {
                    dp[i][j + 1] = Math.max(dp[i][j + 1], dp[i - 1][j] + stations[i - 1][1]);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (dp[n][i] >= target) {
                return i;
            }
        }
        return -1;
    }
}
