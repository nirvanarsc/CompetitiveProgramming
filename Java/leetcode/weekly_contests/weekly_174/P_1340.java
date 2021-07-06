package leetcode.weekly_contests.weekly_174;

public class P_1340 {

    static boolean[] seen;
    static int[] dp;

    public int maxJumps(int[] arr, int d) {
        final int n = arr.length;
        seen = new boolean[n];
        dp = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                res = Math.max(res, dfs(arr, i, d));
            }
        }
        return res;
    }

    private static int dfs(int[] arr, int idx, int d) {
        if (seen[idx]) {
            return dp[idx];
        }
        int res = 1;
        for (int j = 1; j <= d && idx + j < arr.length; j++) {
            if (!(arr[idx] > arr[idx + j])) {
                break;
            }
            res = Math.max(res, 1 + dfs(arr, idx + j, d));
        }
        for (int j = 1; j <= d && idx - j >= 0; j++) {
            if (!(arr[idx] > arr[idx - j])) {
                break;
            }
            res = Math.max(res, 1 + dfs(arr, idx - j, d));
        }
        seen[idx] = true;
        return dp[idx] = res;
    }
}
