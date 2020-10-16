package leetcode.weekly_contests.weekly_105;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_920 {

    private static final int MOD = (int) (1e9 + 7);

    /*
    For problem dp[i][j] it means filling i slots, using j out of N songs:
    - the last slot could either be an existing song, in this case we need to look at dp[i-1][j] and we have j-k choices for the last slot
    - or the last slot could be a new song from the remaining unused songs, then we need to look at dp[i-1][j-1] and we have N - j + 1 choices for the last slot.
    => then we get dp[i][j] = dp[i-1][j-1] * (N - j + 1) + dp[i-1][j] * (j - k)
    */
    public int numMusicPlaylistsBottomUp(int N, int L, int K) {
        final long[][] dp = new long[L + 1][N + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= N; j++) {
                final long add = dp[i - 1][j - 1] * (N - j + 1) % MOD;
                final long startNew = (dp[i - 1][j] * Math.max(j - K, 0)) % MOD;
                dp[i][j] = (add + startNew) % MOD;
            }
        }
        return (int) dp[L][N];
    }

    public int numMusicPlaylists(int N, int L, int K) {
        return (int) dfs(N, L, K, new Long[101][101]);
    }

    private static long dfs(int n, int l, int k, Long[][] dp) {
        if (n < 0) {
            return 0;
        }
        if (l == 0) {
            return n == 0 ? 1 : 0;
        }
        if (dp[n][l] != null) {
            return dp[n][l];
        }
        final long add = (dfs(n - 1, l - 1, k, dp) * n) % MOD;
        final long start = (dfs(n, l - 1, k, dp) * Math.max(0, n - k)) % MOD;
        return dp[n][l] = (add + start) % MOD;
    }
}
