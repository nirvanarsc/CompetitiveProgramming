package leetcode.weekly_contests.weekly_93;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P_871 {

    public int minRefuelStopsPQ(int target, int startFuel, int[][] stations) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int res = 0;
        final List<int[]> all = Stream.concat(Stream.of(stations), Stream.of(new int[] { target, 0 }))
                                      .collect(Collectors.toUnmodifiableList());
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
