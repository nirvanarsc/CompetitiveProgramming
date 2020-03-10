package weekly_contests.weekly_109;

public class P_935 {

    private static final int MOD = (int) (1e9 + 7);

    private static final int[][] BOARD = {
            { 4, 6 }, { 6, 8 }, { 7, 9 }, { 4, 8 }, { 3, 9, 0 }, {}, { 1, 7, 0 }, { 2, 6 }, { 1, 3 }, { 4, 2 }
    };

    @SuppressWarnings("MethodParameterNamingConvention")
    public int knightDialer(int N) {
        int res = 0;
        final Integer[][] dp = new Integer[10][N];
        for (int i = 0; i <= 9; i++) {
            res = (res + dfs(i, N - 1, dp)) % MOD;
        }
        return res;
    }

    private static int dfs(int i, int n, Integer[][] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[i][n] != null) {
            return dp[i][n];
        }
        int res = 0;
        for (int neighbour : BOARD[i]) {
            res = (res + dfs(neighbour, n - 1, dp)) % MOD;
        }
        return dp[i][n] = res;
    }
}
