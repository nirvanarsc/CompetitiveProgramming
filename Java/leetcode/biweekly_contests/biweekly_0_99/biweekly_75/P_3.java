package leetcode.biweekly_contests.biweekly_0_99.biweekly_75;

public class P_3 {

    static char[] w;
    static int n;
    static boolean[][] seen;
    static long[][] dp;

    public long numberOfWays(String s) {
        n = s.length();
        w = s.toCharArray();
        seen = new boolean[n][4];
        dp = new long[n][4];
        final long ll = dfs(0, 0, 2);
        seen = new boolean[n][4];
        dp = new long[n][4];
        return ll + dfs(0, 0, 5);
    }

    private static long dfs(int idx, int p, int mask) {
        if (idx == n) {
            return p == 3 ? 1 : 0;
        }
        if (seen[idx][p]) {
            return dp[idx][p];
        }
        long res = dfs(idx + 1, p, mask);
        if (p < 3) {
            if ((mask & (1 << p)) == 0) {
                if (w[idx] - '0' == 0) {
                    res += dfs(idx + 1, p + 1, mask);
                }
            } else {
                if (w[idx] - '0' == 1) {
                    res += dfs(idx + 1, p + 1, mask);
                }
            }
        }
        seen[idx][p] = true;
        return dp[idx][p] = res;
    }
}
