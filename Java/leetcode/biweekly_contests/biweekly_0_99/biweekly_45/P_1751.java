package leetcode.biweekly_contests.biweekly_0_99.biweekly_45;

import java.util.Arrays;
import java.util.Comparator;

public class P_1751 {

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        final long[][] dp = new long[events.length][k + 1];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return (int) dfs(events, 0, k, dp);
    }

    private static long dfs(int[][] e, int idx, int k, long[][] dp) {
        if (idx == e.length) {
            return 0;
        }
        if (dp[idx][k] != -1) {
            return dp[idx][k];
        }
        long res = dfs(e, idx + 1, k, dp);
        if (k > 0) {
            final int next = lowerBound(e, e[idx][1] + 1);
            res = Math.max(res, e[idx][2] + dfs(e, next, k - 1, dp));
        }
        return dp[idx][k] = res;
    }

    private static int lowerBound(int[][] e, int target) {
        int lo = 0, hi = e.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (e[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
