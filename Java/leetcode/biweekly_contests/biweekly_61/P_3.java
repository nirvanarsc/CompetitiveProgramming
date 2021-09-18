package leetcode.biweekly_contests.biweekly_61;

import java.util.Arrays;
import java.util.Comparator;

public class P_3 {

    static boolean[] seen;
    static long[] dp;

    public long maxTaxiEarnings(int _n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));
        final int n = rides.length;
        seen = new boolean[n];
        dp = new long[n];
        return dfs(rides, 0);
    }

    private static long dfs(int[][] arr, int idx) {
        if (idx == arr.length) {
            return 0;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        long res = 0;
        res = Math.max(res, dfs(arr, idx + 1));
        res = Math.max(res, arr[idx][1] - arr[idx][0] + arr[idx][2] + dfs(arr, lowerBound(arr, arr[idx][1])));
        seen[idx] = true;
        return dp[idx] = res;
    }

    private static int lowerBound(int[][] arr, int target) {
        int lo = 0;
        int hi = arr.length;
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
