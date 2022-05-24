package leetcode.weekly_contests.weekly_0_99.weekly_78;

public class P_808 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public double soupServings(int N) {
        N = N / 25 + (N % 25 > 0 ? 1 : 0);
        if (N >= 200) {
            return 1;
        }
        return dfs(N, N, new Double[N + 1][N + 1]);
    }

    private static double dfs(int a, int b, Double[][] dp) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1;
        }
        if (b <= 0) {
            return 0;
        }
        if (dp[a][b] != null) {
            return dp[a][b];
        }
        final double f1 = dfs(a - 4, b, dp);
        final double f2 = dfs(a - 3, b - 1, dp);
        final double f3 = dfs(a - 2, b - 2, dp);
        final double f4 = dfs(a - 1, b - 3, dp);
        return dp[a][b] = 0.25 * (f1 + f2 + f3 + f4);
    }
}
