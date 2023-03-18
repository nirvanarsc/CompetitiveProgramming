package leetcode.biweekly_contests.biweekly_0_99.biweekly_64;

import java.util.Arrays;
import java.util.Comparator;

public class P_2 {

    static int n;
    static int[][] dp;
    static boolean[][] seen;

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        n = events.length;
        dp = new int[n][3];
        seen = new boolean[n][3];
        return dfs(events, 0, 2);
    }

    private static int dfs(int[][] arr, int idx, int k) {
        if (idx == n) {
            return 0;
        }
        if (seen[idx][k]) {
            return dp[idx][k];
        }
        int res = 0;
        if (k > 0) {
            res = Math.max(res, arr[idx][2] + dfs(arr, lowerBound(arr, 1 + arr[idx][1]), k - 1));
        }
        res = Math.max(res, dfs(arr, idx + 1, k));
        seen[idx][k] = true;
        return dp[idx][k] = res;
    }

    private static int lowerBound(int[][] arr, int target) {
        int lo = 0;
        int hi = n;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (arr[mid][0] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
