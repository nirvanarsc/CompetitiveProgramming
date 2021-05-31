package leetcode.weekly_contests.weekly_243;

public class P_4 {

    public int minSkips(int[] dist, int speed, int hoursBefore) {
        final int n = dist.length;
        final int[][] dp = new int[n + 1][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = speed * ceil(dp[i - 1][j], speed) + dist[i - 1];
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + dist[i - 1]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[n][i] <= (long) speed * hoursBefore) {
                return i;
            }
        }
        return -1;
    }

    private static int ceil(int a, int b) {
        return (a + b - 1) / b;
    }
}
