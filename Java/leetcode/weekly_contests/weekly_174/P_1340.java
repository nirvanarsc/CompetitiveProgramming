package leetcode.weekly_contests.weekly_174;

public class P_1340 {

    public int maxJumps(int[] arr, int d) {
        int res = 1;
        final Integer[] dp = new Integer[1001];
        for (int i = 0; i < arr.length; i++) {
            res = Math.max(res, dfs(arr, i, d, dp));
        }
        return res;
    }

    private static int dfs(int[] arr, int i, int d, Integer[] dp) {
        if (dp[i] != null) {
            return dp[i];
        }
        int res = 1;
        for (int j = i + 1; j <= Math.min(i + d, arr.length - 1) && arr[j] < arr[i]; j++) {
            res = Math.max(res, 1 + dfs(arr, j, d, dp));
        }
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[j] < arr[i]; j--) {
            res = Math.max(res, 1 + dfs(arr, j, d, dp));
        }
        return dp[i] = res;
    }
}
