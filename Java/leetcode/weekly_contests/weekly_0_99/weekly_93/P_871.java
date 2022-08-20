package leetcode.weekly_contests.weekly_0_99.weekly_93;

import java.util.PriorityQueue;

public class P_871 {

    public int minRefuelStopsPQ(int target, int startFuel, int[][] stations) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        final int n = stations.length;
        final int[][] all = new int[n + 1][2];
        System.arraycopy(stations, 0, all, 0, n);
        all[n] = new int[] { target, 0 };
        int res = 0;
        for (int[] s : all) {
            while (!pq.isEmpty() && startFuel < s[0]) {
                startFuel += pq.remove()[1];
                res++;
            }
            if (startFuel < s[0]) {
                return -1;
            }
            pq.offer(s);
        }
        return res;
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        final int n = stations.length;
        final long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = startFuel;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] - stations[i][0] >= 0) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], dp[i][j] + stations[i][1]);
                }
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
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
