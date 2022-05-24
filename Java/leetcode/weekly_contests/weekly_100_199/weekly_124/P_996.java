package leetcode.weekly_contests.weekly_100_199.weekly_124;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_996 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int numSquarefulPerms(int[] A) {
        final int n = A.length;
        final int[][] dp = new int[n + 1][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res = dfs(A, n, 0, (1 << n) - 1, dp);
        final int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i - 1];
        }
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int num : A) {
            freq.merge(num, 1, Integer::sum);
        }
        for (int f : freq.values()) {
            res /= factorial[f];
        }
        return res;
    }

    private static int dfs(int[] arr, int prev, int mask, int target, int[][] dp) {
        if (mask == target) {
            return 1;
        }
        if (dp[prev][mask] != -1) {
            return dp[prev][mask];
        }
        int res = 0;
        if (prev == arr.length) {
            for (int i = 0; i < arr.length; i++) {
                res += dfs(arr, i, mask | 1 << i, target, dp);
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                if ((mask & (1 << i)) == 0 && isSquare(arr[prev] + arr[i])) {
                    res += dfs(arr, i, mask | 1 << i, target, dp);
                }
            }
        }
        return dp[prev][mask] = res;
    }

    private static boolean isSquare(int v) {
        final int r = (int) Math.sqrt(v);
        return r * r == v;
    }
}
