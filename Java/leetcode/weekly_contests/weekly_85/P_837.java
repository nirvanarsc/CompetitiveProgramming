package leetcode.weekly_contests.weekly_85;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_837 {

    public double new21Game(int N, int K, int W) {
        return dfs(N, K, W, 0, new Double[K]);
    }

    private static double dfs(int N, int K, int W, int curr, Double[] dp) {
        if (curr == K - 1) {
            return Math.min(N - K + 1, W) / (double) W;
        }
        if (curr > N) { return 0; }
        if (curr >= K) { return 1.0; }
        if (dp[curr] != null) {
            return dp[curr];
        }

        final double next = dfs(N, K, W, curr + 1, dp);
        final double max = dfs(N, K, W, curr + 1 + W, dp);

        return dp[curr] = next - (max - next) / W;
    }
}
