package weekly_contests.weekly_52;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_688 {

    private static final int[][] DIRS =
            { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 } };

    public double knightProbability(int N, int K, int r, int c) {
        return find(N, K, r, c, new Double[N][N][K + 1]);
    }

    public double find(int N, int K, int r, int c, Double[][][] dp) {
        if (r < 0 || r >= N || c < 0 || c >= N) {
            return 0;
        }
        if (K == 0) {
            return 1;
        }
        if (dp[r][c][K] != null) {
            return dp[r][c][K];
        }
        double rate = 0;
        for (int[] dir : DIRS) {
            rate += 0.125 * find(N, K - 1, r + dir[0], c + dir[1], dp);
        }
        return dp[r][c][K] = rate;
    }
}
