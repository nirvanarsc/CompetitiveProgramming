package leetcode.weekly_contests.weekly_100_199.weekly_169;

public final class P_1306 {

    static int n;
    static int[] dp;
    static boolean[] seen;

    public boolean canReach(int[] arr, int start) {
        n = arr.length;
        dp = new int[n];
        seen = new boolean[n];
        return dfs(arr, start) == 1;
    }

    private static int dfs(int[] arr, int idx) {
        if (idx < 0 || idx >= n) {
            return 0;
        }
        if (arr[idx] == 0) {
            return 1;
        }
        if (seen[idx]) {
            return dp[idx];
        }
        seen[idx] = true;
        return dp[idx] = Math.max(dfs(arr, idx - arr[idx]), dfs(arr, idx + arr[idx]));
    }
}
